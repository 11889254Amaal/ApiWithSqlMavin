import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrateTableWeb {
	static final String DB_URL = "jdbc:mysql://localhost:3306/maveindbms";
	  static final String USER = "root";
	  static final String PASS = "root";

	public boolean CreateTableToDB () {
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        Statement stmt = conn.createStatement();
	     ) {      
	         String sql = "CREATE TABLE Web " +
	                  "(id int NOT NULL AUTO_INCREMENT, " +
	                  " web_pages   VARCHAR(100) not NULL, " +    
	                  " state_province VARCHAR(100) , " +
	                  " alpha_two_code VARCHAR(100) , " +
	                  " name  VARCHAR(100)  , " +
	                  " country  VARCHAR(100)  , " +
	                  " domains  VARCHAR(100)  , " +
	                  " PRIMARY KEY ( id ))";
	         String sql1="ALTER TABLE Web AUTO_INCREMENT=1";
	         stmt.executeUpdate(sql);
	         stmt.executeUpdate(sql1);
	       
	      
	       
	        System.out.println(true+"===>Created web Table table in given database...");  
	       
	     } catch (SQLException e) {
	       System.out.println("Table Web Table Already Build");
	       System.out.println("***********************************");
	     }
	return false;
	  }
}
