<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page using Jsp</title>
</head>
<body>
<% 
List <String> li= (List<String>)request.getAttribute("errors");
if(li!=null){
Iterator<String> itr=li.iterator();
%>
<ul>
<% while(itr.hasNext()){
%>
<li> <%=itr.next() %></li>
<% } %>
</ul>
<% } %>



<form action="RegisterCont" method="post">
Name <input type="text" name="name"><br><br>
Age <input type="text" name="age" value="0"><br><br>
Gender <br> 
<input type="radio" name="gender" value="female"> Female<br>

<input type="radio" name="gender" value="male"> Male<br><br>
Address<textarea rows="3" cols="7" name="address"></textarea><br><br>
<input type="submit" value="submit">

</form>
</body>
</html>