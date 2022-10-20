<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Tạo tài khoản</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="Responsive bootstrap 4 admin template" name="description">
    <meta content="Coderthemes" name="author">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <style>
        sup{
            color: red;
        }
    </style>
    <jsp:include page="/WEB-INF/layout/meta_css.jsp"></jsp:include>
</head>

<body>

<!-- Begin page -->
<div id="wrapper">


    <!-- Topbar Start -->
    <jsp:include page="/WEB-INF/layout/navbar-custom.jsp"></jsp:include>
    <!-- end Topbar -->

    <!-- ========== Left Sidebar Start ========== -->
    <jsp:include page="/WEB-INF/layout/left-side-menu.jsp"></jsp:include>

    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid" style="margin-top: 25px">

                <div class="row">
                    <c:if test="${!requestScope.errors.isEmpty()&&requestScope.errors!=null }">
                        <c:forEach items="${requestScope.errors}" var="item">
                            <div class="alert alert-warning" role="alert">
                                <div class="alert alert-danger alert-dismissible" role="alert">
                                    <button class="close" type="button" data-dismiss="alert" aria-label="Close"><span
                                            class="mdi mdi-close" aria-hidden="true"></span></button>
                                    <div class="icon"><span class="mdi mdi-close-circle-o"></span></div>
                                    <div class="message">
                                        <span>Error!</span>
                                            ${item}
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>


                    <c:if test="${requestScope.message!=null}">
                        <div class="alert alert-success alert-dismissible" role="alert">
                            <button class="close" type="button" data-dismiss="alert" aria-label="Close"><span
                                    class="mdi mdi-close" aria-hidden="true"></span></button>
                            <div class="icon"><span class="mdi mdi-check"></span></div>
                            <div class="message">
                                <strong><i class="fa-brands fa-creative-commons-nd"></i></strong>
                                    ${requestScope.message}
                            </div>
                        </div>
                    </c:if>

                    <div class="row">


                    <div class="col-md-8">
                        <div class="card card-user">
                            <div class="card-header">
                                <h5 class="card-title">Đăng ký tài khoản mới</h5>
                            </div>
                            <div class="card-body">
                                <form>
                                    <div class="row">
                                        <div class="col-md-4 pr-1">
                                            <div class="form-group">
                                                <label>Tài khoản <sup>*</sup></label>
                                                <input type="text" class="form-control" name="username">
                                            </div>
                                        </div>
                                        <div class="col-md-4 px-1">
                                            <div class="form-group">
                                                <label>Mật khẩu <sup>*</sup></label>
                                                <input type="password" class="form-control"  name="pass">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 pr-1">
                                            <div class="form-group">
                                                <label>Họ và tên <sup>*</sup></label>
                                                <input type="text" class="form-control" name="fullName">
                                            </div>
                                        </div>
                                        <div class="col-md-6 pl-1">
                                            <div class="form-group">
                                                <label>Email <sup>*</sup></label>
                                                <input type="email" class="form-control" name="email">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Link hình đại diện </label>
                                                <input type="url" class="form-control" name="img">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4 pr-1">
                                            <div class="form-group">
                                                <label>Số điện thoại <sup>*</sup></label>
                                                <input type="text" class="form-control" name="phone">
                                            </div>
                                        </div>
                                        <div class="col-md-4 px-1">
                                            <div class="form-group">
                                                <label>Thành phố <sup>*</sup></label>
                                                <select>
                                                    <c:forEach items="${applicationScope.listCountry}" var="country">
                                                        <option value="${country.getId()}">
                                                                ${country.getName()}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-4 pl-1">
                                            <div class="form-group">
                                                <label>Ngày sinh <sup>*</sup></label>
                                                <input type="date" class="form-control" name="birthday">
                                            </div>
                                        </div>
                                        <div class="col-md-4 pl-1">
                                            <div class="form-group">
                                                <label>Giới tính <sup>*</sup></label>
                                                <select>
                                                    <c:forEach items="${applicationScope.listGenders}" var="genders">
                                                        <option value="${genders.getId()}">
                                                            ${genders.getName()}
                                                        </option>
                                                    </c:forEach>
                                                </select>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="row col-md-7">
                                        <div class="update ml-auto mr-auto" style="float: left">
                                            <button type="submit" class="btn btn-primary btn-round">Tạo tài khoản</button>
                                        </div>
                                        <div class="update ml-auto mr-auto" style="float: right">
                                            <button type="submit" class="btn btn-primary btn-round"><a href="/users">Hủy</a></button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>





                </div>

            </div>

        </div>
    </div>
</div>
<footer class="footer">
    <div class="container-fluid">
    </div>
</footer>


<jsp:include page="/WEB-INF/layout/script.jsp"></jsp:include>

</body>

</html>
