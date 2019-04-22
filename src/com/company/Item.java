package com.company;

public abstract class Item {
    int worldX;
    int worldY;

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public abstract boolean collect();
}
