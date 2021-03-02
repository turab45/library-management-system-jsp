<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Books</title>
     <%@ include file="links.jsp" %> 
</head>

<body style="margin: -20px 0px;background-color: #fff;">
    <%@ include file="navbar.jsp" %>  
    <div class="article-clean" style="background-color: #fff;">
        <div class="container" style="background-color: #fff;">
            <div class="intro">
                <h1 class="text-center" style="color: rgb(31,40,81);font-weight: bold;">Books</h1>
                <p class="text-center"> </p>
            </div>
            <div class="table-responsive shadow" style="background-color: #fff;">
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
                        <tr>
                            <td style="color: rgb(14,16,18);">Cell 1</td>
                            <td style="color: rgb(14,16,18);">Cell 2</td>
                            <td style="color: rgb(14,16,18);">Cell 2</td>
                            <td style="color: rgb(14,16,18);">Cell 2</td>
                            <td style="color: rgb(14,16,18);">Cell 2</td>
                            <td style="width: 36px;"><a href="#" style="text-decoration: none;font-weight: bold;"><i class="fas fa-edit"></i></a></td>
                            <td style="width: 36px;height: 49px;"><a href="#" style="/*text-decoration: none;*//*background-color: red;*//*color: rgb(221,16,16);*//*border: 1px solid;*//*border-radius: 5px;*//*width: 12px;*//*height: 20px;*/color: red;font-weight: bold;"></a><a href="#" style="text-decoration: none;font-weight: bold;"><i class="material-icons" style="width: 11;height: 13;color: rgb(255,19,34);">delete</i></a></td>
                        </tr>
                        <tr></tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
     <%@ include file="scripts.jsp" %> 
</body>

</html>