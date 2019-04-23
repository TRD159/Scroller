package com.company;

public class Screen {
    int worldX, worldY;

    public Screen() {
        worldX = 0;
        worldY = 0;
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
