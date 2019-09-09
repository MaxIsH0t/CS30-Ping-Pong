package me.maxish0t.pingpong.gui;

import me.maxish0t.pingpong.util.DrawUtils;
import me.maxish0t.pingpong.util.PingPongUtils;

import javax.swing.*;
import java.awt.*;

public class MainPingPongGUI extends JFrame
{
    private static int GUI_WIDTH = 1200;
    private static int GUI_HEIGHT = 750;
    private static final String GUI_TITLE = "PingPong";

    public MainPingPongGUI()
    {
        setTitle(GUI_TITLE);
        setSize(GUI_WIDTH, GUI_HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PingPongUtils.LOGGER.info("Game Size: " + GUI_WIDTH + " by " + GUI_HEIGHT);
    }

    public void paint(Graphics g)
    {
        //DrawUtils.drawRectangle(50, 50, 100, 100, Color.RED, g);
        DrawUtils.drawCircle(getWidth() * 1/2, getHeight() * 1/2, 20, 20, Color.RED, g);
    }
}
