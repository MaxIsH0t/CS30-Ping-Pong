package me.maxish0t.pingpong.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class DrawUtils
{
    /**
     * Draws a Rectangle
     */
    public static void drawRectangle(int x, int y, int width, int height, Color color, Graphics graphics)
    {
        graphics.setColor(color);
        graphics.drawRect(x, y, width, height);
        graphics.fillRect(x, y, width, height);
    }

    /**
     * Draws a Circle
     */
    public static void drawCircle(double x, double y, double ballSize, Color color, Graphics graphics)
    {
        Graphics2D g2d = (Graphics2D) graphics;
        Ellipse2D ball = new Ellipse2D.Double(x, y, ballSize, ballSize);
        g2d.setColor(color);
        g2d.fill(ball);
    }

    /**
     * Draw a Button
     */
    public static void drawExitButton(String buttonText, int x, int y, int width, int height, Color mainColor, Graphics graphics, ActionListener actionListener)
    {
        JButton jButton = new JButton(buttonText);
        jButton.setBounds(x, y, width, height);
        jButton.setLayout(null);
        jButton.setBackground(mainColor);
        jButton.addActionListener(actionListener);
        jButton.update(graphics);
        jButton.repaint();
        jButton.setLocation(x, y);
    }
}
