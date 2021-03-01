<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home</title>
    <%@ include file="links.jsp" %>  
</head>

<body style="background-color: #fff;">
<%@ include file="navbar.jsp" %>  
    <div></div>
    <div class="features-boxed" style="background-color: #fff;">
        <div class="container" style="background-color: #fff;">
            <div class="intro">
                <h2 class="text-center">Features </h2>
                <p class="text-center">Nunc luctus in metus eget fringilla. Aliquam sed justo ligula. Vestibulum nibh erat, pellentesque ut laoreet vitae.</p>
            </div>
            <div class="row justify-content-center features" style="background-color: #fff;">
                <div class="col-sm-6 col-md-5 col-lg-4 item" style="background-color: #fff;">
                    <div class="box" style="background-color: rgb(31,40,81);/*border-radius: 1px solid;*/border-radius: 30px;"><i class="fas fa-users icon" style="color: #fff;"></i>
                        <h3 class="name" style="color: #fff;">Students</h3>
                        <h3 class="name" style="color: #fff;">68</h3>
                    </div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box" style="background-color: rgb(31,40,81);"><i class="fa fa-book icon" style="color: #fff;"></i>
                        <h3 class="name" style="color: #fff;">Books</h3>
                        <h3 class="name" style="color: #fff;">90</h3>
                    </div>
                </div>
                <div class="col-sm-6 col-md-5 col-lg-4 item">
                    <div class="box" style="background-color: rgb(31,40,81);"><i class="fa fa-list-alt icon" style="color: #fff;"></i>
                        <h3 class="name" style="color: #fff;">Issued Books</h3>
                        <h3 class="name" style="color: #fff;">34</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/Profile-Edit-Form.js"></script>
    <script src="assets/js/sidebar.js"></script>
    <script src="assets/js/Table-With-Search.js"></script>
</body>

</html>