package com.st;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MouseAdapterMod extends MouseAdapter {
    public void mouseClicked(MouseEvent e) {
        Light sender = (Light) e.getSource();
        sender.switchLight();
        System.out.println(sender.radius);
    }
}

public class Light extends JPanel {
    private boolean isLighting;  // 是否点亮
    public final int radius;
    private final Color fundColor;
    private final Color lightingColor;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        frame.setContentPane(root);
        Light c = new Light(50);
        root.add(c);
        c.setPreferredSize(new Dimension(50, 50));
        c.switchLight();
        //        test
        c.addMouseListener(new MouseAdapterMod());  // 添加鼠标响应事件
        frame.setVisible(true);
    }

    public Light(int radius) {
        this.radius = radius;
        this.fundColor = new Color(79, 11, 11);
        this.lightingColor = new Color(239, 117, 117);
        this.setPreferredSize(new Dimension(radius, radius));

    }

    public Light() {
        this.radius = 20;
        this.fundColor = new Color(79, 11, 11);
        this.lightingColor = new Color(239, 117, 117);
        this.setPreferredSize(new Dimension(50, 50));

    }

    // 绘图函数
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.isLighting) {
            g.setColor(this.lightingColor);
        } else {
            g.setColor(this.fundColor);
        }
        g.fillOval(0, 0, radius, radius);
    }

    // 切换
    public void switchLight() {
        this.isLighting = !this.isLighting;
        System.out.println("Switch light");
        this.repaint();
    }
}
