package com.group6;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DigitListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        char input = keyEvent.getKeyChar();
        if(!(Character.isDigit(input)) || input == KeyEvent.VK_BACK_SPACE || input == KeyEvent.VK_DELETE){
            keyEvent.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
