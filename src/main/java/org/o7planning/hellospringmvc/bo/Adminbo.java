package org.o7planning.hellospringmvc.bo;

import org.o7planning.hellospringmvc.dao.Admindao;

public class Adminbo {
	public boolean ktdnAdmin(String un, String pass) throws Exception {
		Admindao addao=new Admindao();
		return addao.ktdnadmin(un, pass);
	}
	public void add(String un,String pass, String repass) throws Exception {
		Admindao addao=new Admindao();
		addao.add(un, pass, repass);
	}
}
