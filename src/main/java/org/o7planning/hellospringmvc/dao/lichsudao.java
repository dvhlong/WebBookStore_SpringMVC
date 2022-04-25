package org.o7planning.hellospringmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.Giohangbean;
import org.o7planning.hellospringmvc.bean.Khachhangbean;
import org.o7planning.hellospringmvc.bo.Giohangbo;



public class lichsudao {
	public void getData(Khachhangbean kh,ArrayList<Giohangbo> ghbols) throws Exception {
		//use QlSach select * from ChiTietHoaDon as cthd join hoadon as hd on cthd.MaHoaDon=hd.MaHoaDon join KhachHang as kh on hd.makh=kh.makh where kh.tendn=?";
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	System.out.println("ten dang nhap la :"+kh.getMakh());
    	PreparedStatement st=cn.prepareStatement("select * from qlsach.khachhang where tendn=?");
    	st.setString(1, kh.getMakh());
    	ResultSet rs=st.executeQuery();
    	int makh;
    	if (rs.next()) {
    		makh=rs.getInt(1);
    		st=cn.prepareStatement("select * from qlsach.hoadon where makh=? and damua=?");
    		st.setInt(1, makh);
    		st.setInt(2, 1);
    		rs=st.executeQuery();
    		while (rs.next()) {
    			System.out.println("Time: "+rs.getTimestamp(3));
    			Giohangbo ghbo=new Giohangbo();
    			ghbo.timebuy=rs.getTimestamp(3);
    			System.out.println("Ma hoa don: "+rs.getInt(1));
    			int mahd=rs.getInt(1);
    			PreparedStatement st1=cn.prepareStatement("select * from qlsach.chitiethoadon as cthd"
    					+ " join qlsach.hoadon as hd on cthd.MaHoaDon=hd.MaHoaDon"
    					+ " join qlsach.khachhang as kh on hd.makh=kh.makh "
    					+ " join qlsach.sach as s on s.MaSach=cthd.MaSach"
    					+ " where kh.makh=? and hd.MaHoaDon=?");
    			st1.setInt(1, makh);
    			st1.setInt(2, mahd);
    			ResultSet rs1=st1.executeQuery();
    			while (rs1.next()) {
    				System.out.println(String.format("Ma sach: %s, So luong mua: %d",rs1.getString(2),rs1.getLong(3)));
    				Giohangbean gh=new Giohangbean(rs1.getString(2),rs1.getString(19),rs1.getString(26),rs1.getLong(21),rs1.getLong(3));
    				ghbo.ds.add(gh);
    			}
    			ghbols.add(ghbo);
    		}
    	}
    	cn.close();
	}
}
