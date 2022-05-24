package com.st;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

class MouseAdapterMod extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {
        Switch sender = (Switch) e.getSource();
        sender.switchStatus();
    }
}

public class Switch extends JPanel {
    boolean isOn;
    String upString, downString;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        frame.setContentPane(root);
        Switch c = new Switch("    on", "    off");
        root.add(c);
        frame.setVisible(true);
    }

    public Switch(String s) {
        this.upString = s;
        this.downString = "";
        this.isOn = false;
        this.myFundSettings();

    }

    public Switch(String sUp, String sDown) {
        this.upString = sUp;
        this.downString = sDown;
        this.isOn = false;
        this.myFundSettings();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(10, 10, 10));
        if (this.isOn) {
            g.fillRect(10, 25, 30, 25);
        } else {
            g.fillRect(10, 50, 30, 25);

        }
        g.drawRect(10, 25, 30, 50);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString(this.upString, 0, 16);
        if (!Objects.equals(this.downString, "")) {
            g.drawString(this.downString, 0, 91);

        }
    }

    private void myFundSettings() {
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setPreferredSize(new Dimension(50, 100));
        this.addMouseListener(new MouseAdapterMod());  // 添加鼠标响应事件

    }

    public void switchStatus() {
        this.isOn = !this.isOn;
        System.out.println(this.getVisibleRect());
        this.repaint();
    }


}
