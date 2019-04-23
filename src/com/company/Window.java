package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;


public class Window extends JFrame implements Runnable{
    private int UPS;
    private double TBU;

    BufferedImage background;

    Screen s;

    public Window(String title, int UPS) throws HeadlessException {
        super(title);

        this.UPS = UPS;

        TBU = 1000.0/UPS;

        setSize(400, 400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            background = ImageIO.read(new File("Background.png"));
        } catch (Exception e) {

        }

        s = new Screen();

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
        g.drawImage(background.getSubimage(s.worldX, s.worldY, getWidth(), getHeight()), 0, 0, null);
    }
}
