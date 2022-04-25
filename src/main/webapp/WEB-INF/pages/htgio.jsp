<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="org.o7planning.hellospringmvc.bo.Giohangbo"%>
<%@page import="org.o7planning.hellospringmvc.bean.Giohangbean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="org.o7planning.hellospringmvc.bo.Loaibo"
    import="org.o7planning.hellospringmvc.bo.Sachbo"
    import="java.util.ArrayList"
    import="org.o7planning.hellospringmvc.bean.Sachbean"
    import="org.o7planning.hellospringmvc.bean.Loaibean"
    import="org.o7planning.hellospringmvc.bean.Khachhangbean"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">	
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<fmt:requestEncoding value="UTF-8" />
  <%
  request.setCharacterEncoding("utf-8");
  response.setCharacterEncoding("utf-8");
  ArrayList<Sachbean> dssach=(ArrayList<Sachbean>)request.getAttribute("dssach");
  ArrayList<Loaibean> dsloai=(ArrayList<Loaibean>)request.getAttribute("dsloai");
  Khachhangbean kh= (Khachhangbean)session.getAttribute("kh");
  %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li class="active"><a href="htsach">Trang chủ</a></li>
      <li><a <%if(kh==null){%> href="#" data-toggle="modal" data-target="#myModal" <% }else {%> href="themgh" <%} %>>Giỏ hàng</a></li>
      <li><a <%if(kh==null){%> href="#" data-toggle="modal" data-target="#myModal" <% }else {%> href="thanhtoan" <%} %>>Thanh Toán</a></li>
      <li><a <%if(kh==null){%> href="#" data-toggle="modal" data-target="#myModal" <% }else {%> href="lichsu" <%} %>>Lịch sử mua hàng</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li>
      <%
     
      
      if(kh!=null){
    %>
      <a href="#">Xin chào: <%=kh.getHoten()%> </a>
      <li><a href="logoutController"> Đăng xuất</a></li>
      <%} else { %>
      <a href="#" data-toggle="modal" data-target="#myModal">
      <span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li>
      <li><a href="#" data-toggle="modal" data-target="#myModal2"><span class="glyphicon glyphicon-user"></span> Đăng ký</a></li>
      <%if(session.getAttribute("tb")!=null){
   	   out.print("<script>alert('"+session.getAttribute("tb")+"');</script>" );
			}
      	}
     %>
    </ul>
  </div>
</nav>
<div class="container">


  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <form action="login" method=post>
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Đăng nhập</h4>
        </div>
        <div class="modal-body">
        <b><label >Username:</label><br></b>
    	<input type="text" name="txtun"><br>
    	<b><label>Pasword:</label><br></b>
    	<input type="password" name="txtpw"><br>
        </div>
        <div class="modal-footer">
        	<input type="submit" name="button" value="Dang Nhap"><hr>
        </div>
      </div>
      </form>
    </div>
  </div>
  
</div>
    <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Đăng ký</h4>
        </div>
        <div class="modal-body">
    	<table>
    		<tr>
    			<td >
    			<input type="Text" placeholder="Nhập username"><br>
    			<input type="Password" placeholder="Nhập Mật khẩu"><br>
    			<input type="Password" placeholder="Nhập lại mật khẩu"><br>
    			<input type="Text" placeholder="Nhập địa chỉ email"><br>
    			<input type="Text" placeholder="Nhập lại địa chỉ email"><br>
    			</td>
    			<td>
    			<input type="Text" placeholder="Nhập Họ và tên"><br>
    			<select><option selected>Giới tính</option></select><br>
    			<select><option selected>Ngày Sinh</option></select>
    			<select><option selected>Tháng</option></select>
    			<select><option selected>Năm</option></select><br>
    			<select><option selected>Tỉnh/TP</option></select><br>
    			<input type="Text" placeholder="Nhập Mã xác nhận">
    			</td>
    		</tr>
    	</table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Đăng ký</button>
        </div>
      </div>
      
    </div>
  </div>
 

  <table width="1000" align="center">
     
     <tr>
		<td width="200" valign="top">
             <table class="table table-hover">
                <%for(Loaibean L:dsloai){ %>
                    <tr>
                        <td><a href="htsach?ml=<%=L.getMaloai()%>"><%=L.getTenloai() %></a> </td>
                    </tr>
                    <%} %>
             </table>
         </td>
 		<td width="600" valign="top">
 		  <% Giohangbo gh1=(Giohangbo)session.getAttribute("gh");
				if (gh1!=null){ %>
          <table class="table table-hover">
        
           <%		
				     
				     for(Giohangbean g: gh1.ds){%>
				     <form method="post" action="suagh?ms=<%=g.getMasach()%>">
				     	<tr>
				     	<td><%=g.getMasach() %></td>
				     	<td><%=g.getTensach() %></td>
				     	<td><%=g.getTacgia() %></td>
				     	<td><%=g.getGia() %></td>
				     	<td><%=g.getSlmua() %></td>
				     	<td><input name="txtsl" type="number">
				               <button name="butsua" type="submit" class="btn-link" value="sua">
				                  Sửa
				                </button>
				           </td>
				            <td><%=g.getThanhtien() %> </td>
				             <td>
				              <button name="butxoa" type="submit" class="btn-link" value="xoa">
				                  Xóa
				                </button>
				              </td>
				       </tr>
				       </form>
				       <%} %>
				       
				       
          </table>
          Tong tien= <%=gh1.Tongtien() %>
          <%} %>
          <form method="post" action="thanhtoan">
			<input type="submit" class="btn btn-default" value="Thanh toán" name="buysubmit" style="right:40%;position:absolute">
			</form>
         </td>
         <td width="200" valign="top">
         
          	<form action="htsach" method="post">
          	<table>
          	<tr>
             	 <td><input type="text" name="key" placeholder="Nhập từ khóa"></td>
             	 <td><button type="submit" name="sendkey"><i class="fa fa-search"></i></button></td>
            </tr>
    		 </table>
    		</form>
           
         </td>
     </tr>
     
  </table>

</body>
</html>