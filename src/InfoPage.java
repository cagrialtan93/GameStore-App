import javax.swing.*;
import java.awt.*;

public class InfoPage {
    public InfoPage() {
        JFrame frame = new JFrame("JFrame Example");

        JLabel label1 = new JLabel("Label 1");
        JLabel label2 = new JLabel("Label 2");
        JLabel label3 = new JLabel("Label 3");

        JTextField textField1 = new JTextField(10);
        JTextField textField2 = new JTextField(10);
        JTextField textField3 = new JTextField(10);

        frame.setLayout(new FlowLayout());

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
