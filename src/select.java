import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;


public class select {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���سɹ�");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�����쳣");
		try {
			Connection con = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studb", "root", "zxcvbnm");
			System.out.println("���ӳɹ�");
			Statement sta = (Statement) con.createStatement();

			ResultSet rs = (ResultSet) sta.executeQuery("select*from stuinfo");
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				System.out.println( username+ password);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�����쳣");
			e.printStackTrace();
		}

	}

	
	
	
	
	
	

}
