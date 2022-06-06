import com.st.Panel;

import javax.swing.*;

class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel root = new Panel();
        frame.setContentPane(root);
        frame.setBounds(100,100,800,400);
        frame.setVisible(true);
    }
}