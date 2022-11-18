package cn.harper.value.impl;


import cn.harper.value.Value;

public class ModeValue extends Value<String> {
    private final String[] modes;

    public ModeValue(String valueName, String defaultValue, String[] modes) {
        super(valueName, defaultValue);
        this.modes = modes;
    }

    public final String[] getModes() {
        return this.modes;
    }

    public final boolean isCurrentMode(String value) {
        return ((String)this.getValue()).equals(value);
    }
}
