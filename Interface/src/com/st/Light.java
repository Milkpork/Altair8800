package com.st;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Light extends JPanel {
    private boolean isLighting;  // 是否点亮
    public final int radius;
    private final Color fundColor;
    private final Color lightingColor;
    private final String text;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        frame.setContentPane(root);
        Light c = new Light("hello");
        root.add(c);
        c.switchLight();

        //        test
//        c.addMouseListener(new MouseAdapterModTest());  // 添加鼠标响应事件

        frame.setVisible(true);
    }

    public Light(String text, int radius) {
        this.text = text;
        this.radius = radius;
        this.fundColor = new Color(79, 11, 11);
        this.lightingColor = new Color(239, 117, 117);
        this.myFundSettings();
    }

    public Light(String text) {
        this.text = text;
        this.radius = 20;
        this.fundColor = new Color(79, 11, 11);
        this.lightingColor = new Color(239, 117, 117);
        this.myFundSettings();
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
        g.fillOval(0, 20, radius, radius);
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("Arial", Font.PLAIN, 8));
        g.drawString(this.text, 0, 20);

    }

    private void myFundSettings() {
        this.setPreferredSize(new Dimension(radius, radius + 20));
    }

    // 切换
    public void switchLight() {
        this.isLighting = !this.isLighting;
        this.repaint();
    }

    public void switchLight(boolean isLighting) {
        this.isLighting = isLighting;
        this.repaint();
    }

    public boolean getOnStatus() {
        return this.isLighting;
    }
}
