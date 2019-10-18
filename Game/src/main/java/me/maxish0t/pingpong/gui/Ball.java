package me.maxish0t.pingpong.gui;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball {

    /**
     * Ball Variables
     */
    public double x;
    public double y;
    public double diameter;
    public Color color;

    /**
     * Draws a Ball
     * @param x
     * @param y
     * @param diameter
     * @param color
     * @param graphics
     */
    public Ball(double x, double y, double diameter, Color color, Graphics graphics) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
    }

    public static void drawBall(double x, double y, double diameter, Color color, Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        Ellipse2D ball = new Ellipse2D.Double(x, y, diameter, diameter);
        g2d.setColor(color);
        g2d.fill(ball);
    }
}
