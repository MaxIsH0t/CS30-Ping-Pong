package me.maxish0t.pingpong.gui;

import me.maxish0t.pingpong.PingPong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class BallChaseGUI extends JPanel implements MouseListener, ActionListener, KeyListener {

    private int mouseX, mouseY;
    private int height, width;
    private boolean first;
    private boolean start;
    private int ballX, ballY, ballSpeedX = 3, ballSpeedY = 3, ballSize = 20;
    private HashSet<String> keys = new HashSet<String>();
    private Timer t = new Timer(5, this);

    Random rnd = new Random();
    public ArrayList<TestBall> balls = new ArrayList<TestBall>();

    public BallChaseGUI() {
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
        t.setInitialDelay(100);
        t.start();

        for (int i = 0; i < 50; i++) {
            int randomStartXPos = (int) (Math.random() * (PingPong.displayWidth - 40) + 1);
            int randomStartYPos = (int) (Math.random() * (PingPong.displayHeight - 40) + 1);
            balls.add(new TestBall(randomStartXPos, randomStartYPos, 30));
        }
    }

    public void mouseClicker() {
        //getMousePosition().move(ballX, ballY);
        //ballX = mouseX;
        //ballY = mouseY;

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
        repaint();
    }

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

        for (TestBall ball : balls) {
            ball.move();
            g2d.draw(ball.getEllipse());
        }

        if (first) {
            ballX = width / 2 - ballSize / 2;
            ballY = height / 2 - ballSize / 2;
            first = false;
        }

        if (start == false) {
            // Ball
            Ball testBall = new Ball(ballX, ballY, ballSize, Color.WHITE);
            testBall.drawBall(g);
        }
    }

    public void move() {
        for (TestBall ball : balls) {
            ball.move();
        }
    }

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

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_BACK_SPACE:
                keys.add("SPACE");
                break;
        }
    }

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
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
