package me.ders.darknessutils.mixin;

import me.ders.darknessutils.DarknessUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static me.ders.darknessutils.features.SlotLocking.isLocked;

@Mixin(ScreenHandler.class)
public class ScreenHandlerMixin {

    @Shadow
    @Final
    public DefaultedList<Slot> slots;

    @Inject(at = @At("HEAD"), method = "onSlotClick", cancellable = true)
    public void onSlotClick(int slotIndex, int button, SlotActionType actionType, PlayerEntity player, CallbackInfo info) {
        if(!MinecraftClient.getInstance().isOnThread()) return;

        if(slotIndex >= 0 && slotIndex < this.slots.size()) {
            Slot finalSlot = this.slots.get(slotIndex);

            if(finalSlot instanceof CreativeInventoryScreen.CreativeSlot)
                finalSlot = ((CreativeSlotAccessor) finalSlot).getSlot();

            if (finalSlot.inventory == player.getInventory() && isLocked(((SlotAccessor) finalSlot).getIndex()) && DarknessUtils.CONFIG.doSlotLocking())
                info.cancel();
        }
    }


}