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
<div class="col-md-4">
</div>
<!-- create a new account -->
<div class="col-md-4 col-sm-4 create-new-account">
    <h4 class="checkout-subtitle" style="text-align: center ;">Đăng ký tài khoản mới</h4>
    <form class="register-form outer-top-xs" role="form">
        <div class="form-group">
            <div class="form-group">
                <label class="info-title">Họ và tên<span>*</span></label>
                <input type="text" class="form-control unicase-form-control text-input" id="fullName">
            </div>
            <label class="info-title" for="exampleInputEmail2">Tài khoản<span>*</span></label>
            <input type="text" class="form-control unicase-form-control text-input" id="username">
        </div>
        <div class="form-group">
            <label class="info-title" >Mật khẩu <span>*</span></label>
            <input type="password" class="form-control unicase-form-control text-input" id="password">
        </div>
        <div class="form-group">
            <label class="info-title" >Giới tính <span>*</span></label>
            <input type="text" class="form-control unicase-form-control text-input" id="gender">
        </div>
        <div class="form-group">
            <label class="info-title" >Sinh nhật <span>*</span></label>
            <input type="date" class="form-control unicase-form-control text-input" id="bthday">
        </div>
        <div class="form-group">
            <label class="info-title" for="exampleInputEmail2">Email <span>*</span></label>
            <input type="email" class="form-control unicase-form-control text-input" id="exampleInputEmail2">
        </div>
        <div class="form-group">
            <label class="info-title">Nơi ở <span>*</span></label>
            <input type="text" class="form-control unicase-form-control text-input" id="country">
        </div>
        <div class="form-group">
            <label class="info-title">Số điện thoại<span>*</span></label>
            <input type="text" class="form-control unicase-form-control text-input" id="phone">
        </div>
        <button type="submit" class="btn-upper btn btn-primary checkout-page-button">Đăng ký</button>
    </form>
</div>
<jsp:include page="/layout/footer.jsp"></jsp:include>