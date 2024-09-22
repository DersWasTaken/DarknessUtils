package me.ders.darknessutils.mixin;


import io.wispforest.owo.ui.core.Color;
import me.ders.darknessutils.DarknessUtils;
import me.ders.darknessutils.config.impl.BossOptions;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    @Shadow private World world;

    Map<String, Supplier<Object>> mobColors = new HashMap<>() {{
        put("Skeleton King",        () -> DarknessUtils.CONFIG.skeletonKingOptions);
        put("Zombie King",          () -> DarknessUtils.CONFIG.zombieKingOptions);
        put("Nether King",          () -> DarknessUtils.CONFIG.netherKingOptions);
        put("Spider King",          () -> DarknessUtils.CONFIG.spiderKingOptions);
        put("Dragon Slayer",        () -> DarknessUtils.CONFIG.dragonSlayerOptions);
        put("Panda King",           () -> DarknessUtils.CONFIG.pandaKingOptions);
        put("Pumpkin King",         () -> DarknessUtils.CONFIG.pumpkinKingOptions);
        put("Ocean Prince",         () -> DarknessUtils.CONFIG.oceanPrinceOptions);
        put("Witch Queen",          () -> DarknessUtils.CONFIG.witchQueenOptions);
        put("Dragon King",          () -> DarknessUtils.CONFIG.dragonKingOptions);
        put("Super Warden",         () -> DarknessUtils.CONFIG.superWardenOptions);
        put("Cursed AutismFather",  () -> DarknessUtils.CONFIG.cursedAFOptions);
        put("Cursed ZEDDY1977",     () -> DarknessUtils.CONFIG.cursedZEDDY1977Options);
        put("Cursed Crankles_",     () -> DarknessUtils.CONFIG.cursedCranklesOptions);
        put("Cursed Solphire",      () -> DarknessUtils.CONFIG.cursedSolphireOptions);
        put("Cursed FunMummy",      () -> DarknessUtils.CONFIG.cursedFunMummyOptions);
    }};

    /**
     * @author Der_s
     * @reason Calls to {@link Entity#setGlowing} do not work for client sided entities.
     */
    @Overwrite
    public boolean isGlowing() {
        if(hasCustomName()) {
            Optional<Map.Entry<String, Supplier<Object>>> mobColor = getMobColor();
            if (mobColor.isPresent()) {
                if (world.getBlockState(new BlockPos(95, 3, -251)).getBlock().asItem() == Items.BEDROCK || world.isClient()) {
                    //more voodoo magic, do not attempt
                    try {
                        Method isEnabledMethod = mobColor.get().getValue().get().getClass().getDeclaredMethod("isEnabled");
                        return (Boolean) isEnabledMethod.invoke(mobColor.get().getValue().get()) && DarknessUtils.CONFIG.showBossHighlights();
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        return getWorld().isClient() ? getFlag(GLOWING_FLAG_INDEX) : glowing;
    }

    @Inject(method = "getTeamColorValue", at = @At("HEAD"), cancellable = true)
    public void injectGetTeamColorValue(CallbackInfoReturnable<Integer> ci) {
        if(hasCustomName() && DarknessUtils.CONFIG.showBossHighlights()) {
            getMobColor().ifPresent(entry -> {
                //actual black magic, avoid in future
                try {
                    Method colorMethod = entry.getValue().get().getClass().getDeclaredMethod("color");
                    Color color = (Color) colorMethod.invoke(entry.getValue().get());

                    ci.setReturnValue(color.rgb());
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    public Optional<Map.Entry<String, Supplier<Object>>> getMobColor() {
        return mobColors
                .entrySet()
                .stream()
                .filter(it -> getCustomName()
                        .toString()
                        .toLowerCase()
                        .contains(it.getKey().toLowerCase())).findFirst();
    }
}
