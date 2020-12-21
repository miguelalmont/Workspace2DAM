package proyecto_oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Miguel Alcantara
 *
 */
public class DatabaseConnection {
	
    private static DatabaseConnection instance;
    private Connection connection;
    
    /**IP O HOSTNAME Y PUERTO DE LA BD**/
    private String url = "jdbc:oracle:thin:@localhost:49161:xe";
    
    /**USUARIO DE LA BD**/
    private String username = "miguel";
    
    /**CONTRASEÑA DE LA BD**/
    private String password = "miguel";
    
    /**
     * Instancia una conexion a la base de datos.
     * @throws SQLException
     */
    private DatabaseConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }
    
    /**
     * Devuelve una instancia de esta clase con la conexion a la base de datos.
     * @return Connection
     */
    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }

}
