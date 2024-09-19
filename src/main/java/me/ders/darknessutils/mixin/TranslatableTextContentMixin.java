package me.ders.darknessutils.mixin;


import io.wispforest.owo.text.TextLanguage;
import me.ders.darknessutils.DarknessUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.*;
import net.minecraft.util.Language;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * cursed voodoo magic for pretty colors
 */
@Environment(EnvType.CLIENT)
@Mixin(value = TranslatableTextContent.class, priority = 900)
public abstract class TranslatableTextContentMixin {

    @Shadow
    private List<StringVisitable> translations;

    @Shadow
    @Final
    private String key;

    Map<String, Supplier<Integer>> colorMapping = new HashMap<>() {{
        put("<primary>", () -> DarknessUtils.CONFIG.modColors.primary().rgb());
        put("<secondary>", () -> DarknessUtils.CONFIG.modColors.secondary().rgb());
        put("<tertiary>", () -> DarknessUtils.CONFIG.modColors.tertiary().rgb());
        put("<quaternary>", () -> DarknessUtils.CONFIG.modColors.quaternary().rgb());
    }};

    @Inject(method = "updateTranslations", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Language;get(Ljava/lang/String;)Ljava/lang/String;"), cancellable = true)
    public void injectUpdateTranslations(CallbackInfo ci) {

        if(!key.contains("darkness-settings")) return;

        Language lang = Language.getInstance();
        if (lang instanceof TextLanguage) {
            MutableText text = (MutableText) ((TextLanguage) lang).getText(key);

            if(text != null) {
                for (Map.Entry<String, Supplier<Integer>> entry : colorMapping.entrySet()) {
                    if(text.toString().contains(entry.getKey())) {
                        Style prevStyle = text.getStyle();

                        text = (MutableText) Text.of(text.getString().replace(entry.getKey(), ""));
                        text.setStyle(prevStyle.withColor(entry.getValue().get()));
                    }
                    translations = new ArrayList<>();
                    translations.add(text);
                    ci.cancel();
                }
            }
        }
    }
}