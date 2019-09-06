package me.maxish0t.pingpong.gui;

import java.applet.Applet;
import java.awt.*;

public class Rect1 extends Applet {

    public void paint (Graphics g) {
        Rectangle r = new Rectangle(10, 10, 20, 20);
        g.fillRect(10, 10, 20, 20);
        g.setColor(Color.BLACK);
    }
}
