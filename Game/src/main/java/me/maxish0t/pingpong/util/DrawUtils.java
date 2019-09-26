package me.maxish0t.pingpong.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class DrawUtils
{
    // Buttons
    private static JButton exitButton = new JButton();
    private static JButton startButton = new JButton();

    /**
     * Draws a Rectangle
     */
    public static void drawRectangle(int x, int y, int width, int height, Color color, Graphics graphics) {
        graphics.setColor(color);
        graphics.drawRect(x, y, width, height);
        graphics.fillRect(x, y, width, height);
    }

    /**
     * Draws a Circle
     */
    public static void drawCircle(double x, double y, double ballSize, Color color, Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        Ellipse2D ball = new Ellipse2D.Double(x, y, ballSize, ballSize);
        g2d.setColor(color);
        g2d.fill(ball);
    }

    /**
     * Draw a Reset Button
     */
    public static void drawResetButton(String buttonText, int x, int y, int width, int height, Color mainColor, ActionListener actionListener, JPanel jPanel) {
        startButton.setText(buttonText);
        startButton.setBounds(x, y, width, height);
        startButton.setLocation(x, y);
        startButton.setBackground(mainColor);
        startButton.addActionListener(actionListener);
        jPanel.add(startButton);
    }

    /**
     * Draw a Exit Button
     */
    public static void drawExitButton(String buttonText, int x, int y, int width, int height, Color mainColor, ActionListener actionListener, JPanel jPanel) {
        exitButton.setText(buttonText);
        exitButton.setBounds(x, y, width, height);
        exitButton.setLocation(x, y);
        exitButton.setBackground(mainColor);
        exitButton.addActionListener(actionListener);
        jPanel.add(exitButton);
    }
}
