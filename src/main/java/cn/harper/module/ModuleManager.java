package cn.harper.module;

import com.darkmagician6.eventapi.EventManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleManager {
    private static final ArrayList<Module> mL = new ArrayList<>();
    public ModuleManager(){
        EventManager.register(this);
    }
    public Module getModuleByName(String theMod) {
        for (Module mod : getModList()) {
            if (mod.getName().equalsIgnoreCase(theMod)) {
                return mod;
            }
        }
        return null;
    }

    public Module getModuleByClass(Class<? extends Module> theMod) {
        for (Module mod : getModList()) {
            if (mod.getClass().equals(theMod)) {
                return mod;
            }
        }
        return null;
    }

    public List<Module> getModulesByCategory(Category category) {
        return getModList().stream().filter(module -> module.getCategory() == category).collect(Collectors.toList());
    }

    public static void registerModule(Module module) {
        mL.add(module);
    }
    public static ArrayList<Module> getModList() {
        return mL;
    }
}
