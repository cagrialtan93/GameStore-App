import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TryingSomething {
    public TryingSomething() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new BorderLayout());

        DefaultListModel<Integer> defaultListModel = new DefaultListModel<Integer>();
        int[] ofNumbers = new int[30];
        for (int i = 0; i < ofNumbers.length; i++) {
            defaultListModel.addElement(i);
        }

        JList jList = new JList<>(defaultListModel);
        JScrollPane jScrollPane = new JScrollPane(jList);



        panel.add(jScrollPane);
        frame.add(panel);
        frame.setSize(300,300);
        frame.show();
    }
}
