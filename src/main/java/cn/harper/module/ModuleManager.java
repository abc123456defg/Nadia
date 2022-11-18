package cn.harper.module;

import cn.harper.event.EventKey;
import cn.harper.module.modules.movement.Sprint;
import cn.harper.module.modules.render.Hud;
import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleManager {
    public static boolean needsort = true;
    public static final ArrayList<Module> modulelist = new ArrayList<>();
    public static ArrayList<Module> enabledModList = new ArrayList<>();

    public ModuleManager() {
        EventManager.register(this);
    }

    public void init() {
        //movement
        modulelist.add(new Sprint());
        //render
        modulelist.add(new Hud());
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

    public static ArrayList<Module> getModList() {
        return modulelist;
    }
    public static ArrayList<Module> getEnabledModList() {
        ArrayList<Module> enabledModList = new ArrayList<>();
        for (Module m : getModList()) {
            if (m.isEnabled() && !m.isHide()) {
                enabledModList.add(m);
            }
        }
        return enabledModList;
    }

    @EventTarget
    public void onKey(EventKey event) {
        for (Module module : modulelist) {
            if (module.getKeyCode() == event.getKeyCode()) {
                module.toggle();
            }
        }

    }
}
