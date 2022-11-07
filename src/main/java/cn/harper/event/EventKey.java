package cn.harper.event;

import com.darkmagician6.eventapi.events.Event;

public class EventKey implements Event {
    private int keyCode;
    public EventKey(int keyCode){
        this.keyCode = keyCode;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }
}
