package org.o7planning.hellospringmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.Sachbean;

public class Sachdao {
	public ArrayList<Sachbean> getSach() throws Exception{
		ArrayList<Sachbean> ds =new ArrayList<Sachbean>();
		Connection cn;
//		ds.add(new Sachbean("s11", "Cấu trúc dữ liệu1", "Đỗ Ngọc", (long)120000, (long)1000,"image_sach/b21.jpg", "toan"));
//		ds.add(new Sachbean("s22", "Cơ sở dữ liệu2", "Đỗ Ngọc", (long)120000, (long)1000,"image_sach/b22.jpg", "cntt"));
//		ds.add(new Sachbean("s33", "lập trình Java3", "Quách Tuấn Ngọc", (long)120000, (long)1000,"image_sach/b24.jpg", "cntt"));
//		ds.add(new Sachbean("s4", "Đại chất công trình", "Đỗ Ngọc", (long)120000, (long)1000,"image_sach/b16.jpg", "luat"));
//		ds.add(new Sachbean("s5", "Bản đồ", "Đỗ Ngọc", (long)120000, (long)1000,"image_sach/b11.jpg", "va"));
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	Statement st=cn.createStatement();
    	ResultSet rs;
    	rs=st.executeQuery("Select * From qlsach.sach where anh is not null");
    	while(rs.next()) {
				ds.add(new Sachbean(rs.getString(1),rs.getString(2),rs.getString(9),rs.getLong(4),rs.getLong(3),rs.getTimestamp(8),rs.getString(7),rs.getString(5)));
			
    	}
    	cn.close();
		return ds;
	}	
	public void addSach(String masach,String tensach,String tacgia,long gia,long soluong,String anh,String maloai) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	java.util.Date javaDate = new java.util.Date();
	    long javaTime = javaDate.getTime();
	  	Timestamp timenhap=new java.sql.Timestamp(javaTime);
    	PreparedStatement st=cn.prepareStatement("select * from qlsach.sach where masach=?");
    	st.setString(1, masach);
    	ResultSet rs=st.executeQuery();
    	if(!rs.next()) {
    		st=cn.prepareStatement("insert into qlsach.sach values(?,?,?,?,?,?,?,?,?)");
    		st.setString(1, masach);
    		st.setString(2, tensach);
    		st.setLong(3, soluong);
    		st.setLong(4, gia);
    		st.setString(5, maloai);
    		st.setInt(6, 1);
    		st.setString(7, anh);
    		st.setTimestamp(8, timenhap);
    		st.setString(9, tacgia);
    		System.out.println(st.executeUpdate());
    	}
    	cn.close();
	}
	public void editSach(String masach,String tensach,String tacgia,long gia,long soluong,Timestamp ngaynhap,String anh,String maloai) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("update qlsach.sach set tensach=?,soluong=?,gia=?,maloai=?,anh=?,NgayNhap=?,tacgia=? where masach=?");
    	st.setString(1, tensach);
    	st.setLong(2, soluong);
    	st.setLong(3, gia);
    	st.setString(4, maloai);
    	st.setString(5, anh);
    	st.setTimestamp(6, ngaynhap);
    	st.setString(7, tacgia);
    	st.setString(8, masach);
    	st.executeUpdate();
    	cn.close();
	}
	public void deleteSach(String masach) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("delete from qlsach.sach where masach=?");
    	st.setString(1, masach);
    	st.executeUpdate();
    	cn.close();
	}
}