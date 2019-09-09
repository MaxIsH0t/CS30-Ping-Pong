package me.maxish0t.pingpong.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class MoveBall extends JPanel implements ActionListener
{
    Timer timer = new Timer(5, this);
    double x = 0, y = 0, velX = 2, velY = 2;

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(x, y, 40, 40);
        graphics2D.fill(circle);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (x < 0 || x > 560)
        {
            velX = -velX;
        }

        if (y < 0 || y > 360)
        {
            velY = -velY;
        }

        x += velX;
        y += velY;
        repaint();
    }
}
