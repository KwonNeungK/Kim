import javax.swing.table.*;

import javax.swing.*;

import java.util.*;

 

 

public class JMenuTable extends AbstractTableModel {

  Vector MenuDataSet = new Vector();

  String[] columnHeader

       = new String[] {"음식명","가격","수량","총액"};
 

  public void addRow(String[] row){

    // 테이블에 한줄을 추가한다.

    // 테이블 로우는 {"음식명","가격","수량","총액"} 순으로 구성된다.

    // 배열 row의 length가 모자르거나 하면 row를 추가하지 않고, 그냥 리턴한다.

    // STEP 1. 입력된 데이타가 VALID한지 체크한다.

    if(row.length < 0 || row.length > columnHeader.length) return;

 

    // STEP 2. 데이타 객체에 로우를 추가한다.

    MenuDataSet.add(row);

  }// addRow
  public String getColumnName(int col){ return columnHeader[col];}

  /**

   * implementation 되어야하는 필수 메소드

   */

  public int getColumnCount() {

    // 테이블의 컬럼 수를 리턴한다.

    return columnHeader.length;

  }

  public Object getValueAt(int row, int col) {

    // 테이블의 특정 로우와 컬럼에서의 값을 리턴한다.

    String[] rowData = (String[])MenuDataSet.get(row);

    return rowData[col];

  }// getValueAt

 

  public int getRowCount() {

    // 테이블의 전체 로우 수를 리턴한다.

    return MenuDataSet.size();

  }

}// class StockTableModel



