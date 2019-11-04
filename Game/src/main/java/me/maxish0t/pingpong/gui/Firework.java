package me.maxish0t.pingpong.gui;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Firework {

    /**
     * Object Variables
     */

    /**
     * Firework Variables
     */
    private static float x;
    private static float y;
    private static Color color;
    private static float diameter;
    private static float xSpeed;
    private static float ySpeed;
    private static float width = 1600, height = 900;

    /**
     * Firework Constructor
     */
    public Firework(float xPosition, float yPosition, Color fireworkColor) {
        this.x = xPosition;
        this.y = yPosition;
        this.color = fireworkColor;
        this.diameter = 10F;
        this.xSpeed = 5.0F;
        this.ySpeed = 5.0F;
    }

    /**
     * Ball Movement
     */
    public static void move() {
        x += xSpeed;
        y += ySpeed;
    }

    /**
     * Edge Detection
     */
    public static void edgeDetection() {
        if (x+xSpeed-diameter/2 < 0 || x+xSpeed+diameter/2 > width) {
            xSpeed *= -1;
        }
        if (y+ySpeed-diameter/2 < 0 || y+ySpeed+diameter/2 > height) {
            ySpeed *= -1;
        }
    }

    /**
     * Draw Firework
     */
    public static void draw(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        Ellipse2D ball = new Ellipse2D.Double(x, y, diameter, diameter);
        g2d.setColor(color);
        g2d.fill(ball);
    }

}
