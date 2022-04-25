package org.o7planning.hellospringmvc.bo;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.Sachbean;
import org.o7planning.hellospringmvc.dao.Sachdao;




public class Sachbo {
	Sachdao sdao=new Sachdao();
	public ArrayList<Sachbean> getSach() throws Exception{
		return sdao.getSach();
	}
	public ArrayList<Sachbean> timMaLoai(String maloai) throws Exception{
		ArrayList<Sachbean> tam= new ArrayList<Sachbean>();
		ArrayList<Sachbean> ds=getSach();
		for (Sachbean s:ds)
			if(s.getMaloai().equals(maloai))
				tam.add(s);
		return tam;	
	}
	public ArrayList<Sachbean> Tim(String key) throws Exception{
    	ArrayList<Sachbean> tam= new ArrayList<Sachbean>();
    	ArrayList<Sachbean> ds=getSach();
    	for(Sachbean s: ds)
    		if(s.getTensach().toLowerCase().trim().contains(key.toLowerCase().trim()) ||
    				s.getTacgia().toLowerCase().trim().contains(key.toLowerCase().trim()))
    			tam.add(s);
    	return tam;
    }
	public Long Dem(String maloai) throws Exception{
    	Long d=(long)0;
    	ArrayList<Sachbean> ds=getSach();
    	for(Sachbean s: ds)
    		if(s.getMaloai().equals(maloai))
    			d++;
    	return d;
    }
	public void addsach(String masach,String tensach,String tacgia,long gia,long soluong,String anh,String maloai) throws Exception {
		sdao.addSach(masach, tensach, tacgia, gia, soluong, anh, maloai);
	}
	public void editSach(String masach,String tensach,String tacgia,long gia,long soluong,Timestamp ngaynhap,String anh,String maloai) throws Exception {
		sdao.editSach(masach, tensach, tacgia, gia, soluong, ngaynhap, anh, maloai);
	}
	public void deleteSach(String masach) throws Exception {
		sdao.deleteSach(masach);
	}
}