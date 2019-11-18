package me.maxish0t.pingpong.gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

public class Blackhole implements MouseListener {

    /**
     * Blackhole Variables
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
     * Blackhole Constructor
     */
    public Blackhole() {
        this.x = MainPingPongGUI.mouseX;
        this.y = MainPingPongGUI.mouseY;
        this.color = new Color(R, G, B);;
        float minDiameter = (float) (width*1/27.77777777); // Value = 18
        float maxDiameter = width*1/25; //Value = 20
        this.diameter = (float) (Math.random() * maxDiameter-minDiameter + maxDiameter);
        this.xSpeed =  (float) (Math.random() * -5 + 5);
        this.ySpeed = (float) (Math.random() * -5 + 5);
        gravity = 0.5F;
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

        if (x == MainPingPongGUI.ballX) {
            MainPingPongGUI.ballX = width / 2 - MainPingPongGUI.ballSize / 2;
            MainPingPongGUI.ballY = height / 2 - MainPingPongGUI.ballSize / 2;
        }
        if (y == MainPingPongGUI.ballY) {
            MainPingPongGUI.ballX = width / 2 - MainPingPongGUI.ballSize / 2;
            MainPingPongGUI.ballY = height / 2 - MainPingPongGUI.ballSize / 2;
        }
    }

    /**
     * Draw Blackhole
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
