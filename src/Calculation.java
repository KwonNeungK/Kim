import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Calculation extends JFrame{

	Order o;
	Manager manager=new Manager();
	public static int priceNum;
	public static int cashNum;
	public static int result;


	private int i = 0;

	private JLabel total = new JLabel("구매 금액 : ");
	private JTextField price = new JTextField();
	private JLabel received = new JLabel("수령 금액 :");
	private JTextField cash = new JTextField();
	private JLabel balance = new JLabel("잔돈 :");
	private JTextField bill = new JTextField();


	private JButton[] nums = new JButton[10];
	private JButton numClear = new JButton("Clear");
	private JButton numDelete = new JButton("Del");
	private JButton numResult = new JButton("=");

	private JButton calculate = new JButton("계산");
	private JPanel numsPanel = new JPanel(new GridLayout(4,3));



	private JPanel panelCal = new JPanel(new GridBagLayout());// GridBagLayout

	//
	//
	//	private void jTableComp() {
	//
	//	}


	public void compInit() {
		this.setLayout(null);

		String header[]= {"음식","가격", "수량", "총가격"};

		ArrayList<Order> result = manager.getAllData();
		Object[][] contents=new Object[result.size()][4];

		for(int i=0;i<result.size();i++) {
			o=result.get(i);
			contents[i][0]=String.valueOf(o.getMenu());
			contents[i][1]=o.getPrice();
			contents[i][2]=o.getQuantity();
			contents[i][3]=o.getPrice() * o.getQuantity();
		}

		TableModel model = new DefaultTableModel(contents, header) {
			public Class getColumnClass(int header) {
				Class returnValue;
				if ((header >= 0) && (header < getColumnCount())) {
					returnValue = getValueAt(0, header).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};


		JTable table=new JTable(model);
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);

		JScrollPane jScroll=new JScrollPane(table);
		jScroll.setBounds(15, 10, 450, 450);
		this.add(jScroll);


		this.total.setBounds(500, 10, 75, 27);
		this.add(total);
		this.price.setBounds(585, 10, 100, 27);
		this.add(price);
		this.received.setBounds(500, 45, 75, 27);
		this.add(received);
		this.cash.setBounds(585, 45, 100, 27);
		this.add(cash);
		this.balance.setBounds(500, 80, 75, 27);
		this.add(balance);
		this.bill.setBounds(585, 80, 100, 27);
		this.add(bill);

		for (int i = 0; i <10; i++){
			nums[i] = new JButton(""+ i );
		}
		// button 배열로 생성

		JButton[] buttons = new JButton[]{
				nums[7],nums[8],nums[9],nums[4],nums[5],nums[6],nums[1],nums[2],nums[3],numClear,nums[0],numDelete};
		for(JButton tmp: buttons){
			this.numsPanel.add(tmp);
		} // button 추가 시킨거. JButton 배열 생성 후 


		this.add(numsPanel);
		this.numsPanel.setBounds(500,150,200,200);
		this.numResult.setBounds(500,350,200,27);
		this.add(numResult); // 누르면 결과 나오는 거
	}

	public void eventInit(){

		//		price = o.getTotalPrice();

		for(i=0; i<nums.length; i++){
			nums[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String cmd=e.getActionCommand();
					cash.setText(cash.getText()+cmd);
				}
			});
		} 

		numClear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String cmd=e.getActionCommand();
				cash.setText("");
			}
		});

		numResult.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String cmd=e.getActionCommand();
				Calculation.priceNum = Integer.parseInt(price.getText());
				Calculation.cashNum = Integer.parseInt(cash.getText());
				Calculation.result = Calculation.priceNum-Calculation.cashNum;
				bill.setText(String.valueOf(result));
				
				
			}
		});	
		
		
	}



	public Calculation() {
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.compInit();
		this.eventInit();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Calculation();
	}


}
