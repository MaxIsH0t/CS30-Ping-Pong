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

    public MainPingPongGUI(String title) throws HeadlessException {
        super(title);
        title = GUI_TITLE;
    }

    // Main GUI for the Game
    public static void mainGUI()
    {
        JFrame jFrame = new JFrame(PingPongUtils.GAME_NAME);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(GUI_WIDTH, GUI_HEIGHT);

        // Sets the GUI in the middle of the monitor
        jFrame.setLocationRelativeTo(null);

        jFrame.setVisible(true);

        // Boxes
        //DrawUtils.drawRectangle(10, 10, 20, 20, Color.BLACK);

        PingPongUtils.LOGGER.info("Game Size: " + GUI_WIDTH + " by " + GUI_HEIGHT);
    }

    public void paint(Graphics g)
    {
        Rectangle r = new Rectangle(10, 10, 20, 20);
        g.fillRect(
                (int)r.getX(),
                (int)r.getY(),
                (int)r.getWidth(),
                (int)r.getHeight()
        );
    }
}
