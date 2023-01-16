import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class Main {
	private static final String filepath = "C:\\Users\\User010\\Desktop\\mavienAPI\\eva.json";

	static void choicesFunction1() {

		System.out.println("***************************");
		System.out.println("Welcome...Please Select one of the following options:");
		System.out.println("1. connect to database");
		System.out.println("2. add api to file");
		System.out.println("3. Create Table");
		System.out.println("4. Read from API");
		System.out.println("5. Insert to Table");
		System.out.println("6. Read from Table");
		System.out.println("7. update from Table (domains based in id)");
		System.out.println("8. delete from Table web based in id");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		choicesFunction1();

		do {
			/// hibkjbjkjguj
			int userInput = sc.nextInt();
			switch (userInput) {
			case 1:
				// this class to connect eclipes with my database
				System.out.println("==========Connect to database===================");
				DemoConnectMysql connectToDatabse1 = new DemoConnectMysql();
				connectToDatabse1.conToDataBase();
				System.out.println("================================================");
				choicesFunction1();
				//
				break;

			case 2:
				System.out.println("==========Get api from URL===================");
				URL url = new URL("http://universities.hipolabs.com/search?country=United+States");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();
				StringBuilder informationString = new StringBuilder();
				int responseCode = conn.getResponseCode();
				if (responseCode != 200) {
					throw new RuntimeException("HttpresponseCode");

				}

				else {
					Scanner scanner = new Scanner(url.openStream());
					while (scanner.hasNext()) {
						informationString.append(scanner.nextLine());
					}
					scanner.close();

					System.out.println(informationString.toString());

				}
				System.out.println("===========================================");
				choicesFunction1();
				break;
			case 3:
				System.out.println("==========CRATE TABLE WEB===================");
				CrateTableWeb CreateTable = new CrateTableWeb();
				CreateTable.CreateTableToDB();

				System.out.println("===========================================");
				choicesFunction1();
				break;
			case 4:
				System.out.println("==========Get api from URL===================");
				URL url1 = new URL("http://universities.hipolabs.com/search?country=United+States");
				HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
				conn1.setRequestMethod("GET");
				conn1.connect();
				StringBuilder informationString1 = new StringBuilder();
				int responseCode1 = conn1.getResponseCode();
				if (responseCode1 != 200) {
					throw new RuntimeException("HttpresponseCode");

				}

				else {
					Scanner scanner = new Scanner(url1.openStream());
					while (scanner.hasNext()) {
						informationString1.append(scanner.nextLine());
					}
					scanner.close();
					Gson gson = new Gson();
					// System.out.println(informationString1.toString());
					ApiSQL[] apiResult = gson.fromJson(informationString1.toString(), ApiSQL[].class);
					for (ApiSQL x : apiResult) {
						try {
							System.out.println(" ***************************** " + "|");
//					
							System.out.println("web_pages : " + x.getWeb_pages());
							System.out.println("state_province : " + x.getState_province());
							System.out.println("alpha_two_code : " + x.getAlpha_two_code());
							System.out.println("name : " + x.getName());
							System.out.println("country : " + x.getCountry());
							System.out.println("domains : " + x.getdomains());
							System.out.println("|" + " ***************************** " + "|");
						} catch (Exception e) {
						}
					}
				}

				System.out.println("===========================================");
				choicesFunction1();
				break;
			case 5:
				System.out.println("==========Insert to Table===================");
				URL url11 = new URL("http://universities.hipolabs.com/search?country=United+States");
				HttpURLConnection conn11 = (HttpURLConnection) url11.openConnection();
				conn11.setRequestMethod("GET");
				conn11.connect();
				StringBuilder informationString11 = new StringBuilder();
				int responseCode11 = conn11.getResponseCode();
				if (responseCode11 != 200) {
					throw new RuntimeException("HttpresponseCode");

				}

				else {
					Scanner scanner = new Scanner(url11.openStream());
					while (scanner.hasNext()) {
						informationString11.append(scanner.nextLine());
					}
					scanner.close();
					Gson gson = new Gson();
					// System.out.println(informationString1.toString());
					ApiSQL[] apiResult = gson.fromJson(informationString11.toString(), ApiSQL[].class);
					for (ApiSQL x : apiResult) {
						List<String> web_pages = x.getWeb_pages();
						String state_province = x.getState_province();
						String alpha_two_code = x.getAlpha_two_code();
						String name = x.getName();
						String country = x.getCountry();
						List<String> domains = x.getdomains();

						Class.forName("com.mysql.cj.jdbc.Driver");
						String url111 = "jdbc:mysql://localhost:3306/MaveinDBMS";
						String username = "root";
						String password = "root";

						Connection con1 = DriverManager.getConnection(url111, username, password);
						int id = 1;

						if (con1 != null) {
							String SQLqueryForInserting = "insert into Web(web_pages,state_province, alpha_two_code,name, country,domains)"
									+ " values('" + web_pages + "' ,'" + state_province + "', '" + alpha_two_code
									+ "','" + name + "' ,' " + domains + "','" + country + "')";
							Statement st = con1.createStatement();
							//
							// Executing query
							int m = st.executeUpdate(SQLqueryForInserting);
							if (m >= 1) {
								System.out.println("inserted successfully : " + SQLqueryForInserting);

							} else {
								System.out.println("insertion failed");

								// Closing the connections
							}

						}

					}
				}

				choicesFunction1();
				break;
			case 6:
				System.out.println("==========Read From Table===================");
				String sqlDB = " SELECT * FROM Web ";

				Class.forName("com.mysql.jdbc.Driver");
				String url111 = "jdbc:mysql://localhost:3306/maveindbms";
				String username = "root";
				String password = "root";
				try {

					Connection conn111 = DriverManager.getConnection(url111, username, password);
					Statement st = conn111.createStatement();
					ResultSet m = st.executeQuery(sqlDB);
					if (m.next()) {
						do {
							System.out.println("id : " + m.getInt(1));
							System.out.println("web_pages :" + m.getString(2));
							System.out.println("state_province :" + m.getString(3));
							System.out.println("alpha_two_code :" + m.getString(4));
							System.out.println("name :" + m.getString(5));

							System.out.println("country :" + m.getString(6));

							System.out.println("domains :" + m.getString(7));

							System.out.println("*********************************");
						} while (m.next());
					} else {
						System.out.println("No such user id is already registered");
					}
					conn111.close();
				} catch (Exception ex) {
					System.err.println(ex);
				}
				choicesFunction1();
				break;
			case 7:
				System.out.println("==========Update From Table Web===================");
				System.out.println("plz enter id that want to update");
				Scanner sc1 = new Scanner(System.in); // System.in is a standard input stream
				int id = sc1.nextInt();
				System.out.println("plz enter new  domains");
				String domains = sc1.next();
				String sqlDB1 = " update Web set domains = ? where id =  " + id;

				Class.forName("com.mysql.jdbc.Driver");
				String url1111 = "jdbc:mysql://localhost:3306/maveindbms";
				String username1 = "root";
				String password1 = "root";
				try (
						// gets connection with database
						Connection connection = DriverManager.getConnection(url1111, username1, password1);

						// sends queries and receives results
						PreparedStatement statement = connection.prepareStatement(sqlDB1);) {
					// this way to prevent sql injection
					statement.setString(id, domains);

					int count = statement.executeUpdate();

					System.out.print(" updated rows is " + id + ".");
				} catch (SQLException e) {
					// some logic depending on scenario
					// maybe LOGGER.log(e.getMessage()) and "result false"
					e.printStackTrace();
				}
				choicesFunction1();
				break;

			case 8:
				System.out.println("==========DELETE From Table Web===================");

				System.out.println("plz enter id that want to delete");
				Scanner sc11 = new Scanner(System.in); // System.in is a standard input stream
				int id1 = sc11.nextInt();

				Connection conn111 = null;
				Statement stmt = null;
				try {
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (Exception e) {
						System.out.println(e);
					}
					conn111 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/maveindbms", "root",
							"root");
					System.out.println("Connection is created successfully:");
					stmt = (Statement) conn111.createStatement();
					String query1 = "delete from  Web " + "where id=" + id1;
					stmt.executeUpdate(query1);
					System.out.println("Record is deleted from the table successfully..................");
				} catch (SQLException excep) {
					excep.printStackTrace();
				} catch (Exception excep) {
					excep.printStackTrace();
				} finally {
					try {
						if (stmt != null)
							conn111.close();
					} catch (SQLException se) {
					}
					try {
						if (conn111 != null)
							conn111.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}
				}
				System.out.println("Please check it in the MySQL Table. Record is now deleted.......");

				choicesFunction1();
				break;
			}

		} while (true);

	}
}
