package com.group6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.group6.Icons.*;

import static com.group6.Colors.lightGreen;
import static com.group6.Fonts.*;
import static com.group6.Icons.*;
public class MyFrames {
    static private int xx;
    private int x;
    static private int yy;
    private int y;
    int confirm;
    private static int height = 100;
    private static int width = 300;
    private static Color duckColor;
    private static Color frameBackground;
    private static ImageIcon iconType;
    private static int positionX = 541;
    private static int positionY = 267;
    private static String message = "Error retry";
    public static JFrame frame;


    static void showSuccessfullFrame(String message, ImageIcon icon, int positionX, int positionY) {
        MyFrames.message = message;
        MyFrames.iconType = icon;
        MyFrames.positionX = (positionX - 300) / 2;
        MyFrames.positionY = (positionY - 220) / 2;
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setBackground(new Color(0, 0, 0, 0));
        Rectangle r = new Rectangle(MyFrames.positionX, MyFrames.positionY, 300, 220);
        frame.setBounds(r);
        frame.add(getDialog());
        frame.setVisible(true);

    }

    private static JPanel getDialog() {
        JPanel panel = new RoundEdgePanel(30, Color.black);
        panel.setBackground(Color.black);
        panel.setLayout(null);
        panel.setBounds(0, 0, 300, 220);
        panel.addMouseMotionListener(new MyMotionListener());
        JLabel successfulIcon = new JLabel(iconType);
        successfulIcon.setBounds(25, 0, 250, 150);
        successfulIcon.setText(MyFrames.message);
        successfulIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        successfulIcon.setForeground(Color.WHITE);
        successfulIcon.setHorizontalTextPosition(SwingConstants.CENTER);
        successfulIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel.add(successfulIcon);
        JButton b = new JButton("ok");
        b.setBackground(lightGreen);
        b.setBounds(125, 160, 50, 30);
        b.addActionListener(action -> frame.dispose());
        panel.add(b);
        b.setFocusPainted(false);
        return panel;
    }

    int showConfirmDialog(String message, ImageIcon icon, int positionX, int positionY) {
        int confirms = 9;
        MyFrames.message = message;
        MyFrames.iconType = icon;
        MyFrames.positionX = (positionX - 350) / 2;
        MyFrames.positionY = (positionY - 220) / 2;
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        Rectangle r = new Rectangle(MyFrames.positionX, MyFrames.positionY, 350, 220);
        frame.setBounds(r);

        JPanel panel = new RoundEdgePanel(30, Color.black);
        panel.setBackground(new Color(0x13130C));
        panel.setLayout(null);
        panel.setBounds(0, 0, 350, 220);
        panel.addMouseListener(new MyMotionListener());
        JLabel successfulIcon = new JLabel(iconType);
        successfulIcon.setBounds(30, 0, 300, 150);
        successfulIcon.setText(MyFrames.message);
        successfulIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        successfulIcon.setForeground(Color.WHITE);
        successfulIcon.setHorizontalTextPosition(SwingConstants.CENTER);
        successfulIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel.add(successfulIcon);
        JButton yesBtn = new RoundedEdgeButton(7, Color.red);
        yesBtn.setBackground(Color.red);
        yesBtn.setBounds(80, 160, 80, 30);
        yesBtn.setForeground(Color.white);
        yesBtn.setFocusPainted(true);
        yesBtn.addActionListener(action -> {
            confirm = 1;
            frame.dispose();
        });
        panel.add(yesBtn);
        JButton cancleBtn = new RoundedEdgeButton(7, lightGreen);
        cancleBtn.setText("Cancle");
        cancleBtn.setBackground(lightGreen);
        cancleBtn.setBounds(180, 160, 80, 30);
        cancleBtn.setForeground(Color.white);
        cancleBtn.addActionListener(action -> {
            confirm = 0;
            frame.dispose();
        });
        panel.add(cancleBtn);
        cancleBtn.setFocusPainted(true);
        frame.add(panel);
        frame.setVisible(true);

        return confirm;
    }

    private static JOptionPane getConfirmDialog() {

        JPanel panel = new RoundEdgePanel(30, Color.black);
        panel.setBackground(Color.black);
        panel.setLayout(null);
        panel.setBounds(0, 0, 350, 220);
        panel.addMouseListener(new MyMotionListener());
        JLabel successfulIcon = new JLabel(iconType);
        successfulIcon.setBounds(30, 0, 300, 150);
        successfulIcon.setText(MyFrames.message);
        successfulIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        successfulIcon.setForeground(Color.WHITE);
        successfulIcon.setHorizontalTextPosition(SwingConstants.CENTER);
        successfulIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
        panel.add(successfulIcon);
        JButton yesBtn = new RoundedEdgeButton(7, Color.red);
        yesBtn.setBackground(Color.red);
        yesBtn.setBounds(80, 160, 80, 30);
        yesBtn.setForeground(Color.white);
        yesBtn.setFocusPainted(true);
        yesBtn.addActionListener(action -> {

            frame.dispose();
        });
        panel.add(yesBtn);
        JButton cancleBtn = new RoundedEdgeButton(7, lightGreen);
        cancleBtn.setText("Cancle");
        cancleBtn.setBackground(lightGreen);
        cancleBtn.setBounds(180, 160, 80, 30);
        cancleBtn.setForeground(Color.white);
        cancleBtn.addActionListener(action -> {
            frame.dispose();
        });
        panel.add(cancleBtn);
        cancleBtn.setFocusPainted(true);
        JButton[] bottons = {cancleBtn, yesBtn};
        JOptionPane j = new JOptionPane(panel,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE, null,
                bottons
        );
        return j;
    }


    private static class MyMotionListener implements MouseMotionListener, MouseListener {

        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            int x = mouseEvent.getXOnScreen();
            int y = mouseEvent.getYOnScreen();
            frame.setLocation(x - xx, y - yy);
        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            xx = mouseEvent.getX();
            yy = mouseEvent.getY();
        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }

    int r = 1;
    int u = 0;
    int v = 2;

    public void showProcessDialog() {
        frame = new JFrame();

        frame.setBounds(525, 300, 300, 200);
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));
        MyPainter myPainter = new MyPainter();
        frame.getContentPane().add(myPainter);

        frame.setVisible(true);

        Thread t = new Thread(() -> {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            frame.dispose();
            showSuccessfullFrame("Succefully paid ", bigSuccessfulIcon, 1382, 755);
        });
        t.start();

        while (true) {

            u = 0;
            r = 1;
            v = 2;
            myPainter.repaint();
            try {
                Thread.sleep(700);
            } catch (Exception ex) {

            }
            u = 2;
            r = 0;
            v = 1;

            myPainter.repaint();
            try {
                Thread.sleep(700);
            } catch (Exception ex) {

            }
            u = 1;
            r = 2;
            v = 0;
            myPainter.repaint();
            try {
                Thread.sleep(700);
            } catch (Exception ex) {

            }
        }

    }

    public JPanel getProcessDialog() {

        JPanel panel = new RoundEdgePanel(30, Color.black);
        panel.setLayout(null);
        MyPainter p = new MyPainter();
        panel.add(p);
        return panel;
    }

    public class MyPainter extends JPanel {

        public MyPainter() {
            setLayout(null);
            setBackground(Color.black);
            JLabel b = new JLabel("Processing...");
            b.setBounds(80, 80, 250, 50);
            b.setForeground(Color.white);
            b.setFont(segoeUIEmoji);

            add(b);
        }

        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(Color.black);
            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            Color startColor = new Color(red, green, blue);
            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            Color[] colors = {new Color(242, 237, 0), new Color(255, 10, 16), new Color(0, 242, 17)};
            Color endColor = new Color(red, green, blue);
            GradientPaint gradientPaint = new GradientPaint(0, 0, colors[u], 0, 0, colors[u]);
            g2d.setPaint(gradientPaint);
            g2d.fillOval(130, 130, 15, 15);
            GradientPaint gradientPaint2 = new GradientPaint(0, 0, colors[r], 0, 0, colors[r]);

            g2d.setPaint(gradientPaint2);
            g2d.fillOval(150, 130, 15, 15);

            GradientPaint gradientPaint3 = new GradientPaint(0, 0, colors[v], 0, 0, colors[v]);

            g2d.setPaint(gradientPaint3);
            g2d.fillOval(170, 130, 15, 15);
        }
    }

    public static void main(String h[]) {
        MyFrames f = new MyFrames();
        f.showProcessDialog();


    }

    public static void openDialog(Frame f) {
        final JDialog dialog = new JDialog(f, "a test", true);
        dialog.setUndecorated(true);
        final JButton button = new JButton("custom button");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(button.getActionCommand());
                dialog.dispose();
            }
        });
        JPanel panel = new JPanel();
        panel.add(button);
        JButton[] buttons = {button};
        JOptionPane optionPane = new JOptionPane(panel,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, buttons, button);
        dialog.getContentPane().add(getConfirmDialog());
        dialog.pack();
        dialog.setBackground(new Color(0, 0, 0, 0));
        dialog.setLocationRelativeTo(f);
        dialog.setVisible(true);
    }

    public static void showAboutFrame(String message, ImageIcon icon, int positionX, int positionY) {
        if(! (frame == null))
            frame.dispose();
        MyFrames.message = message;
        MyFrames.iconType = icon;
        MyFrames.positionX = (positionX - 650) / 2;
        MyFrames.positionY = (positionY - 500) / 2;
        frame = new JFrame();

        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        Rectangle r = new Rectangle(MyFrames.positionX+75, MyFrames.positionY-45, 600, 350);
        frame.setBounds(r);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x232323));
        panel.setLayout(null);
        panel.setBounds(0, 0, 600, 350);
        panel.addMouseListener(new MyMotionListener());
        JPanel upPanel = new JPanel();
        upPanel.setBounds(0,15,600,50);
        upPanel.setBackground(Color.black);
        upPanel.setLayout(null);
        panel.add(upPanel);
        JLabel label = new JLabel();
        label.setText("Toll Gate System  - About");
        label.setForeground(Color.white);
        label.setFont(Fonts.segoeUIEmoji2);
        label.setBounds(15,10,300,35);
        upPanel.add(label);

        JLabel versionLabel = new JLabel("Toll Gate 2019.1");
        versionLabel.setBounds(100,80,200,30);
        versionLabel.setFont(newSegoeUIEmoji2);
        versionLabel.setForeground(new Color(0x646464));
        JLabel runtimeVersion = new JLabel("Java version \"1.8.0_192\"");
        runtimeVersion.setBounds(100,110,300,40);
        runtimeVersion.setFont(mediumSegoeUIEmojij);
        runtimeVersion.setForeground(new Color(0x646464));
        JLabel jvmLabel = new JLabel();
        jvmLabel.setText("Java(TM) SE Runtime Environment (build 1.8.0_192-b12)");
        jvmLabel.setFont(mediumSegoeUIEmojij);
        jvmLabel.setBounds(100,135,550,40);
        jvmLabel.setForeground(new Color(0x646464));

        JLabel ruLabel = new JLabel("VM: 64 bit server");
        ruLabel.setFont(mediumSegoeUIEmojij);
        ruLabel.setBounds(100,180,450,40);
        ruLabel.setForeground(new Color(0x646464));


        JLabel powered = new JLabel("Designed by: Group6");
        powered.setForeground(new Color(0x646464));
        powered.setFont(mediumSegoeUIEmojij);
        powered.setBounds(100,230,450,50);

        JLabel copyRight = new JLabel("Copyright 2019 Group 6 ");
        copyRight.setBounds(100,300,500,40);
        copyRight.setFont(mediumSegoeUIEmojij);
        copyRight.setForeground(new Color(0x646464));

        panel.add(copyRight);
        panel.add(ruLabel);
        panel.add(jvmLabel);
        panel.add(powered);
        panel.add(versionLabel);
        panel.add(runtimeVersion);
        frame.add(panel);

    }
    public static void showFAQs(){
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        Rectangle r = new Rectangle(MyFrames.positionX+75, MyFrames.positionY-45, 650, 350);
        frame.setBounds(r);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x232323));
        panel.setLayout(null);
        panel.setBounds(0, 0, 650, 350);
        panel.addMouseListener(new MyMotionListener());
        JPanel upPanel = new JPanel();
        upPanel.setBounds(0,15,650,50);
        upPanel.setBackground(Color.black);
        upPanel.setLayout(null);
        panel.add(upPanel);
        JLabel label = new JLabel();
        label.setText("Toll Gate System   - FAQs");
        label.setForeground(Color.white);
        label.setFont(Fonts.segoeUIEmoji2);
        label.setBounds(15,10,300,35);
        upPanel.add(label);

        JLabel versionLabel = new JLabel("Q. How can i sign in? ");
        versionLabel.setBounds(30,70,200,30);
        versionLabel.setFont(mediumSegoeUIEmojij);
        versionLabel.setForeground(new Color(0xE6E6E6));
        JLabel runtimeVersion = new JLabel("a. home> look down the panel>sign in >input registered email addressed and password> validate");
        runtimeVersion.setBounds(45,110,600,40);
        runtimeVersion.setFont(smallSegoeUIEmoji);
        runtimeVersion.setForeground(new Color(0x646464));
        JLabel jvmLabel = new JLabel();
        jvmLabel.setText("Q. can i remove my self from the system ?");
        jvmLabel.setFont(mediumSegoeUIEmojij);
        jvmLabel.setBounds(30,150,550,40);
        jvmLabel.setForeground(new Color(0xE6E6E6));

        JLabel ruLabel = new JLabel("a. No! only the admin can do that ");
        ruLabel.setFont(smallSegoeUIEmoji);
        ruLabel.setBounds(45,190,450,40);
        ruLabel.setForeground(new Color(0x646464));


        JLabel powered = new JLabel("Q. Is  installment allowed ");
        powered.setForeground(new Color(0xE6E6E6));
        powered.setFont(mediumSegoeUIEmojij);
        powered.setBounds(30,230,450,50);

        JLabel copyRight = new JLabel("a. No! all money has to be payed in full");
        copyRight.setBounds(45,270,500,40);
        copyRight.setFont(smallSegoeUIEmoji);
        copyRight.setForeground(new Color(0x646464));

        panel.add(copyRight);
        panel.add(ruLabel);
        panel.add(jvmLabel);
        panel.add(powered);
        panel.add(versionLabel);
        panel.add(runtimeVersion);
        frame.add(panel);

    }
    public static void showContact(){
        if(! (frame == null))
            frame.dispose();
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        Rectangle r = new Rectangle(MyFrames.positionX+75, MyFrames.positionY-45, 550, 350);
        frame.setBounds(r);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x232323));
        panel.setLayout(null);
        panel.setBounds(0, 0, 550, 350);
        panel.addMouseListener(new MyMotionListener());
        JPanel upPanel = new JPanel();
        upPanel.setBounds(0,15,550,50);
        upPanel.setBackground(Color.black);
        upPanel.setLayout(null);
        panel.add(upPanel);
        JLabel label = new JLabel();
        label.setText("Toll Gate System   - Contact");
        label.setForeground(Color.white);
        label.setFont(Fonts.segoeUIEmoji2);
        label.setBounds(15,10,300,35);
        upPanel.add(label);

        JLabel versionLabel = new JLabel("Email:");
        versionLabel.setBounds(30,70,200,30);
        versionLabel.setFont(mediumSegoeUIEmojij);
        versionLabel.setForeground(new Color(0xE6E6E6));
        JLabel runtimeVersion = new JLabel("info@tollgatenigeria.com tollgate@gmail.com tollgate@yahoo.com");
        runtimeVersion.setBounds(45,110,600,40);
        runtimeVersion.setFont(smallSegoeUIEmoji);
        runtimeVersion.setForeground(new Color(0x646464));
        JLabel jvmLabel = new JLabel();
        jvmLabel.setText("Mobile:");
        jvmLabel.setFont(mediumSegoeUIEmojij);
        jvmLabel.setBounds(30,150,550,40);
        jvmLabel.setForeground(new Color(0xE6E6E6));

        JLabel ruLabel = new JLabel("08033333333 (+1)902344334 07054547454 ");
        ruLabel.setFont(smallSegoeUIEmoji);
        ruLabel.setBounds(45,190,450,40);
        ruLabel.setForeground(new Color(0x646464));


        JLabel powered = new JLabel("Web:");
        powered.setForeground(new Color(0xE6E6E6));
        powered.setFont(mediumSegoeUIEmojij);
        powered.setBounds(30,230,450,50);

        JLabel copyRight = new JLabel("Tollgatesystem.com.ng");
        copyRight.setBounds(45,270,500,40);
        copyRight.setFont(smallSegoeUIEmoji);
        copyRight.setForeground(new Color(0x646464));

        panel.add(copyRight);
        panel.add(ruLabel);
        panel.add(jvmLabel);
        panel.add(powered);
        panel.add(versionLabel);
        panel.add(runtimeVersion);


        frame.add(panel);

    }
}


