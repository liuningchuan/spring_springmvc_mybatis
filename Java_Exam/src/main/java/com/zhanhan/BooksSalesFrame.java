package com.zhanhan;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * 主窗口类
 *
 * @author xxx
 * @school xxxx学院
 * @number xxxxxx
 * @major 计算机科学技术
 */
public class BooksSalesFrame extends JFrame implements ActionListener {

    /**
     * default serial version ID
     */
    private static final long serialVersionUID = 1L;

    //定义组件
    //JPanel jp1,jp2;
    JLabel jl1, jl2, jl3;
    JButton jb1, jb2, jb3, jb4, jb5;
    JTable jt;
    JScrollPane jsp;
    JTextField jtf1, jtf2, jtf3;

    SaleList sl;

    public BooksSalesFrame() {

        //将布局设置为空布局
        this.setLayout(null);

        jb1 = new JButton("显示库存");
        jb1.setBounds(50, 30, 120, 30);
        jb1.setFont(new Font("微软雅黑", 1, 16));
        jb1.addActionListener(this);

        jb2 = new JButton("销售图");
        jb2.setBounds(250, 30, 120, 30);
        jb2.setFont(new Font("微软雅黑", 1, 16));
        jb2.addActionListener(this);

        jb3 = new JButton("保存并退出");
        jb3.setBounds(500, 30, 120, 30);
        jb3.setFont(new Font("微软雅黑", 1, 16));
        jb3.addActionListener(this);

        this.add(jb1);
        this.add(jb2);
        this.add(jb3);

        jb4 = new JButton("提交");
        jb4.setBounds(100, 350, 120, 30);
        jb4.setFont(new Font("微软雅黑", 1, 16));
        jb4.addActionListener(this);

        jb5 = new JButton("清除");
        jb5.setBounds(100, 400, 120, 30);
        jb5.setFont(new Font("微软雅黑", 1, 16));
        jb5.addActionListener(this);

        this.add(jb4);
        this.add(jb5);

        jl1 = new JLabel("数量");
        jl1.setBounds(400, 330, 120, 30);
        jl1.setFont(new Font("微软雅黑", 1, 16));
        jtf1 = new JTextField(10);
        jtf1.setBounds(500, 330, 120, 20);

        jl2 = new JLabel("图书编号");
        jl2.setBounds(400, 370, 120, 30);
        jl2.setFont(new Font("微软雅黑", 1, 16));
        jtf2 = new JTextField(10);
        jtf2.setBounds(500, 370, 120, 20);

        jl3 = new JLabel("销售员");
        jl3.setBounds(400, 410, 120, 30);
        jl3.setFont(new Font("微软雅黑", 1, 16));
        jtf3 = new JTextField(10);
        jtf3.setBounds(500, 410, 120, 20);

        this.add(jl1);
        this.add(jtf1);
        this.add(jl2);
        this.add(jtf2);
        this.add(jl3);
        this.add(jtf3);

        //创建一个数据模型对象
        sl = new SaleList();

        //初始化JTable
        jt = new JTable(sl);
        jt.setFont(new Font("新宋体", 1, 16));

        //初始化jsp JScrollPane
        jsp = new JScrollPane(jt);
        jsp.setBounds(0, 100, 800, 200);

        //把jsp放入到jframe
        this.add(jsp);

        this.setSize(800, 500);
        this.setTitle("图书销售");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int windowWidth = this.getWidth(); //获得窗口宽
        int windowHeight = this.getHeight(); //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);//设置窗口居中显示

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            //打开一个新窗口
            //查看图书列表
            new BookFrame();
        } else if (e.getSource() == jb2) {
            JFrame frame = new JFrame();
            ChartFrame p = new ChartFrame();
            frame.setContentPane(p);
            frame.setSize(400, 500);
            frame.setLayout(new BorderLayout());

            frame.setVisible(true);
        } else if (e.getSource() == jb3) {
            this.dispose();
        } else if (e.getSource() == jb4) {

        } else if (e.getSource() == jb5) {

        }
    }
}
