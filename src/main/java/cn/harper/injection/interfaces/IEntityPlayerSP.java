package cn.harper.injection.interfaces;

import cn.harper.event.EventMove;

public interface IEntityPlayerSP {
    void setMoveSpeed(EventMove event, double speed);
    float getDirection();
}
