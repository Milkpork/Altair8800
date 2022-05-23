package com.st;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MouseAdapterMod2 extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {
        Switch sender = (Switch) e.getSource();
        sender.switchStatus();
        System.out.println(sender.isOn);
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
        Switch c = new Switch("hello");
        root.add(c);
        c.addMouseListener(new MouseAdapterMod2());  // 添加鼠标响应事件

        frame.setVisible(true);
    }

    public Switch(String s) {
        this.upString = s;
        this.downString = "";
        this.isOn = false;
        this.setPreferredSize(new Dimension(50, 100));

    }

    public Switch(String sUp, String sDown) {
        this.upString = sUp;
        this.downString = sDown;
        this.isOn = false;
        this.setPreferredSize(new Dimension(50, 100));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(10, 10, 10));
        if (this.isOn) {
            g.fillRect(0, 0, 48, 49);
        } else {
            g.fillRect(0, 49, 48, 49);

        }
        g.drawRect(0, 0, 48, 98);
    }

    public void switchStatus() {
        this.isOn = !this.isOn;
        System.out.println("Switch light");
        this.repaint();
    }


}
