package me.maxish0t.pingpong.gui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

public class BallChaseGUI extends JPanel implements MouseListener, ActionListener {

    private float x = getWidth() / 2;
    private float y = getHeight() / 2;
    private float diameter = 30;
    private Color color = Color.WHITE;

    public BallChaseGUI() {
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Ball
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D ellipse2D = new Ellipse2D.Float(getWidth() / 2, getHeight() / 2, diameter, diameter);
        g2d.setColor(color);
        g2d.fill(ellipse2D);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

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
}
