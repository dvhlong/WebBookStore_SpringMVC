package org.o7planning.hellospringmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o7planning.hellospringmvc.bean.Giohangbean;
import org.o7planning.hellospringmvc.bean.Khachhangbean;
import org.o7planning.hellospringmvc.bean.Loaibean;
import org.o7planning.hellospringmvc.bean.Sachbean;
import org.o7planning.hellospringmvc.bo.Giohangbo;
import org.o7planning.hellospringmvc.bo.Khachhangbo;
import org.o7planning.hellospringmvc.bo.Loaibo;
import org.o7planning.hellospringmvc.bo.Sachbo;
import org.o7planning.hellospringmvc.bo.lichsubo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BanSach_Home_Controller {
	
	@RequestMapping("/htsach")
	public ModelAndView htsach(Model model,HttpServletRequest request,HttpServletResponse response) {
		try {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		Loaibo loai=new Loaibo();
	  	Sachbo sbo=new Sachbo();
		String ml=request.getParameter("ml");
	    String key=request.getParameter("key");
		
	  	ArrayList<Loaibean> dsloai;
			dsloai = loai.getloai();
	  	ArrayList<Sachbean> dssach=sbo.getSach();
	    if(ml!=null)
	   	 dssach=sbo.timMaLoai(ml);
	    else
	   	 if(key!=null)
	   		 dssach=sbo.Tim(key);
	    request.setAttribute("dsloai", dsloai);
	    request.setAttribute("dssach", dssach);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return new ModelAndView("menu2");		
	}
	
	@RequestMapping("/login")
	public String login(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		String un=request.getParameter("txtun");
		String pass=request.getParameter("txtpw");
		Khachhangbo khbo=new Khachhangbo();
		
		Khachhangbean kh;
		try {
			kh = khbo.ktdn(un, pass);
		if(kh!=null){
    	 session.setAttribute("kh", kh);
    	 session.setAttribute("tb", null);
		}else{
    	 session.setAttribute("tb", "Dang nhap sai");
		}
			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return "redirect:htsach";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		session.setAttribute("kh", null);
		session.setAttribute("tb", null);
		return "redirect:htsach";
	}
	
	@RequestMapping("/register")
	public String register(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		
	  	response.setCharacterEncoding("utf-8");
		String name=request.getParameter("HotenKH");
		String un=request.getParameter("TenDN");
		String pass=request.getParameter("Matkhau");
		String repass=request.getParameter("Matkhaunhatrlai");
		String email=request.getParameter("Email");
		String address=request.getParameter("Diachi");
		String phone=request.getParameter("Dienthoai");
		Khachhangbo khbo=new Khachhangbo();
		System.out.print(name);
		try {
			request.setCharacterEncoding("utf-8");
			khbo.add(name, address, phone, email, un, pass, repass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:htsach";
	}
	
	@RequestMapping("/themgh")
	public ModelAndView themgh(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	  	response.setCharacterEncoding("utf-8");
	  	Loaibo loai=new Loaibo();
	  	Sachbo sbo=new Sachbo();
	  	ArrayList<Loaibean> dsloai;
		try {
			
			dsloai = loai.getloai();
	  	ArrayList<Sachbean> dssach=sbo.getSach();
	  	String ml=request.getParameter("ml");
	    String key=request.getParameter("key");
	    if(ml!=null)
	   	 dssach=sbo.timMaLoai(ml);
	    else
	   	 if(key!=null)
	   		 dssach=sbo.Tim(key);
	    request.setAttribute("dsloai", dsloai);
	    request.setAttribute("dssach", dssach);
		String masach=request.getParameter("ms");
		String tensach=request.getParameter("ts");
		String tacgia=request.getParameter("tg");
		String giatam=request.getParameter("gia");
	

		if (masach!=null){
		//Tao cho 1 giohang khi dat mua quyen sach dau tien
		Giohangbo gh=null;
		if(session.getAttribute("gh")==null){
			gh=new Giohangbo();
			session.setAttribute("gh", gh);
		}
		//b1:gan session vao bien
		gh=(Giohangbo)session.getAttribute("gh");
		gh.Them(masach, tensach, tacgia, Long.parseLong(giatam), (long)1);
		session.setAttribute("gh", gh);
		}
		//request.setAttribute("gh", gh);
		 
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("htgio");
	}
	
	@RequestMapping("/suagh")
	public String suagh(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		String ms=request.getParameter("ms");
		try {
			long sl=Long.parseLong(request.getParameter("txtsl"));
			if(ms!=null){
				Giohangbo gh=(Giohangbo)session.getAttribute("gh");
				if(request.getParameter("butxoa")!=null)
					gh.Xoa(ms);
				if(request.getParameter("butsua")!=null){
				for(Giohangbean g:gh.ds)
					if(g.getMasach().equals(ms))
					if(g.getSlmua()+sl<=0)
						break;
					else	{
						gh.Them(ms,"", "", (long)0,sl);
						break;
					}
				}
				session.setAttribute("gh", gh);
				return "redirect:themgh";
				}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			if(ms!=null){
				Giohangbo gh=(Giohangbo)session.getAttribute("gh");
				if(request.getParameter("butxoa")!=null)
					gh.Xoa(ms);
				
				session.setAttribute("gh", gh);
				return "redirect:themgh";
				}
		}
		return "redirect:themgh";
	}
		
	@RequestMapping("/thanhtoan")
	public String thanhtoan(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		try {
			if(session.getAttribute("gh")!=null) {
				Giohangbo gh=(Giohangbo)session.getAttribute("gh");
				Khachhangbean kh=(Khachhangbean)session.getAttribute("kh");
				gh.addHD(gh, kh);
				session.setAttribute("gh", null);
				
			}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		return "redirect:themgh";
	}
	
	@RequestMapping("/lichsu")
	public ModelAndView lichsu(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	
	  	response.setCharacterEncoding("utf-8");
	  	Loaibo loai=new Loaibo();
	  	Sachbo sbo=new Sachbo();
	  	ArrayList<Loaibean> dsloai;
		try {
			request.setCharacterEncoding("utf-8");
			lichsubo lsbo=null;
		 	dsloai = loai.getloai();
		  	ArrayList<Sachbean> dssach=sbo.getSach();
		  	String ml=request.getParameter("ml");
		    String key=request.getParameter("key");
		    if(ml!=null)
		   	 dssach=sbo.timMaLoai(ml);
		    else
		   	 if(key!=null)
		   		 dssach=sbo.Tim(key);
		    request.setAttribute("dsloai", dsloai);
		    request.setAttribute("dssach", dssach);
				lsbo=new lichsubo();
				lsbo.kh=(Khachhangbean)session.getAttribute("kh");
				lsbo.getData();
				session.setAttribute("ls", lsbo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("lichsumua");
	}
}
