package me.maxish0t.pingpong;

import me.maxish0t.pingpong.gui.MainPingPongGUI;
import me.maxish0t.pingpong.util.PingPongUtils;

import javax.swing.*;

/**
 * Created By Mahmoud Saleh
 * Date Created On: Friday, September 6, 2019
 */
public class PingPong {
    public static final int displayWidth = 1600;
    public static final int displayHeight = 900;

    public static void main(String[] args) {
        // Loads the main GUI for the Ping Pong Game
        MainPingPongGUI mainPingPongGUI = new MainPingPongGUI();

        JFrame frm = new JFrame();
        frm.setTitle("Ping Pong");
        frm.setContentPane(mainPingPongGUI);
        frm.setSize(displayWidth, displayHeight);
        frm.setResizable(false);
        frm.setVisible(true);
        screenSizeChecker();

        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PingPongUtils.LOGGER.info(PingPongUtils.GAME_NAME + " has been loaded on version " + PingPongUtils.GAME_VERSION);
    }

    public static void screenSizeChecker() {
        String fullSize = "DisplayWidth= " + displayWidth + "; DisplayHeight= " + displayHeight;
        System.out.println(fullSize);
        float checker = displayWidth / displayHeight;
        if (displayWidth < 500) {
            System.out.println("ERROR: This program will not work on this display, the width is too small.");
        } else if (checker < 0.5625) {
            System.out.println("ERROR: This program will not work on this display, the height is too small.");
        }
    }
}
