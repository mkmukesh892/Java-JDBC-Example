package com.mukesh.jdbc.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdate {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","mukesh");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement=connection.createStatement();
			statement.addBatch("update mytable set roll='52101' where roll='34'");
			statement.addBatch("update mytable set roll='52102' where roll='120'");
			statement.addBatch("update mytable set roll='52103' where roll='234'");
			statement.addBatch("update mytable set roll='52104' where roll='345'");
			statement.addBatch("update mytable set roll='52105' where roll='4567'");
			int [] recordsAffected=statement.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(statement!=null)
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

}
