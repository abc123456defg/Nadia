package cn.harper.injection.mixins;

import cn.harper.event.EventRender;
import com.darkmagician6.eventapi.EventManager;
import net.minecraft.client.renderer.EntityRenderer;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class MixinEntityRenderer {
    @Inject(method = "renderWorldPass", at =
    @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;disableFog()V", shift = At.Shift.AFTER))
    private void eventRender3D(int pass, float partialTicks, long finishTimeNano, CallbackInfo callbackInfo) {
        EventRender eventRender = new EventRender(pass, partialTicks, finishTimeNano);
        EventManager.call(eventRender);
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
    }
}
