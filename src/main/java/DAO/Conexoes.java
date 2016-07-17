package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexoes {
	
	public Connection getConexao()throws Exception{
		Connection cnn = null;
		Class.forName("org.postgresql.Driver");
		cnn = DriverManager.getConnection("jdbc:postgresql:sgsli","bruno","angra1");
		return cnn;
	}

}
