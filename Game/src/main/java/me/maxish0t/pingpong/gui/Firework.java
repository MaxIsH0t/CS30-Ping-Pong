package me.maxish0t.pingpong.gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Firework implements MouseListener {

    /**
     * Firework variables
     */
    private float x;
    private float y;
    private Color color;
    private float diameter;
    private float xSpeed;
    private float ySpeed;
    private float gravity;
    public static int count = 25; // Amount of Fireworks

    /**
     * Random Color R G B
     */
    Random randomColor = new Random();
    int colorR = randomColor.nextInt(255);
    int colorG = randomColor.nextInt(255);
    int colorB = randomColor.nextInt(255);

    Random randomFirework = new Random();
    Random randomSpeed = new Random();

    /**
     * Firework Constructor
     * @param width
     * @param height
     */
    public Firework(int width, int height) {
        this.x = getMouseX(false);
        this.y = getMouseY(false);
        this.color = new Color(colorR, colorG, colorB);
        //int fireworkRanPos = randomFirework.nextInt(width*1/25);
        this.diameter = 5F;
        this.xSpeed = 3F;
        this.ySpeed = 3F;
        gravity = 0.5F;
    }

    /**
     * Renders a Firework to the screen.
     * @param graphics
     */
    public void drawFirework(Graphics graphics) {
        Ball drawFirework = new Ball(x, y, diameter, Color.WHITE);
        drawFirework.drawBall(graphics);
    }

    public void step() {
        // Increasing x & y by their speeds so they move.
        x += xSpeed;
        y += ySpeed;

        // Changing gravity of the firework but not changing the original pos
        ySpeed += gravity;
    }

    /**
     * Gets the position of the MouseX.
     * @param debugPosition
     * @return
     */
    private int getMouseX(boolean debugPosition) {
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        Point point = pointerInfo.getLocation();
        int xMousePosition = (int) point.getX();
        if (debugPosition) {
            System.out.println("X Mouse Position is: " + xMousePosition);
        }
        return xMousePosition;
    }

    /**
     * Gets the position of the MouseY.
     * @param debugPosition
     * @return
     */
    private int getMouseY(boolean debugPosition) {
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        Point point = pointerInfo.getLocation();
        int yMousePosition = (int) point.getY();
        if (debugPosition) {
            System.out.println("Y Mouse Position is: " + yMousePosition);
        }
        return yMousePosition;
    }

    @Override
    public void mouseClicked(MouseEvent e) {} // Unused

    @Override
    public void mousePressed(MouseEvent e) {} // Unused

    @Override
    public void mouseReleased(MouseEvent e) {} // Unused

    @Override
    public void mouseEntered(MouseEvent e) {} // Unused

    @Override
    public void mouseExited(MouseEvent e) {} // Unused

}
