package cn.harper.value.impl;


import cn.harper.value.Value;

public class NumberValue extends Value<Double> {
    private final double maxValue;
    private final double minValue;
    private final double increase;
    public double animationX;

    public NumberValue(String valueName, double defaultValue, double min, double max, double increase) {
        super(valueName, defaultValue);
        this.minValue = min;
        this.maxValue = max;
        this.increase = increase;
    }

    public final double getMaxValue() {
        return this.maxValue;
    }

    public final double getMinValue() {
        return this.minValue;
    }

    public final double getIncrease() {
        return this.increase;
    }
}
