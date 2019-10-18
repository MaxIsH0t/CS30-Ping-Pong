package me.maxish0t.pingpong.gui;

import me.maxish0t.pingpong.util.DrawUtils;

import java.awt.*;
import java.awt.event.*;

public class Fireworks implements MouseListener
{
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void drawBall(Graphics graphics) {
        DrawUtils.drawCircleParticle(10, 10, 30, Color.GRAY, graphics);
    }
}
