package me.ders.darknessutils.features;

import me.ders.darknessutils.DarknessUtils;
import me.ders.darknessutils.mixin.PlayerInventoryAccessor;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.KeybindComponent;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class AutoFix {

    private static AutoFix instance;
    private boolean triggerFix = false;

    private AutoFix() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(triggerFix) return;

            if(client.player == null) return;
            if(MinecraftClient.getInstance().world == null) return;
            if(client.player.getInventory() == null) return;

            PlayerInventoryAccessor inventoryAccessor = (PlayerInventoryAccessor) MinecraftClient.getInstance().player.getInventory();

            for (DefaultedList<ItemStack> itemStacks : inventoryAccessor.getCombinedInventory()) {
                itemStacks.forEach(itemStack -> {
                    checkItem(itemStack, client);
                });
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(!triggerFix) return;
            if(client.player == null) return;
            if(MinecraftClient.getInstance().world == null) return;

            if(DarknessUtils.fixBinding.wasPressed()) {
                MinecraftClient.getInstance().player.networkHandler.sendChatCommand("fix all");

                triggerFix = false;
            }
        });
    }

    public static AutoFix getInstance() {
        if(instance == null) {
            instance = new AutoFix();
        }
        return instance;
    }

    private void checkItem(ItemStack item, MinecraftClient client) {
        if (item.isEmpty() || item.getMaxDamage() == 0) return;

        double damagePercent = (double) (item.getMaxDamage() - item.getDamage()) / item.getMaxDamage();

        if (damagePercent <= 0.5) {
            triggerFix = true;

            KeybindComponent key = Component.keybind("key.fix").color(NamedTextColor.GREEN);
            TextComponent text = Component.text("Press ", NamedTextColor.GRAY)
                    .append(key)
                    .append(Component.text(" to fix your gear").color(NamedTextColor.GRAY));

            client.player.sendMessage(text);
        }
    }


}