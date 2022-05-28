package com.st;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel {
    Light INTE = new Light("INTE");
    Light PROT = new Light("PROT");
    Light MEMR = new Light("MEMR");
    Light INP = new Light(" INP");
    Light MI = new Light("  MI");
    Light OUT = new Light(" OUT");
    Light HLTA = new Light("HLTA");
    Light STACK = new Light("STACK");
    Light WO = new Light("  WO");
    Light INT = new Light(" INT");

    Light D7 = new Light("  D7");
    Light D6 = new Light("  D6");
    Light D5 = new Light("  D5");
    Light D4 = new Light("  D4");
    Light D3 = new Light("  D3");
    Light D2 = new Light("  D2");
    Light D1 = new Light("  D1");
    Light D0 = new Light("  D0");

    Light WAIT = new Light("WAIT");
    Light HLDA = new Light("HLDA");
    Light A15 = new Light(" A15");
    Light A14 = new Light(" A14");
    Light A13 = new Light(" A13");
    Light A12 = new Light(" A12");
    Light A11 = new Light(" A11");
    Light A10 = new Light(" A10");
    Light A9 = new Light("  A9");
    Light A8 = new Light("  A8");
    Light A7 = new Light("  A7");
    Light A6 = new Light("  A6");
    Light A5 = new Light("  A5");
    Light A4 = new Light("  A4");
    Light A3 = new Light("  A3");
    Light A2 = new Light("  A2");
    Light A1 = new Light("  A1");
    Light A0 = new Light("  A0");
    Switch S15 = new Switch("  15");
    Switch S14 = new Switch("  14");
    Switch S13 = new Switch("  13");
    Switch S12 = new Switch("  12");
    Switch S11 = new Switch("  11");
    Switch S10 = new Switch("  10");
    Switch S9 = new Switch("   9");
    Switch S8 = new Switch("   8");
    Switch S7 = new Switch("   7");
    Switch S6 = new Switch("   6");
    Switch S5 = new Switch("   5");
    Switch S4 = new Switch("   4");
    Switch S3 = new Switch("   3");
    Switch S2 = new Switch("   2");
    Switch S1 = new Switch("   1");
    Switch S0 = new Switch("   0");

    BottomSwitch TotalSwitch = new BottomSwitch(" OFF", "  ON");
    BottomSwitch RunSwitch = new BottomSwitch("STOP", " RUN");
    BottomSwitch SingleStepSwitch = new BottomSwitch("SINGLE");
    BottomSwitch ExamineSwitch = new BottomSwitch("EXAMINE", "NEXT");
    BottomSwitch DepositSwitch = new BottomSwitch("DEPO", "NEXT");
    BottomSwitch ResetSwitch = new BottomSwitch("RESET", " CLR");
    BottomSwitch ProtectSwitch = new BottomSwitch("PROTECT", "UNPROTECT");
    BottomSwitch AUXSwitch1 = new BottomSwitch(" AUX");
    BottomSwitch AUXSwitch2 = new BottomSwitch(" AUX");

    boolean isOpening = false;
    int nowStatus;
    int leftMissCount = 0, rightMissCount = -1;
    boolean isRightRunning = true;
    Light[] tennisList = {A15, A14, A13, A12, A11, A10, A9, A8};
    Timer timer;


    ActionListener tennisProgram = new ActionListener() {
        int index = -1;

        @Override
        public void actionPerformed(ActionEvent e) {
            index += isRightRunning ? 1 : -1;
            index = index - Math.floorDiv(index, 8) * 8;
            if (index == 0 && isRightRunning) {
                rightMissCount += 1;
                System.out.println("rightMiss!");
            } else if (index == 7 && !isRightRunning) {
                leftMissCount += 1;
                System.out.println("leftMiss!");
            }
            int temp = index - (isRightRunning ? 1 : -1);
            // temp%8, m - (int) Math.floorDiv(m, n) * n
            tennisList[temp - Math.floorDiv(temp, 8) * 8].switchLight(false);
            tennisList[index].switchLight(true);
        }
    };

    class MyKeyListener implements KeyListener {
        @Override // 按下
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == '0'){
                S15.switchStatus();
                if (nowStatus == 13 && !isRightRunning && S15.getOnStatus() && A15.getOnStatus()) {
                    isRightRunning = !isRightRunning;
                }
            }else if (e.getKeyChar() == '1'){
                S8.switchStatus();
                if (nowStatus == 13 && isRightRunning && S8.getOnStatus() && A8.getOnStatus()) {
                    isRightRunning = !isRightRunning;
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override // 输入的内容
        public void keyTyped(KeyEvent e) {
        }
    }

    class S15SwitchMod extends MouseAdapter {
        //        S15
        public void mouseClicked(MouseEvent e) {
            if (nowStatus == 13 && !isRightRunning && S15.getOnStatus() && A15.getOnStatus()) {
                isRightRunning = !isRightRunning;
            }
        }
    }

    class S8SwitchMod extends MouseAdapter {
        //        S8
        public void mouseClicked(MouseEvent e) {
            if (nowStatus == 13 && isRightRunning && S8.getOnStatus() && A8.getOnStatus()) {
                isRightRunning = !isRightRunning;
            }
        }
    }

    class TotalSwitchMod extends MouseAdapter {
        //        总开关
        public void mouseClicked(MouseEvent e) {
            if (e.getY() < 20) {
                // off
                reset();
                isOpening = false;
                nowStatus = 0;
            } else if (e.getY() > 50) {
                // on
                if (!isOpening) {
                    MEMR.switchLight(true);
                    MI.switchLight(true);
                    WO.switchLight(true);
                    D3.switchLight(true);
                    D0.switchLight(true);
                    WAIT.switchLight(true);
                    A3.switchLight(true);
                    A0.switchLight(true);
                    isOpening = true;
                }
            }
        }
    }

    class RunSwitchMod extends MouseAdapter {
        //        运行
        public void mouseClicked(MouseEvent e) {
            if (!isOpening) {
                return;
            }
            System.out.println(nowStatus);
            if (e.getY() < 20) {
                if (nowStatus == 13) {
                    stopTennis();
                }

            } else if (e.getY() > 50) {
                if (nowStatus == 12 || nowStatus == 14) {
                    tableTennis();
                }
            }
        }
    }

    class ExamineSwitch extends MouseAdapter {
        //        运行
        public void mouseClicked(MouseEvent e) {
            if (!isOpening) {
                return;
            }
            int switchOpenStatus = 0;  // 状态压缩
            // 获取一个开关的状态码
            Component[] ls = getComponents();
            for (Component c : ls) {
                if (c.getClass().getName().equals("com.st.Switch")) {
                    if (((Switch) c).getOnStatus()) {
                        int digit = Integer.parseInt(((Switch) c).upString.trim());
                        switchOpenStatus |= (1 << digit);  // 二进制
                    }
                }
            }
            if (e.getY() < 20) {
                System.out.println(switchOpenStatus);
                if (switchOpenStatus == 0) {
                    nowStatus = 12;  // TENNIS
                } else if (switchOpenStatus == 128) {
                    showMissCount(true);
                }
            } else if (e.getY() > 50) {
                if (switchOpenStatus == 128) {
                    showMissCount(false);
                }

            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel root = new Panel();
        frame.setContentPane(root);
        frame.setVisible(true);
    }

    public Panel() {
        this.timer = new Timer(200, tennisProgram);
        this.myLayouts();
        this.myFundSettings();
    }

    public void myFundSettings() {
        this.setFocusable(true);
        this.addKeyListener(new MyKeyListener());
        this.TotalSwitch.addMouseListener(new TotalSwitchMod());
        this.ExamineSwitch.addMouseListener(new ExamineSwitch());
        this.RunSwitch.addMouseListener(new RunSwitchMod());
        this.S15.addMouseListener(new S15SwitchMod());
        this.S8.addMouseListener(new S8SwitchMod());
    }

    public void myLayouts() {
        // 布局管理
        int lightWidth = 20;
        int lightHeight = 50;
        int switchWidth = 20;
        int switchHeight = 70;
        this.setMinimumSize(new Dimension(1260, 500));
        this.setLayout(null);
        this.add(this.INTE);
        this.INTE.setBounds(100, 50, 30, 50);
        this.add(this.PROT);
        this.PROT.setBounds(130, 50, lightWidth, lightHeight);
        this.add(this.MEMR);
        this.MEMR.setBounds(160, 50, lightWidth, lightHeight);
        this.add(this.INP);
        this.INP.setBounds(190, 50, lightWidth, lightHeight);
        this.add(this.MI);
        this.MI.setBounds(220, 50, lightWidth, lightHeight);
        this.add(this.OUT);
        this.OUT.setBounds(250, 50, lightWidth, lightHeight);
        this.add(this.HLTA);
        this.HLTA.setBounds(280, 50, lightWidth, lightHeight);
        this.add(this.STACK);
        this.STACK.setBounds(310, 50, lightWidth, lightHeight);
        this.add(this.WO);
        this.WO.setBounds(340, 50, lightWidth, lightHeight);
        this.add(this.INT);
        this.INT.setBounds(370, 50, lightWidth, lightHeight);

        this.add(this.D7);
        this.D7.setBounds(470, 50, lightWidth, lightHeight);
        this.add(this.D6);
        this.D6.setBounds(500, 50, lightWidth, lightHeight);
        this.add(this.D5);
        this.D5.setBounds(550, 50, lightWidth, lightHeight);
        this.add(this.D4);
        this.D4.setBounds(580, 50, lightWidth, lightHeight);
        this.add(this.D3);
        this.D3.setBounds(610, 50, lightWidth, lightHeight);
        this.add(this.D2);
        this.D2.setBounds(660, 50, lightWidth, lightHeight);
        this.add(this.D1);
        this.D1.setBounds(690, 50, lightWidth, lightHeight);
        this.add(this.D0);
        this.D0.setBounds(720, 50, lightWidth, lightHeight);

        this.add(this.WAIT);
        this.WAIT.setBounds(100, 100, lightWidth, lightHeight);
        this.add(this.HLDA);
        this.HLDA.setBounds(130, 100, lightWidth, lightHeight);

        this.add(this.A15);
        this.A15.setBounds(170, 100, lightWidth, lightHeight);
        this.add(this.A14);
        this.A14.setBounds(220, 100, lightWidth, lightHeight);
        this.add(this.A13);
        this.A13.setBounds(250, 100, lightWidth, lightHeight);
        this.add(this.A12);
        this.A12.setBounds(280, 100, lightWidth, lightHeight);
        this.add(this.A11);
        this.A11.setBounds(330, 100, lightWidth, lightHeight);
        this.add(this.A10);
        this.A10.setBounds(360, 100, lightWidth, lightHeight);
        this.add(this.A9);
        this.A9.setBounds(390, 100, lightWidth, lightHeight);
        this.add(this.A8);
        this.A8.setBounds(440, 100, lightWidth, lightHeight);
        this.add(this.A7);
        this.A7.setBounds(470, 100, lightWidth, lightHeight);
        this.add(this.A6);
        this.A6.setBounds(500, 100, lightWidth, lightHeight);
        this.add(this.A5);
        this.A5.setBounds(550, 100, lightWidth, lightHeight);
        this.add(this.A4);
        this.A4.setBounds(580, 100, lightWidth, lightHeight);
        this.add(this.A3);
        this.A3.setBounds(610, 100, lightWidth, lightHeight);
        this.add(this.A2);
        this.A2.setBounds(660, 100, lightWidth, lightHeight);
        this.add(this.A1);
        this.A1.setBounds(690, 100, lightWidth, lightHeight);
        this.add(this.A0);
        this.A0.setBounds(720, 100, lightWidth, lightHeight);

        this.add(this.S15);
        this.S15.setBounds(170, 150, switchWidth, switchHeight);
        this.add(this.S14);
        this.S14.setBounds(220, 150, switchWidth, switchHeight);
        this.add(this.S13);
        this.S13.setBounds(250, 150, switchWidth, switchHeight);
        this.add(this.S12);
        this.S12.setBounds(280, 150, switchWidth, switchHeight);
        this.add(this.S11);
        this.S11.setBounds(330, 150, switchWidth, switchHeight);
        this.add(this.S10);
        this.S10.setBounds(360, 150, switchWidth, switchHeight);
        this.add(this.S9);
        this.S9.setBounds(390, 150, switchWidth, switchHeight);
        this.add(this.S8);
        this.S8.setBounds(440, 150, switchWidth, switchHeight);
        this.add(this.S7);
        this.S7.setBounds(470, 150, switchWidth, switchHeight);
        this.add(this.S6);
        this.S6.setBounds(500, 150, switchWidth, switchHeight);
        this.add(this.S5);
        this.S5.setBounds(550, 150, switchWidth, switchHeight);
        this.add(this.S4);
        this.S4.setBounds(580, 150, switchWidth, switchHeight);
        this.add(this.S3);
        this.S3.setBounds(610, 150, switchWidth, switchHeight);
        this.add(this.S2);
        this.S2.setBounds(660, 150, switchWidth, switchHeight);
        this.add(this.S1);
        this.S1.setBounds(690, 150, switchWidth, switchHeight);
        this.add(this.S0);
        this.S0.setBounds(720, 150, switchWidth, switchHeight);

        this.add(this.TotalSwitch);
        this.TotalSwitch.setBounds(50, 220, switchWidth, switchHeight);
        this.add(this.RunSwitch);
        this.RunSwitch.setBounds(170, 220, switchWidth, switchHeight);
        this.add(this.SingleStepSwitch);
        this.SingleStepSwitch.setBounds(240, 220, switchWidth, switchHeight);
        this.add(this.ExamineSwitch);
        this.ExamineSwitch.setBounds(310, 220, switchWidth, switchHeight);
        this.add(this.DepositSwitch);
        this.DepositSwitch.setBounds(370, 220, switchWidth, switchHeight);
        this.add(this.ResetSwitch);
        this.ResetSwitch.setBounds(440, 220, switchWidth, switchHeight);
        this.add(this.ProtectSwitch);
        this.ProtectSwitch.setBounds(510, 220, switchWidth, switchHeight);
        this.add(this.AUXSwitch1);
        this.AUXSwitch1.setBounds(580, 220, switchWidth, switchHeight);
        this.add(this.AUXSwitch2);
        this.AUXSwitch2.setBounds(650, 220, switchWidth, switchHeight);
    }

    public void reset() {
        Component[] ls = this.getComponents();
        for (Component c : ls) {
            if (c.getClass().getName().equals("com.st.Light")) {
                ((Light) c).switchLight(false);
            }
        }
    }

    public void tableTennis() {
        System.out.println("run tennis");
        this.reset();
        this.nowStatus = 13; // 开始运行
        this.leftMissCount = 0;
        this.rightMissCount = 0;
        this.MEMR.switchLight(true);
        this.MI.switchLight(true);
        this.WO.switchLight(true);
        this.D7.switchLight(true);
        this.D6.switchLight(true);
        this.D5.switchLight(true);
        this.D4.switchLight(true);
        this.D3.switchLight(true);
        this.D2.switchLight(true);
        this.D1.switchLight(true);
        this.D0.switchLight(true);
        this.A4.switchLight(true);
        this.A3.switchLight(true);
        this.A2.switchLight(true);
        this.A1.switchLight(true);
        this.A0.switchLight(true);
        this.timer.start();
    }

    public void stopTennis() {
        System.out.println("rightMiss：" + rightMissCount + "leftMiss: " + leftMissCount);
        this.timer.stop();
        this.nowStatus = 14;
        this.reset();
        this.MEMR.switchLight(true);
        this.MI.switchLight(true);
        this.WO.switchLight(true);
        this.D4.switchLight(true);
        this.D3.switchLight(true);
        this.D1.switchLight(true);
        this.WAIT.switchLight(true);
        this.A3.switchLight(true);
        this.A4.switchLight(true);
    }

    public void showMissCount(boolean isLeft) {
        this.reset();
        this.MEMR.switchLight(true);
        this.MI.switchLight(true);
        this.WO.switchLight(true);
        this.WAIT.switchLight(true);
        this.A7.switchLight(true);
        int score;
        if (isLeft) {
            score = this.leftMissCount;
        } else {
            this.A0.switchLight(true);
            score = this.rightMissCount;
        }
        D0.switchLight((score & 1) != 0);
        D1.switchLight((score & 2) != 0);
        D2.switchLight((score & 4) != 0);
        D3.switchLight((score & 8) != 0);
        D4.switchLight((score & 16) != 0);
        D5.switchLight((score & 32) != 0);
        D6.switchLight((score & 64) != 0);
        D7.switchLight((score & 128) != 0);
    }
}
