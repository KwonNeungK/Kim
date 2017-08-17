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
				System.out.println("서버가 연결을 대기하는 중 입니다.");
				Socket sock = server.accept(); // 네트워크에서 20000포트로 들어오는 데이터 듣기
				System.out.println(sock.getInetAddress() + "님이 접속 했습니다.");

				OutputStream os = sock.getOutputStream(); // 데이터 보내기(스트림 개방) -> import java.io.OutputStream;
				DataOutputStream dos = new DataOutputStream(os); // 데이터 보내기 스트림 업그레이드 -> import java.io.OutputStream;

				InputStream is = sock.getInputStream(); // 데이터 받기 (스트림개방)
				DataInputStream dis = new DataInputStream(is); // 데이터 받기 스트림 업그레이드
				while (true) {
					String msg = dis.readUTF();
					if(msg.equals("orders")) {
						String table = dis.readUTF();
						ObjectInputStream input = new ObjectInputStream(dis); 

						List<Order> orders = (List<Order>)input.readObject();

						System.out.println(table + "에서 주문이 들어왔습니다.");
						orderedprice = 0;
						for (int i = 0; i < orders.size(); i++) {
							Order order = orders.get(i);
							System.out.println("\n"+"     "+order.getMenu()+" ( "+order.getPrice()+" ) x "+ order.getQuantity()+" = "+ order.getTotalPrice());
							orderedprice += order.getTotalPrice();
						}
						System.out.println("\n"+table+"주문 총액 : "+orderedprice);
					}
					else if(msg.equals("alert")) {
						String table = dis.readUTF();
						System.out.println(table + "에서 호출이 되었습니다."); // (읽기) 출력
					}
					else 
						System.out.println(msg); // (읽기) 출력
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
