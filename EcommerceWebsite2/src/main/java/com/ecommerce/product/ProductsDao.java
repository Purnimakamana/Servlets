package com.ecommerce.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.dao.User;

public class ProductsDao {
	static Connection con;

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/user";
			String username = "root";
			String userpassword = "root";
			con = DriverManager.getConnection(url, username, userpassword);
		} catch (Exception u) {
			u.printStackTrace();
		}
		return con;
	}
	public static int save(Products p) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into Products(product_name,product_price,product_url,product_desc,product_cat) values(?,?,?,?,?)");
			ps.setString(1, p.getProductName());
			ps.setInt(2, p.getProductPrice());
			ps.setString(3, p.getProductUrl());
			ps.setString(4, p.getProductDesc());
			ps.setString(5, p.getProductCat());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static List<Products> getProduct(String cat) throws SQLException{  
	    List<Products> ll=new ArrayList<>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from products where product_cat=?"); 
	        ps.setString(1, cat);
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            Products p=new Products();  
	            p.setProductId(rs.getInt(1));  
	            p.setProductName(rs.getString(2));  
	            p.setProductPrice(rs.getInt(3));  
	            p.setProductUrl(rs.getString(4));
	            p.setProductDesc(rs.getString(5));
	            p.setProductCat(rs.getString(6));
	            ll.add(p);  
	           
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    System.out.println(ll);
	    return ll;  
	} 
	public static List<Products> getProductDetails(int id) throws SQLException{  
	    List<Products> ll=new ArrayList<>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from products where products_id=?"); 
	        ps.setInt(1, id);
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	 Products p=new Products();  
		            p.setProductId(rs.getInt(1));  
		            p.setProductName(rs.getString(2));  
		            p.setProductPrice(rs.getInt(3));  
		            p.setProductUrl(rs.getString(4));
		            p.setProductDesc(rs.getString(5));
		            p.setProductCat(rs.getString(6));
		            ll.add(p);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return ll;  
	}
}
