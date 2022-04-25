package org.o7planning.hellospringmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import org.o7planning.hellospringmvc.bean.Giohangbean;
import org.o7planning.hellospringmvc.bean.Khachhangbean;
import org.o7planning.hellospringmvc.bo.Giohangbo;



public class Giohangdao {
	public void addHD(Giohangbo gh,Khachhangbean kh) throws Exception {
		//lấy time mua hàng
		java.util.Date javaDate = new java.util.Date();
	    long javaTime = javaDate.getTime();
	  	gh.timebuy=new java.sql.Timestamp(javaTime);
	  	Connection cn;
	  	Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/qlsach?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	//lấy makh từ tendn
    	PreparedStatement st=cn.prepareStatement("select * from qlsach.khachhang where tendn=?");
    	st.setString(1, kh.getMakh());
    	ResultSet rs=st.executeQuery();
    	int makh;
    	SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
    	try {
    		if(rs.next()) { 
        		makh=rs.getInt(1);
        		st=cn.prepareStatement("insert into qlsach.hoadon (makh,NgayMua,damua,TongTien) values(?,?,?,?)");
        		st.setInt(1, makh);
        		st.setString(2, sdf.format(gh.timebuy));
        		st.setBoolean(3, false);
        		st.setLong(4, gh.Tongtien());
        		st.executeUpdate();
        		st=cn.prepareStatement("select * from qlsach.hoadon where NgayMua=?");     		
        		st.setString(1, sdf.format(gh.timebuy));
        		rs=st.executeQuery();
        		if(rs.next()) {
        			
        			int mahd=rs.getInt(1);
        			System.out.println("Ma hoa don la: "+mahd);
        			for(Giohangbean i:gh.ds) {
        				st=cn.prepareStatement("insert into qlsach.chitiethoadon (MaSach,SoLuongMua,MaHoaDon,daMua) values(?,?,?,?)");
        				st.setString(1, i.getMasach());
        				st.setLong(2, i.getSlmua());
        				st.setInt(3, mahd);
        				st.setBoolean(4, false);
        				st.executeUpdate();
        			}
        		}
        	}
    	} catch (Exception e) {
    		System.out.println(e);
    	}
    	
    	cn.close();
	}
}
