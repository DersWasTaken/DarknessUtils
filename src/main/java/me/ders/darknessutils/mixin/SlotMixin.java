package me.ders.darknessutils.mixin;

import me.ders.darknessutils.DarknessUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static me.ders.darknessutils.features.SlotLocking.isLocked;

@Mixin(Slot.class)
public class SlotMixin {

    @Shadow @Final
    public Inventory inventory;

    @Shadow
    @Final private int index;

    @Inject(at = @At("HEAD"), method = "canInsert", cancellable = true)
    public void canInsert(ItemStack stack, CallbackInfoReturnable<Boolean> info) {
        if(!MinecraftClient.getInstance().isOnThread()) return;

        if(MinecraftClient.getInstance().player != null) {
            PlayerInventory playerInventory = MinecraftClient.getInstance().player.getInventory();

            if(inventory == playerInventory && isLocked(index) && DarknessUtils.CONFIG.doSlotLocking())
                info.setReturnValue(false);
        }
    }

    @Inject(at = @At("HEAD"), method = "canTakeItems", cancellable = true)
    public void canTakeItems(PlayerEntity playerEntity, CallbackInfoReturnable<Boolean> info) {
        if(!MinecraftClient.getInstance().isOnThread()) return;

        if(inventory == playerEntity.getInventory() && isLocked(index) && DarknessUtils.CONFIG.doSlotLocking())
            info.setReturnValue(false);
    }

}