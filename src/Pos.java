import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Pos
{
	JFrame jFrame = new JFrame("JTable ����");

	String food[] = new String[10];
	String columnNames[] =
	{ "��ǰ��ȣ", "��ǰ�̸�", "��ǰ����", "��ǰ����" };

	Object rowData[][] =
	{
	{ 1, "������", 100, "������" },
	{ 2, "������", 200, "�ҷ���ǰ" },
	{ 3, "ĭ����", 300, "���ڰ��� ������" } };
	
	
	//DefaultTableModel�� �����ϰ� ������ ���
	DefaultTableModel defaultTableModel = new DefaultTableModel(rowData, columnNames);

	//JTable�� DefaultTableModel�� ���
	JTable jTable = new JTable(defaultTableModel);
	
	//JScrollPane�� JTable�� ���
	JScrollPane jScollPane = new JScrollPane(jTable);

	public Pos()
	{
		jFrame.add(jScollPane);
		
		//�� ���� �߰�!
		Object [] temporaryObject = { 4, "���ڼ���", 500, "��ǰ���� ���밭��" };
		defaultTableModel.addRow(temporaryObject);
		
		//��� �� ���� ���ϱ�
		System.out.println(defaultTableModel.getRowCount());
		System.out.println(defaultTableModel.getColumnCount());
		
		//�÷�(��)�� index�� 0���� �����Ѵ�!!
		System.out.println(defaultTableModel.getColumnName(0));
		
		//0���� �����ϸ� �������� �����ϰ� ù°���� �����Ѵ�!!
		defaultTableModel.removeRow(0);
		
		//���� ���� ���� 0���� index�� ���۵ȴٴ� �Ϳ� �����Ѵ�!!
		System.out.println(defaultTableModel.getValueAt(2, 2));
		
		//Ư�� ��ǥ�� ���� �ٲٴ� ���� setValueAt()
		defaultTableModel.setValueAt("5000", 2, 2);
		
		//���̺� Row�� �̸� ������ ���·� �����!
		jTable.setRowSelectionInterval(1, 1);

		jFrame.setSize(500, 300);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	/*
	 * for(int i =0; i<nums.length; i++){
			this.nums[i].setText(""+i);			
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
	 */

	public static void main(String[] args)
	{
		new Pos();
	}
}