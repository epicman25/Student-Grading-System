import java.sql.*;


import javax.swing.*;
public class DatabaseConnection {
	 Connection DBConnection = null;
	public static Connection databaseconnector()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection DBConnection = DriverManager.getConnection("jdbc:sqlite:Student Grading System.db");
			return DBConnection;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}

}
