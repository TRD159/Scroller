package com.company;

public abstract class Item extends Bject{
    public Item(int wX, int wY) {
        super(wX, wY);
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public abstract boolean collect();
}
