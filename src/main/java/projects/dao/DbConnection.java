package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {
  private static final String SCHEMA = "projects";
  private static final String USER = "projects";
  private static final String PASSWORD = "projects";
  private static final String HOST = "localhost";
  private static final int PORT = 3306; 
  
  public static Connection getConnection() {
	 String uri = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, USER, PASSWORD);
	 
	 System.out.println("Connecting with url=" + uri);
	 
	try {
	 Connection conn = DriverManager.getConnection(uri);
	 System.out.println("Successfully obtained connection!"); 
	 return conn; 
   } catch (SQLException e) {
	  throw new DbException(e); 
   }
 }
}
