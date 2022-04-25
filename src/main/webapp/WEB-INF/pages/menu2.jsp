<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@	page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
    import="org.o7planning.hellospringmvc.bo.Loaibo"
    import="org.o7planning.hellospringmvc.bo.Sachbo"
    import="org.o7planning.hellospringmvc.bean.Sachbean"
    import="org.o7planning.hellospringmvc.bean.Loaibean"
    import="org.o7planning.hellospringmvc.bean.Khachhangbean"
	import="java.util.ArrayList"%>

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
  <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
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
      <!-- dung JSTL -->
      <li>
      <c:choose>
         <c:when test="${sessionScope.kh!=null }">
         <li><a href="#">Xin chào:${sessionScope.kh.getHoten() }</a></li>
         <li><a href="logout"> Đăng xuất</a></li>
        </c:when>
          <c:otherwise>
                 <li><a href="#" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li>
		         <li><a href="#" data-toggle="modal" data-target="#myModal2"><span class="glyphicon glyphicon-user"></span> Đăng ký</a></li>
		           <c:if test="${sessionScope.tb!=null }">
		           		<script>alert('Dang nhap sai');</script>
		           </c:if>
  	      </c:otherwise>
        </c:choose> 
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
        	<input type="submit" name="button" value="Đăng nhập" class="btn btn-default"><hr>
        </div>
      </div>
      </form>
    </div>
  </div>
  
</div>
    <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <form action="register" method=post>
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Đăng ký</h4>
        </div>
        <div class="modal-body">
    	<table>
    		 <tr style="height:40px">
                                <td> Họ tên khách hàng:</td>
                                <td>
                                    <input id="HotenKH" name="HotenKH" type="text" value="">

                                </td>
                            </tr>
                            <tr style="height:40px">
                                <td> Tên đăng nhập:</td>
                                <td>
                                    <input id="TenDN" name="TenDN" type="text" value="">
                                </td>
                            </tr>
                            <tr style="height:40px">
                                <td>  Mật khẩu:</td>
                                <td>
                                    <input id="Matkhau" name="Matkhau" type="password">
                                </td>
                            </tr>
                            <tr style="height:40px">
                                <td>Mật khẩu nhập lại: </td>
                                <td>
                                    <input id="Matkhaunhatrlai" name="Matkhaunhatrlai" type="password">
                                </td>
                            </tr>
                            <tr style="height:40px">
                                <td> Email:</td>
                                <td>
                                    <input id="Email" name="Email" type="text" value="">
                                </td>
                            </tr>
                            <tr style="height:40px">
                                <td> Địa chỉ:</td>
                                <td>
                                    <input id="Diachi" name="Diachi" type="text" value="">
                                </td>
                            </tr>
                            <tr style="height:40px">
                                <td>Điện thoại:</td>
                                <td>
                                    <input id="Dienthoai" name="Dienthoai" type="text" value="">
                                </td>
                            </tr>
    	</table>
        </div>
        <div class="modal-footer">
          <input type="submit" class="btn btn-default" value="Đăng ký" name="rbutton">
        </div>
      </div>
      </form>
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
          <table class="table table-hover">
          
          <%
          		int n=dssach.size();
          		for (int i=0;i<n;i++){
        	  		Sachbean s=dssach.get(i);%>
        	  <tr>
        	  	<td>
        	  		<img src="<%=s.getAnh() %>"><br>
        	  		<a <%if(kh==null){%> href="#" data-toggle="modal" data-target="#myModal" <% }else {%> href="themgh?ms=<%=s.getMasach()%>&ts=<%=s.getTensach()%>&tg=<%=s.getTacgia()%>&gia=<%=s.getGia()%>" <%} %>> <img src="buynow.jpg"> </a> <br>
        	  		<%=s.getTensach() %><br>
        	  		Tác Giả: <%=s.getTacgia() %><br>
        	  		Giá: <%=s.getGia() %> VND <br>
        	  		
        	  	</td>
        	  		<%i++;
            	    if(i<n){
            	    	s=dssach.get(i);
            	    %>
            	    <td>
            	        <img src="<%=s.getAnh() %>"><br>
            	        <a <%if(kh==null){%> href="#" data-toggle="modal" data-target="#myModal" <% }else {%> href="themgh?ms=<%=s.getMasach()%>&ts=<%=s.getTensach()%>&tg=<%=s.getTacgia()%>&gia=<%=s.getGia()%>" <%} %>> <img src="buynow.jpg"> </a> <br>
            	        <%=s.getTensach() %> <br>
            	        Tác giả: <%=s.getTacgia() %> <br>
            	      	Giá: <%=s.getGia() %> <br>  
            	    </td>
            	    <%} %>
        	  </tr>
          <%} %>
          </table>
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