package cn.harper.value;


public abstract class Value<V> {
    private final String valueName;
    private V value;

    public Value(String valueName) {
        this.valueName = valueName;
    }

    public Value(String valueName, V value) {
        this.valueName = valueName;
        this.value = value;
    }

    public final String getValueName() {
        return this.valueName;
    }

    public final V getValue() {
        return this.value;
    }

    public final void setValue(V value) {
        if (this.onChangeValue(this.value, value)) {
            this.value = value;
        }
    }

    public final void forceSetValue(V value) {
        this.value = value;
    }

    public boolean isVisible() {
        return true;
    }

    protected boolean onChangeValue(V pre, V post) {
        return true;
    }
}
