package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferedImage;
import java.io.File;


public class Window extends JFrame implements Runnable{
    private int UPS;
    private double TBU;

    BufferedImage background;
    BufferedImage game;

    Screen s;

    Collision test;

    public Window(String title, int UPS) throws HeadlessException {
        super(title);

        this.UPS = UPS;

        TBU = 1000.0/UPS;

        setSize(800, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        try {
            background = new BufferedImage(4000, 1600, BufferedImage.TYPE_INT_ARGB);
            for(int x = 0; x < background.getWidth(); x += 200) {
                for(int y = 0; y < background.getHeight(); y += 200) {
                    background.getGraphics().drawImage(ImageIO.read(new File("BetaTile.png")), x, y, null);
                }
            }
        } catch (Exception e) {

        }

        s = new Screen(0, 0);
        s.setWorldY(background.getHeight() - getHeight());

        test = new Collision(1000, 1200, 400, 400);

        setResizable(false);
        setVisible(true);

        Thread t = new Thread(this);
        t.start();

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_DOWN:
                        if(s.getWorldY() < background.getHeight() - getHeight())
                            s.wY(5);
                        break;
                    case KeyEvent.VK_UP:
                        if(s.getWorldY() > 0)
                            s.wY(-5);
                        break;
                    case KeyEvent.VK_LEFT:
                        if(s.getWorldX() > 0)
                            s.wX(-5);
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(s.getWorldX() < background.getWidth() - getWidth())
                            s.wX(5);
                }
            }
        });
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        long uDone = 0;

        while (true) {
            long uNeed = (long)(((System.nanoTime() - startTime)/1000000)/TBU);
            boolean shouldRepaint = false;
            for(; uDone < uNeed; uDone++) {
                update();
                shouldRepaint = true;
            }
            if(shouldRepaint)
                repaint();
        }
    }

    private void update() {

    }

    public void paint(Graphics g) {
        int wX = (background.getWidth() - getWidth())/2;
        int wY = (background.getHeight() - getHeight())/2;
        //sx is 1600 at the center and sy is 500
        double bX = wX - ((wX - s.getWorldX()) * 0.8);
        double bY = wY - ((wY - s.getWorldY()) * 0.8);
        game.getGraphics().drawImage(background.getSubimage((int)bX, (int)bY, getWidth(), getHeight()), 0, 0, null);
        //How drawing objects works
        if(test.getWorldX() + test.getWid() > s.getWorldX()
                && test.getWorldX() <= s.getWorldX() + getWidth()
                && test.getWorldY() + test.getHig() > s.getWorldY()
                && test.getWorldY() <= s.getWorldY() + getHeight()) {
            game.getGraphics().fillRect(test.getWorldX() - s.getWorldX(), test.getWorldY() - s.getWorldY(), test.getWid(), test.getHig());
        }
        g.drawImage(game, 0, 0, null);
    }
}
