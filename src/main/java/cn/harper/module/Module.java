package cn.harper.module;

import cn.harper.core.font.FontManager;
import cn.harper.utils.render.RenderUtil;
import com.darkmagician6.eventapi.EventManager;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class Module {
    private String name, description,displayName, tag = "";
    private int keyCode;
    private Category category;
    public boolean isEnabled;
    public boolean cantToggle = false;
    private boolean isHide  = false;

    public float posX;
    public float posY;
    public float lastY;
    public float posYRend;
    public float displaywidth;
    public float namewidth;
    public static Minecraft mc = Minecraft.getMinecraft();


    public Module(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.keyCode = Keyboard.KEY_NONE;
    }

    public Module(String name, Category category) {
        this.name = name;
        this.description = "unknown";
        this.category = category;
        this.keyCode = Keyboard.KEY_NONE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isHide() {
        return isHide;
    }

    public void setCantToggle(boolean cantToggle) {
        this.cantToggle = cantToggle;
    }

    public void setHide(boolean hide) {
        isHide = hide;
    }

    public void onEnable() {
        EventManager.register(this);
    }

    public void onDisable() {
        EventManager.unregister(this);
    }

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }


    public void setDisplayName(String displayName) {

        if (this.displayName == null) {
            this.displayName = displayName;
            displaywidth = FontManager.normal.getStringWidth(displayName);
            namewidth = FontManager.normal.getStringWidth(name);

            posX = -15;

        }

        if (!this.displayName.equals(displayName)) {
            this.displayName = displayName;
            displaywidth = FontManager.normal.getStringWidth(displayName);
            namewidth = FontManager.normal.getStringWidth(name);

            posX = -15;

        }
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
    public void enable() {
        this.setEnabled(true);
    }

    public void disable() {
        this.setEnabled(false);
    }

    public void toggle() {
        if (this.cantToggle) return;
        this.setEnabled(!this.isEnabled);
    }

    public void setEnabled(boolean action) {

        if (this.cantToggle) return;

        if (action) {
            this.isEnabled = true;
            this.onEnable();

            if (mc.theWorld != null) {
                mc.thePlayer.playSound("random.click", 0.5F, 1.0F);
            }

        } else {
            this.isEnabled = false;
            this.onDisable();

            if (mc.theWorld != null) {
                mc.thePlayer.playSound("random.click", 0.4F, 0.8F);
            }

        }

    }
    public void onRenderArray() {

        if (namewidth == 0)
            namewidth = FontManager.normal.getStringWidth(name);

        if (lastY - posY > 0)
            posYRend = 14;
        if (lastY - posY < 0)
            posYRend = -14;
        if (posYRend != 0)
            posYRend = (float) RenderUtil.getAnimationStateSmooth(0, posYRend, 16.0f / Minecraft.getDebugFPS());

        float modwidth = (displayName != null) ? FontManager.normal.getStringWidth(displayName) + 3 + FontManager.normal.getStringWidth(name) : namewidth;

        if (isEnabled()) {
            posX = (float) RenderUtil.getAnimationStateSmooth(modwidth, posX, 16.0f / Minecraft.getDebugFPS());
        } else {
            posX = (float) RenderUtil.getAnimationStateSmooth(-15, posX, 16.0f / Minecraft.getDebugFPS());
        }
    }
}
