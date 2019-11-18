package me.maxish0t.pingpong.gui;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball {

    /**
     * Ball Variables
     */
    public static double x;
    public static double y;
    public static double diameter;
    public static Color color;

    /**
     * Draws a Ball
     * @param x
     * @param y
     * @param diameter
     * @param color
     */
    public Ball(double x, double y, double diameter, Color color) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
    }

    public static void drawBall(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        Ellipse2D ball = new Ellipse2D.Double(x, y, diameter, diameter);
        g2d.setColor(color);
        g2d.fill(ball);
    }
}
