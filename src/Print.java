import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Print extends JDialog{
	Manager manager=new Manager();
	private JLabel id=new JLabel();
	private JLabel name=new JLabel();
	private JButton button=new JButton("확인");
	private JPanel panel=new JPanel();
	private Order o;
	
	
	private void jTableComp() {
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
//		jScroll.setBounds(15, 10, 450, 450);
		this.add(jScroll);

	}
	public Print(Main parent) {
		this.setTitle("Print");
		this.setSize(400,300);
		this.setLocationRelativeTo(parent);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.jTableComp();
		this.setModal(true);
	}
}
