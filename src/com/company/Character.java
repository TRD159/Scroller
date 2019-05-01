package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.TreeMap;

public class Character extends Bject implements Mover {
    CharID id;
    ArrayList<BufferedImage> sprites = null;
    int index = 0;

    public Character(int worldX, int worldY, CharID id, ImageManager im) {
        super(worldX, worldY);
        this.id = id;
        switch (this.id) {
            case CharTest:
                sprites = new ArrayList<>() {
                    {
                        add(im.getImage("Jim0"));
                        add(im.getImage("Jim1"));
                        add(im.getImage("Jim2"));
                        add(im.getImage("Jim3"));
                        add(im.getImage("Jim4"));
                        add(im.getImage("Jim5"));
                        add(im.getImage("Jim6"));
                    }
                };
                break;
        }

    }

    public Character(Rectangle r, CharID id, ImageManager im) {
        super(r);
        this.id = id;
        switch (this.id) {
            case CharTest:
                sprites = new ArrayList<>() {
                    {
                        add(im.getImage("Jim0"));
                        add(im.getImage("Jim1"));
                        add(im.getImage("Jim2"));
                        add(im.getImage("Jim3"));
                        add(im.getImage("Jim4"));
                        add(im.getImage("Jim5"));
                        add(im.getImage("Jim6"));
                    }
                };
                break;
        }

    }

    public BufferedImage getSprite(int i) {
        return sprites.get(i);
    }
}
