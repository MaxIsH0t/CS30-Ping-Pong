package me.maxish0t.pingpong.gui;

import me.maxish0t.pingpong.util.DrawUtils;
import me.maxish0t.pingpong.util.PingPongUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

public class MainPingPongGUI extends JFrame
{
    private static int GUI_WIDTH = 1200;
    private static int GUI_HEIGHT = 750;
    private static final String GUI_TITLE = "PingPong";

    public static int CIRCLE_X = GUI_WIDTH * 1/2;
    public static int CIRCLE_Y = GUI_HEIGHT * 1/2;


    public MainPingPongGUI()
    {
        MoveBall moveBall = new MoveBall();

        // MAIN FRAME
        setTitle(GUI_TITLE);
        setSize(GUI_WIDTH, GUI_HEIGHT);
        add(moveBall);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PingPongUtils.LOGGER.info("Game Size: " + GUI_WIDTH + " by " + GUI_HEIGHT);
    }

    public void paint(Graphics g)
    {
        //DrawUtils.drawRectangle(50, 50, 100, 100, Color.RED, g);
        //DrawUtils.drawCircle(CIRCLE_X, CIRCLE_Y, 20, 20, Color.RED, g);
    }
}
