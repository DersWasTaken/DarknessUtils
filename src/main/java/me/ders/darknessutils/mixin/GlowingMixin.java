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
import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
@Mixin(Entity.class)
public abstract class GlowingMixin  {

    @Shadow public abstract World getWorld();

    @Shadow protected abstract boolean getFlag(int index);

    @Shadow @Final protected static int GLOWING_FLAG_INDEX;

    @Shadow private boolean glowing;

    @Shadow public abstract Text getCustomName();

    @Shadow public abstract boolean hasCustomName();

    Map<String, Supplier<Integer>> mobColors = new HashMap<>() {{
        put("Skeleton King",        () -> DarknessUtils.CONFIG.bossHighlights.bossColors.skeletonKingColor().rgb());
        put("Zombie King",          () -> DarknessUtils.CONFIG.bossHighlights.bossColors.zombieKingColor().rgb());
        put("Nether King",          () -> DarknessUtils.CONFIG.bossHighlights.bossColors.netherKingColor().rgb());
        put("Dragon Slayer",        () -> DarknessUtils.CONFIG.bossHighlights.bossColors.dragonSlayerColor().rgb());
        put("Panda King",           () -> DarknessUtils.CONFIG.bossHighlights.bossColors.pandaKingColor().rgb());
        put("Pumpkin King",         () -> DarknessUtils.CONFIG.bossHighlights.bossColors.pumpkinKingColor().rgb());
        put("Ocean Prince",         () -> DarknessUtils.CONFIG.bossHighlights.bossColors.oceanPrinceColor().rgb());
        put("Witch Queen",          () -> DarknessUtils.CONFIG.bossHighlights.bossColors.witchQueenColor().rgb());
        put("Dragon King",          () -> DarknessUtils.CONFIG.bossHighlights.bossColors.dragonKingColor().rgb());
        put("Super Warden",         () -> DarknessUtils.CONFIG.bossHighlights.bossColors.superWardenColor().rgb());
        put("Cursed AutismFather",  () -> DarknessUtils.CONFIG.bossHighlights.bossColors.cursedAFColor().rgb());
        put("Cursed ZEDDY1977",     () -> DarknessUtils.CONFIG.bossHighlights.bossColors.cursedZEDDY1977Color().rgb());
        put("Cursed Crankles_",     () -> DarknessUtils.CONFIG.bossHighlights.bossColors.cursedCrankles_Color().rgb());
        put("Cursed Solphire",      () -> DarknessUtils.CONFIG.bossHighlights.bossColors.cursedSolphireColor().rgb());
    }};

    /**
     * @author Der_s
     * @reason Calls to {@link Entity#setGlowing} do not work for client sided entities.
     */
    @Overwrite
    public boolean isGlowing() {
        if(hasCustomName()) {
            if(getMobColor().isPresent()) {
                return DarknessUtils.CONFIG.bossHighlights.showBossHighlights();
            }
        }

        return getWorld().isClient() ? getFlag(GLOWING_FLAG_INDEX) : glowing;
    }

    @Inject(method = "getTeamColorValue", at = @At("HEAD"), cancellable = true)
    public void injectGetTeamColorValue(CallbackInfoReturnable<Integer> ci) {
        if(hasCustomName() && DarknessUtils.CONFIG.bossHighlights.showBossHighlights()) {
            getMobColor().ifPresent(stringColorEntry -> ci.setReturnValue(stringColorEntry.getValue().get()));
        }
    }

    public Optional<Map.Entry<String, Supplier<Integer>>> getMobColor() {
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
