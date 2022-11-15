package cn.harper.core;


import cn.harper.module.ModuleManager;
import org.lwjgl.opengl.Display;

public class Client {
    public static Client instance = new Client();
    public String Name = "Nadia";
    public float Version = 0.1f;
    public String Author = "Harper";

    private ModuleManager moduleManager;
    public void init() {
        Display.setTitle(Name + " " + Version);
        moduleManager = new ModuleManager();
        moduleManager.init();
    }

    public void shutdown() {

    }
}
