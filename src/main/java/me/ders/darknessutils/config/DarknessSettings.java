package me.ders.darknessutils.config;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.Nest;
import io.wispforest.owo.config.annotation.SectionHeader;
import io.wispforest.owo.ui.core.Color;
import net.minecraft.text.Text;

@Modmenu(modId = "darknessutils")
@Config(name = "darkness-settings", wrapperName = "DarknessModSettings")
public class DarknessSettings {

    @SectionHeader("bossSettings")
    @Nest
    public BossHighlights bossHighlights = new BossHighlights();

    public static class BossHighlights {
        public boolean showBossHighlights = true;

        @Nest
        public BossColors bossColors = new BossColors();

        public static class BossColors {
            public Color skeletonKingColor = Color.ofRgb(0xCCCCCC);
            public Color zombieKingColor = Color.ofRgb(0x38761D);
            public Color netherKingColor = Color.ofRgb(0xB45F06);
            public Color dragonSlayerColor = Color.ofRgb(0xE95BFF);
            public Color pandaKingColor = Color.ofRgb(0x6AA84F);
            public Color pumpkinKingColor = Color.ofRgb(0xB44409);
            public Color oceanPrinceColor = Color.ofRgb(0x3D85C6);
            public Color witchQueenColor = Color.ofRgb(0x674EA7);
            public Color dragonKingColor = Color.ofRgb(0x1B0F29);
            public Color superWardenColor = Color.ofRgb(0x0B5394);
            public Color cursedAFColor = Color.ofRgb(0xFF0014);
            public Color cursedZEDDY1977Color = Color.ofRgb(0xFF4F0B);
            public Color cursedCrankles_Color = Color.ofRgb(0xFF059F);
            public Color cursedSolphireColor = Color.ofRgb(0xAA26FF);
        }
    }

    @SectionHeader("modSettings")
    @Nest
    public ModColors modColors = new ModColors();

    public static class ModColors {
        public Color primary = Color.ofRgb(0x8955F2);
        public Color secondary = Color.ofRgb(0xD68EF9);
        public Color tertiary = Color.ofRgb(0xC494F9);
        public Color quaternary = Color.ofRgb(0xD8C2FB);
    }

}
