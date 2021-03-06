<%@ page import="java.util.*" %>
<%@ page import="bean.FacultyBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<%
List<FacultyBean> StudentList = (List<FacultyBean>)session.getAttribute("StudentList");
int count=0;
%>
<body>
<div style="margin-left:25px;margin-top:50px;border:1px solid;
		padding:6px;background:#415677;width:450px;
		color:white;font-size:18px;border-top-right-radius:10em;">First Month Attendance</div>
		<hr style="margin-left:26px;margin-top:-2px;border-color:#415677;width:1050px;">
<form action="FirstMonthAttendance" method="post">
<div style="background-color:#a2b3c4;
	display: inline-block;
	padding:5px 5px;
	width:240px;
	height:30px;
	font-size:14px;margin-top:15px;margin-left:200px;padding-left:40px;">Total Classes Happened</div>
	<input type="text" style="margin-left:30px;width:300px;height:32px;" name="totalClasses">
<table class="table table-striped" style="margin-top:20px;width:850px;margin-left:100px;">
<thead>
      <tr>
        <th style="padding-left:170px;">Student Id</th>
        <th>Attendance </th>
      </tr>
    </thead>
  <tbody>
<%
for(FacultyBean bean : StudentList){
	%>
	<tr>
	<td style="padding-left:200px;">
	<%=bean.getStudentId() %>
	</td>
	<td><input type="text" name="<%=bean.getStudentId()%>"></td>
	</tr>	
	<%
	count++;
}
%>

</tbody>
</table>
<input type="hidden" name="size" value=<%=count %>>
<input type="submit" style="margin-left:500px;margin-top:25px;margin-bottom: 10px;" class="btn btn-info" value="Submit Attendance">
</form>
</body>
</html>