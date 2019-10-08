package me.maxish0t.pingpong.gui;

import me.maxish0t.pingpong.util.DrawUtils;
import me.maxish0t.pingpong.util.TextUtils;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import javax.swing.*;

public class MainPingPongGUI extends JPanel implements KeyListener, ActionListener {
    private String BORDER = "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -";
    private int height, width;
    private Timer t = new Timer(5, this);
    private boolean first;
    private HashSet<String> keys = new HashSet<String>();
    public static boolean isGameReset = false;

    // pad
    private final int SPEED = 5;
    private int       padH  = 10, padW = 100;
    private int       bottomPadX, topPadX;
    private int       inset = 10;

    // ball
    private double ballX, ballY, velX = 2, velY = 2, ballSize = 20;

    // score
    private int scoreTop, scoreBottom;

    // background color
    private boolean isBGWhite, isBGBlack;

    // pause game
    private boolean isGamePaused;

    public MainPingPongGUI() {
        setBackgroundColor(false, false);
        isBGBlack = true;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        first = true;
        t.setInitialDelay(100);
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        height = getHeight();
        width = getWidth();
        // initial positioning
        if (first) {
            isGameReset = false;
            bottomPadX = width / 2 - padW / 2;
            topPadX = bottomPadX;
            ballX = width / 2 - ballSize / 2;
            ballY = height / 2 - ballSize / 2;
            first = false;
        }
        if (isBGBlack == true && isBGWhite == false) {
            setBackground(Color.BLACK);
            // bottom pad
            DrawUtils.drawRectangle(bottomPadX, height - padH - inset, padW, padH, Color.WHITE, g);
            // top pad
            DrawUtils.drawRectangle(topPadX, inset, padW, padH, Color.WHITE, g);
            // ball
            DrawUtils.drawCircle(ballX, ballY, ballSize, Color.WHITE, g);

            TextUtils.drawText(BORDER, 0, height / 2, 35, Color.WHITE, g);
            String scoreT = "AI: " + new Integer(scoreTop).toString();
            String scoreB = "Player: " + new Integer(scoreBottom).toString();
            TextUtils.drawText(scoreT, width - 105, height / 2 - 30, 30, Color.WHITE, g);
            TextUtils.drawText(scoreB, width - 125, height / 2 + 30, 30, Color.WHITE, g);
        }
        if (isBGWhite == true && isBGBlack == false) {
            setBackground(Color.WHITE);
            // bottom pad
            DrawUtils.drawRectangle(bottomPadX, height - padH - inset, padW, padH, Color.BLACK, g);
            // top pad
            DrawUtils.drawRectangle(topPadX, inset, padW, padH, Color.BLACK, g);
            // ball
            DrawUtils.drawCircle(ballX, ballY, ballSize, Color.BLACK, g);

            TextUtils.drawText(BORDER, 0, height / 2, 35, Color.BLACK, g);
            String scoreT = "AI: " + new Integer(scoreTop).toString();
            String scoreB = "Player: " + new Integer(scoreBottom).toString();
            TextUtils.drawText(scoreT, width - 105, height / 2 - 30, 30, Color.BLACK, g);
            TextUtils.drawText(scoreB, width - 125, height / 2 + 30, 30, Color.BLACK, g);
        }
        // reset button
        DrawUtils.drawResetButton("RESET", 10, height / 2 + 30, 120, 50, Color.YELLOW, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Program is currently resetting....");
                ballX = width / 2 - ballSize / 2;
                ballY = height / 2 - ballSize / 2;

                ballX += velX;
                ballY += velY;

                scoreBottom = 0;
                scoreTop = 0;
            }
        }, this);
        // exit button
        DrawUtils.drawExitButton("EXIT", 10, height / 2 + 90, 120, 50, Color.YELLOW, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Program is currently exiting....");
                System.exit(5);
            }
        }, this);
        // white button
        DrawUtils.drawWhiteButton("WHITE", 10, height / 2 - 90, 120, 50, Color.YELLOW, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Program is currently changing its background....");
                isBGBlack = false;
                isBGWhite = true;
            }
        }, this);
        // black button
        DrawUtils.drawBlackButton("BLACK", 10, height / 2 - 150, 120, 50, Color.YELLOW, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Program is currently changing its background....");
                if (isBGWhite == true) {
                    isBGWhite = false;
                    isBGBlack = true;
                } else {
                    isBGBlack = true;
                }
            }
        }, this);
        // player name
        DrawUtils.drawPlayerNameBox("Put player name here", 1, 10, 100, 50, Color.BLUE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        }, this);
        // game reset
        if (isGameReset == true) {
            TextUtils.drawText("Press the button to reset the ball.", width / 2, 150 * 2, 40, Color.WHITE, g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // side walls
        if (ballX < 0 || ballX > width - ballSize) {
            velX = -velX;
        }
        // top / down walls
        if (ballY < 0) {
            velY = -velY;
            ++ scoreBottom;
            isGameReset = true;
            isGamePaused = true;
        }
        if (ballY + ballSize > height) {
            velY = -velY;
            ++ scoreTop;
            isGameReset = true;
            isGamePaused = true;
        }
        // bottom pad
        if (ballY + ballSize >= height - padH - inset && velY > 0) {
            if (ballX + ballSize >= bottomPadX && ballX <= bottomPadX + padW) {
                velY = -velY;
            }
        }
        // top pad
        if (ballY <= padH + inset && velY < 0) {
            if (ballX + ballSize >= topPadX && ballX <= topPadX + padW) {
                velY = -velY;
            }
        }
        if (isGameReset == true) {
            ballX = width / 2 - ballSize / 2;
            ballY = height / 2 - ballSize / 2;

            ballX += velX;
            ballY += velY;

            isGameReset = false;
        }
        // makes the ball move
        ballX += velX;
        ballY += velY;
        // pressed keys
        if (keys.size() == 1) {
            if (keys.contains("LEFT")) {
                bottomPadX -= (bottomPadX > 0) ? SPEED : 0;
            }
            else if (keys.contains("RIGHT")) {
                bottomPadX += (bottomPadX < width - padW) ? SPEED : 0;
            }
        }
        // AI
        double delta = ballX - topPadX;
        if (delta > 0) {
            topPadX += (topPadX < width - padW) ? SPEED : 0;
        }
        else if (delta < 0) {
            topPadX -= (topPadX > 0) ? SPEED : 0;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_LEFT:
                keys.add("LEFT");
                break;
            case KeyEvent.VK_RIGHT:
                keys.add("RIGHT");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_LEFT:
                keys.remove("LEFT");
                break;
            case KeyEvent.VK_RIGHT:
                keys.remove("RIGHT");
                break;
        }
    }

    private void setBackgroundColor(boolean setWhite, boolean setBlack) {
        setBackground(Color.BLACK);
        if (this.getBackground() == Color.BLACK && setWhite == true) {
            setBackground(Color.WHITE);
        } else if (this.getBackground() == Color.WHITE && setBlack == true) {
            setBackground(Color.BLACK);
        }
    }
}
