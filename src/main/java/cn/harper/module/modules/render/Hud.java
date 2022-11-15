package cn.harper.module.modules.render;

import cn.harper.event.EventRender2D;
import cn.harper.module.Category;
import cn.harper.module.Module;
import com.darkmagician6.eventapi.EventTarget;
import org.lwjgl.input.Keyboard;

public class Hud extends Module {

    public Hud(){
        super("HUD", Category.Render);
        this.setEnabled(true);
        this.setKeyCode(Keyboard.KEY_N);
    }
    @EventTarget
    public void onRender(EventRender2D event){


    }
}
