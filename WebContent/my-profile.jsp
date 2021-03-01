<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>libraray-design</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/material-icons.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="assets/css/Article-Clean.css">
    <link rel="stylesheet" href="assets/css/Bootstrap-4---Table-Fixed-Header.css">
    <link rel="stylesheet" href="assets/css/Features-Boxed.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Dark.css">
    <link rel="stylesheet" href="assets/css/Profile-Edit-Form-1.css">
    <link rel="stylesheet" href="assets/css/Profile-Edit-Form.css">
    <link rel="stylesheet" href="assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="assets/css/sidebar.css">
    <link rel="stylesheet" href="assets/css/Table-With-Search-1.css">
    <link rel="stylesheet" href="assets/css/Table-With-Search.css">
</head>

<body>
    <%@ include file="navbar.jsp" %>  
    <div class="article-clean">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-xl-8 offset-lg-1 offset-xl-2">
                    <div class="intro"></div>
                    <form>
                        <div class="form-row profile-row">
                            <div class="col-md-8">
                                <h1 class="text-center" style="color: rgb(31,40,81);">My Profile</h1>
                                <hr style="background-color: rgb(31,40,81);">
                                <div class="form-row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group"><label style="color: rgb(31,40,81);font-weight: bold;font-size: 16px;">First Name </label><input class="form-control" type="text" name="firstname" style="border-color: rgb(31,40,81);color: rgb(31,40,81);font-size: 14px;"
                                                readonly=""></div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="form-group"><label style="color: rgb(31,40,81);font-weight: bold;font-size: 16px;">Last Name </label><input class="form-control" type="text" name="lastname" style="border-color: rgb(31,40,81);color: rgb(31,40,81);font-size: 14px;"
                                                readonly=""></div>
                                    </div>
                                </div>
                                <div class="form-group"><label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">Email </label><input class="form-control" type="email" autocomplete="off" required="" name="email" style="border-color: rgb(31,40,81);color: rgb(31,40,81);font-size: 14px;"
                                        autofocus="" readonly=""></div>
                                <div class="form-group"><label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">Password</label><input class="form-control" type="email" autocomplete="off" required="" name="email" style="border-color: rgb(31,40,81);color: rgb(31,40,81);font-size: 14px;"
                                        autofocus="" readonly=""></div>
                                <hr style="background-color: rgb(31,40,81);">
                                <div class="form-row">
                                    <div class="col-md-12 content-right"><a class="btn btn-primary form-btn" role="button" href="update-profile.html" style="background-color: rgb(31,40,81);border-color: rgb(31,40,81);">UPDATE</a><button class="btn btn-danger form-btn" type="reset" style="background-color: rgb(31,40,81);border-color: rgb(31,40,81);">CANCEL </button></div>
                                </div>
                            </div>
                        </div>
                    </form>
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