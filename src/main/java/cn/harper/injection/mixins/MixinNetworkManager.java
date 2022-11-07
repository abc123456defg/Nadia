package cn.harper.injection.mixins;

import cn.harper.event.EventPacketReceive;
import cn.harper.event.EventPacketSend;
import com.darkmagician6.eventapi.EventManager;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetworkManager.class)
public class MixinNetworkManager {


    @Inject(method = "channelRead0", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/Packet;processPacket(Lnet/minecraft/network/INetHandler;)V", shift = At.Shift.BEFORE), cancellable = true)
    private void packetReceived(ChannelHandlerContext p_channelRead0_1_, Packet packet, CallbackInfo ci) {
        EventPacketReceive event = new EventPacketReceive(packet);
        EventManager.call(event);
        if (event.isCancelled()) {
            ci.cancel();
        }
    }

    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    private void packetSend(Packet packetIn, CallbackInfo ci) {
        EventPacketSend event = new EventPacketSend(packetIn);
        EventManager.call(event);
        if (event.isCancelled()) {
            ci.cancel();
        }
    }

}
