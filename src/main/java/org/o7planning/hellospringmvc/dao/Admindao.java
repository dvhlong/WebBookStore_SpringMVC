package org.o7planning.hellospringmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Admindao {
	public boolean ktdnadmin(String un, String pass) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("select * from qlsach.dangnhap where TenDangNhap=? and MatKhau=? and Quyen=?");
    	st.setString(1, un);
    	st.setString(2, pass);
    	st.setBoolean(3, true);
    	ResultSet rs=st.executeQuery();
    	if(rs.next()) {
    		System.out.println(rs.getString(1)+" "+rs.getString(2));
    		cn.close();
    		return true;
    	} else {
    		cn.close();
    		return false;
    	}
	}
	public void add(String un, String pass, String repass) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("select * from qlsach.dangnhap where TenDangNhap=? ");
    	st.setString(1, un);
    	ResultSet rs = st.executeQuery();
    	if(!rs.next()&&pass.equals(repass)) {
    		st=cn.prepareStatement("insert into qlsach.dangnhap values (?,?,?)");
    		st.setString(1, un);
    		st.setString(2, pass);
    		st.setBoolean(3, true);
    		st.executeUpdate();
    	}
    	cn.close();
	}
}
