package org.o7planning.hellospringmvc.bo;

import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.Giohangbean;
import org.o7planning.hellospringmvc.bean.Khachhangbean;
import org.o7planning.hellospringmvc.dao.Giohangdao;




public class Giohangbo {
	public ArrayList<Giohangbean> ds=new ArrayList<Giohangbean>();
	public java.sql.Timestamp timebuy;
	public void Them(String masach,String tensach,String tacgia,Long gia,Long slmua) {
		for (Giohangbean g:ds) {
			if(g.getMasach().equals(masach)) {
				g.setSlmua(g.getSlmua()+slmua);
				return;
			}
		}
		ds.add(new Giohangbean(masach,tensach,tacgia,gia,slmua));
	}
	public void Xoa(String masach) {
		for(Giohangbean g:ds) {
			if(g.getMasach().equals(masach)) {
				ds.remove(g);
				return;
			}
		}
	}
	public Long Tongtien() {
		long s=0;
		for (Giohangbean g:ds)
			s=s+g.getThanhtien();
		return s;
	}
	public void addHD(Giohangbo gh,Khachhangbean kh) throws Exception {
		Giohangdao ghdao=new Giohangdao();
		ghdao.addHD(gh, kh);
	}
}
