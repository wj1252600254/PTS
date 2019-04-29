package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JFrame frame;
    private JButton jButton1;
    private JButton jButton2;

    public void init() {
        frame = new JFrame("PTS系统");
        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(2, 1));
        jButton1 = new JButton("查询系统（药剂师、用户均可使用）");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindSystem().show();
            }
        });
        jButton2 = new JButton("数据库管理系统");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DBManagerSystem().manage();
            }
        });
        container.add(jButton1);
        container.add(jButton2);

        Dimension frameSize = frame.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
