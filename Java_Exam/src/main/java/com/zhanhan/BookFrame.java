package com.zhanhan;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * 库存图表窗口
 *
 * @author xxx
 * @school xxxx学院
 * @number xxxxxx
 * @major 计算机科学技术
 */
public class BookFrame extends JFrame implements ActionListener {
    /**
     * default serial version ID
     */
    private static final long serialVersionUID = 1L;

    JButton jb1, jb2;
    JTable jt;
    JScrollPane jsp;
    BookList bl;

    public BookFrame() {

        this.setLayout(null);

        //创建一个数据模型对象
        bl = new BookList();

        //初始化JTable
        jt = new JTable(bl);
        jt.setFont(new Font("新宋体", 1, 16));

        //初始化jsp JScrollPane
        jsp = new JScrollPane(jt);
        jsp.setBounds(0, 0, 350, 150);
        this.add(jsp);

        jb1 = new JButton("确定");
        jb1.setBounds(50, 150, 80, 30);
        jb1.setFont(new Font("微软雅黑", 1, 16));
        jb1.addActionListener(this);

        jb2 = new JButton("退出");
        jb2.setBounds(200, 150, 80, 30);
        jb2.setFont(new Font("微软雅黑", 1, 16));
        jb2.addActionListener(this);

        this.add(jb1);
        this.add(jb2);

        this.setSize(350, 220);

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
            //关闭对话框
            this.dispose();
        } else if (e.getSource() == jb2) {
            this.dispose();
        }
    }
}
