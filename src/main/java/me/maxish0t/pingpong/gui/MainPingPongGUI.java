package me.maxish0t.pingpong.gui;

import me.maxish0t.pingpong.draw.RenderPaddles;
import me.maxish0t.pingpong.draw.DrawUtils;
import me.maxish0t.pingpong.draw.TextUtils;
import me.maxish0t.pingpong.util.BorderAlgorithm;
import me.maxish0t.pingpong.util.Constants;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import javax.swing.*;

public class MainPingPongGUI extends JPanel implements KeyListener, ActionListener, MouseListener {

    /**
     * Frame Variables
     */
    private String        BORDER = "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -";
    public static double  ballX, ballY, ballSpeedX = 4, ballSpeedY = 4, ballSize = 20;
    private int           padH  = 10, padW = 100, bottomPadX, topPadX, inset = 10;
    public static boolean isGameReset = false;
    private boolean       shouldMoveBall = false;
    private boolean       isBGWhite, isBGBlack;
    private int           scoreTop, scoreBottom;
    public static int     mouseX, mouseY;
    public static int     height, width;
    private final int     SPEED = 4;
    private boolean       first;
    private boolean       hasPlayedMenu = false;

    /**
     * Lists & Arrays
     */
    private HashSet<String> keys = new HashSet<String>();
    private Timer   t = new Timer(5, this);
    Blackhole[] fireworks = new Blackhole[25];
    private ArrayList<NightSkyBalls> balls = new ArrayList<>();
    private Random rnd = new Random();

    /**
     * Random R G P color ints for the random colors.
     */
    int R = (int)(Math.random()*256);
    int G = (int)(Math.random()*256);
    int B= (int)(Math.random()*256);

    /**
     * Frame Constructor
     */
    public MainPingPongGUI() {
        isBGBlack = true;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addMouseListener(this);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                mouseX = getMousePosition().x;
                mouseY = getMousePosition().y;

                mouseClicker();
            }
        });

        BorderAlgorithm.drawBorder(BORDER);

        first = true;
        t.setInitialDelay(100);
        t.start();

        // spawns 60 random night sky balls at a random position
        for (int i = 0; i < 60; i++) {
            int randomStartXPos = (int) (Math.random() * (Constants.displayWidth - 40) + 1);
            int randomStartYPos = (int) (Math.random() * (Constants.displayHeight - 40) + 1);
            balls.add(new NightSkyBalls(randomStartXPos, randomStartYPos, 30));
        }
    }

    /**
     * When the mouse is clicked things in this method will happen.
     */
    private void mouseClicker() {
        // makes the night sky balls move
        for (NightSkyBalls ball : balls) {
            ball.move();
        }

        if (shouldMoveBall) {
            if( ballX < mouseX ){
                ballSpeedX = -ballSpeedX;
                ballSpeedY = -ballSpeedY;
            }
            if( ballX > mouseX ){
                ballSpeedX = -ballSpeedX;
                ballSpeedY = -ballSpeedY;
            }
            if( ballY < mouseY ){
                ballSpeedY = -ballSpeedY;
            }
            if( ballY > mouseY ){
                ballSpeedY = -ballSpeedY;
            }
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        height = getHeight();
        width = getWidth();

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));

        // draws the night sky balls
        for (NightSkyBalls ball : balls) {
            g2d.draw(ball.getEllipse());
        }

        if(VariablesGUI.timer >= 0) {
            VariablesGUI.timer--;
            DrawUtils.drawRectangle(0, 0, width, height, Color.GRAY, g);
            TextUtils.drawText("Welcome to Max's PingPong Game!", (width / 2) - (200 * 2), height / 2, 50, Color.WHITE, g);
            if (VariablesGUI.fade < 1.0F) {
                VariablesGUI.fade += 0.03F;
            }
        } else {
            if (!hasPlayedMenu) {
                String string = "How to play?";
                String string2 = "- You use the left and right keys on the keyboard.";
                TextUtils.drawText(string, (width / 2) - (250 / 2), 250, 50, Color.WHITE, g);
                TextUtils.drawText(string2, (width / 2) - (480), 300, 50, Color.WHITE, g);

                DrawUtils.drawPlayButton("Press Here To Play", (Constants.displayWidth / 2) - (500 / 2), 10, 500, 100, Color.RED, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        hasPlayedMenu = true;
                        DrawUtils.playButton.setVisible(false);
                    }
                }, this);
            } else if (hasPlayedMenu) {
                /**
                 for (int i = 0; i < fireworks.length; i++) {
                 fireworks[i] = new Blackhole();

                 fireworks[i].edgeDetection();
                 fireworks[i].move();
                 fireworks[i].draw(g);
                 }**/

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
                    RenderPaddles bottomPaddle = new RenderPaddles(bottomPadX, height - padH - inset, padW, padH, new Color(R, G, B), g);
                    bottomPaddle.renderPaddle();

                    // top pad
                    RenderPaddles topPaddle = new RenderPaddles(topPadX, inset, padW, padH, new Color(R, G, B), g);
                    topPaddle.renderPaddle();

                    // ball
                    DrawUtils.drawCircle(ballX, ballY, ballSize, new Color(R, G, B), g);

                    TextUtils.drawText(BORDER, 0, MainPingPongGUI.height / 2, 35, new Color(R, G, B), g);

                    String scoreT = "AI: " + new Integer(scoreTop).toString();
                    String scoreB = "Player: " + new Integer(scoreBottom).toString();
                    TextUtils.drawText(scoreT, width - 105, height / 2 - 30, 30, Color.WHITE, g);
                    TextUtils.drawText(scoreB, width - 125, height / 2 + 30, 30, Color.WHITE, g);
                }

                if (isBGWhite == true && isBGBlack == false) {
                    setBackground(Color.WHITE);

                    // bottom pad
                    RenderPaddles bottomPaddle = new RenderPaddles(bottomPadX, height - padH - inset, padW, padH, Color.WHITE, g);
                    bottomPaddle.renderPaddle();

                    // top pad
                    RenderPaddles topPaddle = new RenderPaddles(topPadX, inset, padW, padH, Color.WHITE, g);
                    topPaddle.renderPaddle();

                    // ball
                    DrawUtils.drawCircle(ballX, ballY, ballSize, Color.WHITE, g);

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
                        ballX = width / 2 - ballSize / 2;
                        ballY = height / 2 - ballSize / 2;

                        ballX += ballSpeedX;
                        ballY += ballSpeedY;

                        scoreBottom = 0;
                        scoreTop = 0;
                    }
                }, this);

                // exit button
                DrawUtils.drawExitButton("EXIT", 10, height / 2 + 90, 120, 50, Color.YELLOW, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(5);
                    }
                }, this);

                // white button
                DrawUtils.drawWhiteButton("WHITE", 10, height / 2 - 90, 120, 50, Color.YELLOW, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        isBGBlack = false;
                        isBGWhite = true;
                    }
                }, this);

                // black button
                DrawUtils.drawBlackButton("BLACK", 10, height / 2 - 150, 120, 50, Color.YELLOW, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
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
            }        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // side walls
        if (ballX < 0 || ballX > width - ballSize) {
            ballSpeedX = -ballSpeedX;
        }

        // top / down walls
        if (ballY < 0) {
            ballSpeedY = -ballSpeedY;
            ++ scoreBottom;
            System.out.println("Score for bottom paddle");
            isGameReset = true;
        }

        if (ballY + ballSize > height) {
            ballSpeedY = -ballSpeedY;
            ++ scoreTop;
            isGameReset = true;
        }

        // bottom pad
        if (ballY + ballSize >= height - padH - inset && ballSpeedY > 0) {
            if (ballX + ballSize >= bottomPadX && ballX <= bottomPadX + padW) {
                ballSpeedY = -ballSpeedY;
            }
        }

        // top pad
        if (ballY <= padH + inset && ballSpeedY < 0) {
            if (ballX + ballSize >= topPadX && ballX <= topPadX + padW) {
                ballSpeedY = -ballSpeedY;
            }
        }

        if (isGameReset == true) {
            ballX = width / 2 - ballSize / 2;
            ballY = height / 2 - ballSize / 2;

            ballX += ballSpeedX;
            ballY += ballSpeedY;

            isGameReset = false;
        }

        // makes the ball move
        ballX += ballSpeedX;
        ballY += ballSpeedY;

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

    @Override
    public void mouseClicked(MouseEvent e) {} // unused

    @Override
    public void mousePressed(MouseEvent e) {} // unused

    @Override
    public void mouseReleased(MouseEvent e) {} // unused

    @Override
    public void mouseEntered(MouseEvent e) {} // unused

    @Override
    public void mouseExited(MouseEvent e) {} // unused

}
