package me.ders.darknessutils

import me.emafire003.dev.coloredglowlib.ColoredGlowLibMod
import me.emafire003.dev.coloredglowlib.util.Color
import net.fabricmc.api.ModInitializer
import net.minecraft.entity.EntityType


class DarknessUtils : ModInitializer {

    //TODO: REMOVE GLOW-LIB AND IMPLEMENT CUSTOM LOGIC
    val glowLib = ColoredGlowLibMod.getLib()


    //TODO: MOVE TO CONFIG FILE
    //TODO: SEPARATE COLORS FOR BOSSES THAT ARE THE SAME ENTITY
    val mobColors = hashMapOf(
        Pair(EntityType.ZOMBIE, Color(0x38761D)), //ZOMBIE KING
        Pair(EntityType.SKELETON, Color(0xCCCCCC)), //SKELETON KING
        Pair(EntityType.PIGLIN_BRUTE, Color(0xB45F06)), //NETHER KING
        Pair(EntityType.WITHER_SKELETON, Color(0x444444)), //DRAGON SLAYER & DRAGON KING
        Pair(EntityType.HUSK, Color(0xE69138)), //PANDA KING & PUMPKIN KING
        Pair(EntityType.DROWNED, Color(0x3D85C6)), //OCEAN PRINCE
        Pair(EntityType.WITCH, Color(0x674EA7)), //WITCH QUEEN
        Pair(EntityType.WARDEN, Color(0x0B5394)), //SUPER WARDEN
    )
    override fun onInitialize() {
        mobColors.forEach { (type, color) ->
            glowLib.setColorToEntityType(type,color)
        }
    }

}