package me.maxish0t.pingpong.gui;

import me.maxish0t.pingpong.util.DrawUtils;
import me.maxish0t.pingpong.util.PingPongUtils;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class MainPingPongGUI extends JPanel implements KeyListener, ActionListener
{
    // screen height and width
    private int height, width;

    // timer related
    private Timer t = new Timer(5, this);

    private boolean first;

    // ball
    private double ballX, ballY, velX = 5, velY = 5, ballSize = 20;

    public MainPingPongGUI()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        first = true;

        t.setInitialDelay(100);
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // sets the background
        setBackground(Color.BLACK);

        // determines the height and width of the frame so the ball can't leave the screen
        height = getHeight();
        width = getWidth();

        // initial positioning
        if (first) {
            ballX = width / 2 - ballSize / 2;
            ballY = height / 2 - ballSize / 2;
            first = false;
        }

        // ball
        DrawUtils.drawCircle(ballX, ballY, ballSize, Color.RED, g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // side walls
        if (ballX < 0 || ballX > width - ballSize) {
            velX = -velX;
        }

        // top / down walls
        if (ballY < 0) {
            velY = -velY;
        }

        // bottom
        if (ballY + ballSize > height) {
            velY = -velY;
        }

        // makes the ball move
        ballX += velX;
        ballY += velY;

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
