import javax.swing.table.*;

import javax.swing.*;

import java.util.*;

 

 

public class JMenuTable extends AbstractTableModel {

  Vector MenuDataSet = new Vector();

  String[] columnHeader

       = new String[] {"���ĸ�","����","����","�Ѿ�"};
 

  public void addRow(String[] row){

    // ���̺� ������ �߰��Ѵ�.

    // ���̺� �ο�� {"���ĸ�","����","����","�Ѿ�"} ������ �����ȴ�.

    // �迭 row�� length�� ���ڸ��ų� �ϸ� row�� �߰����� �ʰ�, �׳� �����Ѵ�.

    // STEP 1. �Էµ� ����Ÿ�� VALID���� üũ�Ѵ�.

    if(row.length < 0 || row.length > columnHeader.length) return;

 

    // STEP 2. ����Ÿ ��ü�� �ο츦 �߰��Ѵ�.

    MenuDataSet.add(row);

  }// addRow
  public String getColumnName(int col){ return columnHeader[col];}

  /**

   * implementation �Ǿ���ϴ� �ʼ� �޼ҵ�

   */

  public int getColumnCount() {

    // ���̺��� �÷� ���� �����Ѵ�.

    return columnHeader.length;

  }

  public Object getValueAt(int row, int col) {

    // ���̺��� Ư�� �ο�� �÷������� ���� �����Ѵ�.

    String[] rowData = (String[])MenuDataSet.get(row);

    return rowData[col];

  }// getValueAt

 

  public int getRowCount() {

    // ���̺��� ��ü �ο� ���� �����Ѵ�.

    return MenuDataSet.size();

  }

}// class StockTableModel



