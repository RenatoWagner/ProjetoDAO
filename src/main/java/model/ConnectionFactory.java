package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


		
public class ConnectionFactory {
		  public static Connection getConnection() throws ClassNotFoundException {
			  Class.forName("org.postgresql.Driver");
			  try {
		            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/primeiroestagiobd2","postgres","passwd007");
		        } catch (SQLException e) {
		            throw new RuntimeException(e);
		        }
		    }
}
