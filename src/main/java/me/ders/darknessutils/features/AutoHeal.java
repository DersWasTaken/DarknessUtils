package me.ders.darknessutils.features;

import me.ders.darknessutils.DarknessUtils;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.KeybindComponent;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.minecraft.client.MinecraftClient;

public class AutoHeal {

    private static AutoHeal instance;
    private boolean triggerHeal = false;

    private AutoHeal() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(triggerHeal) return;

            if(client.player == null) return;
            if(MinecraftClient.getInstance().world == null) return;

            double healthPercentage = client.player.getHealth() / client.player.getMaxHealth();

            if(healthPercentage <= 0.4) {
                triggerHeal = true;

                KeybindComponent key = Component.keybind("key.heal").color(NamedTextColor.GREEN);
                TextComponent text = Component.text("Press ", NamedTextColor.GRAY)
                        .append(key)
                        .append(Component.text(" to heal yourself").color(NamedTextColor.GRAY));

                client.player.sendMessage(text);
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(!triggerHeal) return;
            if(client.player == null) return;
            if(MinecraftClient.getInstance().world == null) return;

            if(DarknessUtils.healBinding.wasPressed()) {
                MinecraftClient.getInstance().player.networkHandler.sendChatCommand("heal");

                triggerHeal = false;
            }
        });
    }

    public static AutoHeal getInstance() {
        if(instance == null) {
            instance = new AutoHeal();
        }
        return instance;
    }

}