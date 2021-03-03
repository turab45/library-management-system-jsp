<%@page import="dao.RoleDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="daoimpl.RoleDaoImpl"%>
<%@page import="dao.RoleDao"%>
<%@page import="models.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Add User</title>
    <%@ include file="links.jsp" %> 
</head>

<%
	RoleDao roleDaoImpl = new RoleDaoImpl();

	List<Role> allRolls  = roleDaoImpl.getAllRole();
%>

<body style="font-family: Lora, serif;background-color: #fff;">
    <%@ include file="navbar.jsp" %> 
    <div class="article-clean">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-xl-8 offset-lg-1 offset-xl-2">
                    <div class="intro"></div>
                    <form method="post" action="User?action='add'">
                        <div class="form-row profile-row">
                            <div class="col-md-8">
                                <h1 class="text-center" style="color: rgb(31,40,81);">User</h1>
                                <hr style="background-color: rgb(31,40,81);">
                                <div class="form-row">
                                    <div class="col"><label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">Name</label><input class="form-control" name="name" type="text" style="border-color: rgb(31,40,81);"></div>
                                </div>
                                <div class="form-group"><label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">Email</label><input class="form-control" name="email" type="email" style="border-color: rgb(31,40,81);"></div>
                                <div class="form-group"><label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">Password</label><input class="form-control" name="password" type="password" style="border-color: rgb(31,40,81);"></div>
                                <div class="form-group">
                                <label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">Role</label>
                                <select name="role" class="custom-select" style="color: rgb(31,40,81);border-color: rgb(31,40,81);">
                                <optgroup label="Select Role">
                                
                                <%for(Role role: allRolls){ %>
                                	<option value="<%=role.getRole() %>" selected=""><%=role.getRole() %></option>
                                
                                <%} %>
                                
                                </optgroup></select></div>
                                <hr style="background-color: #fff;">
                                <div class="form-row">
                                    <div class="col-md-12 content-right"><button class="btn btn-primary form-btn" type="submit" style="background-color: rgb(31,40,81);border-color: rgb(31,40,81);">ADD</button><button class="btn btn-danger form-btn" type="reset" style="background-color: rgb(31,40,81);border-color: rgb(31,40,81);">CANCEL </button></div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="scripts.jsp" %> 
</body>

</html>