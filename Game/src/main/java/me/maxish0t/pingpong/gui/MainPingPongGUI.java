package me.maxish0t.pingpong.gui;

import me.maxish0t.pingpong.util.DrawUtils;
import me.maxish0t.pingpong.util.PingPongUtils;
import me.maxish0t.pingpong.util.TextUtils;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.HashSet;
import javax.swing.*;

public class MainPingPongGUI extends JPanel implements KeyListener, ActionListener
{
    // screen height and width
    public static int height, width;

    // timer related
    private Timer t = new Timer(5, this);

    private boolean first;
    private HashSet<String> keys = new HashSet<String>();

    // ball
    // vel x, y default = 3
    private double ballX, ballY, velX = 3, velY = 3, ballSize = 20;

    // buttons
    public static JButton regular = new JButton("Regular Mode");
    public static JButton dark = new JButton("Dark Mode");
    private boolean regularMode;
    private boolean darkMode;
    public static int regularmodeX = 1600 / 2 - 120, regularmodeY = 50, darkModeX = 900 / 2 + 70, darkModeY= 10;

    // pad
    private final int SPEED = 5;
    private int padH = 250, padW = 15;
    private int rightPadX, leftPadX;
    private int rightPadY, leftPadY;
    private int inset = 10;

    // score
    private int scoreLeftUser, scoreRightUser;

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
            rightPadY = height / 2 - padW / 2;
            leftPadY = rightPadY;
            rightPadX = width * 29/30;
            ballX = width / 2 - ballSize / 2;
            ballY = height / 2 - ballSize / 2;
            first = false;
        }

        // left pad
        Rectangle2D bottomPad = new Rectangle(width * 1/30 - 10, leftPadY - padH, padW, padH);
        g2d.fill(bottomPad);

        // right pad
        Rectangle2D topPad = new Rectangle(rightPadX, rightPadY, padW, padH);
        g2d.fill(topPad);

        // ball
        DrawUtils.drawCircle(ballX, ballY, ballSize, Color.RED, g);

        // scores
        String scoreLeft = "Left: " + new Integer(scoreLeftUser).toString();
        String scoreRight = "Right: " + new Integer(scoreRightUser).toString();
        TextUtils.drawText(scoreLeft, 10, height / 2, 20, Color.WHITE, g);
        TextUtils.drawText(scoreRight, width - 70, height / 2, 20, Color.WHITE, g);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // top pad
        if (ballX <= rightPadX - 200)
        {
            System.out.println("THIS WORKS!!!!!!!!!!!!!!!");
        }

            if (ballX + ballSize >= rightPadY && ballX <= rightPadY + padW)
                velY = -velY;

        // side walls
        if (ballX < 0 || ballX > width - ballSize)
        {
            velX = -velX;
        }

        // top / down walls
        if (ballY < 0)
        {
            velY = -velY;
        }

        // bottom
        if (ballY + ballSize > height)
        {
            velY = -velY;
        }

        // wall left
        if (ballX < 0)
        {
            //ballX = width / 2 - ballSize / 2;
            //ballY = height / 2 - ballSize / 2;

            ++ scoreRightUser;
            System.out.println("Score 1 point for right user!");
        }

        // wall right
        if (ballX + ballSize > width)
        {
            //ballX = width / 2 - ballSize / 2;
            //ballY = height / 2 - ballSize / 2;

            ++ scoreLeftUser;
            System.out.println("Score 1 point for left user!");
        }

        // makes the ball move
        ballX += velX;
        ballY += velY;

        // pressed keys
        if (keys.size() == 1) {
            if (keys.contains("LEFT")) {
                rightPadY -= (rightPadY > -420) ? SPEED : 0;
            }
            else if (keys.contains("RIGHT")) {
                rightPadY += (rightPadY < +300) ? SPEED : 0;
            }
        }

        // AI
        double delta = ballY - leftPadY;
        if (delta > 0) {
            leftPadY += (leftPadY < height - padW - 90) ? SPEED : 0;
        }
        else if (delta < 0) {
            leftPadY -= (leftPadY > 50) ? SPEED : 0;
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_LEFT:
                keys.add("LEFT");
                break;
            case KeyEvent.VK_RIGHT:
                keys.add("RIGHT");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_LEFT:
                keys.remove("LEFT");
                break;
            case KeyEvent.VK_RIGHT:
                keys.remove("RIGHT");
                break;
        }
    }
}
