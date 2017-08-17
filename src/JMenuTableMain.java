import javax.swing.JFrame;

import javax.swing.*;

import javax.swing.table.*;

import java.awt.*;

/**

 * Title:

 * Description:

 * Copyright:    Copyright (c) 2001

 * Company:

 * @author

 * @version 1.0

 */



public class JMenuTableMain extends JFrame {



	public JMenuTableMain() {

		// STEP 1. 윈도우 프레임 초기화

		super("Abstract Table Model Sample");

		setSize(600,200);


		// STEP 2. 테이블 모델 생성
		JMenuTable stm = new JMenuTable();

		// STEP 2-1. 테이블 모델에 데이타 초기화
		for(int i = 0; i<10; i++){
			stm.addRow(
					new String[]{"김치찌개","5000","1","5000"} );
		}


		// STEP 3. 테이블 생성

		JTable table = new JTable(stm);

		JScrollPane scrollPane = new JScrollPane(table);

		getContentPane().add(scrollPane,BorderLayout.CENTER);

	}// Constructor



	public static void main(String args[]){

		JMenuTableMain sample1= new JMenuTableMain();

		sample1.setVisible(true);

	}// main

}// class StockTableSample1



