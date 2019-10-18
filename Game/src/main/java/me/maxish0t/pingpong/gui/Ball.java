package me.maxish0t.pingpong.gui;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball {

    /**
     * Ball Variables
     */
    private double x;
    private double y;
    private double diameter;
    private Color color;

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

        Graphics2D g2d = (Graphics2D) graphics;
        Ellipse2D ball = new Ellipse2D.Double(this.x, this.y, this.diameter, this.diameter);
        g2d.setColor(this.color);
        g2d.fill(ball);
    }

    public static void drawBall(double x, double y, double diameter, Color color, Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        Ellipse2D ball = new Ellipse2D.Double(x, y, diameter, diameter);
        g2d.setColor(color);
        g2d.fill(ball);
    }
}
