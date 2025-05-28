package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserModel {
	
	private ArrayList<User> users = new ArrayList<User>();

	public UserModel() {
	}
	
	public ArrayList<User> get() {
		String query = "select * from users";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String role = rs.getString(4);
				String phone = rs.getString(5);
				
				users.add(new User(id,name,email,role,phone,null,null));
				
				/*System.out.println("id:" + id);
				System.out.println("name:" + name);
				System.out.println("email:" + email);
				System.out.println("role:" + role);
				System.out.println("phone:" + phone);
				System.out.println("");*/
			}
			
			rs.close();
			return users; 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		
		
		
		return users;
	}

	
	public boolean create(int id,String name, String email, String rol) {
		String query = "INSERT INTO `users` (`id`, `name`, `email`, `role`, `phone`, `create_at`, `update_at`) VALUES ('"+id+"', '"+name+"', '"+email+"', '"+rol+"', NULL, NULL, NULL);";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = conn.createStatement();
			
			int rs = stmt.executeUpdate(query);
			if(rs>0)
				return true; 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		
		return false;
	}
	
	
	public boolean update(User user)
	{
		String query = "UPDATE `users` SET `name` = '"+user.name+"' WHERE `users`.`id` = "+user.id+";";
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = conn.createStatement();
			
			int rs = stmt.executeUpdate(query);
			 
			if(rs > 0) 
				return true; 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		
		return false;
	}
}
