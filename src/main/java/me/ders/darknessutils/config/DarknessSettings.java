package me.ders.darknessutils.config;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.Nest;
import io.wispforest.owo.config.annotation.SectionHeader;
import io.wispforest.owo.ui.core.Color;
import me.ders.darknessutils.config.impl.BossOptions;
import org.checkerframework.checker.units.qual.N;

@Modmenu(modId = "darknessutils")
@Config(name = "darkness-settings", wrapperName = "DarknessModSettings")
public class DarknessSettings {

    @SectionHeader("bossSettings")
    public boolean showBossHighlights = true;

    @Nest
    public BossOptions.SkeletonKingOptions skeletonKingOptions = new BossOptions.SkeletonKingOptions();

    @Nest
    public BossOptions.ZombieKingOptions zombieKingOptions = new BossOptions.ZombieKingOptions();

    @Nest
    public BossOptions.NetherKingOptions netherKingOptions = new BossOptions.NetherKingOptions();

    @Nest
    public BossOptions.SpiderKingOptions spiderKingOptions = new BossOptions.SpiderKingOptions();

    @Nest
    public BossOptions.DragonSlayerOptions dragonSlayerOptions = new BossOptions.DragonSlayerOptions();

    @Nest
    public BossOptions.PandaKingOptions pandaKingOptions = new BossOptions.PandaKingOptions();

    @Nest
    public BossOptions.PumpkinKingOptions pumpkinKingOptions = new BossOptions.PumpkinKingOptions();

    @Nest
    public BossOptions.OceanPrinceOptions oceanPrinceOptions = new BossOptions.OceanPrinceOptions();

    @Nest
    public BossOptions.WitchQueenOptions witchQueenOptions = new BossOptions.WitchQueenOptions();

    @Nest
    public BossOptions.DragonKingOptions dragonKingOptions = new BossOptions.DragonKingOptions();

    @Nest
    public BossOptions.SuperWardenOptions superWardenOptions = new BossOptions.SuperWardenOptions();

    @Nest
    public BossOptions.CursedAFOptions cursedAFOptions = new BossOptions.CursedAFOptions();

    @Nest
    public BossOptions.CursedZEDDY1977Options cursedZEDDY1977Options = new BossOptions.CursedZEDDY1977Options();

    @Nest
    public BossOptions.CursedCrankles_Options cursedCranklesOptions = new BossOptions.CursedCrankles_Options();

    @Nest
    public BossOptions.CursedSolphireOptions cursedSolphireOptions = new BossOptions.CursedSolphireOptions();

    @Nest
    public BossOptions.CursedFunMummyOptions cursedFunMummyOptions = new BossOptions.CursedFunMummyOptions();

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