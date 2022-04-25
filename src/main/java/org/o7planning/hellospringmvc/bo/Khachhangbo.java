package org.o7planning.hellospringmvc.bo;

import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.Khachhangbean;
import org.o7planning.hellospringmvc.dao.Khachhangdao;



public class Khachhangbo {
	Khachhangdao khdao=new Khachhangdao();
	public ArrayList<Khachhangbean> getKhachHang() throws Exception{
		return khdao.getKhachHang();
	}
	public Khachhangbean ktdn(String makh,String matkhau) throws Exception {
		//ArrayList<Khachhangbean>ds= getKhachHang();
		//for (Khachhangbean kh:ds)
			//if(kh.getMakh().equals(makh)&&kh.getMatkhau().equals(matkhau))
					//return kh;
		//return null;
		Khachhangdao khdao=new Khachhangdao();
		return khdao.ktdn(makh, matkhau);
	}
	public void add(String name,String address,String phone,String email,String un,String pass,String repass) throws Exception {
		Khachhangdao khdao=new Khachhangdao();
		khdao.add(name, un, pass, repass, email, address, phone);
	}
}