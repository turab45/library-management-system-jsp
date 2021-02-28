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

<body style="margin: -20px 0px;background-color: #fff;">
    <ul class="nav flex-column d-flex sidebar mobile-hid" style="background-color: rgb(31,40,81);">
        <li class="nav-item logo-holder">
            <div class="text-center text-white logo py-4 mx-4"><label style="font-family: Lora, serif;">MyLib</label><a class="text-white float-right" id="sidebarToggleHolder" href="#"><i class="fas fa-bars" id="sidebarToggle"></i></a></div>
        </li>
        <li class="nav-item"></li>
        <li class="nav-item"></li>
        <li class="nav-item"><a class="nav-link text-left text-white py-1 px-0" href="index.html"><i class="fa fa-dashboard mx-3"></i><i class="fa fa-caret-right d-none position-absolute"></i><span class="text-nowrap mx-2">Dashboard</span></a></li>
        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-left text-white py-1 px-0 position-relative" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-users mx-3"></i><span class="text-nowrap mx-2">Students</span><i class="fas fa-caret-down float-none float-lg-right fa-sm"></i></a>
            <div
                class="dropdown-menu border-0 animated fadeIn" role="menu"><a class="dropdown-item text-white" role="presentation" href="add-student.html" style="font-family: Lora, serif;">Add Student</a><a class="dropdown-item text-white" role="presentation" href="#">View Students</a></div>
        </li>
        <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-left text-white py-1 px-0 position-relative" data-toggle="dropdown" aria-expanded="false" href="#"><i class="fas fa-book mx-3"></i><span class="text-nowrap mx-2">Books</span><i class="fas fa-caret-down float-none float-lg-right fa-sm"></i></a>
            <div
                class="dropdown-menu border-0 animated fadeIn" role="menu"><a class="dropdown-item text-white" role="presentation" href="add-book.html">Add Book</a><a class="dropdown-item text-white" role="presentation" href="#"><span>View Books</span></a><a class="dropdown-item text-white" role="presentation" href="#"><span>Issue Book</span></a></div>
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
                class="dropdown-menu border-0 animated fadeIn" role="menu"><a class="dropdown-item text-white" role="presentation" href="profile.html"><span>My Profile</span></a></div>
        </li>
        <li class="nav-item"><a class="nav-link text-left text-white py-1 px-0" href="#"><i class="fas fa-sign-out-alt mx-3"></i><i class="fa fa-caret-right d-none position-absolute"></i><span class="text-nowrap mx-2">Log out</span></a></li>
    </ul>
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
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/Profile-Edit-Form.js"></script>
    <script src="assets/js/sidebar.js"></script>
    <script src="assets/js/Table-With-Search.js"></script>
</body>

</html>