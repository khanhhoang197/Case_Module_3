<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/layout/header.jsp"></jsp:include>
<jsp:include page="/layout/left.jsp"></jsp:include>
<div class="breadcrumb">
    <div class="container">
        <div class="breadcrumb-inner">
            <ul class="list-inline list-unstyled">
                <li><a href="home.html">Home</a></li>
                <li class='active'>Đăng ký</li>
            </ul>
        </div><!-- /.breadcrumb-inner -->
    </div><!-- /.container -->
</div>
<!-- /.breadcrumb -->

<div class="col-md-3">

</div>
<div class="body-content">
    <div class="container">
        <div class="sign-in-page">
            <div class="row">
                <!-- Sign-in -->
                <div class="col-md-6 col-sm-6 sign-in">
                    <h4 class="">Đăng nhập</h4>
                    <form class="register-form outer-top-xs" role="form">
                        <div class="form-group">
                            <label class="info-title" for="exampleInputEmail1">Tài khoản <span>*</span></label>
                            <input type="email" class="form-control unicase-form-control text-input"
                                   id="exampleInputEmail1">
                        </div>
                        <div class="form-group">
                            <label class="info-title" for="exampleInputPassword1">Mật khẩu<span>*</span></label>
                            <input type="password" class="form-control unicase-form-control text-input"
                                   id="exampleInputPassword1">
                        </div>
                        <div class="radio outer-xs">
                            <label>
                                <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">Ghi nhớ
                                đăng nhập!
                            </label>
                            <a href="#" class="forgot-password pull-right">Quên mật khẩu</a>
                        </div>
                        <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Đăng nhập</button>
                    </form>
                </div>
<jsp:include page="/layout/footer.jsp"></jsp:include>