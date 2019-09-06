package me.maxish0t.pingpong;

import me.maxish0t.pingpong.gui.MainPingPongGUI;
import me.maxish0t.pingpong.util.PingPongUtils;

import java.awt.*;

/**
 * Created By Mahmoud Saleh
 * Date Created On: Friday, September 6, 2019
 */
public class PingPong
{
    public static void main(String[] args)
    {
        // Loads the main GUI for the Ping Pong Game
        MainPingPongGUI.mainGUI();
        Rectangle box= new Rectangle(5,10,20,30);
        System.out.println(box);



        PingPongUtils.LOGGER.info(PingPongUtils.GAME_NAME + " has been loaded on version " + PingPongUtils.GAME_VERSION);
    }
}
