package org.o7planning.hellospringmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.Khachhangbean;
import org.o7planning.hellospringmvc.bo.md5;




public class Khachhangdao {
	public ArrayList<Khachhangbean> getKhachHang() throws Exception{
		ArrayList<Khachhangbean> ds= new ArrayList<Khachhangbean>();
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	Statement st=cn.createStatement();
    	ResultSet rs;
    	rs=st.executeQuery("Select * From qlsach.khachhang");
    	while(rs.next()) {
    		ds.add(new Khachhangbean(md5.getMd5(rs.getString(6)),rs.getString(2),rs.getString(3),md5.getMd5(rs.getString(7))));
    	}
    	cn.close();
		return ds;
	}
	public Khachhangbean ktdn(String un, String pass) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("Select * From qlsach.khachhang where tendn=? and pass=?");
    	st.setString(1, un);
    	st.setString(2, pass);
    	ResultSet rs;
    	rs=st.executeQuery();
    	if (rs.next()) {
    		System.out.println(rs.getString(6)+"  "+rs.getString(7));;
    		Khachhangbean kh = new Khachhangbean(rs.getString(6),rs.getString(2),rs.getString(3),rs.getString(7));
    		cn.close();
    		return kh;
    	} else {
    		cn.close();
    		return null;
		}
	}
	public void add(String name,String un,String pass,String repass, String email,String address,String phone) throws Exception{
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("Select * From qlsach.khachhang where tendn=?");
    	st.setString(1, un);
    	ResultSet rs;
    	rs=st.executeQuery();
    	if(!rs.next()&&pass.equals(repass)) {
    		PreparedStatement st1=cn.prepareStatement("insert into qlsach.khachhang (hoten,diachi,sodt,email,tendn,pass) values (?,?,?,?,?,?)");
    		st1.setString(1, name);
    		st1.setString(2, address);
    		st1.setString(3, phone);
    		st1.setString(4, email);
    		st1.setString(5, un);
    		st1.setString(6, pass);
    		st1.executeUpdate();
    	}
    	cn.close();
	}
}
