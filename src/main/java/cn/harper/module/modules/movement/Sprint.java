package cn.harper.module.modules.movement;

import cn.harper.event.EventUpdate;
import cn.harper.module.Category;
import cn.harper.module.Module;
import cn.harper.utils.player.PlayerUtil;
import com.darkmagician6.eventapi.EventTarget;

public class Sprint extends Module {
    public Sprint(){
        super("Sprint", Category.Movement);
        setEnabled(true);
    }
    @EventTarget
    public void onUpdate(EventUpdate event){
        boolean sprint = mc.thePlayer.getFoodStats().getFoodLevel() > 6.0F || mc.thePlayer.capabilities.allowFlying;
        if (mc.thePlayer.isSneaking()|| this.mc.thePlayer.isCollidedHorizontally){
            return;
        }
        if (PlayerUtil.MovementInput() && sprint ){
            mc.thePlayer.setSprinting(true);
        }
    }
    @Override
    public void onDisable(){
        mc.thePlayer.setSprinting(false);
    }

}
