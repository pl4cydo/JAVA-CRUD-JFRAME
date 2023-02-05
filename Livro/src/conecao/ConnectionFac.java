package conecao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFac {
	
	private static final String USERNAME = "placydo";
	private static final String PASSWORD = "placydo";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud_java_jframe";
	
	public static Connection createConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		Connection con = createConnection();
		
		if(con!=null) {
			System.out.println("COnexão feita");
			con.close();
		}
	}
	
}
