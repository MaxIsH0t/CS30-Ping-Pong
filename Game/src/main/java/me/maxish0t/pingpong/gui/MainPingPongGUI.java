package me.maxish0t.pingpong.gui;

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

        JFrame jFrame = new JFrame(PingPongUtils.GAME_NAME);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(GUI_WIDTH, GUI_HEIGHT);

        // Sets the GUI in the middle of the monitor
        jFrame.setLocationRelativeTo(null);

        jFrame.setVisible(true);

        PingPongUtils.LOGGER.info("Game Size: " + GUI_WIDTH + " by " + GUI_HEIGHT);
    }
}
