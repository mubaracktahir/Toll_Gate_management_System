package com.group6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DigitListener implements KeyListener {

    private JTextField textField;
    private JFrame frame;
    DigitListener(){

    }
    DigitListener(JTextField textField){
        this.textField = textField;
    }
    DigitListener(JFrame frame){
        this.frame = frame;
    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {

        char input = keyEvent.getKeyChar();
        Window w = new Window(frame);

        if(keyEvent.getSource() == textField){
            if(input == keyEvent.VK_SPACE) {
                w.getToolkit().beep();
                keyEvent.consume();
            }

        }
        else{
            if(!(Character.isDigit(input)) || input == KeyEvent.VK_BACK_SPACE || input == KeyEvent.VK_DELETE){
                w.getToolkit().beep();
                keyEvent.consume();
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
