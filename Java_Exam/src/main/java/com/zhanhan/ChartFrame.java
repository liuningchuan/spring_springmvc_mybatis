package com.zhanhan;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 统计图表窗口
 *
 * @author xxx
 * @school xxxx学院
 * @number xxxxxx
 * @major 计算机科学技术
 */
public class ChartFrame extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ChartFrame p = new ChartFrame();
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(p);
        frame.setSize(443, 552);
        frame.setLayout(new BorderLayout());

        frame.setVisible(true);
    }

    @Override
    synchronized protected void paintComponent(Graphics g) {

        int x = 20;
        int y = 450;
        int xDistance = 360;
        int yDistance = 380;
        int letterDistance = 12;

        g.drawLine(x, y, x + xDistance, y);
        g.drawLine(x, y, x, y - yDistance);

        g.drawString(String.valueOf(yDistance), x, y - yDistance);
        g.drawString(String.valueOf(0), x, y + letterDistance);

        int j = yDistance;
        for (int i = 33, k = 1; i < xDistance; i = i + xDistance / 10, k++) {

            j = j - yDistance / 10;

            g.drawLine(x + i, y, x + i, y - j);
            g.drawString(String.valueOf(j), x + i, y - j);
            g.drawString(String.valueOf(k), x + i, y + letterDistance);
        }

    }
}