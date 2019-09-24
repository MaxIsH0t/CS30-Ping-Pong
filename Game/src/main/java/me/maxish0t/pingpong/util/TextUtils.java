package me.maxish0t.pingpong.util;

import java.awt.*;

public class TextUtils {
    private static boolean debugString = false;

    /**
     * Draws a text
     */
    public static void drawText(String string, int x, int y, int size, Color color, Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setColor(color);
        graphics.setFont(new Font("TimesRoman", Font.PLAIN, size));
        g2.drawString(string, x, y);

        if (debugString == false) {
            System.out.println("String: " + string + " Size X: " + x + " Size Y: " + y + " Size: " + size + " Color: " + color);
            debugString = true;
        }
    }
}
