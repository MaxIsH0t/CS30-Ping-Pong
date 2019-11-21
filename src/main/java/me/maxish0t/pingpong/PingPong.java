package me.maxish0t.pingpong;

import me.maxish0t.pingpong.gui.MainPingPongGUI;
import me.maxish0t.pingpong.util.Constants;
import me.maxish0t.pingpong.util.OSChecker;
import me.maxish0t.pingpong.util.logger.EnumConsoleColor;
import me.maxish0t.pingpong.util.logger.PingPongLogger;
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

    public static JFrame frm = new JFrame();

    public static void main(String[] args) {
        mainGUI();
        ScreenSizeTester.checker();
        OSChecker.checkOS();

        PingPongLogger.infoMessage(Constants.GAME_NAME + " has been loaded on version " + Constants.GAME_VERSION, EnumConsoleColor.ANSI_BLUE);
    }

    private static void mainGUI() {
        MainPingPongGUI mainPingPongGUI = new MainPingPongGUI();
        frm.setTitle("Ping Pong - " + Constants.GAME_VERSION);
        frm.setContentPane(mainPingPongGUI);
        frm.setSize(Constants.displayWidth, Constants.displayHeight);
        frm.setResizable(true);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);

        // Sets the Icon from the resources
        URL res = Constants.class.getClassLoader().getResource("icon.png");
        File file = null;
        try {
            file = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        String absolutePath = file.getAbsolutePath();
        BufferedImage myImg = null;
        try {
            myImg = ImageIO.read(new File(absolutePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frm.setIconImage(myImg);
    }

}
