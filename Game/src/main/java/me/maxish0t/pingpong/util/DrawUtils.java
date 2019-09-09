package me.maxish0t.pingpong.util;

import java.awt.*;

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
    public static void drawCircle(int x, int y, int width, int height, Color color, Graphics graphics)
    {
        graphics.setColor(color);
        graphics.drawOval(x, y, width, height);
        graphics.fillOval(x, y, width, height);
    }
}
