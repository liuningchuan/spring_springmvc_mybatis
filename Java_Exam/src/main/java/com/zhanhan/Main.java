package com.zhanhan;

import javax.swing.UIManager;

/**
 * 主程序类
 *
 * @author xxx
 * @school xxxx学院
 * @number xxxxxx
 * @major 计算机科学技术
 */
public class Main {
    public static void main(String[] args) {
        try {
            // 将当前窗体外观设置为所在操作系统的外观
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new BooksSalesFrame();
    }
}
