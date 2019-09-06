package me.maxish0t.pingpong.gui;

import me.maxish0t.pingpong.util.PingPongUtils;

import javax.swing.*;

public class MainPingPongGUI
{
    private static int GUI_WIDTH = 1200;
    private static int GUI_HEIGHT = 750;

    // Main GUI for the Game
    public static void mainGUI()
    {
        JFrame jFrame = new JFrame(PingPongUtils.GAME_NAME);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(GUI_WIDTH, GUI_HEIGHT);

        // Sets the GUI in the middle of the monitor
        jFrame.setLocationRelativeTo(null);

        jFrame.setVisible(true);

        PingPongUtils.LOGGER.info("Game Size: " + GUI_WIDTH + " by " + GUI_HEIGHT);
    }
}
