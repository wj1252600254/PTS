package view;


import service.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DBManagerSystem {
    private JFrame frame;
    private JLabel jLabel;
    private JLabel jLabe2;
    private JLabel jLabe3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JList<String> jList1;
    private JList<String> jList2;
    private String content;

    public void show(DefaultListModel model1, DefaultListModel model2) {
        frame = new JFrame("数据库管理系统");
        Container container = frame.getContentPane();


        //面板初始化
        jPanel1 = new JPanel();
        jPanel2 = new JPanel(new BorderLayout());
        jPanel3 = new JPanel(new BorderLayout());
        jPanel4 = new JPanel(new GridLayout(4, 1));


        //确定框架
        jPanel1.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 3));
        container.add(jPanel1, BorderLayout.NORTH);
        jPanel2.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        container.add(jPanel2, BorderLayout.WEST);
        jPanel3.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        container.add(jPanel3, BorderLayout.EAST);
        jPanel4.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
        container.add(jPanel4, BorderLayout.CENTER);


        //Jpanel.North   1
        jLabel = new JLabel("数据库管理系统", JLabel.CENTER);
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
        jButton1 = new JButton("用户管理");
        jButton4 = new JButton("药剂师管理");
        jButton2 = new JButton("处方管理");
        jButton3 = new JButton("药物管理");
        jPanel4.add(jButton1);
        jPanel4.add(jButton4);
        jPanel4.add(jButton2);
        jPanel4.add(jButton3);


        //给jlist增加监听器
        jList1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int count = e.getClickCount();
                if (count == 2) {
                    JDialog jDialog = new JDialog();
                    jDialog.setSize(400, 600);
                    Container container1 = jDialog.getContentPane();
                    jDialog.setTitle("用户信息");
                    JTextArea jTextArea = new JTextArea();
                    JScrollPane jScrollPane = new JScrollPane(jTextArea);
                    container1.add(jScrollPane);
                    content = jList1.getSelectedValue();
                    jTextArea.setText(((UserReadService) ReadServiceFactory.getReadService(UserReadService.class)).displayUser(content));
                    jDialog.setVisible(true);
                }
            }
        });

        jList2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int count = e.getClickCount();
                if (count == 2) {
                    JDialog jDialog = new JDialog();
                    jDialog.setSize(400, 600);
                    Container container1 = jDialog.getContentPane();
                    jDialog.setTitle("药物信息");
                    JTextArea jTextArea = new JTextArea();
                    JScrollPane jScrollPane = new JScrollPane(jTextArea);
                    container1.add(jScrollPane);
                    content = jList2.getSelectedValue();
                    jTextArea.setText(((DrugReadService) ReadServiceFactory.getReadService(DrugReadService.class)).dispalyDrug(content));
                    jDialog.setVisible(true);
                }
            }
        });

        //用户管理
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog jDialog = new JDialog();
                jDialog.setTitle("用户管理");
                Container container1 = jDialog.getContentPane();
                jDialog.setSize(400, 400);
                JPanel jPanelUp = new JPanel();
                jPanelUp.setBorder(BorderFactory.createTitledBorder("增加用户"));
                JPanel jPanelDown = new JPanel();
                jPanelDown.setBorder(BorderFactory.createTitledBorder("删除用户"));
                jPanelUp.setLayout(new GridLayout(6, 1));
                //添加用户功能
                JPanel j1 = new JPanel();
                JLabel jl1 = new JLabel("姓名：");
                JTextField jt1 = new JTextField();
                jt1.setPreferredSize(new Dimension(300, 30));
                j1.add(jl1);
                j1.add(jt1);
                jPanelUp.add(j1);
                JPanel j2 = new JPanel();
                JLabel jl2 = new JLabel("电话：");
                JTextField jt2 = new JTextField();
                jt2.setPreferredSize(new Dimension(300, 30));
                j2.add(jl2);
                j2.add(jt2);
                jPanelUp.add(j2);
                JPanel j3 = new JPanel();
                JLabel jl3 = new JLabel("生日：");
                JTextField jt3 = new JTextField("yyyy-MM-dd");
                jt3.setPreferredSize(new Dimension(250, 30));
                j3.add(jl3);
                j3.add(jt3);
                jPanelUp.add(j3);
                JPanel j4 = new JPanel();
                JLabel jl4 = new JLabel("保险公司：");
                JTextField jt4 = new JTextField();
                jt4.setPreferredSize(new Dimension(250, 30));
                j4.add(jl4);
                j4.add(jt4);
                jPanelUp.add(j4);
                JPanel j7 = new JPanel();
                JLabel jl7 = new JLabel("保险单号：");
                JTextField jt7 = new JTextField();
                jt7.setPreferredSize(new Dimension(250, 30));
                j7.add(jl7);
                j7.add(jt7);
                jPanelUp.add(j7);
                JButton jb1 = new JButton("添加");
                jPanelUp.add(jb1);
                container1.add(jPanelUp);
                //删除功能
                JPanel j6 = new JPanel();
                JTextField jt6 = new JTextField("用户电话");
                jt6.setPreferredSize(new Dimension(300, 30));
                JButton jb2 = new JButton("删除");
                j6.add(jt6);
                j6.add(jb2);
                jPanelDown.add(j6);
                container1.add(jPanelDown, BorderLayout.SOUTH);
                //添加事件
                jb1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int isSuccess = ((UserWriteService) WriteServiceFactory.getWriteService(UserWriteService.class)).insertUser(jt2.getText().trim(), jt1.getText().trim(),
                                jt3.getText().trim(), jt4.getText().trim(), jt7.getText().trim());
                        JOptionPane.showMessageDialog(jDialog, isSuccess > 0 ? "添加成功！" : "添加失败");
                        if (isSuccess > 0) {
                            model1.addElement(jt2.getText().trim());
                        }
                    }
                });
                jb2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int isSuccess = ((UserWriteService) WriteServiceFactory.getWriteService(UserWriteService.class)).deleteUser(jt6.getText().trim());
                        JOptionPane.showMessageDialog(jDialog, isSuccess > 0 ? "删除成功！" : "删除失败");
                        if (isSuccess > 0) {
                            model1.removeElement(jt6.getText().trim());
                        }
                    }
                });
                jDialog.setVisible(true);
            }
        });

        //处方管理功能
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog jDialog = new JDialog();
                jDialog.setTitle("处方管理");
                Container container1 = jDialog.getContentPane();
                jDialog.setSize(400, 500);
                JPanel jPanelUp = new JPanel();
                jPanelUp.setBorder(BorderFactory.createTitledBorder("增加处方"));
                JPanel jPanelDown = new JPanel();
                jPanelDown.setBorder(BorderFactory.createTitledBorder("删除处方"));
                jPanelUp.setLayout(new GridLayout(9, 1));
                //添加用户功能
                JPanel j1 = new JPanel();
                JLabel jl1 = new JLabel("处方单号：");
                JTextField jt1 = new JTextField();
                jt1.setPreferredSize(new Dimension(250, 30));
                j1.add(jl1);
                j1.add(jt1);
                jPanelUp.add(j1);
                JPanel j2 = new JPanel();
                JLabel jl2 = new JLabel("用户电话：");
                JTextField jt2 = new JTextField();
                jt2.setPreferredSize(new Dimension(250, 30));
                j2.add(jl2);
                j2.add(jt2);
                jPanelUp.add(j2);
                JPanel j3 = new JPanel();
                JLabel jl3 = new JLabel("药师电话：");
                JTextField jt3 = new JTextField();
                jt3.setPreferredSize(new Dimension(250, 30));
                j3.add(jl3);
                j3.add(jt3);
                jPanelUp.add(j3);
                JPanel j4 = new JPanel();
                JLabel jl4 = new JLabel("开单日期：");
                JTextField jt4 = new JTextField("yyyy-MM-dd");
                jt4.setPreferredSize(new Dimension(250, 30));
                j4.add(jl4);
                j4.add(jt4);
                jPanelUp.add(j4);
                JPanel j5 = new JPanel();
                JLabel jl5 = new JLabel("失效日期：");
                JTextField jt5 = new JTextField("yyyy-MM-dd");
                jt5.setPreferredSize(new Dimension(250, 30));
                j5.add(jl5);
                j5.add(jt5);
                jPanelUp.add(j5);
                JPanel j6 = new JPanel();
                JLabel jl6 = new JLabel("给药次数：");
                JTextField jt6 = new JTextField();
                jt6.setPreferredSize(new Dimension(250, 30));
                j6.add(jl6);
                j6.add(jt6);
                jPanelUp.add(j6);

                JButton jb3 = new JButton("加药");
                jPanelUp.add(jb3);
                container1.add(jPanelUp);

                JButton jb4 = new JButton("减药");
                jPanelUp.add(jb4);
                container1.add(jPanelUp);

                JButton jb1 = new JButton("添加");
                jPanelUp.add(jb1);
                container1.add(jPanelUp);
                //删除功能
                JPanel j9 = new JPanel();
                JTextField jt9 = new JTextField("处方单号");
                jt9.setPreferredSize(new Dimension(250, 30));
                JButton jb2 = new JButton("删除");
                j9.add(jt9);
                j9.add(jb2);
                jPanelDown.add(j9);
                container1.add(jPanelDown, BorderLayout.SOUTH);

                //添加事件
                jb1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int isSuccess = ((PrescriptionWriteService) WriteServiceFactory.getWriteService(PrescriptionWriteService.class)).insertPrescription(jt1.getText().trim(), jt2.getText().trim(),
                                jt3.getText().trim(), jt4.getText().trim(), jt5.getText().trim(), Integer.valueOf(jt6.getText().trim()));
                        JOptionPane.showMessageDialog(jDialog, isSuccess > 0 ? "添加成功！" : "添加失败");
                    }
                });
                jb2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int isSuccess = ((PrescriptionWriteService) WriteServiceFactory.getWriteService(PrescriptionWriteService.class)).deletePrescription(jt9.getText().trim());
                        JOptionPane.showMessageDialog(jDialog, isSuccess > 0 ? "删除成功！" : "删除失败");
                    }
                });

                //给加药，减药添加事件
                jb3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JDialog jDialog = new JDialog();
                        jDialog.setTitle("添加药物");
                        Container container1 = jDialog.getContentPane();
                        jDialog.setSize(400, 300);
                        JPanel jPanelUp1 = new JPanel();
                        jPanelUp1.setLayout(new GridLayout(4, 1));
                        JPanel j1 = new JPanel();
                        JLabel jl1 = new JLabel("处方单号：");
                        JTextField jt1 = new JTextField();
                        jt1.setPreferredSize(new Dimension(250, 30));
                        j1.add(jl1);
                        j1.add(jt1);
                        jPanelUp1.add(j1);
                        JPanel j11 = new JPanel();
                        JLabel jl11 = new JLabel("药物名字：");
                        JTextField jt11 = new JTextField();
                        jt11.setPreferredSize(new Dimension(250, 30));
                        j11.add(jl11);
                        j11.add(jt11);
                        jPanelUp1.add(j11);
                        JPanel j21 = new JPanel();
                        JLabel jl21 = new JLabel("用药量：");
                        JTextField jt21 = new JTextField();
                        jt21.setPreferredSize(new Dimension(250, 30));
                        j21.add(jl21);
                        j21.add(jt21);
                        jPanelUp1.add(j21);
                        JButton jb11 = new JButton("确定");
                        jPanelUp1.add(jb11);
                        jb11.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int isSuccess = ((PrescriptionEntryWriteService) WriteServiceFactory.getWriteService(PrescriptionEntryWriteService.class)).insertPrescriptionEntry(jt1.getText(), jt21.getText(), jt11.getText());
                                JOptionPane.showMessageDialog(jDialog, isSuccess > 0 ? "添加成功！" : "添加失败");
                            }
                        });
                        container1.add(jPanelUp1);
                        jDialog.setVisible(true);
                    }
                });
                jb4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JDialog jDialog = new JDialog();
                        jDialog.setTitle("删除药物");
                        Container container1 = jDialog.getContentPane();
                        jDialog.setSize(400, 300);
                        JPanel jPanelUp1 = new JPanel();
                        jPanelUp1.setLayout(new GridLayout(3, 1));
                        JPanel j1 = new JPanel();
                        JLabel jl1 = new JLabel("处方单号");
                        JTextField jt1 = new JTextField();
                        jt1.setPreferredSize(new Dimension(250, 30));
                        j1.add(jl1);
                        j1.add(jt1);
                        jPanelUp1.add(j1);
                        JPanel j11 = new JPanel();
                        JLabel jl11 = new JLabel("药物名字");
                        JTextField jt11 = new JTextField();
                        jt11.setPreferredSize(new Dimension(250, 30));
                        j11.add(jl11);
                        j11.add(jt11);
                        jPanelUp1.add(j11);
                        JButton jb11 = new JButton("确定");
                        jPanelUp1.add(jb11);
                        jb11.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int isSuccess = ((PrescriptionEntryWriteService) WriteServiceFactory.getWriteService(PrescriptionEntryWriteService.class)).deletePrescriptionEntry(jt1.getText(), jt11.getText());
                                JOptionPane.showMessageDialog(jDialog, isSuccess > 0 ? "删除成功！" : "删除失败");
                            }
                        });
                        container1.add(jPanelUp1);
                        jDialog.setVisible(true);
                    }
                });
                jDialog.setVisible(true);
            }
        });

        //药物管理功能
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog jDialog = new JDialog();
                jDialog.setTitle("药物管理");
                Container container1 = jDialog.getContentPane();
                jDialog.setSize(400, 350);
                JPanel jPanelUp = new JPanel();
                jPanelUp.setBorder(BorderFactory.createTitledBorder("增加药物"));
                JPanel jPanelDown = new JPanel();
                jPanelDown.setBorder(BorderFactory.createTitledBorder("删除药物"));
                jPanelUp.setLayout(new GridLayout(5, 1));
                //添加药物功能
                JPanel j1 = new JPanel();
                JLabel jl1 = new JLabel("药名：");
                JTextField jt1 = new JTextField();
                jt1.setPreferredSize(new Dimension(300, 30));
                j1.add(jl1);
                j1.add(jt1);
                jPanelUp.add(j1);
                JPanel j2 = new JPanel();
                JLabel jl2 = new JLabel("用药单位：");
                JTextField jt2 = new JTextField();
                jt2.setPreferredSize(new Dimension(250, 30));
                j2.add(jl2);
                j2.add(jt2);
                jPanelUp.add(j2);
                JPanel j3 = new JPanel();
                JLabel jl3 = new JLabel("替代药物：");
                JTextField jt3 = new JTextField("有多种替代药物，请用半角逗号隔开");
                jt3.setPreferredSize(new Dimension(250, 30));
                j3.add(jl3);
                j3.add(jt3);
                jPanelUp.add(j3);
                JPanel j4 = new JPanel();
                JLabel jl4 = new JLabel("副作用：");
                JTextField jt4 = new JTextField();
                jt4.setPreferredSize(new Dimension(250, 30));
                j4.add(jl4);
                j4.add(jt4);
                jPanelUp.add(j4);
                JButton jb1 = new JButton("添加");
                jPanelUp.add(jb1);
                container1.add(jPanelUp);
                //删除功能
                JPanel j6 = new JPanel();
                JTextField jt6 = new JTextField("药物名称");
                jt6.setPreferredSize(new Dimension(300, 30));
                JButton jb2 = new JButton("删除");
                j6.add(jt6);
                j6.add(jb2);
                jPanelDown.add(j6);
                container1.add(jPanelDown, BorderLayout.SOUTH);
                //添加事件
                jb1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int isSuccess = ((DrugWriteService) WriteServiceFactory.getWriteService(DrugWriteService.class)).insertDrug(jt1.getText().trim(), jt2.getText().trim(),
                                jt3.getText().trim(), jt4.getText().trim());
                        JOptionPane.showMessageDialog(jDialog, isSuccess > 0 ? "添加成功！" : "添加失败");
                        if (isSuccess > 0) {
                            model2.addElement(jt1.getText().trim());
                        }
                    }
                });
                jb2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int isSuccess = ((DrugWriteService) WriteServiceFactory.getWriteService(DrugWriteService.class)).deleteDrug(jt6.getText().trim());
                        JOptionPane.showMessageDialog(jDialog, isSuccess > 0 ? "删除成功！" : "删除失败");
                        if (isSuccess > 0) {
                            model2.removeElement(jt6.getText().trim());
                        }
                    }
                });
                jDialog.setVisible(true);
            }
        });

        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog jDialog = new JDialog();
                jDialog.setTitle("药师管理");
                Container container1 = jDialog.getContentPane();
                jDialog.setSize(400, 300);
                JPanel jPanelUp = new JPanel();
                jPanelUp.setBorder(BorderFactory.createTitledBorder("增加药师"));
                JPanel jPanelDown = new JPanel();
                jPanelDown.setBorder(BorderFactory.createTitledBorder("删除药师"));
                jPanelUp.setLayout(new GridLayout(3, 1));
                //添加药物功能
                JPanel j1 = new JPanel();
                JLabel jl1 = new JLabel("电话：");
                JTextField jt1 = new JTextField();
                jt1.setPreferredSize(new Dimension(300, 30));
                j1.add(jl1);
                j1.add(jt1);
                jPanelUp.add(j1);
                JPanel j2 = new JPanel();
                JLabel jl2 = new JLabel("姓名：");
                JTextField jt2 = new JTextField();
                jt2.setPreferredSize(new Dimension(250, 30));
                j2.add(jl2);
                j2.add(jt2);
                jPanelUp.add(j2);
                JButton jb1 = new JButton("添加");
                jPanelUp.add(jb1);
                container1.add(jPanelUp);
                //删除功能
                JPanel j6 = new JPanel();
                JTextField jt6 = new JTextField("药师电话");
                jt6.setPreferredSize(new Dimension(250, 30));
                JButton jb2 = new JButton("删除");
                j6.add(jt6);
                j6.add(jb2);
                jPanelDown.add(j6);
                container1.add(jPanelDown, BorderLayout.SOUTH);
                //添加事件
                jb1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int isSuccess = ((PharmacistWriteService) WriteServiceFactory.getWriteService(PharmacistWriteService.class)).insertPharmacist(jt1.getText().trim(), jt2.getText().trim());
                        JOptionPane.showMessageDialog(jDialog, isSuccess > 0 ? "添加成功！" : "添加失败");
                    }
                });
                jb2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int isSuccess = ((PharmacistWriteService) WriteServiceFactory.getWriteService(PharmacistWriteService.class)).deletePharmacist(jt6.getText().trim());
                        JOptionPane.showMessageDialog(jDialog, isSuccess > 0 ? "删除成功！" : "删除失败");
                    }
                });
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
