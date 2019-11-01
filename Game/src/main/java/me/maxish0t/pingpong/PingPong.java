package me.maxish0t.pingpong;

import me.maxish0t.pingpong.gui.BallChaseAndNightSkyGUI;
import me.maxish0t.pingpong.gui.MainPingPongGUI;
import me.maxish0t.pingpong.util.PingPongUtils;
import me.maxish0t.pingpong.util.ScreenSizeTester;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

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
    public static void main(String[] args) throws IOException, URISyntaxException {
        // Loads the main GUI for the Ping Pong Game
        //mainGUI();
        ballChaseGUI();

        // Screen Size Checker
        ScreenSizeTester.checker();

        PingPongUtils.LOGGER.info(PingPongUtils.GAME_NAME + " has been loaded on version " + PingPongUtils.GAME_VERSION);
    }

    // main frame
    private static void mainGUI() throws IOException, URISyntaxException {
        MainPingPongGUI mainPingPongGUI = new MainPingPongGUI();
        JFrame frm = new JFrame();
        frm.setTitle("Ping Pong - " + PingPongUtils.GAME_VERSION);
        frm.setContentPane(mainPingPongGUI);
        frm.setSize(displayWidth, displayHeight);
        frm.setResizable(false);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets the Icon from the resources
        URL res = PingPong.class.getClassLoader().getResource("icon.png");
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();
        BufferedImage myImg = ImageIO.read(new File(absolutePath));
        frm.setIconImage(myImg);
    }

    // ball chase frame
    private static void ballChaseGUI() throws URISyntaxException, IOException {
        BallChaseAndNightSkyGUI ballChaseGUI = new BallChaseAndNightSkyGUI();
        JFrame frm = new JFrame();
        frm.setTitle("BallChaseGUI - " + PingPongUtils.GAME_VERSION);
        frm.getContentPane().add(new BallChaseAndNightSkyGUI());
        frm.setContentPane(ballChaseGUI);
        frm.setSize(displayWidth, displayHeight);
        frm.setResizable(false);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets the Icon from the resources
        URL res = PingPong.class.getClassLoader().getResource("icon.png");
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();
        BufferedImage myImg = ImageIO.read(new File(absolutePath));
        frm.setIconImage(myImg);
    }

}
