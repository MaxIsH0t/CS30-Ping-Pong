package me.maxish0t.pingpong.util;

import me.maxish0t.pingpong.PingPong;

public class ScreenSizeTester {

    // checks if the screen is too small
    public static void checker() {
        String fullSize = "DisplayWidth= " + PingPong.displayWidth + "; DisplayHeight= " + PingPong.displayHeight;
        System.out.println(fullSize);
        float checker = PingPong.displayWidth / PingPong.displayHeight;
        if (PingPong.displayWidth < 500) {
            System.out.println("ERROR: This program will not work on this display, the width is too small.");
            System.exit(5);
        } else if (checker < 0.5625) {
            System.out.println("ERROR: This program will not work on this display, the height is too small.");
            System.exit(5);
        }
    }
}
