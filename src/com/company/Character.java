package com.company;

import java.awt.image.BufferedImage;

public class Character extends Bject implements Mover {
    CharID id;
    BufferedImage sprite;
    int index;

    public Character(int worldX, int worldY, CharID id) {
        super(worldX, worldY);
        this.id = id;
    }
}
