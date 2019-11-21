package me.maxish0t.pingpong.draw;

import me.maxish0t.pingpong.util.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class DrawUtils
{
    // Buttons
    private static JButton exitButton = new JButton();
    private static JButton startButton = new JButton();
    private static JButton backgroundButton = new JButton();
    private static JButton backgroundButton2 = new JButton();
    public static JButton playButton = new JButton();

    // name box
    private static TextField nameBox = new TextField();

    /**
     * Draws a Rectangle
     */
    public static void drawRectangle(int x, int y, int width, int height, Color color, Graphics graphics) {
        graphics.setColor(color);
        graphics.drawRect(x, y, width, height);
        graphics.fillRect(x, y, width, height);
    }

    /**
     * Draws a Circle
     */
    public static void drawCircle(double x, double y, double ballSize, Color color, Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        Ellipse2D ball = new Ellipse2D.Double(x, y, ballSize, ballSize);
        g2d.setColor(color);
        g2d.fill(ball);
    }

    /**
     * Draw a Reset Button
     */
    public static void drawResetButton(String buttonText, int x, int y, int width, int height, Color mainColor, ActionListener actionListener, JPanel jPanel) {
        startButton.setText(buttonText);
        startButton.setBounds(x, y, width, height);
        startButton.setLocation(x, y);
        startButton.setBackground(mainColor);
        startButton.addActionListener(actionListener);
        jPanel.add(startButton);
    }

    /**
     * Draw a Exit Button
     */
    public static void drawExitButton(String buttonText, int x, int y, int width, int height, Color mainColor, ActionListener actionListener, JPanel jPanel) {
        exitButton.setText(buttonText);
        exitButton.setBounds(x, y, width, height);
        exitButton.setLocation(x, y);
        exitButton.setBackground(mainColor);
        exitButton.addActionListener(actionListener);
        jPanel.add(exitButton);
    }

    /**
     * Draw a Change Color Background Button
     */
    public static void drawWhiteButton(String buttonText, int x, int y, int width, int height, Color mainColor, ActionListener actionListener, JPanel jPanel) {
        backgroundButton.setText(buttonText);
        backgroundButton.setBounds(x, y, width, height);
        backgroundButton.setLocation(x, y);
        backgroundButton.setBackground(mainColor);
        backgroundButton.addActionListener(actionListener);
        jPanel.add(backgroundButton);
    }

    /**
     * Draw a Change Color Background Button
     */
    public static void drawBlackButton(String buttonText, int x, int y, int width, int height, Color mainColor, ActionListener actionListener, JPanel jPanel) {
        backgroundButton2.setText(buttonText);
        backgroundButton2.setBounds(x, y, width, height);
        backgroundButton2.setLocation(x, y);
        backgroundButton2.setBackground(mainColor);
        backgroundButton2.addActionListener(actionListener);
        jPanel.add(backgroundButton2);
    }

    /**
     * Draw a Change Color Background Button
     */
    public static void drawPlayButton(String buttonText, int x, int y, int width, int height, Color mainColor, ActionListener actionListener, JPanel jPanel) {
        playButton.setText(buttonText);
        playButton.setBounds(x, y, width, height);
        playButton.setLocation(x, y);
        playButton.setBackground(mainColor);
        playButton.addActionListener(actionListener);
        jPanel.add(playButton);
    }

    /**
     * Draw a Rectangle that you can type text into
     */
    public static void drawPlayerNameBox(String text, int x, int y, int width, int height, Color color, ActionListener actionListener, JPanel jPanel) {
        nameBox.setText(text);
        nameBox.setBounds(new Rectangle(x, y, width, height));
        nameBox.setLocation(x, y);
        nameBox.setBackground(color);
        nameBox.addActionListener(actionListener);
        jPanel.add(exitButton);
    }

    /**
     * Draws a Circle with a Particle Effect
     */
    public static void drawCircleParticle(double x, double y, double ballSize, Color color, Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        Ellipse2D ball = new Ellipse2D.Double(x, y, ballSize, ballSize);
        g2d.setColor(color);
        g2d.fill(ball);
    }

}
