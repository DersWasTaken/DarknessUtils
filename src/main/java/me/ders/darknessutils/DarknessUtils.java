package me.ders.darknessutils;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class DarknessUtils implements ModInitializer {

    public static boolean GlowEnabled = true;

    @Override
    public void onInitialize() {
        //TODO: COMMAND API AND TEXT API (MINI-MESSAGE?)
        ClientCommandRegistrationCallback
            .EVENT
            .register((dispatcher, registryAccess) -> dispatcher.register(ClientCommandManager.literal("glow")
                .executes(context -> {
                    GlowEnabled = !GlowEnabled;

                    MutableText glowValue = GlowEnabled ?
                        Text.literal("[ENABLED]").formatted(Formatting.DARK_GREEN, Formatting.BOLD) :
                        Text.literal("[DISABLED]").formatted(Formatting.DARK_RED, Formatting.BOLD);

                    glowValue.append(Text.literal(" - ").formatted(Formatting.DARK_GRAY));
                    glowValue.append(Text.literal("Boss Highlights").formatted(Formatting.GRAY));

                    context.getSource().sendFeedback(glowValue);
                    return 1;
                })
        ));
    }
}