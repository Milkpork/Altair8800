package com.st;

import javax.swing.*;
import java.awt.*;

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

    Switch TotalSwitch = new Switch(" OFF", "  ON");
    Switch RunSwitch = new Switch("STOP", " RUN");
    Switch SingleStepSwitch = new Switch("SINGLE");
    Switch ExamineSwitch = new Switch("EXAMINE", "NEXT");
    Switch DepositSwitch = new Switch("DEPO", "NEXT");
    Switch ResetSwitch = new Switch("RESET", " CLR");
    Switch ProtectSwitch = new Switch("PROTECT", "UNPROTECT");
    Switch AUXSwitch1 = new Switch(" AUX");
    Switch AUXSwitch2 = new Switch(" AUX");

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel root = new Panel();
        frame.setContentPane(root);
        frame.setVisible(true);
    }

    public Panel() {
        this.setLayout(null);
        this.setMinimumSize(new Dimension(1260, 500));
        this.myLayouts();
    }

    public void myLayouts() {
        int lightWidth = 20;
        int lightHeight = 50;
        int switchWidth = 20;
        int switchHeight = 70;
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
        this.ExamineSwitch.setBounds(310, 220, switchWidth,switchHeight);
        this.add(this.DepositSwitch);
        this.DepositSwitch.setBounds(370,220,switchWidth, switchHeight);
        this.add(this.ResetSwitch);
        this.ResetSwitch.setBounds(440, 220, switchWidth, switchHeight);
        this.add(this.ProtectSwitch);
        this.ProtectSwitch.setBounds(510,220,switchWidth, switchHeight);
        this.add(this.AUXSwitch1);
        this.AUXSwitch1.setBounds(580,220,switchWidth, switchHeight);
        this.add(this.AUXSwitch2);
        this.AUXSwitch2.setBounds(650,220,switchWidth, switchHeight);
    }

}
