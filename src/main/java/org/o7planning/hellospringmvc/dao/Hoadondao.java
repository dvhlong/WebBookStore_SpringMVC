package org.o7planning.hellospringmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.Giohangbean;
import org.o7planning.hellospringmvc.bean.Hoadonbean;
import org.o7planning.hellospringmvc.bo.Hoadonbo;




public class Hoadondao {
	public void getdata(ArrayList<Hoadonbo> hdbols) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("select hd.MaHoaDon,kh.hoten,hd.NgayMua,Sum(cthd.SoLuongMua) as TongSoLuong,Sum(s.gia) as TongGia,Sum(cthd.SoLuongMua*s.gia) as ThanhTien\n"
    			+ "From hoadon as hd\n"
    			+ "inner join qlsach.chitiethoaDon as cthd on hd.MaHoaDon=cthd.MaHoaDon\n"
    			+ "inner join qlsach.khachhang as kh on hd.makh=kh.makh\n"
    			+ "inner join qlsach.sach as s on cthd.MaSach=s.masach\n"
    			+ "where (hd.damua=0)\n"
    			+ "group by hd.MaHoaDon,kh.hoten,hd.NgayMua");
    	ResultSet rs=st.executeQuery();
    	while (rs.next()) {
    		Hoadonbo hdbo=new Hoadonbo();
    		hdbo.hd=new Hoadonbean(rs.getLong(1),rs.getString(2),rs.getTimestamp(3),rs.getLong(4),rs.getLong(5),rs.getLong(6));
    		long mahd=rs.getLong(1);
    		PreparedStatement st1=cn.prepareStatement("select * from qlsach.chitiethoadon as cthd\n"
    				+ "join qlsach.sach as sach on sach.masach=cthd.MaSach\n"
    				+ "where MaHoaDon=? and daMua=?");
    		st1.setLong(1, mahd);
    		st1.setInt(2, 0);
    		ResultSet rs1=st1.executeQuery();
    		while (rs1.next()) {
    			Giohangbean ghbean=new Giohangbean(rs1.getString(2),rs1.getNString(7),rs1.getString(14),rs1.getLong(9),rs1.getLong(3));
    			hdbo.ghls.add(ghbean);
    		}
    		hdbols.add(hdbo);
    	}
    	cn.close();
	}
	public void xacnhanhd(long mahd) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("update qlsach.hoadon set damua=? where MaHoaDon=?");
    	st.setInt(1, 1);
    	st.setLong(2, mahd);
    	st.executeUpdate();
    	st=cn.prepareStatement("update qlsach.chitiethoadon set daMua=? where MaHoaDon=?");
    	st.setInt(1, 1);
    	st.setLong(2, mahd);
    	st.executeUpdate();
    	cn.close();
	}
	public void xacnhancthd(long mahd,String masach) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("update qlsach.chitiethoadon set daMua=? where MaHoaDon=? and MaSach=?");
    	st.setInt(1, 1);
    	st.setLong(2, mahd);
    	st.setString(3, masach);
    	st.executeUpdate();
    	st=cn.prepareStatement("Select * from qlsach.chitiethoadon where MaHoaDon=? and daMua=?");
    	st.setLong(1, mahd);
    	st.setInt(2, 0);
    	ResultSet rs=st.executeQuery();
    	if(!rs.next()) {
    		st=cn.prepareStatement("update qlsach.hoadon set damua=? where MaHoaDon=?");
        	st.setInt(1, 1);
        	st.setLong(2, mahd);
        	st.executeUpdate();
    	}
    	cn.close();
	}
	public void xoahd(long mahd) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("delete from qlsach.hoadon where MaHoaDon=?");
    	st.setLong(1, mahd);
    	st.executeUpdate();
    	cn.close();
	}
}