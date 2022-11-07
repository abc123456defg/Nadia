package cn.harper.core;


import org.lwjgl.opengl.Display;

public class Client {
    public static Client instance = new Client();
    public String Name = "Nadia";
    public float Version = 0.1f;
    public String Author = "Harper";

    public void init() {
        Display.setTitle(Name + " " + Version);
    }

    public void shutdown() {

    }
}
