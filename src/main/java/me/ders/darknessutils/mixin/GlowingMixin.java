package me.ders.darknessutils.mixin;


import me.ders.darknessutils.DarknessUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Environment(EnvType.CLIENT)
@Mixin(Entity.class)
public abstract class GlowingMixin  {

    @Shadow public abstract World getWorld();

    @Shadow protected abstract boolean getFlag(int index);

    @Shadow @Final protected static int GLOWING_FLAG_INDEX;

    @Shadow private boolean glowing;

    @Shadow public abstract Text getCustomName();

    @Shadow public abstract boolean hasCustomName();

    //TODO: MOVE TO CONFIGURATION FILE/POLL API FOR NAMES
    Map<String, Integer> mobColors = new HashMap<>() {{
        put("Skeleton King", 0xCCCCCC);
        put("Zombie King", 0x38761D);
        put("Nether King", 0xB45F06);
        put("Dragon Slayer", 0xE95BFF);
        put("Panda King", 0x6AA84F);
        put("Pumpkin King",0xB44409);
        put("Ocean Prince", 0x3D85C6);
        put("Witch Queen", 0x674EA7);
        put("Dragon King", 0x1B0F29);
        put("Super Warden", 0x0B5394);
        put("Cursed AutismFather", 0xFF0014);
        put("Cursed ZEDDY1977", 0xFF4F0B);
        put("Cursed Crankles_", 0xFF059F);
        put("Cursed Solphire", 0xAA26FF);
    }};

    /**
     * @author Der_s
     * @reason Calls to {@link Entity#setGlowing} do not work for client sided entities.
     */
    @Overwrite
    public boolean isGlowing() {
        if(hasCustomName()) {
            if(getMobColor().isPresent()) {
                return DarknessUtils.GlowEnabled;
            }
        }

        return getWorld().isClient() ? getFlag(GLOWING_FLAG_INDEX) : glowing;
    }

    @Inject(method = "getTeamColorValue", at = @At("HEAD"), cancellable = true)
    public void injectGetTeamColorValue(CallbackInfoReturnable<Integer> ci) {
        if(hasCustomName() && DarknessUtils.GlowEnabled) {
            getMobColor().ifPresent(stringColorEntry -> ci.setReturnValue(stringColorEntry.getValue()));
        }
    }

    public Optional<Map.Entry<String, Integer>> getMobColor() {
        return mobColors
                .entrySet()
                .stream()
                .filter(it ->
                        getCustomName()
                                .toString()
                                .toLowerCase()
                                .contains(it.getKey().toLowerCase())
                ).findFirst();
    }
}
