import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DemoConnectMysql {
	public static void conToDataBase() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/MaveinDBMS";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		if (con != null) {
			System.out.println("Database Connected successfully");
           
			

		} else {
			System.out.println("Database Connection failed");
		}
	}
}
