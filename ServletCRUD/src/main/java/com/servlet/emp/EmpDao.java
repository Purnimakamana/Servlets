package com.servlet.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	static Connection con;
	public static Connection createC() {
	try {
	Class.forName("com.mysql.jdbc.Driver");



	String url = "jdbc:mysql://localhost:3306/crudservlet";
	String username = "root";
	String userpassword = "root";



	con = DriverManager.getConnection(url, username, userpassword);
	}
	catch(Exception e) {
	e.printStackTrace();
	}
	return con;
	}
	public static int save(Emp e){  
		int status=0;  
		try{  
			Connection con = createC();
			String query = "insert into emp(name,password,email,country) values (?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);  
			ps.setString(1,e.getName());  
			ps.setString(2,e.getPassword());  
			ps.setString(3,e.getEmail());  
			ps.setString(4,e.getCountry());  

			status=ps.executeUpdate();  

			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  

		return status;  
	}  
	public static int update(Emp e){  
		int status=0;  
		try{  
			Connection con = createC();
			String query="update emp set name=?,password=?,email=?,country=? where id=?";
			PreparedStatement ps=con.prepareStatement(query);  
			ps.setString(1,e.getName());  
			ps.setString(2,e.getPassword());  
			ps.setString(3,e.getEmail());  
			ps.setString(4,e.getCountry());  
			ps.setInt(5,e.getId());  

			status=ps.executeUpdate();  

			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  

		return status;  
	}  
	public static int delete(int id){  
		int status=0;  
		try{  
			Connection con = createC(); 
			String query="delete from emp where id=?";
			PreparedStatement ps=con.prepareStatement(query);  
			ps.setInt(1,id);  
			status=ps.executeUpdate();  

			con.close();  
		}catch(Exception e){e.printStackTrace();}  

		return status;  
	}  
	public static Emp getEmployeeById(int id){  
		Emp e=new Emp();  

		try{  
			Connection con = createC();  
			String query="select * from emp where id=?";
			PreparedStatement ps=con.prepareStatement(query);  
			ps.setInt(1,id);  
			ResultSet rs=ps.executeQuery();  
			if(rs.next()){  
				e.setId(rs.getInt(1));  
				e.setName(rs.getString(2));  
				e.setPassword(rs.getString(3));  
				e.setEmail(rs.getString(4));  
				e.setCountry(rs.getString(5));  
			}  
			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  

		return e;  
	}  
	public static List<Emp> getAllEmployees(){  
		List<Emp> list=new ArrayList<Emp>();  

		try{  
			Connection con = createC();  
			String query="select * from emp";
			PreparedStatement ps=con.prepareStatement(query);  
			ResultSet rs=ps.executeQuery();  
			while(rs.next()){  
				Emp e=new Emp();  
				e.setId(rs.getInt(1));  
				e.setName(rs.getString(2));  
				e.setPassword(rs.getString(3));  
				e.setEmail(rs.getString(4));  
				e.setCountry(rs.getString(5));  
				list.add(e);  
			}  
			con.close();  
		}catch(Exception e){e.printStackTrace();}  

		return list;  
	}  

}
