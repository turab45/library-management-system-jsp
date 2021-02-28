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

<body style="font-family: Lora, serif;background-color: #fff;">
    <ul class="nav flex-column d-flex sidebar mobile-hid" style="background-color: rgb(31,40,81);">
        <li class="nav-item logo-holder">
            <div class="text-center text-white logo py-4 mx-4"><label style="font-family: Lora, serif;">MyLib</label><a class="text-white float-right" id="sidebarToggleHolder" href="#"><i class="fas fa-bars" id="sidebarToggle"></i></a></div>
        </li>
        <li class="nav-item"></li>
        <li class="nav-item"><a class="nav-link text-left text-white py-1 px-0" href="index.html"><i class="fa fa-dashboard mx-3"></i><i class="fa fa-caret-right d-none position-absolute"></i><span class="text-nowrap mx-2">Dashboard</span></a></li>
        <li class="nav-item"></li>
        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-left text-white py-1 px-0 position-relative" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-users mx-3"></i><span class="text-nowrap mx-2">Students</span><i class="fas fa-caret-down float-none float-lg-right fa-sm"></i></a>
            <div
                class="dropdown-menu border-0 animated fadeIn" role="menu"><a class="dropdown-item text-white" role="presentation" href="add-student.html">Add Student</a><a class="dropdown-item text-white" role="presentation" href="view-students.html">View Students</a></div>
        </li>
        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-left text-white py-1 px-0 position-relative" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-book mx-3"></i><span class="text-nowrap mx-2">Books</span><i class="fas fa-caret-down float-none float-lg-right fa-sm"></i></a>
            <div
                class="dropdown-menu border-0 animated fadeIn" role="menu"><a class="dropdown-item text-white" role="presentation" href="#">Add Book</a><a class="dropdown-item text-white" role="presentation" href="view-books.html"><span>View Books</span></a><a class="dropdown-item text-white" role="presentation"
                    href="#"><span>Issue Book</span></a></div>
        </li>
        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-left text-white py-1 px-0 position-relative" data-toggle="dropdown" aria-expanded="false" href="#"><i class="far fa-list-alt mx-3"></i><span class="text-nowrap mx-2">Category</span><i class="fas fa-caret-down float-none float-lg-right fa-sm"></i></a>
            <div
                class="dropdown-menu border-0 animated fadeIn" role="menu"><a class="dropdown-item text-white" role="presentation" href="add-category.html">Add Category</a><a class="dropdown-item text-white" role="presentation" href="view-category.html">View Categories</a></div>
        </li>
        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-left text-white py-1 px-0 position-relative" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-user-cog mx-3"></i><span class="text-nowrap mx-2">Permissions</span><i class="fas fa-caret-down float-none float-lg-right fa-sm"></i></a>
            <div
                class="dropdown-menu border-0 animated fadeIn" role="menu"><a class="dropdown-item text-white" role="presentation" href="add-permission.html">Add Permission</a><a class="dropdown-item text-white" role="presentation" href="view-permissions.html">View Permission</a><a class="dropdown-item text-white"
                    role="presentation" href="#">Assign Permission</a></div>
        </li>
        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-left text-white py-1 px-0 position-relative" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-sliders-h mx-3"></i><span class="text-nowrap mx-2">Settings</span><i class="fas fa-caret-down float-none float-lg-right fa-sm"></i></a>
            <div
                class="dropdown-menu border-0 animated fadeIn" role="menu"><a class="dropdown-item text-white" role="presentation" href="#"><span>My Profile</span></a></div>
        </li>
        <li class="nav-item"><a class="nav-link text-left text-white py-1 px-0" href="#"><i class="fas fa-sign-out-alt mx-3"></i><i class="fa fa-caret-right d-none position-absolute"></i><span class="text-nowrap mx-2">Log out</span></a></li>
    </ul>
    <div class="article-clean">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-xl-8 offset-lg-1 offset-xl-2">
                    <div class="intro"></div>
                    <form>
                        <div class="form-row profile-row">
                            <div class="col-md-8">
                                <h1 class="text-center" style="color: rgb(31,40,81);">Category</h1>
                                <hr style="background-color: rgb(31,40,81);">
                                <div class="form-group"><label style="color: rgb(31,40,81);font-size: 16px;font-weight: bold;">Category</label><input class="form-control" type="text" style="border-color: rgb(31,40,81);"></div>
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
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/Profile-Edit-Form.js"></script>
    <script src="assets/js/sidebar.js"></script>
    <script src="assets/js/Table-With-Search.js"></script>
</body>

</html>