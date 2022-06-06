package com.st;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;


public class Switch extends JPanel {
    boolean isOn;
    Timer timer;
    int nowYPos = 35;
    String upString, downString;
    AudioPlayer player;

    ActionListener taskPerformer = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isOn) {
                if (nowYPos > 20) {
                    repaint();
                } else {
                    Timer t = (Timer) e.getSource();
                    t.stop();
                }
            } else {
                if (nowYPos < 35) {
                    repaint();
                } else {
                    Timer t = (Timer) e.getSource();
                    t.stop();
                }
            }
        }
    };

    static class MouseAdapterMod extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (e.getY() < 20 || e.getY() > 50) {
                return;
            }
            Switch sender = (Switch) e.getSource();
            sender.switchStatus();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        frame.setContentPane(root);
        Switch c = new Switch("SINGLE");
        root.add(c);
        frame.setVisible(true);
    }

    public Switch(String s) {
        this.upString = s;
        this.downString = "";
        this.isOn = false;
        try {
            this.player = new AudioPlayer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        timer = new Timer(5, taskPerformer);
        this.myFundSettings();

    }

    public Switch(String sUp, String sDown) {
        this.upString = sUp;
        this.downString = sDown;
        this.isOn = false;
        try {
            this.player = new AudioPlayer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        timer = new Timer(5, taskPerformer);
        this.myFundSettings();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(10, 10, 10));
        if (this.isOn) {
            if (this.nowYPos != 20) {
                this.nowYPos -= 1;
            }
        } else {
            if (this.nowYPos != 35) {
                this.nowYPos += 1;
            }
        }
        g.fillRect(0, this.nowYPos, 18, 15);

        g.drawRect(0, 20, 18, 30);
        g.setFont(new Font("Arial", Font.PLAIN, 8));
        g.drawString(this.upString, 0, 20);
        if (!Objects.equals(this.downString, "")) {
            g.drawString(this.downString, 0, 60);

        }
    }

    private void myFundSettings() {
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setPreferredSize(new Dimension(20, 70));
        this.addMouseListener(new MouseAdapterMod());  // 添加鼠标响应事件
    }

    public void switchStatus() {
        this.isOn = !this.isOn;
        this.player.play();
        this.timer.start();
    }

    public boolean getOnStatus() {
        return this.isOn;
    }

}
