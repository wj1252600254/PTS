package view;

import javax.swing.*;
import java.awt.*;

public class DBManagerSystem {
    private JFrame frame;
    private JLabel jLabel;

    public void manage() {
        frame = new JFrame("Manager");
        Container container = frame.getContentPane();
        jLabel = new JLabel("尚在开发中");
        container.add(jLabel);
        Dimension frameSize = frame.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
