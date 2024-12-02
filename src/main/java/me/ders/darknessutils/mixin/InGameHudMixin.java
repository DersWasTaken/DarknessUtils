package me.ders.darknessutils.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import me.ders.darknessutils.DarknessUtils;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static me.ders.darknessutils.features.SlotLocking.isLocked;
import static me.ders.darknessutils.features.SlotLocking.unlockSlot;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    private static final Identifier SLOT_LOCK_TEXTURE = Identifier.of("darknessutils", "lock_overlay.png");

    private MatrixStack matrices;
    private int slotIndex = 0;

    @Inject(at = @At("HEAD"), method = "renderHotbar")
    public void renderHotbar(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        matrices = context.getMatrixStack();
        slotIndex = 0;
    }

    @Inject(at = @At("HEAD"), method = "renderHotbarItem")
    public void renderHotbarItem(DrawContext context, int x, int y, RenderTickCounter tickCounter, PlayerEntity player, ItemStack stack, int seed, CallbackInfo ci) {
        if (isLocked(slotIndex) && DarknessUtils.CONFIG.doSlotLocking()) {
            if (player.getInventory().getStack(slotIndex).isEmpty()) {
                unlockSlot(slotIndex);
            } else {
                RenderSystem.setShaderTexture(0, SLOT_LOCK_TEXTURE);

                context.drawTexture(
                        SLOT_LOCK_TEXTURE,
                        x,
                        y,
                        0,
                        0,
                        16,
                        16,
                        256,
                        256
                );
            }
        }
        slotIndex++;

        if(slotIndex == 9)
            slotIndex = 40;
    }

}
