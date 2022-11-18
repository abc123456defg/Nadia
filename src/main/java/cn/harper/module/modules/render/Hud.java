package cn.harper.module.modules.render;

import cn.harper.core.font.FontManager;
import cn.harper.event.EventRender2D;
import cn.harper.module.Category;
import cn.harper.module.Module;
import cn.harper.module.ModuleManager;
import cn.harper.utils.color.ColorUtils;
import cn.harper.utils.render.RenderUtil;
import com.darkmagician6.eventapi.EventTarget;
import com.darkmagician6.eventapi.types.Priority;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Keyboard;

import java.awt.*;

public class Hud extends Module {

    public Hud(){
        super("HUD", Category.Render);
        this.setEnabled(true);
        this.setKeyCode(Keyboard.KEY_N);
        this.setDisplayName("Simple");
    }

    @EventTarget
    public void onRender(EventRender2D event){
        ScaledResolution sr = new ScaledResolution(mc);
        float width = sr.getScaledWidth();
        float height = sr.getScaledHeight();
        renderArray(sr);
    }
    private void renderArray(ScaledResolution sr) {

        float nextY = 3f;

        for (Module module : ModuleManager.getEnabledModList()) {
            module.onRenderArray();
            if (!module.isEnabled() && module.posX == 0)
                continue;

            // Module 信息
            String modName = module.getName();
            String displayName = module.getDisplayName();
            float modwidth = module.posX;

            module.lastY = module.posY;
            module.posY = nextY;

            // 画背景
            RenderUtil.drawRect(sr.getScaledWidth() - modwidth - 7f, nextY + module.posYRend - 3.5f,
                    sr.getScaledWidth(), nextY + module.posYRend + 10.5f, RenderUtil.reAlpha(ColorUtils.BLACK.c, 0.55f));
            // 画字体
            FontManager.normal.drawString(modName, sr.getScaledWidth() - modwidth - 2, nextY + module.posYRend - 1.5f,
                    new Color(191, 144, 240).getRGB());
            if (displayName != null)
                FontManager.normal.drawString(displayName, sr.getScaledWidth() - modwidth + FontManager.normal.getStringWidth(modName),
                        nextY + module.posYRend - 1.5f, new Color(159, 159, 159).getRGB());

            nextY += 14;
        }

    }
}
