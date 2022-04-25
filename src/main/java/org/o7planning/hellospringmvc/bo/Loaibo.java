package org.o7planning.hellospringmvc.bo;

import java.util.ArrayList;

import org.o7planning.hellospringmvc.bean.Loaibean;
import org.o7planning.hellospringmvc.dao.Loaidao;



public class Loaibo {
	Loaidao ldao=new Loaidao();
	public ArrayList<Loaibean> getloai() throws Exception {
		return ldao.getloai();
	}
	public void addloai(String maloai,String tenloai) throws Exception {
		ldao.addloai(maloai, tenloai);
	}
	public void editloai(String maloai,String tenloai) throws Exception {
		ldao.editloai(maloai, tenloai);
	}
	public void deleteloai(String maloai) throws Exception {
		ldao.deleteloai(maloai);
	}
}