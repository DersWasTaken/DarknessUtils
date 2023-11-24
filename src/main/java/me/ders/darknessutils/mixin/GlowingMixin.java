package me.ders.darknessutils.mixin;


import net.minecraft.entity.Entity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;

import java.util.Arrays;
import java.util.List;

@Mixin(Entity.class)
public abstract class GlowingMixin {

    @Shadow public abstract World getWorld();

    @Shadow protected abstract boolean getFlag(int index);

    @Shadow @Final protected static int GLOWING_FLAG_INDEX;

    @Shadow private boolean glowing;

    @Shadow public abstract Text getCustomName();

    @Shadow public abstract boolean hasCustomName();

    /**
     * @author Der_s
     * @reason Calls to {@link Entity#setGlowing} do not work for client sided entities.
     */
    @Overwrite
    public boolean isGlowing() {

        //TODO: MOVE TO CONFIGURATION FILE/POLL API FOR NAMES
        List<String> highlightedNames = Arrays.asList(
                "Skeleton King",
                "Zombie King",
                "Nether King",
                "Dragon Slayer",
                "Panda King",
                "Pumpkin King",
                "Ocean Prince",
                "Witch Queen",
                "Dragon King",
                "Super Warden",
                "Cursed AutismFather",
                "Cursed ZEDDY1977",
                "Cursed Crankles_",
                "Cursed Solphire"
        );

        if(hasCustomName()) {
            return highlightedNames
                    .stream()
                    .anyMatch(it ->
                            getCustomName()
                            .toString()
                            .toLowerCase()
                            .contains(it.toLowerCase())
                    );

        }

        return getWorld().isClient() ? getFlag(GLOWING_FLAG_INDEX) : glowing;
    }

}
