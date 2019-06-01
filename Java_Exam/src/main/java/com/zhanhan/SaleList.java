package com.zhanhan;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * 销售列表类
 *
 * @author 赵晗
 * @school 电子信息学院
 * @number 2014301220029
 */
public class SaleList extends AbstractTableModel {

    /*
     * default serial version ID
     */
    private static final long serialVersionUID = 1L;

    //rowData用来存放行数据、columnNames存放列名
    ArrayList<ArrayList<String>> rowData;
    ArrayList<String> columnNames;

    public SaleList() {
        //中间
        columnNames = new ArrayList<String>();
        //设置列名
        columnNames.add("序号");
        columnNames.add("编号");
        columnNames.add("书名");
        columnNames.add("销售员");
        columnNames.add("数量");
        columnNames.add("单价");
        columnNames.add("总价");

        rowData = new ArrayList<>();
        //rowData可以存放多行

        ArrayList<String> hang1 = new ArrayList<>();
        hang1.add("1");
        hang1.add("001");
        hang1.add("Java程序设计");
        hang1.add("张三");
        hang1.add("3");
        hang1.add("34.0");
        hang1.add("102");
        //加入rowData
        rowData.add(hang1);

        ArrayList<String> hang2 = new ArrayList<>();
        hang2.add("2");
        hang2.add("002");
        hang2.add("丁丁历险记");
        hang2.add("张三");
        hang2.add("2");
        hang2.add("28.0");
        hang2.add("56");
        //加入rowData
        rowData.add(hang2);

        ArrayList<String> hang3 = new ArrayList<>();
        hang3.add("3");
        hang3.add("001");
        hang3.add("Java程序设计");
        hang3.add("李四");
        hang3.add("2");
        hang3.add("34.0");
        hang3.add("68.0");
        //加入rowData
        rowData.add(hang3);

        ArrayList<String> hang4 = new ArrayList<>();
        hang4.add("4");
        hang4.add("003");
        hang4.add("围城");
        hang4.add("李四");
        hang4.add("4");
        hang4.add("30.5");
        hang4.add("122.0");
        //加入rowData
        rowData.add(hang4);

    }

    //得到共有多少行
    @Override
    public int getRowCount() {
        return this.rowData.size();
    }

    //得到共有多少列
    @Override
    public int getColumnCount() {
        return this.columnNames.size();
    }

    //得到某行某列的信息
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return ((ArrayList<?>) this.rowData.get(rowIndex)).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return (String) this.columnNames.get(column);
    }
}