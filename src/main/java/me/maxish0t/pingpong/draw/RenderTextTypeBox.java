package me.maxish0t.pingpong.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RenderTextTypeBox {

    /**
     * Variable for the text field.
     */
    public static JTextField jTextField = new JTextField(40);
    private static String text;
    private static int x;
    private static int y;
    private static int width;
    private static int height;
    private static Color color;
    private static ActionListener actionListener;

    /**
     * Constructor to render a Text Field on the frame.
     */
    public RenderTextTypeBox(String text, int x, int y, int width, int height, Color color, ActionListener actionListener) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.actionListener = actionListener;
    }

    /**
     * Renders the text field to the frame.
     */
    public static void renderTextField() {
        jTextField.setText(text);
        jTextField.setBounds(x, y, width, height);
        jTextField.addActionListener(actionListener);
        jTextField.setCaretColor(color);
        jTextField.setSelectedTextColor(color);
        jTextField.setSelectionColor(color);
        jTextField.setDisabledTextColor(color);
    }

}
