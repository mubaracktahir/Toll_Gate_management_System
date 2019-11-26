package com.group6;

import javax.swing.*;
import java.awt.*;

public class RoundedEdgeButton extends JButton {
    private Color backgroundColor;
    private int radius;
    public RoundedEdgeButton(int radius,Color backgroundColor){
        super();
        this.radius = radius;
        this.backgroundColor = backgroundColor;
        this.setOpaque(false);
        this.setBorderPainted(false);
        this.setForeground(Color.white);
    }
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        Dimension d = new Dimension(radius,radius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        if(backgroundColor != null){
            graphics.setColor(backgroundColor);
        }
        else graphics2D.setColor(getBackground());

        graphics2D.fillRoundRect(0,0,width-1,height-1,d.width,d.height);
        graphics2D.setColor(getForeground());

    }

}
