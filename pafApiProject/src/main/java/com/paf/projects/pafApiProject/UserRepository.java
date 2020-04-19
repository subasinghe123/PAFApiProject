package com.paf.projects.pafApiProject;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class UserRepository {
	
	Connection con = null;
	
	List<User> users;
	public UserRepository(){
		String url="jdbc:mysql://localhost:3306/userapiproject?serverTimezone=UTC";
		String username="root";
		String password="";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		users = new ArrayList<>();
		
		User u1 = new User();
		u1.setUid(1);
		u1.setUname("randula");
		u1.setContactno("0719506013");
		u1.setAddress("Kegalle");
		u1.setEmail("rand@gmail.com");
		
		User u2 = new User();
		u2.setUid(2);
		u2.setUname("saranga");
		u2.setContactno("0709506013");
		u2.setAddress("Kegalle");
		u2.setEmail("sara@gmail.com");
		
		User u3 = new User();
		u3.setUid(3);
		u3.setUname("chinthaka");
		u3.setContactno("0789506013");
		u3.setAddress("Kegalle");
		u3.setEmail("chinna@gmail.com");
		
		users.add(u1);
		users.add(u2);
		users.add(u3);
		
	}
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public User createUser(User u1) {
		
		String insertsql ="INSERT INTO `users`(`uid`, `uname`, `contactno`, `address`, `email`) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement st = con.prepareStatement(insertsql);
			st.setInt(1, u1.uid);
			st.setString(2, u1.uname);
			st.setString(3, u1.contactno);
			st.setString(4, u1.address);
			st.setString(5, u1.email);
			
			st.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
		users.add(u1);
		System.out.println(users);
		return u1;
		
	}

}
