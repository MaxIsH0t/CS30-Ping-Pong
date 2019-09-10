package me.maxish0t.pingpong.gui;

import me.maxish0t.pingpong.util.DrawUtils;
import me.maxish0t.pingpong.util.PingPongUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Timer;

public class MainPingPongGUI extends JFrame
{
    private boolean first;
    private int height, width;

    private static int GUI_WIDTH = 1200;
    private static int GUI_HEIGHT = 750;
    private static final String GUI_TITLE = "PingPong";

    //public static int CIRCLE_X = GUI_WIDTH * 1/2;
    public static int CIRCLE_X = GUI_WIDTH * 1/2;
    public static int CIRCLE_Y = GUI_WIDTH * 1/2;

    // Ball
    private int ballX, ballY, velX = 1, velY = 1, ballSize = 20;


    public MainPingPongGUI()
    {
        // MAIN FRAME
        setTitle(GUI_TITLE);
        setSize(GUI_WIDTH, GUI_HEIGHT);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PingPongUtils.LOGGER.info("Game Size: " + GUI_WIDTH + " by " + GUI_HEIGHT);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        //DrawUtils.drawRectangle(50, 50, 100, 100, Color.RED, g);
        Graphics2D g2d = (Graphics2D) g;

        height = getHeight();
        width = getWidth();


        if (first)
        {
            ballX = GUI_WIDTH / 2 - ballSize / 2;
            ballY = GUI_HEIGHT / 2 - ballSize / 2;
            first = false;
        }

        //DrawUtils.drawCircle(ballX, ballY, 20, 20, Color.RED, g);

        Ellipse2D ball = new Ellipse2D.Double(ballX, ballY, ballSize, ballSize);
        g2d.fill(ball);

        System.out.println(ballX + " " + ballY);
    }
}
