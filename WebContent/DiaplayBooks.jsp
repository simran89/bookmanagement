<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
     <%@ page import="java.sql.ResultSet" %>
     <%@ page import="com.samle.biz.Book" %>
      <%@ page import="com.sample.jdbc.DBConnection" %>
     <%@ page import="com.sample.jdbc.UsersTable" %>
     <%@ page import ="java.sql.Connection" %>
          <%@ page import ="java.util.Iterator" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href = "StyleSheet.css"/>
</head>
<body>
<div id ="Header">
<center>
<h2>Welcome to our Public Library</h2>
</center>
</div>
<%
Connection conn  = DBConnection.getDBConnection("mysql");

List<Book> books =UsersTable.getUsersByRecord(conn);

System.out.println("Size of "+books.size()+" Books");


%>


<div class ="middle">

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<table >

<tr>
	<th> BookName</th>
	<th> BookId</th>
	<th> Author</th>
	<th> publisher</th>
	<th> Edition</th>
	<th> InvoiceNo</th>
	<th> Invoicedate</th>
	<th> cost</th>
	<th>e </th>
</tr>
<%  
Iterator<Book> it = books.iterator();
Book b;
while(it.hasNext())
{
	 b = it.next();
	System.out.println(b.getBookid());
System.out.println(b.getBooktitle());
System.out.println(b.getPublisher());
%>
<tr>
	<td><%= b.getBookid()%> </td>
	<td><%= b.getBooktitle()%> </td>
	<td><%= b.getPublisher()%> </td>
	<td><%= b.getAuthorname()%> </td>
	<td><%= b.getEdition() %> </td>
	<td><%= b.getInvoiceNo()%> </td>
	<td><%= b.getInvoicedate()%> </td>
	<td><%= b.getCost()%></td>
	 <td> <a href="update.jsp?id=<%= b.getBookid()%>">Update</a> </td>
     <td> <a href="del.jsp?id=<%= b.getBookid()%>">Delete</a> </TD>
      
</tr>
<% }%>
</table>

</div>
</body>
</html>