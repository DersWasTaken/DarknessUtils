package me.ders.darknessutils.config;

import blue.endless.jankson.Jankson;
import io.wispforest.owo.config.ConfigWrapper;
import io.wispforest.owo.config.Option;
import io.wispforest.owo.util.Observable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class DarknessModSettings extends ConfigWrapper<me.ders.darknessutils.config.DarknessSettings> {

    public final Keys keys = new Keys();

    private final Option<java.lang.Boolean> bossHighlights_showBossHighlights = this.optionForKey(this.keys.bossHighlights_showBossHighlights);
    private final Option<io.wispforest.owo.ui.core.Color> bossHighlights_bossColors_skeletonKingColor = this.optionForKey(this.keys.bossHighlights_bossColors_skeletonKingColor);
    private final Option<io.wispforest.owo.ui.core.Color> bossHighlights_bossColors_zombieKingColor = this.optionForKey(this.keys.bossHighlights_bossColors_zombieKingColor);
    private final Option<io.wispforest.owo.ui.core.Color> bossHighlights_bossColors_netherKingColor = this.optionForKey(this.keys.bossHighlights_bossColors_netherKingColor);
    private final Option<io.wispforest.owo.ui.core.Color> bossHighlights_bossColors_dragonSlayerColor = this.optionForKey(this.keys.bossHighlights_bossColors_dragonSlayerColor);
    private final Option<io.wispforest.owo.ui.core.Color> bossHighlights_bossColors_pandaKingColor = this.optionForKey(this.keys.bossHighlights_bossColors_pandaKingColor);
    private final Option<io.wispforest.owo.ui.core.Color> bossHighlights_bossColors_pumpkinKingColor = this.optionForKey(this.keys.bossHighlights_bossColors_pumpkinKingColor);
    private final Option<io.wispforest.owo.ui.core.Color> bossHighlights_bossColors_oceanPrinceColor = this.optionForKey(this.keys.bossHighlights_bossColors_oceanPrinceColor);
    private final Option<io.wispforest.owo.ui.core.Color> bossHighlights_bossColors_witchQueenColor = this.optionForKey(this.keys.bossHighlights_bossColors_witchQueenColor);
    private final Option<io.wispforest.owo.ui.core.Color> bossHighlights_bossColors_dragonKingColor = this.optionForKey(this.keys.bossHighlights_bossColors_dragonKingColor);
    private final Option<io.wispforest.owo.ui.core.Color> bossHighlights_bossColors_superWardenColor = this.optionForKey(this.keys.bossHighlights_bossColors_superWardenColor);
    private final Option<io.wispforest.owo.ui.core.Color> bossHighlights_bossColors_cursedAFColor = this.optionForKey(this.keys.bossHighlights_bossColors_cursedAFColor);
    private final Option<io.wispforest.owo.ui.core.Color> bossHighlights_bossColors_cursedZEDDY1977Color = this.optionForKey(this.keys.bossHighlights_bossColors_cursedZEDDY1977Color);
    private final Option<io.wispforest.owo.ui.core.Color> bossHighlights_bossColors_cursedCrankles_Color = this.optionForKey(this.keys.bossHighlights_bossColors_cursedCrankles_Color);
    private final Option<io.wispforest.owo.ui.core.Color> bossHighlights_bossColors_cursedSolphireColor = this.optionForKey(this.keys.bossHighlights_bossColors_cursedSolphireColor);
    private final Option<io.wispforest.owo.ui.core.Color> modColors_primary = this.optionForKey(this.keys.modColors_primary);
    private final Option<io.wispforest.owo.ui.core.Color> modColors_secondary = this.optionForKey(this.keys.modColors_secondary);
    private final Option<io.wispforest.owo.ui.core.Color> modColors_tertiary = this.optionForKey(this.keys.modColors_tertiary);
    private final Option<io.wispforest.owo.ui.core.Color> modColors_quaternary = this.optionForKey(this.keys.modColors_quaternary);

    private DarknessModSettings() {
        super(me.ders.darknessutils.config.DarknessSettings.class);
    }

    private DarknessModSettings(Consumer<Jankson.Builder> janksonBuilder) {
        super(me.ders.darknessutils.config.DarknessSettings.class, janksonBuilder);
    }

    public static DarknessModSettings createAndLoad() {
        var wrapper = new DarknessModSettings();
        wrapper.load();
        return wrapper;
    }

    public static DarknessModSettings createAndLoad(Consumer<Jankson.Builder> janksonBuilder) {
        var wrapper = new DarknessModSettings(janksonBuilder);
        wrapper.load();
        return wrapper;
    }

    public final BossHighlights_ bossHighlights = new BossHighlights_();
    public class BossHighlights_ implements BossHighlights {
        public boolean showBossHighlights() {
            return bossHighlights_showBossHighlights.value();
        }

        public void showBossHighlights(boolean value) {
            bossHighlights_showBossHighlights.set(value);
        }

        public final BossColors_ bossColors = new BossColors_();
        public class BossColors_ implements BossColors {
            public io.wispforest.owo.ui.core.Color skeletonKingColor() {
                return bossHighlights_bossColors_skeletonKingColor.value();
            }

            public void skeletonKingColor(io.wispforest.owo.ui.core.Color value) {
                bossHighlights_bossColors_skeletonKingColor.set(value);
            }

            public io.wispforest.owo.ui.core.Color zombieKingColor() {
                return bossHighlights_bossColors_zombieKingColor.value();
            }

            public void zombieKingColor(io.wispforest.owo.ui.core.Color value) {
                bossHighlights_bossColors_zombieKingColor.set(value);
            }

            public io.wispforest.owo.ui.core.Color netherKingColor() {
                return bossHighlights_bossColors_netherKingColor.value();
            }

            public void netherKingColor(io.wispforest.owo.ui.core.Color value) {
                bossHighlights_bossColors_netherKingColor.set(value);
            }

            public io.wispforest.owo.ui.core.Color dragonSlayerColor() {
                return bossHighlights_bossColors_dragonSlayerColor.value();
            }

            public void dragonSlayerColor(io.wispforest.owo.ui.core.Color value) {
                bossHighlights_bossColors_dragonSlayerColor.set(value);
            }

            public io.wispforest.owo.ui.core.Color pandaKingColor() {
                return bossHighlights_bossColors_pandaKingColor.value();
            }

            public void pandaKingColor(io.wispforest.owo.ui.core.Color value) {
                bossHighlights_bossColors_pandaKingColor.set(value);
            }

            public io.wispforest.owo.ui.core.Color pumpkinKingColor() {
                return bossHighlights_bossColors_pumpkinKingColor.value();
            }

            public void pumpkinKingColor(io.wispforest.owo.ui.core.Color value) {
                bossHighlights_bossColors_pumpkinKingColor.set(value);
            }

            public io.wispforest.owo.ui.core.Color oceanPrinceColor() {
                return bossHighlights_bossColors_oceanPrinceColor.value();
            }

            public void oceanPrinceColor(io.wispforest.owo.ui.core.Color value) {
                bossHighlights_bossColors_oceanPrinceColor.set(value);
            }

            public io.wispforest.owo.ui.core.Color witchQueenColor() {
                return bossHighlights_bossColors_witchQueenColor.value();
            }

            public void witchQueenColor(io.wispforest.owo.ui.core.Color value) {
                bossHighlights_bossColors_witchQueenColor.set(value);
            }

            public io.wispforest.owo.ui.core.Color dragonKingColor() {
                return bossHighlights_bossColors_dragonKingColor.value();
            }

            public void dragonKingColor(io.wispforest.owo.ui.core.Color value) {
                bossHighlights_bossColors_dragonKingColor.set(value);
            }

            public io.wispforest.owo.ui.core.Color superWardenColor() {
                return bossHighlights_bossColors_superWardenColor.value();
            }

            public void superWardenColor(io.wispforest.owo.ui.core.Color value) {
                bossHighlights_bossColors_superWardenColor.set(value);
            }

            public io.wispforest.owo.ui.core.Color cursedAFColor() {
                return bossHighlights_bossColors_cursedAFColor.value();
            }

            public void cursedAFColor(io.wispforest.owo.ui.core.Color value) {
                bossHighlights_bossColors_cursedAFColor.set(value);
            }

            public io.wispforest.owo.ui.core.Color cursedZEDDY1977Color() {
                return bossHighlights_bossColors_cursedZEDDY1977Color.value();
            }

            public void cursedZEDDY1977Color(io.wispforest.owo.ui.core.Color value) {
                bossHighlights_bossColors_cursedZEDDY1977Color.set(value);
            }

            public io.wispforest.owo.ui.core.Color cursedCrankles_Color() {
                return bossHighlights_bossColors_cursedCrankles_Color.value();
            }

            public void cursedCrankles_Color(io.wispforest.owo.ui.core.Color value) {
                bossHighlights_bossColors_cursedCrankles_Color.set(value);
            }

            public io.wispforest.owo.ui.core.Color cursedSolphireColor() {
                return bossHighlights_bossColors_cursedSolphireColor.value();
            }

            public void cursedSolphireColor(io.wispforest.owo.ui.core.Color value) {
                bossHighlights_bossColors_cursedSolphireColor.set(value);
            }

        }
    }
    public final ModColors_ modColors = new ModColors_();
    public class ModColors_ implements ModColors {
        public io.wispforest.owo.ui.core.Color primary() {
            return modColors_primary.value();
        }

        public void primary(io.wispforest.owo.ui.core.Color value) {
            modColors_primary.set(value);
        }

        public io.wispforest.owo.ui.core.Color secondary() {
            return modColors_secondary.value();
        }

        public void secondary(io.wispforest.owo.ui.core.Color value) {
            modColors_secondary.set(value);
        }

        public io.wispforest.owo.ui.core.Color tertiary() {
            return modColors_tertiary.value();
        }

        public void tertiary(io.wispforest.owo.ui.core.Color value) {
            modColors_tertiary.set(value);
        }

        public io.wispforest.owo.ui.core.Color quaternary() {
            return modColors_quaternary.value();
        }

        public void quaternary(io.wispforest.owo.ui.core.Color value) {
            modColors_quaternary.set(value);
        }

    }
    public interface BossHighlights {
        boolean showBossHighlights();
        void showBossHighlights(boolean value);
    }
    public interface BossColors {
        io.wispforest.owo.ui.core.Color skeletonKingColor();
        void skeletonKingColor(io.wispforest.owo.ui.core.Color value);
        io.wispforest.owo.ui.core.Color zombieKingColor();
        void zombieKingColor(io.wispforest.owo.ui.core.Color value);
        io.wispforest.owo.ui.core.Color netherKingColor();
        void netherKingColor(io.wispforest.owo.ui.core.Color value);
        io.wispforest.owo.ui.core.Color dragonSlayerColor();
        void dragonSlayerColor(io.wispforest.owo.ui.core.Color value);
        io.wispforest.owo.ui.core.Color pandaKingColor();
        void pandaKingColor(io.wispforest.owo.ui.core.Color value);
        io.wispforest.owo.ui.core.Color pumpkinKingColor();
        void pumpkinKingColor(io.wispforest.owo.ui.core.Color value);
        io.wispforest.owo.ui.core.Color oceanPrinceColor();
        void oceanPrinceColor(io.wispforest.owo.ui.core.Color value);
        io.wispforest.owo.ui.core.Color witchQueenColor();
        void witchQueenColor(io.wispforest.owo.ui.core.Color value);
        io.wispforest.owo.ui.core.Color dragonKingColor();
        void dragonKingColor(io.wispforest.owo.ui.core.Color value);
        io.wispforest.owo.ui.core.Color superWardenColor();
        void superWardenColor(io.wispforest.owo.ui.core.Color value);
        io.wispforest.owo.ui.core.Color cursedAFColor();
        void cursedAFColor(io.wispforest.owo.ui.core.Color value);
        io.wispforest.owo.ui.core.Color cursedZEDDY1977Color();
        void cursedZEDDY1977Color(io.wispforest.owo.ui.core.Color value);
        io.wispforest.owo.ui.core.Color cursedCrankles_Color();
        void cursedCrankles_Color(io.wispforest.owo.ui.core.Color value);
        io.wispforest.owo.ui.core.Color cursedSolphireColor();
        void cursedSolphireColor(io.wispforest.owo.ui.core.Color value);
    }
    public interface ModColors {
        io.wispforest.owo.ui.core.Color primary();
        void primary(io.wispforest.owo.ui.core.Color value);
        io.wispforest.owo.ui.core.Color secondary();
        void secondary(io.wispforest.owo.ui.core.Color value);
        io.wispforest.owo.ui.core.Color tertiary();
        void tertiary(io.wispforest.owo.ui.core.Color value);
        io.wispforest.owo.ui.core.Color quaternary();
        void quaternary(io.wispforest.owo.ui.core.Color value);
    }
    public static class Keys {
        public final Option.Key bossHighlights_showBossHighlights = new Option.Key("bossHighlights.showBossHighlights");
        public final Option.Key bossHighlights_bossColors_skeletonKingColor = new Option.Key("bossHighlights.bossColors.skeletonKingColor");
        public final Option.Key bossHighlights_bossColors_zombieKingColor = new Option.Key("bossHighlights.bossColors.zombieKingColor");
        public final Option.Key bossHighlights_bossColors_netherKingColor = new Option.Key("bossHighlights.bossColors.netherKingColor");
        public final Option.Key bossHighlights_bossColors_dragonSlayerColor = new Option.Key("bossHighlights.bossColors.dragonSlayerColor");
        public final Option.Key bossHighlights_bossColors_pandaKingColor = new Option.Key("bossHighlights.bossColors.pandaKingColor");
        public final Option.Key bossHighlights_bossColors_pumpkinKingColor = new Option.Key("bossHighlights.bossColors.pumpkinKingColor");
        public final Option.Key bossHighlights_bossColors_oceanPrinceColor = new Option.Key("bossHighlights.bossColors.oceanPrinceColor");
        public final Option.Key bossHighlights_bossColors_witchQueenColor = new Option.Key("bossHighlights.bossColors.witchQueenColor");
        public final Option.Key bossHighlights_bossColors_dragonKingColor = new Option.Key("bossHighlights.bossColors.dragonKingColor");
        public final Option.Key bossHighlights_bossColors_superWardenColor = new Option.Key("bossHighlights.bossColors.superWardenColor");
        public final Option.Key bossHighlights_bossColors_cursedAFColor = new Option.Key("bossHighlights.bossColors.cursedAFColor");
        public final Option.Key bossHighlights_bossColors_cursedZEDDY1977Color = new Option.Key("bossHighlights.bossColors.cursedZEDDY1977Color");
        public final Option.Key bossHighlights_bossColors_cursedCrankles_Color = new Option.Key("bossHighlights.bossColors.cursedCrankles_Color");
        public final Option.Key bossHighlights_bossColors_cursedSolphireColor = new Option.Key("bossHighlights.bossColors.cursedSolphireColor");
        public final Option.Key modColors_primary = new Option.Key("modColors.primary");
        public final Option.Key modColors_secondary = new Option.Key("modColors.secondary");
        public final Option.Key modColors_tertiary = new Option.Key("modColors.tertiary");
        public final Option.Key modColors_quaternary = new Option.Key("modColors.quaternary");
    }
}

