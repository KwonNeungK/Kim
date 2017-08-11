import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Calculation extends JFrame{

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

	private String columnNames[] = {
			"음식", "가격", "수량" 
	};
	private Object rowData[][] = { 
			{"김치찌개", "5000", "1"
			} 
	};
	private DefaultTableModel defaultTableModel = new DefaultTableModel(rowData, columnNames);
	private JTable jTable = new JTable(defaultTableModel);
	private JScrollPane jScroll = new JScrollPane(jTable);

	private JPanel panelCal = new JPanel(new GridBagLayout());// GridBagLayout틀

	public void compInit() {
		this.setLayout(null);
		
		this.jScroll.setBounds(15, 10, 450, 450);
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
		this.numsPanel.add(nums[7]);
		this.numsPanel.add(nums[8]);
		this.numsPanel.add(nums[9]);
		this.numsPanel.add(nums[4]);
		this.numsPanel.add(nums[5]);
		this.numsPanel.add(nums[6]);
		this.numsPanel.add(nums[1]);
		this.numsPanel.add(nums[2]);
		this.numsPanel.add(nums[3]);
		this.numsPanel.add(numClear);
		this.numsPanel.add(nums[0]);
		this.numsPanel.add(numDelete);
		this.add(numsPanel);
		this.numsPanel.setBounds(500,150,200,200);
	
		
	}


	public Calculation() {
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.compInit();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Calculation();
	}


}
