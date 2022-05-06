package com.ecommerce.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.product.Products;
import com.ecommerce.product.ProductsDao;


public class CartDao {
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
	public static int saveAllDetails(int id) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into cart1 values(?,?,?,?,?)");
			List<Products> list=ProductsDao.getProductDetails(id);
			ps.setInt(1, id);
			for(Products p:list) {
			ps.setString(2, p.getProductName());
			ps.setString(3, p.getProductUrl());
			ps.setInt(4, p.getProductPrice());
			ps.setString(5, p.getProductCat());
			}
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static List<Products> getCartDetails(){
		List<Products> ll = new ArrayList<Products>();
		try {
			Connection con = getConnection();
		String query = "select * from cart1";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		while(rs.next()) {
			Products p = new Products();
			p.setProductId(rs.getInt(1));
		p.setProductName(rs.getString(2));
		p.setProductUrl(rs.getString(3));
		p.setProductPrice(rs.getInt(4));
		
		p.setProductCat(rs.getString(5));
		ll.add(p);
		}
		s.close();
		con.close();
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		return ll;
	}
	public static int saveOrderDetails(int id) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("insert into order values(?,?,?,?,?,?)");
			List<Products> list=ProductsDao.getProductDetails(id);
			System.out.println(list);
			ps.setInt(1, id);
			for(Products p:list) {
			ps.setString(2, p.getProductName());
			ps.setInt(3, p.getProductPrice());
			ps.setString(4, p.getProductUrl());
			ps.setString(5, p.getProductDesc());
			ps.setString(6, p.getProductCat());
			}
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static List<Products> getOrderDetails(){
		List<Products> ll = new ArrayList<Products>();
		try {
			Connection con = getConnection();
		String query = "select * from order";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		while(rs.next()) {
			Products p = new Products();
		p.setProductName(rs.getString(1));
		p.setProductDesc(rs.getString(2));
		p.setProductPrice(rs.getInt(3));
		p.setProductUrl(rs.getString(4));
		p.setProductCat(rs.getString(5));
		ll.add(p);
		}
		s.close();
		con.close();
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		return ll;
	}

}
