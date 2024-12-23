package me.ders.darknessutils.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import me.ders.darknessutils.DarknessUtils;
import me.ders.darknessutils.mixed.HandledScreenMixed;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

import static me.ders.darknessutils.DarknessUtils.lockBinding;
import static me.ders.darknessutils.features.SlotLocking.isLocked;

@Mixin(HandledScreen.class)
public abstract class HandledScreenMixin<T extends ScreenHandler> extends Screen implements HandledScreenMixed {

    protected HandledScreenMixin(Text title) {
        super(title);
    }

    private static final Identifier SLOT_LOCK_TEXTURE = Identifier.of("darknessutils", "lock_overlay.png");

    @Shadow @Nullable
    protected Slot focusedSlot;

    @Shadow @Final
    protected T handler;

    private PlayerInventory slotlock$playerInventory;

    @Override
    public PlayerInventory slotlock$getPlayerInventory() {
        return slotlock$playerInventory;
    }

    @Inject(at = @At("TAIL"), method = "<init>")
    public void onInit(T handler, PlayerInventory inventory, Text title, CallbackInfo ci) {
        slotlock$playerInventory = inventory;
    }

    @Inject(at = @At("HEAD"), method = "onMouseClick(Lnet/minecraft/screen/slot/Slot;IILnet/minecraft/screen/slot/SlotActionType;)V", cancellable = true)
    public void onMouseClick(Slot slot, int invSlot, int clickData, SlotActionType actionType, CallbackInfo info) {
        me.ders.darknessutils.features.SlotLocking.handleMouseClick(handler, slotlock$playerInventory, slot, null, invSlot, clickData, actionType, info);
    }

    @Inject(at = @At("HEAD"), method = "keyPressed", cancellable = true)
    public void keyPressed(int keyCode, int scanCode, int modifiers, CallbackInfoReturnable<Boolean> info) {
        me.ders.darknessutils.features.SlotLocking.handleKeyPressed(focusedSlot, slotlock$playerInventory, keyCode, scanCode, info);
    }

    @Inject(at = @At("HEAD"), method = "handleHotbarKeyPressed", cancellable = true)
    public void handleHotbarKeyPressed(int keyCode, int scanCode, CallbackInfoReturnable<Boolean> info) {
        me.ders.darknessutils.features.SlotLocking.handleHotbarKeyPressed(focusedSlot, slotlock$playerInventory, info);
    }

    @Inject(at = @At("HEAD"), method = "drawMouseoverTooltip", cancellable = true)
    public void drawMouseoverTooltip(DrawContext drawContext, int x, int y, CallbackInfo ci) {
        if (handler.getCursorStack().isEmpty() && this.focusedSlot != null && this.focusedSlot.inventory == this.slotlock$playerInventory) {
            Slot finalSlot = focusedSlot;

            if(finalSlot instanceof CreativeInventoryScreen.CreativeSlot) {
                finalSlot = ((CreativeSlotAccessor) finalSlot).getSlot();
            }

            if(finalSlot != null && isLocked(((SlotAccessor) finalSlot).getIndex()) && DarknessUtils.CONFIG.doSlotLocking()) {
                ItemStack stack = finalSlot.hasStack() ? this.focusedSlot.getStack() : ItemStack.EMPTY;
                List<Text> tooltip = getTooltipFromItem(MinecraftClient.getInstance(), stack);

                tooltip.add(Text.translatable("slotlock.locked"));
                tooltip.add(Text.translatable("slotlock.press1").append(lockBinding.getBoundKeyLocalizedText().copy().append(Text.translatable("slotlock.press2"))));

                drawContext.drawTooltip(
                    this.textRenderer, tooltip, stack.getTooltipData() , x, y, stack.get(DataComponentTypes.TOOLTIP_STYLE)
                );

                ci.cancel();
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "drawSlot")
    public void drawSlot(DrawContext context, Slot slot, CallbackInfo ci) {
        Slot finalSlot = slot;
        if(finalSlot instanceof CreativeInventoryScreen.CreativeSlot) {
            finalSlot = ((CreativeSlotAccessor) finalSlot).getSlot();
        }
        if(this.client != null && slot.inventory == slotlock$playerInventory && isLocked(((SlotAccessor) finalSlot).getIndex()) && DarknessUtils.CONFIG.doSlotLocking()) {
            RenderSystem.setShaderTexture(0, SLOT_LOCK_TEXTURE);
            context.drawTexture(
                    RenderLayer::getGuiTexturedOverlay,
                    SLOT_LOCK_TEXTURE,
                    slot.x,
                    slot.y,
                    0,
                    0,
                    16,
                    16,
                    256,
                    256
            );
        }
    }

}