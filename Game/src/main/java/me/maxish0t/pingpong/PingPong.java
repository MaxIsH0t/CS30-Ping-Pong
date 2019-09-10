package me.maxish0t.pingpong;

import me.maxish0t.pingpong.gui.MainPingPongGUI;
import me.maxish0t.pingpong.util.PingPongUtils;

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

        PingPongUtils.LOGGER.info("Ball Position >> X: " + MainPingPongGUI.CIRCLE_X + " | Y: " + MainPingPongGUI.CIRCLE_Y);
        PingPongUtils.LOGGER.info(PingPongUtils.GAME_NAME + " has been loaded on version " + PingPongUtils.GAME_VERSION);
    }
}
