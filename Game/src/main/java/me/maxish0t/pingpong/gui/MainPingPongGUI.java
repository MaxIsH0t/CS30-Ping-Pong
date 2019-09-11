package me.maxish0t.pingpong.gui;

import me.maxish0t.pingpong.util.DrawUtils;
import me.maxish0t.pingpong.util.PingPongUtils;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class MainPingPongGUI extends JPanel implements KeyListener, ActionListener
{
    // screen height and width
    private int height, width;

    // timer related
    private Timer t = new Timer(5, this);

    private boolean first;

    // ball
    private double ballX, ballY, velX = 3, velY = 3, ballSize = 20;

    // buttons
    public static JButton regular = new JButton("Regular Mode");
    public static JButton dark = new JButton("Dark Mode");
    private boolean regularMode;
    private boolean darkMode;
    public static int regularmodeX = 1600 / 2 - 120, regularmodeY = 50, darkModeX = 900 / 2 + 70, darkModeY= 10;

    // pad
    private int padH = 120, padW = 15;
    private int rightPadX, leftPadX;
    private int inset = 10;

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
        Graphics2D g2d = (Graphics2D) g;

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

        // left pad
        Rectangle2D bottomPad = new Rectangle(leftPadX + 1500, height / 2, padW, padH);
        g2d.fill(bottomPad);

        // right pad
        Rectangle2D topPad = new Rectangle(rightPadX + 70, height / 2, padW, padH);
        g2d.fill(topPad);

        // ball
        DrawUtils.drawCircle(ballX, ballY, ballSize, Color.RED, g);

        // box
        //DrawUtils.drawRectangle(width / 2 - 120, 10, 100, 70, Color.WHITE, g);

        // text
        //DrawUtils.drawText("Regular Mode", width / 2 - 110, 50, Color.BLACK, g);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
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
