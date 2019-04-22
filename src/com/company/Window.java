package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Window extends JFrame implements Runnable{
    private int UPS;
    private double TBU;

    BufferedImage background;

    public Window(String title, int UPS) throws HeadlessException {
        super(title);

        this.UPS = UPS;

        TBU = 1000.0/UPS;

        setSize(800, 800);

        background = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);

        setUndecorated(true);
        setVisible(true);

        Thread t = new Thread(this);
        t.start();
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

    }
}
