import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RandomScraps {
	private String columnNames[] = {
			"����", "����", "����" 
	};
	
	private Object rowData[][] = { 
			{
			} 
	};
	
	private DefaultTableModel defaultTableModel = new DefaultTableModel(rowData, columnNames);
	private JTable jTable = new JTable(defaultTableModel);
	private JScrollPane jScroll = new JScrollPane(jTable);
}
