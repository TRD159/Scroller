package com.company;

import java.awt.image.BufferedImage;

public class Character extends Bject {
    CharID id;
    BufferedImage sprite;

    public Character(int worldX, int worldY) {
        super(worldX, worldY);
    }
}
