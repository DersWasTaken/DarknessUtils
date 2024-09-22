package me.ders.darknessutils;

import io.wispforest.owo.config.ui.ConfigScreenProviders;
import me.ders.darknessutils.config.DarknessModSettings;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.MessageAcknowledgmentC2SPacket;
import net.minecraft.text.Text;
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

//        commandManager.command(base.literal("testcrash")
//                .handler(ctx -> {
//                    MinecraftClient.getInstance().player.networkHandler.sendPacket(new MessageAcknowledgmentC2SPacket(-1));
//                }));
    }
}