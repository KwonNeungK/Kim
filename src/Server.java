import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {

	private static int orderedprice;

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(20000);
		while (true) {
			try {
				System.out.println("������ ������ ����ϴ� �� �Դϴ�.");
				Socket sock = server.accept(); // ��Ʈ��ũ���� 20000��Ʈ�� ������ ������ ���
				System.out.println(sock.getInetAddress() + "���� ���� �߽��ϴ�.");

				OutputStream os = sock.getOutputStream(); // ������ ������(��Ʈ�� ����) -> import java.io.OutputStream;
				DataOutputStream dos = new DataOutputStream(os); // ������ ������ ��Ʈ�� ���׷��̵� -> import java.io.OutputStream;

				InputStream is = sock.getInputStream(); // ������ �ޱ� (��Ʈ������)
				DataInputStream dis = new DataInputStream(is); // ������ �ޱ� ��Ʈ�� ���׷��̵�
				while (true) {
					String msg = dis.readUTF();
					if(msg.equals("orders")) {
						String table = dis.readUTF();
						ObjectInputStream input = new ObjectInputStream(dis); 

						List<Order> orders = (List<Order>)input.readObject();

						System.out.println(table + "���� �ֹ��� ���Խ��ϴ�.");
						orderedprice = 0;
						for (int i = 0; i < orders.size(); i++) {
							Order order = orders.get(i);
							System.out.println("\n"+"     "+order.getMenu()+" ( "+order.getPrice()+" ) x "+ order.getQuantity()+" = "+ order.getTotalPrice());
							orderedprice += order.getTotalPrice();
						}
						System.out.println("\n"+table+"�ֹ� �Ѿ� : "+orderedprice);
					}
					else if(msg.equals("alert")) {
						String table = dis.readUTF();
						System.out.println(table + "���� ȣ���� �Ǿ����ϴ�."); // (�б�) ���
					}
					else 
						System.out.println(msg); // (�б�) ���
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
