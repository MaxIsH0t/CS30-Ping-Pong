package me.maxish0t.pingpong.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BallChaseGUI extends JPanel implements MouseListener, ActionListener {

    private int mouseX, mouseY;
    private int height, width;
    private boolean first;
    private int ballX, ballY, ballSpeedX = 3, ballSpeedY = 3, ballSize = 20;
    private Color color = Color.WHITE;
    private Timer t = new Timer(5, this);

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
    }

    public void mouseClicker() {
        getMousePosition().move(ballX, ballY);
        ballX = mouseX;
        ballY = mouseY;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        height = getHeight();
        width = getWidth();

        if (first) {
            ballX = width / 2 - ballSize / 2;
            ballY = height / 2 - ballSize / 2;
            first = false;
        }

        // Ball
        Ball.drawBall(ballX, ballY, ballSize, Color.WHITE, g);
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

        repaint();
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
}
