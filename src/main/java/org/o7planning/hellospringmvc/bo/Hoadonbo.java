package org.o7planning.hellospringmvc.bo;

import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.Giohangbean;
import org.o7planning.hellospringmvc.bean.Hoadonbean;
import org.o7planning.hellospringmvc.dao.Hoadondao;



public class Hoadonbo {
	public Hoadonbean hd=new Hoadonbean();
	public ArrayList<Giohangbean> ghls=new ArrayList<Giohangbean>();
	public void getdata(ArrayList<Hoadonbo> hdbols) throws Exception {
		Hoadondao hddao=new Hoadondao();
		hddao.getdata(hdbols);
	}
	public Hoadonbean gethd() {
		return hd;
	}
	public ArrayList<Giohangbean> getghls(){
		return ghls;
	}
	public void xacnhanhd(long mahd) throws Exception {
		Hoadondao hddao=new Hoadondao();
		hddao.xacnhanhd(mahd);
	}
	public void xacnhancthd(long mahd,String masach) throws Exception {
		Hoadondao hddao=new Hoadondao();
		hddao.xacnhancthd(mahd, masach);
	}
	public void xoahd(long mahd) throws Exception {
		Hoadondao hddao=new Hoadondao();
		hddao.xoahd(mahd);
	}
}
