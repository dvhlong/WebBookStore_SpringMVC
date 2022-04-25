package org.o7planning.hellospringmvc.controller;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.o7planning.hellospringmvc.bean.Khachhangbean;
import org.o7planning.hellospringmvc.bean.Loaibean;
import org.o7planning.hellospringmvc.bean.Sachbean;
import org.o7planning.hellospringmvc.bo.Adminbo;
import org.o7planning.hellospringmvc.bo.Hoadonbo;
import org.o7planning.hellospringmvc.bo.Khachhangbo;
import org.o7planning.hellospringmvc.bo.Loaibo;
import org.o7planning.hellospringmvc.bo.Sachbo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import nl.captcha.Captcha;



@Controller
public class BanSach_Admin_Controller {
	
	@RequestMapping("/htadmin")
	public ModelAndView htadmin(Model model,HttpServletRequest request,HttpServletResponse response) {	
		return new ModelAndView("admin");
	}
	
	@RequestMapping("/loginadmin")
	public String login(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	  	response.setCharacterEncoding("utf-8");
	  	Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
		String un=request.getParameter("txtun"); 
		String pass=request.getParameter("txtpw");
		String answer = request.getParameter("answer");
	  	Adminbo adbo=new Adminbo();
	  	long dem;
	  	if(session.getAttribute("showcapt")==null){
	  		dem=0;
	  		session.setAttribute("showcapt", dem);//=Integer.parseInt( (String) session.getAttribute("showcapt"));
	  	}
	  	dem=(Long) session.getAttribute("showcapt");
	  	try {
	  		request.setCharacterEncoding("utf-8");
	  	if(adbo.ktdnAdmin(un, pass)) {
	  		if(dem>=3) {
	  		if(!captcha.isCorrect(answer)) {
	  			dem++;
	  			session.setAttribute("showcapt", dem);
	  			session.setAttribute("tbad", "Capcha sai");
	  			return "redirect:htadmin";
	  		} else {
	  			dem=0;
				session.setAttribute("showcapt", dem);
				session.setAttribute("adun", un);
				return "redirect:htadmin";
	  		}
	  		} else {
	  		dem=0;
			session.setAttribute("showcapt", dem);
			session.setAttribute("adun", un);
			return "redirect:htadmin";
	  		}
	  	}else {
	  		dem++;
	  		session.setAttribute("showcapt", dem);
	  		session.setAttribute("tbad", "Dang nhap sai");
	  		return "redirect:htadmin";
	  	}
	  	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	return "redirect:htadmin";
	}

	@RequestMapping("/logoutadmin")
	public String logout(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		session.setAttribute("adun", null);
		session.setAttribute("tbad", null);
		return "redirect:htadmin";
	}
	
	@RequestMapping("/registeradmin")
	public String register(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	  	response.setCharacterEncoding("utf-8");
		String un=request.getParameter("TenDN");
		String pass=request.getParameter("Matkhau");
		String repass=request.getParameter("Matkhaunhaplai");
		Adminbo adbo=new Adminbo();
		try {
			request.setCharacterEncoding("utf-8");
			adbo.add(un, pass, repass);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:htadmin";
	}
	
	@RequestMapping("/qlsach")
	public ModelAndView qlsach(Model model,HttpServletRequest request,HttpServletResponse response) {
	  	response.setCharacterEncoding("utf-8");
	  	Sachbo sbo=new Sachbo();
	  	ArrayList<Sachbean> dssach;
	  	Loaibo lbo=new Loaibo();
	  	ArrayList<Loaibean> dsloai;
	  	try {
	  		request.setCharacterEncoding("utf-8");
			dssach=sbo.getSach();
			model.addAttribute("dssach", dssach);
			dsloai=lbo.getloai();
			model.addAttribute("dsloai", dsloai);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	  	return new ModelAndView("qlsach_admin");
	}

	@RequestMapping("/addsach")
	public String addsach(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		
	  	response.setCharacterEncoding("utf-8");
	  	 DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		 String anh="";
		 String masach="";
		 String tensach="";
		 String tacgia="";
		 String maloai="";
		 long gia=0;
		 long soluong=0;
		 try {
			 request.setCharacterEncoding("utf-8");
			 List<FileItem> fItems = upload.parseRequest(request);
			 for(FileItem fItem:fItems) {
				 if(!fItem.isFormField()) {
					 String nameimg = new File(fItem.getName()).getName();
					 anh="image_sach"+File.separator+nameimg;
					 if(!nameimg.equals("")) {
						 //String dirUrl = request.getServletContext().getRealPath("")+"image_sach";
						 //System.out.println(dirUrl);
						 //File dir=new File(dirUrl);
						 //if(!dir.exists()) 
							 //dir.mkdir();
						 //File file=new File(dirUrl+File.separator+nameimg);
						 try {
							 //fItem.write(new File("D:\\Download\\JAVA\\JAVAEE\\JavaEE_Nhom4\\WebContent\\image_sach"+File.separator+nameimg));
							 fItem.write(new File("D:\\Download\\JAVA\\JAVAEE-2\\HelloSpringMVC\\src\\main\\webapp\\image_sach"+File.separator+nameimg));
							 System.out.println("UPLOAD THÀNH CÔNG...!");
				             //System.out.println("Đường dẫn lưu file là: "+dirUrl);
						 } catch (Exception e) {
							// TODO: handle exception
							 e.printStackTrace();
						 }
					 }
				 } else {
					 String ten=fItem.getFieldName();
					 if(ten.equals("masach"))
						 masach=fItem.getString("utf-8");
					 if(ten.equals("tensach"))
						 tensach=fItem.getString("utf-8");
					 if(ten.equals("tacgia"))
						 tacgia=fItem.getString("utf-8");
					 if(ten.equals("maloai"))
						 maloai=fItem.getString();
					 if(ten.equals("gia"))
						 gia=Long.parseLong(fItem.getString());
					 if(ten.equals("soluong"))
						 soluong=Long.parseLong(fItem.getString());
					 
				 }
			 }
		} catch (FileUploadException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
		 System.out.println(masach+tensach+tacgia+maloai);
		 try {
			 Sachbo sbo=new Sachbo();
			 sbo.addsach(masach, tensach, tacgia, gia, soluong, anh, maloai);
		 } catch (Exception e) {
				// TODO: handle exception
			}
		return "redirect:qlsach";
	}

	@RequestMapping("/editsach")
	public String editsach(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		
	  	response.setCharacterEncoding("utf-8");
	  	String ms=request.getParameter("ms");
	  	DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String anh="";
		String tensach="";
		String tacgia="";
		String maloai="";
		long gia=0;
		long soluong=0;
		int bt=0;
		Timestamp ngaynhap = null;
		try {
			request.setCharacterEncoding("utf-8");
			 List<FileItem> fItems = upload.parseRequest(request);
			 for(FileItem fItem:fItems) {
				 if(!fItem.isFormField()) {
					 String nameimg = new File(fItem.getName()).getName();
					 anh="image_sach"+File.separator+nameimg;
					 if(!nameimg.equals("")) {
						 try {
							 //fItem.write(new File("D:\\Download\\JAVA\\JAVAEE\\JavaEE_Nhom4\\WebContent\\image_sach"+File.separator+nameimg));
							 fItem.write(new File("D:\\Download\\JAVA\\JAVAEE-2\\HelloSpringMVC\\src\\main\\webapp\\image_sach"+File.separator+nameimg));
							 System.out.println("UPLOAD THÀNH CÔNG...!");
				             //System.out.println("Đường dẫn lưu file là: "+dirUrl);
						 } catch (Exception e) {
							// TODO: handle exception
							 e.printStackTrace();
						 }
					 }
				 } else {
					 String ten=fItem.getFieldName();
					 if(ten.equals("tensach"))
						 tensach=fItem.getString("utf-8");
					 if(ten.equals("tacgia"))
						 tacgia=fItem.getString("utf-8");
					 if(ten.equals("maloai"))
						 maloai=fItem.getString();
					 if(ten.equals("gia"))
						 gia=Long.parseLong(fItem.getString());
					 if(ten.equals("soluong"))
						 soluong=Long.parseLong(fItem.getString());
					 if(ten.equals("ngaynhap"))
						 ngaynhap=Timestamp.valueOf(fItem.getString());
					 if(ten.equals("butsua"))
						 bt=1;
					 if(ten.equals("butxoa"))
						 bt=2;
				 }
			 }
		} catch (FileUploadException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	  	try {
			Sachbo sbo=new Sachbo();
			if(ms!=null) {
				if(bt==1) {
					sbo.editSach(ms, tensach, tacgia, gia, soluong, ngaynhap, anh, maloai);
				}
				if(bt==2) {
					sbo.deleteSach(ms);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	  	return "redirect:qlsach";
	}

	@RequestMapping("/qlloai")
	public ModelAndView qlloai(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		
	  	response.setCharacterEncoding("utf-8");
	  	Loaibo lbo=new Loaibo();
	  	ArrayList<Loaibean> dsloai;
	  	try {
	  		request.setCharacterEncoding("utf-8");
			dsloai=lbo.getloai();
			request.setAttribute("dsloai", dsloai);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	  	return new ModelAndView("qlloai_admin");
	}

	@RequestMapping("/addloai")
	public String addloai(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	  	response.setCharacterEncoding("utf-8");
	  	String maloai=request.getParameter("maloai");
	  	String tenloai=request.getParameter("tenloai");
	  	try {
	  		request.setCharacterEncoding("utf-8");
			Loaibo lbo=new Loaibo();
			lbo.addloai(maloai, tenloai);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	  	return "redirect:qlloai";
	}

	@RequestMapping("/editloai")
	public String editloai(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	  	response.setCharacterEncoding("utf-8");
		String ml=request.getParameter("ml");
		String tenloai=request.getParameter("tenloai");
		try {
			request.setCharacterEncoding("utf-8");
			Loaibo lbo = new Loaibo();
			if(ml!=null) {
				if(!tenloai.equals(""))
				if(request.getParameter("butsua")!=null) {
					lbo.editloai(ml, tenloai);
				}
				if(request.getParameter("butxoa")!=null) {
					lbo.deleteloai(ml);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:qlloai";
	}

	@RequestMapping("/qlkh")
	public ModelAndView qlkh(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {	
	  	response.setCharacterEncoding("utf-8");
	  	Khachhangbo khbo=new Khachhangbo();
	  	ArrayList<Khachhangbean> khls;
		try {
			request.setCharacterEncoding("utf-8");
			khls = khbo.getKhachHang();
			request.setAttribute("khls", khls);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	return new ModelAndView("qlkh_admin");
	}

	@RequestMapping("/qlhd")
	public ModelAndView qlhd(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	  	response.setCharacterEncoding("utf-8");
	  	try {
	  		request.setCharacterEncoding("utf-8");
	  		ArrayList<Hoadonbo> hdbols=new ArrayList<Hoadonbo>();
		  	Hoadonbo hdbo=new Hoadonbo();
		  	hdbo.getdata(hdbols);
		  	request.setAttribute("dshd", hdbols);
	  	} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	  	return new ModelAndView("qlhd_admin");
	}

	@RequestMapping("/xacnhanhd")
	public String xacnhanhd(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	  	response.setCharacterEncoding("utf-8");
	  	String mahd=request.getParameter("hd");
	  	String ms=request.getParameter("ms");
	  	Hoadonbo hdbo=new Hoadonbo();
	  	
	  	try {
	  		request.setCharacterEncoding("utf-8");
			if(mahd!=null&&ms!=null) {
				System.out.println(mahd+" "+ms);
				System.out.println("Xac nhan chi tiet hoa don");
				hdbo.xacnhancthd(Long.parseLong(mahd), ms);
			}
			if(mahd!=null&&ms==null) {
				System.out.println(mahd);
				System.out.println("Xac nhan hoa don");
				hdbo.xacnhanhd(Long.parseLong(mahd));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	  	return "redirect:qlhd";
	}

	@RequestMapping("/xoahd")
	public String xoahd(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		String mahd=request.getParameter("hd");
	  	Hoadonbo hdbo=new Hoadonbo();
	  	if (mahd!=null) 
	  		try {
				hdbo.xoahd(Long.parseLong(mahd));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	  	return "redirect:qlhd";
	}
}
