package me.maxish0t.pingpong.gui;

import me.maxish0t.pingpong.PingPong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class BallChaseAndNightSkyGUI extends JPanel implements MouseListener, ActionListener, KeyListener {

    /**
     * Ints that do things
     */
    private int mouseX, mouseY;
    private int height, width;
    private int ballX, ballY, ballSpeedX = 3, ballSpeedY = 3, ballSize = 20;

    /**
     * Booleans which allow the program to start and draw the things.
     */
    private boolean first;
    private boolean start;
    private boolean shouldMoveBall = false;

    /**
     * Things that do things to help the program
     */
    private HashSet<String> keys = new HashSet<>();
    private final Timer timer = new Timer(5, this);
    private Random rnd = new Random();

    /**
     * Array Lists lots of manipulation of things being added.
     */
    private ArrayList<NightSkyBalls> balls = new ArrayList<>();
    private Firework[] fireworks = new Firework[25];

    /**
     * Constructor for the frame
     */
    public BallChaseAndNightSkyGUI() {
        setBackground(Color.BLACK);
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
        first = true;
        timer.setInitialDelay(100);
        timer.start();

        // spawns 50 random night sky balls at a random position
        for (int i = 0; i < 50; i++) {
            int randomStartXPos = (int) (Math.random() * (PingPong.displayWidth - 40) + 1);
            int randomStartYPos = (int) (Math.random() * (PingPong.displayHeight - 40) + 1);
            balls.add(new NightSkyBalls(randomStartXPos, randomStartYPos, 30));
        }
    }

    /**
     * When the mouse is clicked things in this method will happen.
     */
    private void mouseClicker() {
        for (int i=0; i < fireworks.length; i++) {
            fireworks[i] = new Firework (width, height);
        }
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

    /**
     * Draws the things that need to be drawn on the frame.
     * @param g Graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        height = getHeight();
        width = getWidth();

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setPaint(new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));

        for(int i=0; i < fireworks.length; i++) {
            fireworks[i] = new Firework(width, height);
        }

        // draws the night sky balls
        for (NightSkyBalls ball : balls) {
            g2d.draw(ball.getEllipse());
        }

        if (first) {
            ballX = width / 2 - ballSize / 2;
            ballY = height / 2 - ballSize / 2;
            first = false;
        }

        if (!start) {
            Ball testBall = new Ball(ballX, ballY, ballSize, Color.WHITE);
            testBall.drawBall(g);
        }
    }

    /**
     * Allows things to be doing things.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (ballY > height - ballSize) {
            ballSpeedY = -ballSpeedY;
        } else if (ballX > width - ballSize) {
            ballSpeedX = -ballSpeedX;
        } else if (ballY < 0) {
            ballSpeedY = -ballSpeedY;
        } else if (ballX < 0) {
            ballSpeedX = -ballSpeedX;
        }

        for (int i=0; i < fireworks.length; i++) {
//            fireworks[i].step(); //Calculate Arithmetic
//            fireworks[i].drawFirework(getGraphics()); //Draw to the Canvas
        }

        // makes the ball move
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // pressed keys
        if (keys.contains("SPACE")) {
            start = true;
        }
        if (keys.size() == 1) {
            if (keys.contains("SPACE")) {
                start = true;
            }
        }

        repaint();
    }

    /**
     * Key pressed on the keyboard which gets the hashmap and adds a key and can be used in the actionlistener.
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_BACK_SPACE:
                keys.add("SPACE");
                break;
        }
    }

    /**
     * Key released on the keyboard which gets the hashmap and removes a key pressed.
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_BACK_SPACE:
                keys.remove("SPACE");
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

    @Override
    public void keyTyped(KeyEvent e) {} // unused

}
