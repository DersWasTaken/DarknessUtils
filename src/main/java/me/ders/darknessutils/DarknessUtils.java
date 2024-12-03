package me.ders.darknessutils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.wispforest.owo.config.ui.ConfigScreenProviders;
import me.ders.darknessutils.config.DarknessModSettings;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.incendo.cloud.Command;
import org.incendo.cloud.execution.ExecutionCoordinator;
import org.incendo.cloud.fabric.FabricClientCommandManager;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;

public class DarknessUtils implements ModInitializer {

    public static final DarknessModSettings CONFIG = DarknessModSettings.createAndLoad();
    public static KeyBinding lockBinding;

    public static boolean isSaveDirty = false;
    private long lastDirtyCheck = System.currentTimeMillis();

    public static LinkedHashSet<Integer> lockedSlots = new LinkedHashSet<>();

    @Override
    public void onInitialize() {
        final FabricClientCommandManager<FabricClientCommandSource> commandManager =
                FabricClientCommandManager.createNative(ExecutionCoordinator.simpleCoordinator());

        final Command.Builder<FabricClientCommandSource> base = commandManager.commandBuilder("darkness");

        commandManager.command(base.literal("config")
                .handler(ctx -> {
                    MinecraftClient.getInstance().send(() -> MinecraftClient.getInstance().setScreen(ConfigScreenProviders.get("darknessutils").apply(null)));
                }));

        lockBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.slotlock",
                InputUtil.Type.KEYSYM,
                InputUtil.GLFW_KEY_LEFT_ALT,
                "key.categories.inventory"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            long currentDirtyCheck = System.currentTimeMillis();

            if(currentDirtyCheck - lastDirtyCheck > 2000) {
                if(isSaveDirty) {
                    File slotLockFile = new File(MinecraftClient.getInstance().runDirectory, "slotlock.json");
                    Path slotLockPath = Paths.get(slotLockFile.getAbsolutePath());
                    String json = "{ }";

                    try {
                        json = Files.readString(slotLockPath);
                    } catch (Exception ignored) { }

                    JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
                    JsonArray jsonArray = new JsonArray();
                    lockedSlots.forEach(jsonArray::add);
                    jsonObject.add("lockedSlots", jsonArray);

                    try {
                        Files.writeString(slotLockPath, jsonObject.toString());
                    } catch (Exception e) {
                        System.getLogger("DarknessUtils").log(System.Logger.Level.INFO,"Failed to update slotlock file");
                    }

                    isSaveDirty = false;
                }

                lastDirtyCheck = currentDirtyCheck;
            }
        });
    }

}