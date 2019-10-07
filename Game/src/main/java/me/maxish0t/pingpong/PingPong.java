package me.maxish0t.pingpong;

import me.maxish0t.pingpong.gui.MainPingPongGUI;
import me.maxish0t.pingpong.util.PingPongUtils;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created By Mahmoud Saleh
 * Date Created On: Friday, September 6, 2019
 */
public class PingPong {
    // frame width & height
    public static final int displayWidth = 1600;
    public static final int displayHeight = 900;

    // whether to debug a message in the console for all strings put on the frame
    public static boolean debugStrings = true;

    // main program that runs when ran
    public static void main(String[] args) {
        // Loads the main GUI for the Ping Pong Game
        mainGUI();

        // Screen Size Checker
        screenSizeChecker();

        PingPongUtils.LOGGER.info(PingPongUtils.GAME_NAME + " has been loaded on version " + PingPongUtils.GAME_VERSION);
    }

    // main frame
    private static void mainGUI() {
        MainPingPongGUI mainPingPongGUI = new MainPingPongGUI();
        JFrame frm = new JFrame();
        frm.setTitle("Ping Pong");
        frm.setContentPane(mainPingPongGUI);
        frm.setSize(displayWidth, displayHeight);
        frm.setResizable(false);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // checks if the screen is too small
    private static void screenSizeChecker() {
        String fullSize = "DisplayWidth= " + displayWidth + "; DisplayHeight= " + displayHeight;
        System.out.println(fullSize);
        float checker = displayWidth / displayHeight;
        if (displayWidth < 500) {
            System.out.println("ERROR: This program will not work on this display, the width is too small.");
            System.exit(5);
        } else if (checker < 0.5625) {
            System.out.println("ERROR: This program will not work on this display, the height is too small.");
            System.exit(5);
        }
    }
}
