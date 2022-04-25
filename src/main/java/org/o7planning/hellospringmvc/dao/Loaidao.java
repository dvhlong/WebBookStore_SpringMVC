package org.o7planning.hellospringmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.Loaibean;




public class Loaidao {
	public ArrayList<Loaibean> getloai() throws Exception {
		ArrayList<Loaibean> ds =new ArrayList<Loaibean>();
//		ds.add(new Loaibean("cntt","Cong nghe thong tin"));
//		ds.add(new Loaibean("toan", "Toán học"));
//		ds.add(new Loaibean("kt", "Kinh tế"));
//		ds.add(new Loaibean("luat", "Luật học"));
//		ds.add(new Loaibean("va", "Văn học"));
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	Statement st=cn.createStatement();
    	ResultSet rs;
    	rs=st.executeQuery("Select * From qlsach.loai order by maloai asc");
    	while(rs.next()) {
    		ds.add(new Loaibean(rs.getString(1),rs.getString(2)));
    	}
    	cn.close();
		return ds;
	}
	public void addloai(String maloai,String tenloai) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("select * from qlsach.loai where maloai=?");
    	st.setString(1, maloai);
    	ResultSet rs=st.executeQuery();
    	if(!rs.next()) {
    		st=cn.prepareStatement("insert into qlsach.loai values (?,?)");
        	st.setString(1,maloai);
        	st.setString(2, tenloai);
        	st.executeUpdate();
        	cn.close();
    	}
	}
	public void editloai(String maloai,String tenloai) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("update qlsach.loai set tenloai=? where maloai=?");
    	st.setString(1, tenloai);
    	st.setString(2, maloai);
    	st.executeUpdate();
    	cn.close();
	}
	public void deleteloai(String maloai) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("update qlsach.sach set maloai=? where maloai=?");
    	st.setString(1, null);
    	st.setString(2, maloai);
    	st.executeUpdate();
    	st=cn.prepareStatement("delete from qlsach.loai where maloai=?");
    	st.setString(1, maloai);
    	st.executeUpdate();
    	cn.close();
	}
}
