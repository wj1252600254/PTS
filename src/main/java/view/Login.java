package view;

import domain.Drug;
import domain.User;
import service.DrugReadService;
import service.ReadServiceFactory;
import service.UserReadService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Login {
    private JFrame frame;
    private JButton jButton1;
    private JButton jButton2;

    private DefaultListModel<String> model1;
    private DefaultListModel<String> model2;

    public void init() {
        model1 = new DefaultListModel<>();
        ArrayList<User> arrayList = ((UserReadService) ReadServiceFactory.getReadService(UserReadService.class)).queryAll();
        for (Object t : arrayList) {
            model1.addElement(((User) t).getPhoneNumber());
        }
        model2 = new DefaultListModel<>();
        ArrayList<Drug> arrayList2 = ((DrugReadService) ReadServiceFactory.getReadService(DrugReadService.class)).queryAll();
        for (Object t : arrayList2) {
            model2.addElement(((Drug) t).getName());
        }
        frame = new JFrame("PTS系统");
        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(2, 1));
        jButton1 = new JButton("查询系统");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindSystem().show(model1, model2);
            }
        });
        jButton2 = new JButton("数据库管理系统");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DBManagerSystem().show(model1, model2);
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
