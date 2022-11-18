package cn.harper.utils.player;

import cn.harper.injection.interfaces.IKeyBinding;
import net.minecraft.client.Minecraft;

public class PlayerUtil {
    public static Minecraft mc = Minecraft.getMinecraft();
    public static boolean MovementInput() {
        return ((IKeyBinding)mc.gameSettings.keyBindForward).getPress() || ((IKeyBinding)mc.gameSettings.keyBindLeft).getPress() || ((IKeyBinding)mc.gameSettings.keyBindRight).getPress() || ((IKeyBinding)mc.gameSettings.keyBindBack).getPress();
    }
}
