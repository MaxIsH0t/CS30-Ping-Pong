package me.maxish0t.pingpong.util;

import java.awt.*;
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
     * Draws a text
     */
    public static void drawText(String string, int x, int y, Color color, Graphics graphics)
    {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setColor(color);
        g2.drawString(string, x, y);
    }
}
