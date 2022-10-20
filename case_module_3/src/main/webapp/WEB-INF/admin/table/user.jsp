<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Vertical layout | Zircos - Responsive Bootstrap 4 Admin Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="Responsive bootstrap 4 admin template" name="description">
    <meta content="Coderthemes" name="author">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <jsp:include page="/WEB-INF/layout/meta_css.jsp"></jsp:include>

</head>

<body>

<!-- Begin page -->
<div id="wrapper">
    <jsp:include page="/WEB-INF/layout/navbar-custom.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/layout/left-side-menu.jsp"></jsp:include>


    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid">

                <div class="row">
                    <div class="col-md-4">
                        <h1><a href="list.html"></a>Danh sách người dùng</h1>
                    </div>
                    <div class="col-lg-4" >
                        <form method="get" action="/users?action=search" class="app-search">
                            <div class="app-search-box">
                                <div class="input-group">
                                    <input oninput="search(event)" style="border-radius: 20px; width: 220px; float: left" type="text" name="searchUser" class="form-control" placeholder="Search..." value="${requestScope.searchUser}" >
                                    <div class="input-group-append">
                                        <button class="btn " type="submit" style="float: left">
                                            <i class="fas fa-search text-dark"></i>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="col-lg-3 ">
                        <a href="/users?action=create" class="btn btn-primary" style="float: right; margin-top: 30px">Thêm tài khoản mới</a>
                    </div>
                </div>
                <div class="row">
                    <table class="table table-hover">
                        <thead>
                        <tr class="text-darkblue">
                            <th scope="col" class="text-center">Hình đại diện</th>
                            <th scope="col" class="text-center">Tài khoản</th>
                            <th scope="col" class="text-center">Họ và tên</th>
                            <th scope="col" class="text-center">Giới tính</th>
                            <th scope="col" class="text-center">Ngày sinh</th>
                            <th scope="col" class="text-center">Email</th>
                            <th scope="col" class="text-center">Số điện thoại</th>
                            <th scope="col" class="text-center">Địa chỉ</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listUser}" var="item">
                            <tr>
                                <td class="text-center"><img src="${item.img}" alt="" style="width: 60px;height: 60px"></td>
                                <td class="text-center"><a href="/users?action=update&username=${item.username}">${item.username}</a></td>
                                <td class="text-center">${item.fullName}</td>
                                <td class="text-center">
                                    <c:forEach items="${applicationScope.listGenders}" var="gender">
                                        <c:if test="${gender.getId()==item.getGender()}">
                                            ${gender.getName()}
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td class="text-center">${item.birthday}</td>
                                <td class="text-center">${item.email}</td>
                                <td class="text-center">${item.phone}</td>
                                <td class="text-center">
                                    <c:forEach items="${applicationScope.listCountry}" var="country">
                                        <c:if test="${country.getId()==item.getCountry()}">
                                            ${country.getName()}
                                        </c:if>
                                    </c:forEach>
                                </td>


                                <td class="text-center">
                                    <button type="button" class="btn btn-warning"><i class="far fa-trash-alt"></i><a onclick="showMessager(${item.username})">Xóa</a>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        <script>
                            function showMessager(username) {
                                if (confirm("Bạn có muốn xóa tài khoản này không?") === true) {
                                    window.location.href = "/users?action=delete&username=" + username;
                                }
                            }
                        </script>
                        </tbody>
                    </table>
                </div>

            </div>

        </div>
        <footer class="footer">
            <div class="container-fluid">
            </div>
        </footer>

    </div>

    <jsp:include page="/WEB-INF/layout/script.jsp"></jsp:include>

</body>

</html>
