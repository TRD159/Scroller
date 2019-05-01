package com.company;

import java.awt.*;

public class Screen extends Bject{

    public Screen(int wX, int wY) {
        super(wX, wY);
    }

    public Screen(Rectangle r) {
        super(r);
    }

    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
        setR(new Rectangle(worldX, worldY, (int)r.getWidth(), (int)r.getHeight()));
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
        setR(new Rectangle(worldX, worldY, (int)r.getWidth(), (int)r.getHeight()));
    }

    public void wY(int i) {
        worldY += i;
        setR(new Rectangle(worldX, worldY, (int)r.getWidth(), (int)r.getHeight()));
    }
    public void wX(int i) {
        worldX += i;
        setR(new Rectangle(worldX, worldY, (int)r.getWidth(), (int)r.getHeight()));
    }
}
