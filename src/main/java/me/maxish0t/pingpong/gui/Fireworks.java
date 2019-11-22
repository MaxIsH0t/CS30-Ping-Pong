package me.maxish0t.pingpong.gui;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Fireworks {

    private static int x;
    private static int y;
    private static int xSpeed;
    private static int ySpeed;
    private static int gravity;
    private static int diameter;
    private static Color color;

    public Fireworks(int x, int y, int diameter, Color color) {
        this.x = x;
        this.y = y;
        this.xSpeed = 5;
        this.ySpeed = 5;
        this.gravity = 5;
        this.diameter = diameter;
        this.color = color;
    }

    public static void drawFireworks(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        Ellipse2D ball = new Ellipse2D.Double(x, y, diameter, diameter);
        g2d.setColor(color);
        g2d.fill(ball);
    }

    public static void moveFireworks() {
        x += xSpeed;
        y += ySpeed;
    }

}
