import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainDB {
	private int orderdate;
	private Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "java7";
		String pw = "java7";

		Connection con = 
				DriverManager.getConnection(url,id,pw);
		return con;

	}
	
	
	public Order isIdExist(String id) throws Exception{

		Connection con = this.getConnection();
		String sql = "select * from menu where orderdate = ?";
		PreparedStatement pstat = con.prepareStatement(sql);	//PreparedStatement를 쓰면 ?로 처리할수있음
		pstat.setInt(1, orderdate);
		ResultSet rs = pstat.executeQuery();
		Order result = ;
		con.close();

		return result;

	}
	
	public static void main(String[] args) {
		
	}
}