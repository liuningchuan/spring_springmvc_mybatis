package com.zhanhan;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * 图书集合类
 *
 * @author xxx
 * @school xxxx学院
 * @number xxxxxx
 * @major 计算机科学技术
 */
public class BookList extends AbstractTableModel {

    /*
     * default serial version ID
     */
    private static final long serialVersionUID = 1L;

    //rowData用来存放行数据、columnNames存放列名
    ArrayList<ArrayList<String>> rowData;
    ArrayList<String> columnNames;

    public BookList() {

        columnNames = new ArrayList<String>();

        columnNames.add("图书编号");
        columnNames.add("名称");
        columnNames.add("库存");

        rowData = new ArrayList<>();
        //rowData可以存放多行

        ArrayList<String> hang1 = new ArrayList<>();
        hang1.add("001");
        hang1.add("Java程序设计");
        hang1.add("80");
        //加入rowData
        rowData.add(hang1);

        ArrayList<String> hang2 = new ArrayList<>();
        hang2.add("002");
        hang2.add("丁丁历险记");
        hang2.add("56");
        //加入rowData
        rowData.add(hang2);

        ArrayList<String> hang3 = new ArrayList<>();
        hang3.add("003");
        hang3.add("围城");
        hang3.add("61");
        //加入rowData
        rowData.add(hang3);

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