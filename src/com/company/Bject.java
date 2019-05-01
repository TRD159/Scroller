package com.company;

import java.awt.*;

public abstract class Bject {
    int worldX, worldY;
    Rectangle r;

    public Bject(int worldX, int worldY) {
        r = new Rectangle(worldX, worldY);
        this.worldX = worldX;
        this.worldY = worldY;
    }

    public Bject(Rectangle r) {
        this.r = r;
        this.worldX = (int)r.getX();
        this.worldY = (int)r.getY();
    }

    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    public Rectangle getR() {
        return r;
    }

    public void setR(Rectangle r) {
        this.r = r;
    }
}
