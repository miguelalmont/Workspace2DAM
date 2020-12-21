package proyecto_oracle;

import java.sql.Connection;
import java.sql.SQLException;

public class Principal {
	
	public static Connection databaseConnection;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			databaseConnection = DatabaseConnection.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Menu menu = new Menu();
		menu.menuPrincipal();
	}

}
