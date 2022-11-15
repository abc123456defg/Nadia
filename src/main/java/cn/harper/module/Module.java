package cn.harper.module;

import com.darkmagician6.eventapi.EventManager;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class Module {
    private String name, description, tag = "";
    private int keyCode;
    private Category category;
    public boolean isEnabled;
    public boolean cantToggle = false;
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
}
