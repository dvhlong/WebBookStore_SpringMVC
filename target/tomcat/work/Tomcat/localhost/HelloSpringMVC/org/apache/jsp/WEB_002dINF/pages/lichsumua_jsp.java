/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-11-27 23:20:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.o7planning.hellospringmvc.bean.Giohangbean;
import org.o7planning.hellospringmvc.bo.Giohangbo;
import org.o7planning.hellospringmvc.bo.lichsubo;
import org.o7planning.hellospringmvc.bo.Loaibo;
import org.o7planning.hellospringmvc.bo.Sachbo;
import java.util.ArrayList;
import org.o7planning.hellospringmvc.bean.Sachbean;
import org.o7planning.hellospringmvc.bean.Loaibean;
import org.o7planning.hellospringmvc.bean.Khachhangbean;

public final class lichsumua_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style>\r\n");
      out.write(".c{\r\n");
      out.write("\tborder: 1px solid black;\r\n");
      out.write("\tbackground-color: #8EE0F2;\r\n");
      out.write("}\r\n");
      out.write("th{\r\n");
      out.write("\tborder: 1px solid black;\r\n");
      out.write("\tbackground-color: #D1DC4E;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\t\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("  ");

  request.setCharacterEncoding("utf-8");
  response.setCharacterEncoding("utf-8");
  ArrayList<Sachbean> dssach=(ArrayList<Sachbean>)request.getAttribute("dssach");
  ArrayList<Loaibean> dsloai=(ArrayList<Loaibean>)request.getAttribute("dsloai");
  Khachhangbean kh= (Khachhangbean)session.getAttribute("kh");
  
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-inverse\">\r\n");
      out.write("  <div class=\"container-fluid\">\r\n");
      out.write("    <ul class=\"nav navbar-nav\">\r\n");
      out.write("      <li class=\"active\"><a href=\"htsach\">Trang chủ</a></li>\r\n");
      out.write("      <li><a ");
if(kh==null){
      out.write(" href=\"#\" data-toggle=\"modal\" data-target=\"#myModal\" ");
 }else {
      out.write(" href=\"themgh\" ");
} 
      out.write(">Giỏ hàng</a></li>\r\n");
      out.write("      <li><a ");
if(kh==null){
      out.write(" href=\"#\" data-toggle=\"modal\" data-target=\"#myModal\" ");
 }else {
      out.write(" href=\"thanhtoan\" ");
} 
      out.write(">Thanh Toán</a></li>\r\n");
      out.write("      <li><a ");
if(kh==null){
      out.write(" href=\"#\" data-toggle=\"modal\" data-target=\"#myModal\" ");
 }else {
      out.write(" href=\"lichsu\" ");
} 
      out.write(">Lịch sử mua hàng</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("    <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("      <li>\r\n");
      out.write("      ");

     
      
      if(kh!=null){
    
      out.write("\r\n");
      out.write("      <a href=\"#\">Xin chào: ");
      out.print(kh.getHoten());
      out.write(" </a>\r\n");
      out.write("      <li><a href=\"logout\"> Đăng xuất</a></li>\r\n");
      out.write("      ");
} else { 
      out.write("\r\n");
      out.write("      <a href=\"#\" data-toggle=\"modal\" data-target=\"#myModal\">\r\n");
      out.write("      <span class=\"glyphicon glyphicon-log-in\"></span> Đăng nhập</a></li>\r\n");
      out.write("      <li><a href=\"#\" data-toggle=\"modal\" data-target=\"#myModal2\"><span class=\"glyphicon glyphicon-user\"></span> Đăng ký</a></li>\r\n");
      out.write("      ");
if(session.getAttribute("tb")!=null){
   	   out.print("<script>alert('"+session.getAttribute("tb")+"');</script>" );
			}
      	}
     
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <!-- Modal -->\r\n");
      out.write("  <div class=\"modal fade\" id=\"myModal\" role=\"dialog\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("    \r\n");
      out.write("      <!-- Modal content-->\r\n");
      out.write("      <form action=\"login\" method=post>\r\n");
      out.write("      <div class=\"modal-content\">\r\n");
      out.write("        <div class=\"modal-header\">\r\n");
      out.write("          <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("          <h4 class=\"modal-title\">Đăng nhập</h4>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"modal-body\">\r\n");
      out.write("        <b><label >Username:</label><br></b>\r\n");
      out.write("    \t<input type=\"text\" name=\"txtun\"><br>\r\n");
      out.write("    \t<b><label>Pasword:</label><br></b>\r\n");
      out.write("    \t<input type=\"password\" name=\"txtpw\"><br>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"modal-footer\">\r\n");
      out.write("        \t<input type=\"submit\" name=\"button\" value=\"Dang Nhap\"><hr>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("</div>\r\n");
      out.write("    <div class=\"modal fade\" id=\"myModal2\" role=\"dialog\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("    \r\n");
      out.write("      <!-- Modal content-->\r\n");
      out.write("      <div class=\"modal-content\">\r\n");
      out.write("        <div class=\"modal-header\">\r\n");
      out.write("          <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("          <h4 class=\"modal-title\">Đăng ký</h4>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"modal-body\">\r\n");
      out.write("    \t<table>\r\n");
      out.write("    \t\t<tr>\r\n");
      out.write("    \t\t\t<td >\r\n");
      out.write("    \t\t\t<input type=\"Text\" placeholder=\"Nhập username\"><br>\r\n");
      out.write("    \t\t\t<input type=\"Password\" placeholder=\"Nhập Mật khẩu\"><br>\r\n");
      out.write("    \t\t\t<input type=\"Password\" placeholder=\"Nhập lại mật khẩu\"><br>\r\n");
      out.write("    \t\t\t<input type=\"Text\" placeholder=\"Nhập địa chỉ email\"><br>\r\n");
      out.write("    \t\t\t<input type=\"Text\" placeholder=\"Nhập lại địa chỉ email\"><br>\r\n");
      out.write("    \t\t\t</td>\r\n");
      out.write("    \t\t\t<td>\r\n");
      out.write("    \t\t\t<input type=\"Text\" placeholder=\"Nhập Họ và tên\"><br>\r\n");
      out.write("    \t\t\t<select><option selected>Giới tính</option></select><br>\r\n");
      out.write("    \t\t\t<select><option selected>Ngày Sinh</option></select>\r\n");
      out.write("    \t\t\t<select><option selected>Tháng</option></select>\r\n");
      out.write("    \t\t\t<select><option selected>Năm</option></select><br>\r\n");
      out.write("    \t\t\t<select><option selected>Tỉnh/TP</option></select><br>\r\n");
      out.write("    \t\t\t<input type=\"Text\" placeholder=\"Nhập Mã xác nhận\">\r\n");
      out.write("    \t\t\t</td>\r\n");
      out.write("    \t\t</tr>\r\n");
      out.write("    \t</table>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"modal-footer\">\r\n");
      out.write("          <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Đăng ký</button>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("  <table width=\"1000\" align=\"center\">\r\n");
      out.write("     \r\n");
      out.write("     <tr>\r\n");
      out.write("\t\t<td width=\"200\" valign=\"top\">\r\n");
      out.write("             <table class=\"table table-hover\">\r\n");
      out.write("                ");
for(Loaibean L:dsloai){ 
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><a href=\"htsach?ml=");
      out.print(L.getMaloai());
      out.write('"');
      out.write('>');
      out.print(L.getTenloai() );
      out.write("</a> </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");
} 
      out.write("\r\n");
      out.write("             </table>\r\n");
      out.write("         </td>\r\n");
      out.write(" \t\t <td width=\"600\" valign=\"top\">\r\n");
      out.write(" \t\t <table class=\"table table-hover\">\t \r\n");
      out.write(" \t\t \t");

 		 		lichsubo ls1=(lichsubo)session.getAttribute("ls");
 		 		if(ls1!=null){
 		 		for(Giohangbo ghbo1: ls1.ghbols)
 		 		if(ghbo1.ds.size()!=0){
 		 	
      out.write("\r\n");
      out.write(" \t\t \t<tr>\r\n");
      out.write(" \t\t \t\t<td colspan=\"5\" style=\"border:1px solid black\">Ngày mua: ");
      out.print(ghbo1.timebuy );
      out.write("</td>\r\n");
      out.write(" \t\t \t</tr>\r\n");
      out.write(" \t\t \t<tr>\r\n");
      out.write("\t\t\t\t<th>Tên sách</th>\r\n");
      out.write("\t\t\t\t<th>Tác giả</th>\r\n");
      out.write("\t\t\t\t<th>Giá</th>\r\n");
      out.write("\t\t\t\t<th>Số lượng mua</th>\r\n");
      out.write("\t\t\t\t<th>Thành tiền </th>\r\n");
      out.write(" \t\t \t</tr>\r\n");
      out.write(" \t\t \t");
	
 		 		for(Giohangbean g: ghbo1.ds) {
 		 	
      out.write("\r\n");
      out.write(" \t\t \t\r\n");
      out.write(" \t\t \t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"c\">");
      out.print(g.getTensach() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"c\">");
      out.print(g.getTacgia() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"c\">");
      out.print(g.getGia() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"c\">");
      out.print(g.getSlmua() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class=\"c\">");
      out.print(g.getThanhtien() );
      out.write(" </td>\r\n");
      out.write(" \t\t \t</tr>\r\n");
      out.write(" \t\t \t");
} 
      out.write("\r\n");
      out.write(" \t\t \t\r\n");
      out.write(" \t\t \t<tr>\r\n");
      out.write(" \t\t \t\t<td colspan=\"5\" style=\"text-align: right;border:1px solid black\">Tổng tiền: ");
      out.print(ghbo1.Tongtien() );
      out.write(" VND</td>\r\n");
      out.write(" \t\t \t</tr>\r\n");
      out.write(" \t\t \t<tr><td colspan=\"5\"></td> </tr>\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td style=\"text-align:right;color:red;font-weight:bold\" colspan=\"5\">Tổng tiền chi: ");
      out.print(ls1.getTongtienchi() );
      out.write(" VND</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("        \r\n");
      out.write("        </td>\r\n");
      out.write("          <td width=\"200\" valign=\"top\">\r\n");
      out.write("         \r\n");
      out.write("          \t<form action=\"htsach\" method=\"post\">\r\n");
      out.write("          \t<table>\r\n");
      out.write("          \t<tr>\r\n");
      out.write("             \t <td><input type=\"text\" name=\"key\" placeholder=\"Nhập từ khóa\"></td>\r\n");
      out.write("             \t <td><button type=\"submit\" name=\"sendkey\"><i class=\"fa fa-search\"></i></button></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("    \t\t </table>\r\n");
      out.write("    \t\t</form>\r\n");
      out.write("           \r\n");
      out.write("         </td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     \r\n");
      out.write("  </table>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}