package view;

import service.DrugReadService;
import service.PrescriptionReadService;
import service.ReadServiceFactory;
import service.UserReadService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FindSystem {
    private JFrame frame;
    private JLabel jLabel;
    private JLabel jLabe2;
    private JLabel jLabe3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JList<String> jList1;
    private JList<String> jList2;
    private JTextArea jTextArea;
    private JScrollPane scrollPane;
    private String content;


    public void show(DefaultListModel model1, DefaultListModel model2) {
        frame = new JFrame("查询系统");
        Container container = frame.getContentPane();


        //面板初始化
        jPanel1 = new JPanel();
        jPanel2 = new JPanel(new BorderLayout());
        jPanel3 = new JPanel(new BorderLayout());
        jPanel4 = new JPanel(new BorderLayout());
        jPanel5 = new JPanel(new GridLayout(3, 1));
        //
        jTextArea = new JTextArea("此处显示查询信息！！！");
        scrollPane = new JScrollPane(jTextArea);

        //确定框架
        jPanel1.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));
        container.add(jPanel1, BorderLayout.NORTH);
        jPanel2.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        container.add(jPanel2, BorderLayout.WEST);
        jPanel3.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        container.add(jPanel3, BorderLayout.EAST);
        jPanel4.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        jPanel4.add(jPanel5, BorderLayout.NORTH);
        jPanel4.add(scrollPane, BorderLayout.CENTER);
        container.add(jPanel4, BorderLayout.CENTER);


        //Jpanel.North   1
        jLabel = new JLabel("查询系统", JLabel.CENTER);
        jPanel1.add(jLabel);

        //Jpanel.WEST   2
        jLabe2 = new JLabel("系统已存用户电话", JLabel.CENTER);
        jPanel2.add(jLabe2, BorderLayout.NORTH);
        jList1 = new JList<>(model1);
        jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   //只能单选
        jPanel2.add(jList1);

        //Jpanel.EAST   3
        jLabe3 = new JLabel("系统已存药物", JLabel.CENTER);
        jPanel3.add(jLabe3, BorderLayout.NORTH);
        jList2 = new JList<>(model2);
        jList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jPanel3.add(jList2);

        //Jpanel.CENTER   5
        jButton1 = new JButton("查询用户处方历史");
        jButton2 = new JButton("查询处方是否有效");
        jButton3 = new JButton("查询药物的通用替代药物");
        jPanel5.add(jButton1);
        jPanel5.add(jButton2);
        jPanel5.add(jButton3);


        //给jlist增加监听器
        jList1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int count = e.getClickCount();
                if (count == 2) {
                    content = jList1.getSelectedValue();
                    jTextArea.setText(((UserReadService) ReadServiceFactory.getReadService(UserReadService.class)).displayUser(content));
                }
            }
        });

        jList2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int count = e.getClickCount();
                if (count == 2) {
                    content = jList2.getSelectedValue();
                    jTextArea.setText(((DrugReadService) ReadServiceFactory.getReadService(DrugReadService.class)).dispalyDrug(content));
                }
            }
        });


        //给按钮添加监听器
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog jDialog = new JDialog();
                jDialog.setSize(400, 100);
                Container container1 = jDialog.getContentPane();
                jDialog.setTitle("查询用户处方历史");
                JTextField jTextField = new JTextField();
                jTextField.setText("请输入查询用户的电话号码（鼠标移至此，文字自动消失）");
                jTextField.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        jTextField.setText("");
                    }
                });
                jTextField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jTextField.setText("");
                    }
                });
                JButton jButton = new JButton("查询");
                jButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        content = jTextField.getText().trim();
                        jTextArea.setText(((UserReadService) ReadServiceFactory.getReadService(UserReadService.class)).displayHistory(content));
                    }
                });
                container1.add(jTextField, BorderLayout.NORTH);
                container1.add(jButton);
                jDialog.setVisible(true);
            }
        });
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog jDialog = new JDialog();
                jDialog.setSize(400, 100);
                Container container1 = jDialog.getContentPane();
                jDialog.setTitle("查询药物的通用替代药物");
                JTextField jTextField = new JTextField();
                jTextField.setText("请输入药物名（鼠标移至此，文字自动消失）");
                /*
                当鼠标移至JTextField，清空输入框
                 */
                jTextField.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        jTextField.setText("");
                    }
                });
                JButton jButton = new JButton("查询");
                jButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        content = jTextField.getText().trim();
                        jTextArea.setText(((DrugReadService) ReadServiceFactory.getReadService(DrugReadService.class)).displayAlternatives(content));
                    }
                });
                container1.add(jTextField, BorderLayout.NORTH);
                container1.add(jButton);
                jDialog.setVisible(true);
            }
        });
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog jDialog = new JDialog();
                jDialog.setSize(400, 100);
                Container container1 = jDialog.getContentPane();
                jDialog.setTitle("查询处方是否有效");
                JTextField jTextField = new JTextField();
                jTextField.setText("请输入处方单号（鼠标移至此，文字自动消失）");
                jTextField.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        jTextField.setText("");
                    }
                });
                jTextField.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jTextField.setText("");
                    }
                });
                JButton jButton = new JButton("查询");
                jButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        content = jTextField.getText().trim();
                        jTextArea.setText(((PrescriptionReadService) ReadServiceFactory.getReadService(PrescriptionReadService.class)).displayIsValid(content));
                    }
                });
                container1.add(jTextField, BorderLayout.NORTH);
                container1.add(jButton);
                jDialog.setVisible(true);
            }
        });

        //居中显示
        Dimension frameSize = frame.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

}
