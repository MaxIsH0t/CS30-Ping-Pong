package me.maxish0t.pingpong.util.logger;

public class PingPongLogger {

    private static String BORDER;

    public static void infoMessage(String message, String enumConsoleColor) {
        System.out.println(enumConsoleColor + BORDER);
        System.out.println(enumConsoleColor + message);
        System.out.println(enumConsoleColor + BORDER + EnumConsoleColor.ANSI_WHITE);
    }

    static {
        BORDER = "------------------------------------------------------------------";
    }
}
