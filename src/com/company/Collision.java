package com.company;

public class Collision extends Bject{
    int wid, hig;
    public Collision(int worldX, int worldY, int wid, int hig) {
        super(worldX, worldY);
        this.hig = hig;
        this.wid = wid;
    }

    public int getWid() {
        return wid;
    }

    public int getHig() {
        return hig;
    }
}
