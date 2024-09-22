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

    private final Option<java.lang.Boolean> showBossHighlights = this.optionForKey(this.keys.showBossHighlights);
    private final Option<io.wispforest.owo.ui.core.Color> skeletonKingOptions_color = this.optionForKey(this.keys.skeletonKingOptions_color);
    private final Option<java.lang.Boolean> skeletonKingOptions_isEnabled = this.optionForKey(this.keys.skeletonKingOptions_isEnabled);
    private final Option<io.wispforest.owo.ui.core.Color> zombieKingOptions_color = this.optionForKey(this.keys.zombieKingOptions_color);
    private final Option<java.lang.Boolean> zombieKingOptions_isEnabled = this.optionForKey(this.keys.zombieKingOptions_isEnabled);
    private final Option<io.wispforest.owo.ui.core.Color> netherKingOptions_color = this.optionForKey(this.keys.netherKingOptions_color);
    private final Option<java.lang.Boolean> netherKingOptions_isEnabled = this.optionForKey(this.keys.netherKingOptions_isEnabled);
    private final Option<io.wispforest.owo.ui.core.Color> spiderKingOptions_color = this.optionForKey(this.keys.spiderKingOptions_color);
    private final Option<java.lang.Boolean> spiderKingOptions_isEnabled = this.optionForKey(this.keys.spiderKingOptions_isEnabled);
    private final Option<io.wispforest.owo.ui.core.Color> dragonSlayerOptions_color = this.optionForKey(this.keys.dragonSlayerOptions_color);
    private final Option<java.lang.Boolean> dragonSlayerOptions_isEnabled = this.optionForKey(this.keys.dragonSlayerOptions_isEnabled);
    private final Option<io.wispforest.owo.ui.core.Color> pandaKingOptions_color = this.optionForKey(this.keys.pandaKingOptions_color);
    private final Option<java.lang.Boolean> pandaKingOptions_isEnabled = this.optionForKey(this.keys.pandaKingOptions_isEnabled);
    private final Option<io.wispforest.owo.ui.core.Color> pumpkinKingOptions_color = this.optionForKey(this.keys.pumpkinKingOptions_color);
    private final Option<java.lang.Boolean> pumpkinKingOptions_isEnabled = this.optionForKey(this.keys.pumpkinKingOptions_isEnabled);
    private final Option<io.wispforest.owo.ui.core.Color> oceanPrinceOptions_color = this.optionForKey(this.keys.oceanPrinceOptions_color);
    private final Option<java.lang.Boolean> oceanPrinceOptions_isEnabled = this.optionForKey(this.keys.oceanPrinceOptions_isEnabled);
    private final Option<io.wispforest.owo.ui.core.Color> witchQueenOptions_color = this.optionForKey(this.keys.witchQueenOptions_color);
    private final Option<java.lang.Boolean> witchQueenOptions_isEnabled = this.optionForKey(this.keys.witchQueenOptions_isEnabled);
    private final Option<io.wispforest.owo.ui.core.Color> dragonKingOptions_color = this.optionForKey(this.keys.dragonKingOptions_color);
    private final Option<java.lang.Boolean> dragonKingOptions_isEnabled = this.optionForKey(this.keys.dragonKingOptions_isEnabled);
    private final Option<io.wispforest.owo.ui.core.Color> superWardenOptions_color = this.optionForKey(this.keys.superWardenOptions_color);
    private final Option<java.lang.Boolean> superWardenOptions_isEnabled = this.optionForKey(this.keys.superWardenOptions_isEnabled);
    private final Option<io.wispforest.owo.ui.core.Color> cursedAFOptions_color = this.optionForKey(this.keys.cursedAFOptions_color);
    private final Option<java.lang.Boolean> cursedAFOptions_isEnabled = this.optionForKey(this.keys.cursedAFOptions_isEnabled);
    private final Option<io.wispforest.owo.ui.core.Color> cursedZEDDY1977Options_color = this.optionForKey(this.keys.cursedZEDDY1977Options_color);
    private final Option<java.lang.Boolean> cursedZEDDY1977Options_isEnabled = this.optionForKey(this.keys.cursedZEDDY1977Options_isEnabled);
    private final Option<io.wispforest.owo.ui.core.Color> cursedCranklesOptions_color = this.optionForKey(this.keys.cursedCranklesOptions_color);
    private final Option<java.lang.Boolean> cursedCranklesOptions_isEnabled = this.optionForKey(this.keys.cursedCranklesOptions_isEnabled);
    private final Option<io.wispforest.owo.ui.core.Color> cursedSolphireOptions_color = this.optionForKey(this.keys.cursedSolphireOptions_color);
    private final Option<java.lang.Boolean> cursedSolphireOptions_isEnabled = this.optionForKey(this.keys.cursedSolphireOptions_isEnabled);
    private final Option<io.wispforest.owo.ui.core.Color> cursedFunMummyOptions_color = this.optionForKey(this.keys.cursedFunMummyOptions_color);
    private final Option<java.lang.Boolean> cursedFunMummyOptions_isEnabled = this.optionForKey(this.keys.cursedFunMummyOptions_isEnabled);
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

    public boolean showBossHighlights() {
        return showBossHighlights.value();
    }

    public void showBossHighlights(boolean value) {
        showBossHighlights.set(value);
    }

    public final SkeletonKingOptions_ skeletonKingOptions = new SkeletonKingOptions_();
    public class SkeletonKingOptions_ implements SkeletonKingOptions {
        public io.wispforest.owo.ui.core.Color color() {
            return skeletonKingOptions_color.value();
        }

        public void color(io.wispforest.owo.ui.core.Color value) {
            skeletonKingOptions_color.set(value);
        }

        public boolean isEnabled() {
            return skeletonKingOptions_isEnabled.value();
        }

        public void isEnabled(boolean value) {
            skeletonKingOptions_isEnabled.set(value);
        }

    }
    public final ZombieKingOptions_ zombieKingOptions = new ZombieKingOptions_();
    public class ZombieKingOptions_ implements ZombieKingOptions {
        public io.wispforest.owo.ui.core.Color color() {
            return zombieKingOptions_color.value();
        }

        public void color(io.wispforest.owo.ui.core.Color value) {
            zombieKingOptions_color.set(value);
        }

        public boolean isEnabled() {
            return zombieKingOptions_isEnabled.value();
        }

        public void isEnabled(boolean value) {
            zombieKingOptions_isEnabled.set(value);
        }

    }
    public final NetherKingOptions_ netherKingOptions = new NetherKingOptions_();
    public class NetherKingOptions_ implements NetherKingOptions {
        public io.wispforest.owo.ui.core.Color color() {
            return netherKingOptions_color.value();
        }

        public void color(io.wispforest.owo.ui.core.Color value) {
            netherKingOptions_color.set(value);
        }

        public boolean isEnabled() {
            return netherKingOptions_isEnabled.value();
        }

        public void isEnabled(boolean value) {
            netherKingOptions_isEnabled.set(value);
        }

    }
    public final SpiderKingOptions_ spiderKingOptions = new SpiderKingOptions_();
    public class SpiderKingOptions_ implements SpiderKingOptions {
        public io.wispforest.owo.ui.core.Color color() {
            return spiderKingOptions_color.value();
        }

        public void color(io.wispforest.owo.ui.core.Color value) {
            spiderKingOptions_color.set(value);
        }

        public boolean isEnabled() {
            return spiderKingOptions_isEnabled.value();
        }

        public void isEnabled(boolean value) {
            spiderKingOptions_isEnabled.set(value);
        }

    }
    public final DragonSlayerOptions_ dragonSlayerOptions = new DragonSlayerOptions_();
    public class DragonSlayerOptions_ implements DragonSlayerOptions {
        public io.wispforest.owo.ui.core.Color color() {
            return dragonSlayerOptions_color.value();
        }

        public void color(io.wispforest.owo.ui.core.Color value) {
            dragonSlayerOptions_color.set(value);
        }

        public boolean isEnabled() {
            return dragonSlayerOptions_isEnabled.value();
        }

        public void isEnabled(boolean value) {
            dragonSlayerOptions_isEnabled.set(value);
        }

    }
    public final PandaKingOptions_ pandaKingOptions = new PandaKingOptions_();
    public class PandaKingOptions_ implements PandaKingOptions {
        public io.wispforest.owo.ui.core.Color color() {
            return pandaKingOptions_color.value();
        }

        public void color(io.wispforest.owo.ui.core.Color value) {
            pandaKingOptions_color.set(value);
        }

        public boolean isEnabled() {
            return pandaKingOptions_isEnabled.value();
        }

        public void isEnabled(boolean value) {
            pandaKingOptions_isEnabled.set(value);
        }

    }
    public final PumpkinKingOptions_ pumpkinKingOptions = new PumpkinKingOptions_();
    public class PumpkinKingOptions_ implements PumpkinKingOptions {
        public io.wispforest.owo.ui.core.Color color() {
            return pumpkinKingOptions_color.value();
        }

        public void color(io.wispforest.owo.ui.core.Color value) {
            pumpkinKingOptions_color.set(value);
        }

        public boolean isEnabled() {
            return pumpkinKingOptions_isEnabled.value();
        }

        public void isEnabled(boolean value) {
            pumpkinKingOptions_isEnabled.set(value);
        }

    }
    public final OceanPrinceOptions_ oceanPrinceOptions = new OceanPrinceOptions_();
    public class OceanPrinceOptions_ implements OceanPrinceOptions {
        public io.wispforest.owo.ui.core.Color color() {
            return oceanPrinceOptions_color.value();
        }

        public void color(io.wispforest.owo.ui.core.Color value) {
            oceanPrinceOptions_color.set(value);
        }

        public boolean isEnabled() {
            return oceanPrinceOptions_isEnabled.value();
        }

        public void isEnabled(boolean value) {
            oceanPrinceOptions_isEnabled.set(value);
        }

    }
    public final WitchQueenOptions_ witchQueenOptions = new WitchQueenOptions_();
    public class WitchQueenOptions_ implements WitchQueenOptions {
        public io.wispforest.owo.ui.core.Color color() {
            return witchQueenOptions_color.value();
        }

        public void color(io.wispforest.owo.ui.core.Color value) {
            witchQueenOptions_color.set(value);
        }

        public boolean isEnabled() {
            return witchQueenOptions_isEnabled.value();
        }

        public void isEnabled(boolean value) {
            witchQueenOptions_isEnabled.set(value);
        }

    }
    public final DragonKingOptions_ dragonKingOptions = new DragonKingOptions_();
    public class DragonKingOptions_ implements DragonKingOptions {
        public io.wispforest.owo.ui.core.Color color() {
            return dragonKingOptions_color.value();
        }

        public void color(io.wispforest.owo.ui.core.Color value) {
            dragonKingOptions_color.set(value);
        }

        public boolean isEnabled() {
            return dragonKingOptions_isEnabled.value();
        }

        public void isEnabled(boolean value) {
            dragonKingOptions_isEnabled.set(value);
        }

    }
    public final SuperWardenOptions_ superWardenOptions = new SuperWardenOptions_();
    public class SuperWardenOptions_ implements SuperWardenOptions {
        public io.wispforest.owo.ui.core.Color color() {
            return superWardenOptions_color.value();
        }

        public void color(io.wispforest.owo.ui.core.Color value) {
            superWardenOptions_color.set(value);
        }

        public boolean isEnabled() {
            return superWardenOptions_isEnabled.value();
        }

        public void isEnabled(boolean value) {
            superWardenOptions_isEnabled.set(value);
        }

    }
    public final CursedAFOptions_ cursedAFOptions = new CursedAFOptions_();
    public class CursedAFOptions_ implements CursedAFOptions {
        public io.wispforest.owo.ui.core.Color color() {
            return cursedAFOptions_color.value();
        }

        public void color(io.wispforest.owo.ui.core.Color value) {
            cursedAFOptions_color.set(value);
        }

        public boolean isEnabled() {
            return cursedAFOptions_isEnabled.value();
        }

        public void isEnabled(boolean value) {
            cursedAFOptions_isEnabled.set(value);
        }

    }
    public final CursedZEDDY1977Options_ cursedZEDDY1977Options = new CursedZEDDY1977Options_();
    public class CursedZEDDY1977Options_ implements CursedZEDDY1977Options {
        public io.wispforest.owo.ui.core.Color color() {
            return cursedZEDDY1977Options_color.value();
        }

        public void color(io.wispforest.owo.ui.core.Color value) {
            cursedZEDDY1977Options_color.set(value);
        }

        public boolean isEnabled() {
            return cursedZEDDY1977Options_isEnabled.value();
        }

        public void isEnabled(boolean value) {
            cursedZEDDY1977Options_isEnabled.set(value);
        }

    }
    public final CursedCranklesOptions cursedCranklesOptions = new CursedCranklesOptions();
    public class CursedCranklesOptions implements CursedCrankles_Options {
        public io.wispforest.owo.ui.core.Color color() {
            return cursedCranklesOptions_color.value();
        }

        public void color(io.wispforest.owo.ui.core.Color value) {
            cursedCranklesOptions_color.set(value);
        }

        public boolean isEnabled() {
            return cursedCranklesOptions_isEnabled.value();
        }

        public void isEnabled(boolean value) {
            cursedCranklesOptions_isEnabled.set(value);
        }

    }
    public final CursedSolphireOptions_ cursedSolphireOptions = new CursedSolphireOptions_();
    public class CursedSolphireOptions_ implements CursedSolphireOptions {
        public io.wispforest.owo.ui.core.Color color() {
            return cursedSolphireOptions_color.value();
        }

        public void color(io.wispforest.owo.ui.core.Color value) {
            cursedSolphireOptions_color.set(value);
        }

        public boolean isEnabled() {
            return cursedSolphireOptions_isEnabled.value();
        }

        public void isEnabled(boolean value) {
            cursedSolphireOptions_isEnabled.set(value);
        }

    }
    public final CursedFunMummyOptions_ cursedFunMummyOptions = new CursedFunMummyOptions_();
    public class CursedFunMummyOptions_ implements CursedFunMummyOptions {
        public io.wispforest.owo.ui.core.Color color() {
            return cursedFunMummyOptions_color.value();
        }

        public void color(io.wispforest.owo.ui.core.Color value) {
            cursedFunMummyOptions_color.set(value);
        }

        public boolean isEnabled() {
            return cursedFunMummyOptions_isEnabled.value();
        }

        public void isEnabled(boolean value) {
            cursedFunMummyOptions_isEnabled.set(value);
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
    public interface SkeletonKingOptions {
        io.wispforest.owo.ui.core.Color color();
        void color(io.wispforest.owo.ui.core.Color value);
        boolean isEnabled();
        void isEnabled(boolean value);
    }
    public interface ZombieKingOptions {
        io.wispforest.owo.ui.core.Color color();
        void color(io.wispforest.owo.ui.core.Color value);
        boolean isEnabled();
        void isEnabled(boolean value);
    }
    public interface NetherKingOptions {
        io.wispforest.owo.ui.core.Color color();
        void color(io.wispforest.owo.ui.core.Color value);
        boolean isEnabled();
        void isEnabled(boolean value);
    }
    public interface SpiderKingOptions {
        io.wispforest.owo.ui.core.Color color();
        void color(io.wispforest.owo.ui.core.Color value);
        boolean isEnabled();
        void isEnabled(boolean value);
    }
    public interface DragonSlayerOptions {
        io.wispforest.owo.ui.core.Color color();
        void color(io.wispforest.owo.ui.core.Color value);
        boolean isEnabled();
        void isEnabled(boolean value);
    }
    public interface PandaKingOptions {
        io.wispforest.owo.ui.core.Color color();
        void color(io.wispforest.owo.ui.core.Color value);
        boolean isEnabled();
        void isEnabled(boolean value);
    }
    public interface PumpkinKingOptions {
        io.wispforest.owo.ui.core.Color color();
        void color(io.wispforest.owo.ui.core.Color value);
        boolean isEnabled();
        void isEnabled(boolean value);
    }
    public interface OceanPrinceOptions {
        io.wispforest.owo.ui.core.Color color();
        void color(io.wispforest.owo.ui.core.Color value);
        boolean isEnabled();
        void isEnabled(boolean value);
    }
    public interface WitchQueenOptions {
        io.wispforest.owo.ui.core.Color color();
        void color(io.wispforest.owo.ui.core.Color value);
        boolean isEnabled();
        void isEnabled(boolean value);
    }
    public interface DragonKingOptions {
        io.wispforest.owo.ui.core.Color color();
        void color(io.wispforest.owo.ui.core.Color value);
        boolean isEnabled();
        void isEnabled(boolean value);
    }
    public interface SuperWardenOptions {
        io.wispforest.owo.ui.core.Color color();
        void color(io.wispforest.owo.ui.core.Color value);
        boolean isEnabled();
        void isEnabled(boolean value);
    }
    public interface CursedAFOptions {
        io.wispforest.owo.ui.core.Color color();
        void color(io.wispforest.owo.ui.core.Color value);
        boolean isEnabled();
        void isEnabled(boolean value);
    }
    public interface CursedZEDDY1977Options {
        io.wispforest.owo.ui.core.Color color();
        void color(io.wispforest.owo.ui.core.Color value);
        boolean isEnabled();
        void isEnabled(boolean value);
    }
    public interface CursedCrankles_Options {
        io.wispforest.owo.ui.core.Color color();
        void color(io.wispforest.owo.ui.core.Color value);
        boolean isEnabled();
        void isEnabled(boolean value);
    }
    public interface CursedSolphireOptions {
        io.wispforest.owo.ui.core.Color color();
        void color(io.wispforest.owo.ui.core.Color value);
        boolean isEnabled();
        void isEnabled(boolean value);
    }
    public interface CursedFunMummyOptions {
        io.wispforest.owo.ui.core.Color color();
        void color(io.wispforest.owo.ui.core.Color value);
        boolean isEnabled();
        void isEnabled(boolean value);
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
        public final Option.Key showBossHighlights = new Option.Key("showBossHighlights");
        public final Option.Key skeletonKingOptions_color = new Option.Key("skeletonKingOptions.color");
        public final Option.Key skeletonKingOptions_isEnabled = new Option.Key("skeletonKingOptions.isEnabled");
        public final Option.Key zombieKingOptions_color = new Option.Key("zombieKingOptions.color");
        public final Option.Key zombieKingOptions_isEnabled = new Option.Key("zombieKingOptions.isEnabled");
        public final Option.Key netherKingOptions_color = new Option.Key("netherKingOptions.color");
        public final Option.Key netherKingOptions_isEnabled = new Option.Key("netherKingOptions.isEnabled");
        public final Option.Key spiderKingOptions_color = new Option.Key("spiderKingOptions.color");
        public final Option.Key spiderKingOptions_isEnabled = new Option.Key("spiderKingOptions.isEnabled");
        public final Option.Key dragonSlayerOptions_color = new Option.Key("dragonSlayerOptions.color");
        public final Option.Key dragonSlayerOptions_isEnabled = new Option.Key("dragonSlayerOptions.isEnabled");
        public final Option.Key pandaKingOptions_color = new Option.Key("pandaKingOptions.color");
        public final Option.Key pandaKingOptions_isEnabled = new Option.Key("pandaKingOptions.isEnabled");
        public final Option.Key pumpkinKingOptions_color = new Option.Key("pumpkinKingOptions.color");
        public final Option.Key pumpkinKingOptions_isEnabled = new Option.Key("pumpkinKingOptions.isEnabled");
        public final Option.Key oceanPrinceOptions_color = new Option.Key("oceanPrinceOptions.color");
        public final Option.Key oceanPrinceOptions_isEnabled = new Option.Key("oceanPrinceOptions.isEnabled");
        public final Option.Key witchQueenOptions_color = new Option.Key("witchQueenOptions.color");
        public final Option.Key witchQueenOptions_isEnabled = new Option.Key("witchQueenOptions.isEnabled");
        public final Option.Key dragonKingOptions_color = new Option.Key("dragonKingOptions.color");
        public final Option.Key dragonKingOptions_isEnabled = new Option.Key("dragonKingOptions.isEnabled");
        public final Option.Key superWardenOptions_color = new Option.Key("superWardenOptions.color");
        public final Option.Key superWardenOptions_isEnabled = new Option.Key("superWardenOptions.isEnabled");
        public final Option.Key cursedAFOptions_color = new Option.Key("cursedAFOptions.color");
        public final Option.Key cursedAFOptions_isEnabled = new Option.Key("cursedAFOptions.isEnabled");
        public final Option.Key cursedZEDDY1977Options_color = new Option.Key("cursedZEDDY1977Options.color");
        public final Option.Key cursedZEDDY1977Options_isEnabled = new Option.Key("cursedZEDDY1977Options.isEnabled");
        public final Option.Key cursedCranklesOptions_color = new Option.Key("cursedCranklesOptions.color");
        public final Option.Key cursedCranklesOptions_isEnabled = new Option.Key("cursedCranklesOptions.isEnabled");
        public final Option.Key cursedSolphireOptions_color = new Option.Key("cursedSolphireOptions.color");
        public final Option.Key cursedSolphireOptions_isEnabled = new Option.Key("cursedSolphireOptions.isEnabled");
        public final Option.Key cursedFunMummyOptions_color = new Option.Key("cursedFunMummyOptions.color");
        public final Option.Key cursedFunMummyOptions_isEnabled = new Option.Key("cursedFunMummyOptions.isEnabled");
        public final Option.Key modColors_primary = new Option.Key("modColors.primary");
        public final Option.Key modColors_secondary = new Option.Key("modColors.secondary");
        public final Option.Key modColors_tertiary = new Option.Key("modColors.tertiary");
        public final Option.Key modColors_quaternary = new Option.Key("modColors.quaternary");
    }
}

