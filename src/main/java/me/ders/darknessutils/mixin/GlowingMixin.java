package me.ders.darknessutils.mixin;


import me.emafire003.dev.coloredglowlib.ColoredGlowLib;
import me.emafire003.dev.coloredglowlib.ColoredGlowLibMod;
import me.emafire003.dev.coloredglowlib.util.Color;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
@Mixin(Entity.class)
public abstract class GlowingMixin {

    @Shadow public abstract World getWorld();

    @Shadow protected abstract boolean getFlag(int index);

    @Shadow @Final protected static int GLOWING_FLAG_INDEX;

    @Shadow private boolean glowing;

    @Shadow public abstract Text getCustomName();

    @Shadow public abstract boolean hasCustomName();

    //TODO: MOVE TO CONFIGURATION FILE/POLL API FOR NAMES
    Map<String, Color> mobColors = new HashMap<>() {{
        put("Skeleton King", new Color(0xCCCCCC));
        put("Zombie King", new Color(0x38761D));
        put("Nether King", new Color(0xB45F06));
        put("Dragon Slayer", new Color(0xE95BFF));
        put("Panda King", new Color(0x6AA84F));
        put("Pumpkin King", new Color(0xB44409));
        put("Ocean Prince", new Color(0x3D85C6));
        put("Witch Queen", new Color(0x674EA7));
        put("Dragon King", new Color(0x1B0F29));
        put("Super Warden", new Color(0x0B5394));
        put("Cursed AutismFather", new Color(0xFF0014));
        put("Cursed ZEDDY1977", new Color(0xFF4F0B));
        put("Cursed Crankles_", new Color(0xFF059F));
        put("Cursed Solphire", new Color(0xAA26FF));
    }};
    //TODO: REMOVE GLOW-LIB AND IMPLEMENT CUSTOM LOGIC

    ColoredGlowLib lib = ColoredGlowLibMod.getLib();

    /**
     * @author Der_s
     * @reason Calls to {@link Entity#setGlowing} do not work for client sided entities.
     */
    @Overwrite
    public boolean isGlowing() {
        if(hasCustomName()) {
            Color mobColor = mobColors.get(getCustomName().getString());
            if(mobColor != null) {
                lib.setColorToEntity((Entity) (Object) this, mobColor);
                return true;
            }
        }

        return getWorld().isClient() ? getFlag(GLOWING_FLAG_INDEX) : glowing;
    }

}
