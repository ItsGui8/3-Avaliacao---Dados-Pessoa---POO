import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static final String url = "jdbc:mysql://localhost:3306/app_db";
	
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(url, USER, PASSWORD);
		
		return connection;
	}
	
	public static void main(String args[]) throws Exception {
		Connection connection = createConnectionToMySQL();
		
		if(connection != null) {
			System.out.println("Conexão criada com sucesso!");
			connection.close();
		}
	}
}
