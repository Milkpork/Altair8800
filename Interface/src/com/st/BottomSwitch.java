package com.st;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class BottomSwitch extends JPanel {
    JPanel upButton, downButton;
    String upString, downString;
    int status = 0;  // 0->归位,1->向上,2->向下
    int nowYPos = 20;
    Timer timer;
    AudioPlayer player;

    class MouseAdapterMod extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            player.play();
            if (e.getY() < 20) {
                status = 1;
                timer.start();
            } else if (e.getY() > 50) {
                status = 2;
                timer.start();
            }
        }
    }

    ActionListener taskPerformer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (status == 1) {
                if (nowYPos > 10) {
                    repaint();
                } else {
                    status = 0;
                }
            } else if (status == 2) {
                if (nowYPos < 30) {
                    repaint();
                } else {
                    status = 0;
                }
            } else if (status == 0) {
                if (nowYPos != 20) {
                    repaint();
                } else {
                    Timer t = (Timer) e.getSource();
                    t.stop();
                }
            }
        }
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        frame.setContentPane(root);
        JPanel c = new BottomSwitch("SINGLE", "hallo");
        root.add(c);
        frame.setVisible(true);
    }

    public BottomSwitch(String upString, String downString) {
        try {
            this.player = new AudioPlayer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.upButton = new JPanel();
        this.downButton = new JPanel();
        this.upString = upString;
        this.downString = downString;
        this.myFundSettings();
        timer = new Timer(10, taskPerformer);
    }

    public BottomSwitch(String upString) {
        try {
            this.player = new AudioPlayer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.upButton = new JPanel();
        this.downButton = new JPanel();
        this.upString = upString;
        this.downString = "";
        this.myFundSettings();
        timer = new Timer(10, taskPerformer);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(20, 20, 20));
        g.setFont(new Font("Arial", Font.PLAIN, 8));
        g.drawRect(0, 10, 18, 48);
        if (this.status == 0) {
            this.nowYPos += (int) Math.signum(20 - this.nowYPos);
        } else if (this.status == 1) {
            this.nowYPos -= 1;
        } else if (this.status == 2) {
            this.nowYPos += 1;
        }
        g.fillRect(0, this.nowYPos, 18, 30);
        g.drawString(this.upString, 0, 10);
        if (!Objects.equals(this.downString, "")) {
            g.drawString(this.downString, 0, 65);
        }

    }

    private void myFundSettings() {
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setPreferredSize(new Dimension(20, 70));
        this.addMouseListener(new BottomSwitch.MouseAdapterMod());  // 添加鼠标响应事件
    }
}
