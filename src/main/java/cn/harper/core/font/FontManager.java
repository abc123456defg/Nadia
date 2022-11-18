package cn.harper.core.font;

import cn.harper.core.font.utils.FontUtils;
import cn.harper.utils.Info;


import java.awt.*;
import java.io.InputStream;

public class FontManager {


    public static FontUtils normal = new FontUtils("Baloo.ttf", Font.PLAIN, 18, 7, false);


    public static Font getFont(String name, int size) {
        Font font;
        try {
            InputStream is = FontManager.class.getResourceAsStream("/assets/minecraft/nadia/font/" + name);
            font = Font.createFont(0, is);
            font = font.deriveFont(Font.PLAIN, size);

        } catch (Exception ex) {
            Info.getLogger().info("[FontManager]: Error loading font " + name);
            font = new Font("Arial", Font.PLAIN, size);
        }
        return font;
    }
}