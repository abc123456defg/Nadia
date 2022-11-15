package cn.harper.event;

import com.darkmagician6.eventapi.events.Event;

public class EventPostMotion implements Event {

    private float yaw;
    private float pitch;

    public EventPostMotion(float yaw, float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public float getYaw() {
        return this.yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public float getPitch() {
        return this.pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }
}
