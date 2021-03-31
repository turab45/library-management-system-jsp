<%@page import="java.util.List"%>
<%@page import="daoimpl.CategoryDaoImpl"%>
<%@page import="dao.CategoryDao"%>
<%@page import="daoimpl.BookDaoImpl"%>
<%@page import="dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="models.*"%>

    
    
    <%
    
   BookDao bookDaoImpl = new BookDaoImpl();
   CategoryDao categoryDaoImpl = new CategoryDaoImpl();
   List<Book> allBooks = bookDaoImpl.getAllBook();
    
 session = request.getSession();
 User user = (User) session.getAttribute("user");
 
 String action = "issue";
 
 if(user != null){
 %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Issue Book</title>
    <%@ include file="links.jsp" %>
</head>

<body style="font-family: Lora, serif;background-color: #fff;">
    <%@ include file="navbar.jsp" %>  
    <div class="article-clean">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-xl-8 offset-lg-1 offset-xl-2">
                    <div class="intro"></div>
                    <form action="Book?action=<%=action%>" method="post">
                        <div class="form-row profile-row">
                            <div class="col-md-8">
                                <h1 class="text-center" style="color: rgb(31,40,81);">Issue Book</h1>
                                <hr style="background-color: rgb(31,40,81);">
                                <div class="form-group"><label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">Book Id</label><input name="book-id" class="form-control" type="number" style="border-color: rgb(31,40,81);"></div>
                                <div class="form-group"><label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">Student Id</label><input name="student-id" class="form-control" type="number" style="border-color: rgb(31,40,81);"></div>
                                <hr style="background-color: #fff;">
                                <div class="form-row">
                                    <div class="col-md-12 content-right"><button class="btn btn-primary form-btn" type="submit" style="background-color: rgb(31,40,81);border-color: rgb(31,40,81);">ISSUE</button><button class="btn btn-danger form-btn" type="reset" style="background-color: rgb(31,40,81);border-color: rgb(31,40,81);">CANCEL </button></div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <div style="margin-top: 20px"></div>
                    
                </div>
            </div>
        </div>
        <div style="margin: 20px">
        <center><h1>Books</h1></center>
        <% if (allBooks.size() > 0) {%>
            
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th style="color: rgb(31,40,81);font-size: 18px;font-family: Lora, serif;">ID</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Title</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Author</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">Category</th>
                            <th style="color: rgb(31,40,81);font-size: 18px;">No of Copies</th>
                            <th class="text-center" colspan="2" style="color: rgb(31,40,81);font-size: 18px;">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%for(Book book: allBooks){
                    	Category c = categoryDaoImpl.getCategoryById(book.getCategory().getId());
                    	%>
                    
                        <tr>
                            <td style="color: rgb(14,16,18);"><%=book.getId() %></td>
                            <td style="color: rgb(14,16,18);"><%=book.getTitle() %></td>
                            <td style="color: rgb(14,16,18);"><%=book.getAuthor() %></td>
                            <td style="color: rgb(14,16,18);"><%=c.getCategory() %></td>
                            <td style="color: rgb(14,16,18);"><%=book.getNoOfCopies()%></td>
                             <% // Book?id=<%=book.getId() && action=<%="update" %>
                            <td style="width: 36px;"><a href="edit-book.jsp?id=<%=book.getId()%>" style="text-decoration: none;font-weight: bold;"><i class="fas fa-edit"></i></a></td>
                            <td style="width: 36px;height: 49px;"><a href="Book?id=<%=book.getId()%>&&action=<%=action %>" style="color: red;font-weight: bold;"></a><a href="Book?id=<%=book.getId()%>&&action=<%=action %>" style="text-decoration: none;font-weight: bold;"><i class="material-icons" style="width: 11;height: 13;color: rgb(255,19,34);">delete</i></a></td>
                        </tr>
                        <tr></tr>
                        <%} %>
                    </tbody>
                </table>
            
            <%} else{ %>
            
            	<center><h1>No Books</h1></center>
            <%} %>
        </div>
    </div>
     <%@ include file="scripts.jsp" %> 
</body>
<%}else{
	response.sendRedirect("login.jsp");
}%>
</html>