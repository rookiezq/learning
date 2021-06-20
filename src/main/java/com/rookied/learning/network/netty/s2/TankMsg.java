package com.rookied.learning.network.netty.s2;

/**
 * @author zhangqiang
 * @date 2021/5/7
 */
public class TankMsg {
    public int x,y;

    public TankMsg(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "TankMsg{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
