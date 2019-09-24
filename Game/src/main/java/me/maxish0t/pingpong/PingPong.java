package me.maxish0t.pingpong;

import me.maxish0t.pingpong.gui.MainPingPongGUI;
import me.maxish0t.pingpong.util.PingPongUtils;

import javax.swing.*;

import static com.sun.javafx.fxml.expression.Expression.add;

/**
 * Created By Mahmoud Saleh
 * Date Created On: Friday, September 6, 2019
 */
public class PingPong
{
    public static void main(String[] args)
    {
        // Loads the main GUI for the Ping Pong Game
        MainPingPongGUI mainPingPongGUI = new MainPingPongGUI();

        JFrame frm = new JFrame();
        frm.setTitle("Ping Pong");
        frm.setContentPane(mainPingPongGUI);
        frm.setSize(1600, 900);
        frm.setResizable(false);
        frm.setVisible(true);

        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PingPongUtils.LOGGER.info(PingPongUtils.GAME_NAME + " has been loaded on version " + PingPongUtils.GAME_VERSION);
    }
}
