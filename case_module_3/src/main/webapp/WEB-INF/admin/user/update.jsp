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


                    <div class="container-fluid" style="margin-top: 25px">
                    <div class="content">
                        <!-- Navbar End -->
                        <c:if test="${!requestScope.errors.isEmpty()&&requestScope.errors!=null }">
                            <c:forEach items="${requestScope.errors}" var="item">
                                <div class="alert alert-warning" role="alert">
                                    <div class="alert alert-danger alert-dismissible" role="alert">
                                        <button class="close" type="button" data-dismiss="alert"
                                                aria-label="Close"><span
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
                                    <strong><i class="fa-solid fa-ban"></i></strong>
                                        ${requestScope.message}
                                </div>
                            </div>
                        </c:if>


                        <div class="row">


                            <div class="col-md-8">
                                <div class="card card-user">
                                    <div class="card-header">
                                        <h4 class="card-title">Chỉnh sửa tài khoản: ${user.getUsername()}</h4>
                                    </div>
                                    <div class="card-body">
                                        <form>
                                            <div class="row">
                                                <div class="col-md-5 pr-1">
                                                    <div class="form-group">
                                                        <img src="${user.getImg()}" alt=""
                                                             style="width: 70px;height: 70px">
                                                    </div>
                                                </div>
                                                <div class="col-md-3 px-1">
                                                    <div class="form-group">
                                                        <label>Mật khẩu</label>
                                                        <input type="password" class="form-control" name="pass"
                                                               value="${user.getPassword()}">
                                                    </div>
                                                </div>
                                                <div class="col-md-3 px-1">
                                                    <div class="form-group">
                                                        <label>Giới tính</label>
                                                        <select>
                                                            <c:forEach items="${applicationScope.listGenders}" var="genders">
                                                                <option value="${genders.getId()}">
                                                                        ${genders.getName()}
                                                                </option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-4 pl-1">
                                                    <div class="form-group">
                                                        <label>Ngày sinh</label>
                                                        <input type="date" class="form-control" name="birthday"
                                                               value="${user.getBirthday()}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6 pr-1">
                                                    <div class="form-group">
                                                        <label>Họ và tên</label>
                                                        <input type="text" class="form-control" name="fullName"
                                                               value="${user.getFullName()}">
                                                    </div>
                                                </div>
                                                <div class="col-md-6 pl-1">
                                                    <div class="form-group">
                                                        <label>Email</label>
                                                        <input type="email" class="form-control" name="email"
                                                               value="${user.getEmail()}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group">
                                                        <label>Hình ảnh</label>
                                                        <input type="url" class="form-control" name="img"
                                                               value="${user.getImg()}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4 pr-1">
                                                    <div class="form-group">
                                                        <label>Số điện Thoại</label>
                                                        <input type="text" class="form-control" name="phone"
                                                               value="${user.getPhone()}">
                                                    </div>
                                                </div>
                                                <div class="col-md-4 px-1">
                                                    <div class="form-group">
                                                        <label>Thành phố</label>
                                                        <select>
                                                            <c:forEach items="${applicationScope.listCountry}" var="country">
                                                                <option value="${country.getId()}">
                                                                        ${country.getName()}
                                                                </option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row col-md-7">
                                                <div class="update ml-auto mr-auto" style="float: left">
                                                    <button type="submit" class="btn btn-primary btn-round">Lưu</button>
                                                </div>
                                                <div class="update ml-auto mr-auto" style="float: right">
                                                    <button type="submit" class="btn btn-primary btn-round"><a
                                                            href="/users">Hủy</a></button>
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
