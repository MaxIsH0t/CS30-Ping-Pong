package me.maxish0t.pingpong.util;

import me.maxish0t.pingpong.PingPong;

public class BorderAlgorithm {

    public static void drawBorder(String string) {
        if (PingPong.frm.getWidth() < Constants.displayWidth) {
            int i = 2;
            while (i <= 200) {
                //System.out.print(string);
                i += 2;  // add 2 to i
            }
        }
    }

}
