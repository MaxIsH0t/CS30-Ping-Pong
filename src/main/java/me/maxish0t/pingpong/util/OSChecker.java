package me.maxish0t.pingpong.util;

import me.maxish0t.pingpong.util.logger.EnumConsoleColor;
import me.maxish0t.pingpong.util.logger.PingPongLogger;

public class OSChecker {

    private static String OS = System.getProperty("os.name").toLowerCase();

    /**
     * Checks if the OS Windows or Mac is being used when running the jar.
     */
    public static void checkOS() {
        if (isWindows()) {
            PingPongLogger.infoMessage("You are currently running the launcher on a windows OS system.", EnumConsoleColor.ANSI_GREEN);
        } else if (isMac()) {
            PingPongLogger.infoMessage("You are currently running the launcher on a mac OS system.", EnumConsoleColor.ANSI_GREEN);
        } else if (isUnix()) {
            PingPongLogger.infoMessage("You are currently running the launcher on a non supported OS system. Program Exiting...", EnumConsoleColor.ANSI_RED);
            System.exit(5);
        } else if (isSolaris()) {
            PingPongLogger.infoMessage("You are currently running the launcher on a non supported OS system. Program Exiting...", EnumConsoleColor.ANSI_RED);
            System.exit(5);
        }
    }

    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);

    }

    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);

    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );

    }

    public static boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }

}
