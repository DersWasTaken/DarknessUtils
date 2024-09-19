package me.ders.darknessutils;

import io.wispforest.owo.config.ui.ConfigScreenProviders;
import me.ders.darknessutils.config.DarknessModSettings;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.loader.api.LanguageAdapter;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Language;
import org.incendo.cloud.Command;
import org.incendo.cloud.execution.ExecutionCoordinator;
import org.incendo.cloud.fabric.FabricClientCommandManager;

public class DarknessUtils implements ModInitializer {

    public static final DarknessModSettings CONFIG = DarknessModSettings.createAndLoad();

    @Override
    public void onInitialize() {
        final FabricClientCommandManager<FabricClientCommandSource> commandManager =
                FabricClientCommandManager.createNative(ExecutionCoordinator.simpleCoordinator());

        final Command.Builder<FabricClientCommandSource> base = commandManager.commandBuilder("darkness");

        commandManager.command(base.literal("config")
                .handler(ctx -> {
                    MinecraftClient.getInstance().send(() -> MinecraftClient.getInstance().setScreen(ConfigScreenProviders.get("darknessutils").apply(null)));
                }));
    }
}