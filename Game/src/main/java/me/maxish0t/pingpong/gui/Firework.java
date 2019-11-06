package me.maxish0t.pingpong.gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

public class Firework implements MouseListener {

    /**
     * Firework Variables
     */
    private static float x;
    private static float y;
    private static Color color;
    private static float diameter;
    private static float xSpeed;
    private static float ySpeed;
    private static float gravity;
    private static float width = 1600, height = 900;

    /**
     * Random R G P color ints for the random colors.
     */
    int R = (int)(Math.random()*256);
    int G = (int)(Math.random()*256);
    int B= (int)(Math.random()*256);

    /**
     * Firework Constructor
     */
    public Firework(float xPosition, float yPosition) {
        this.x = MainPingPongGUI.mouseX;
        this.y = MainPingPongGUI.mouseY;
        this.color = new Color(R, G, B);;

        float minDiameter = width * 1/27.7777777F;

        this.diameter = 25.0F;
        this.xSpeed = 5.0F;
        this.ySpeed = 5.0F;
        this.gravity = 0.5F;
    }

    /**
     * Ball Movement
     */
    public static void move() {
        x += xSpeed;
        y += ySpeed;
        ySpeed += gravity;
    }

    /**
     * Better Edge Detection Algorithm
     */
    public static void edgeDetection() {
        if (x + xSpeed - diameter / 2 < 0 || x + xSpeed + diameter / 2 > width) {
            xSpeed *= -1;
        }
        if (y + ySpeed - diameter / 2 < 0 || y + ySpeed + diameter + 50 / 2 > height) {
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

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
