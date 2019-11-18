package me.maxish0t.pingpong.draw;

import java.awt.*;

public class RenderPaddles {

    /**
     * Paddle Variables
     */
    private static int paddleX;
    private static int paddleY;
    private static int paddleWidth;
    private static int paddleHeight;
    private static Color paddleColor;
    private static Graphics graphics;

    /**
     * Paddles Constructor
     */
    public RenderPaddles(int paddleX, int paddleY, int paddleWidth, int paddleHeight, Color paddleColor, Graphics graphics) {
        this.paddleX = paddleX;
        this.paddleY = paddleY;
        this.paddleWidth = paddleWidth;
        this.paddleHeight = paddleHeight;
        this.paddleColor = paddleColor;
        this.graphics = graphics;
    }

    /**
     * Renders the paddle to the frame.
     */
    public static void renderPaddle() {
        graphics.setColor(paddleColor);
        graphics.drawRect(paddleX, paddleY, paddleWidth, paddleHeight);
        graphics.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);
    }

}
