package com.company;

public class Screen extends Bject{

    public Screen(int wX, int wY) {
        super(wX, wY);
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

    public void wY(int i) {
        worldY += i;
    }
    public void wX(int i) {
        worldX += i;
    }
}
