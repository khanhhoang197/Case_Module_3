<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="header-style-1">

    <!-- ============================================== TOP MENU ============================================== -->
    <div class="top-bar animate-dropdown">
        <div class="container">
            <div class="header-top-inner">
                <div class="cnt-account">
                    <ul class="list-unstyled">
                        <li><a href="#"><i class="icon fa fa-user"></i>Thông tin tài khoản</a></li>
                        <li><a href="#"><i class="icon fa fa-shopping-cart"></i>Giỏ hàng</a></li>
                        <li><a href="#"><i class="icon fa fa-lock"></i>Đăng nhập</a></li>
                    </ul>
                </div>
                <!-- /.cnt-account -->

                <div class="cnt-block">
                    <ul class="list-unstyled list-inline">
                        <li class="dropdown dropdown-small"> <a href="#" class="dropdown-toggle" data-hover="dropdown"
                                                                data-toggle="dropdown"><span class="value">VNĐ </span><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">VNĐ</a></li>
                                <li><a href="#">USD</a></li>
                            </ul>
                        </li>
                        <li class="dropdown dropdown-small"> <a href="#" class="dropdown-toggle" data-hover="dropdown"
                                                                data-toggle="dropdown"><span class="value">Tiếng Việt </span><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Tiếng Việt</a></li>
                                <li><a href="#">English</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!-- /.list-unstyled -->
                </div>
                <!-- /.cnt-cart -->
                <div class="clearfix"></div>
            </div>
            <!-- /.header-top-inner -->
        </div>
        <!-- /.container -->
    </div>
    <!-- /.header-top -->
    <!-- ============================================== TOP MENU : END ============================================== -->
    <div class="main-header">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-2 logo-holder">
                    <!-- ============================================================= LOGO ============================================================= -->
                    <div class="logo"> <a href="index.jsp">
                        <img src="assets\images\logo.png" alt="logo"> </a>
                        <!-- <img src="https://photo2.tinhte.vn/data/attachment-files/2021/07/5557920_CV.jpg" alt="logo" style="width:250px; height: 80px;"> </a>  -->
                    </div>
                    <!-- /.logo -->
                    <!-- ============================================================= LOGO : END ============================================================= -->
                </div>
                <!-- /.logo-holder -->
                <div class="col-xs-12 col-sm-12 col-md-6 top-search-holder">
                    <!-- /.contact-row -->
                    <!-- ============================================================= SEARCH AREA ============================================================= -->
                    <div class="search-area">
                        <form>
                            <div class="control-group" >
                                <ul class="categories-filter animate-dropdown">
                                </ul>
                                <input class="search-field" placeholder="Tìm kiếm..." >
                                <a class="search-button" href="#"></a>
                            </div>
                        </form>
                    </div>
                    <!-- /.search-area -->
                    <!-- ============================================================= SEARCH AREA : END ============================================================= -->
                </div>
                <!-- /.top-search-holder -->

                <div class="col-xs-12 col-sm-12 col-md-4 animate-dropdown top-cart-row">
                    <!-- ============================================================= SHOPPING CART DROPDOWN ============================================================= -->

                    <div class="dropdown dropdown-cart"> <a href="#" class="dropdown-toggle lnk-cart" data-toggle="dropdown">
                        <div class="items-cart-inner">
                            <div class="basket"> <i class="glyphicon glyphicon-shopping-cart"></i> </div>
                            <div class="basket-item-count"><span class="count">2</span></div>
                            <div class="total-price-basket"> <span class="lbl">Giỏ hàng-</span> <span class="total-price"> <span
                                    class="sign">8.500.000</span><span class="value"> VNĐ</span> </span> </div>
                        </div>
                    </a>
                        <ul class="dropdown-menu">
                            <li>
                                <div class="cart-item product-summary">
                                    <div class="row">
                                        <div class="col-xs-4">
                                            <div class="image"> <a href="#"><img src="assets\images\cart.jpg" alt=""></a> </div>
                                        </div>
                                        <div class="col-xs-7">
                                            <h3 class="name"><a href="#">Simple Product</a></h3>
                                            <div class="price">8.500.000 VNĐ</div>
                                        </div>
                                        <div class="col-xs-1 action"> <a href="#"><i class="fa fa-trash"></i></a> </div>
                                    </div>
                                </div>
                                <!-- /.cart-item -->
                                <div class="clearfix"></div>
                                <hr>
                                <div class="clearfix cart-total">
                                    <div class="pull-right"> <span class="text">Tổng tiền: </span><span class='price'>8.500.000 VNĐ</span>
                                    </div>
                                    <div class="clearfix"></div>
                                    <a href="checkout.html" class="btn btn-upper btn-primary btn-block m-t-20">Thanh toán</a>
                                </div>
                                <!-- /.cart-total-->
                            </li>
                        </ul>
                        <!-- /.dropdown-menu-->
                    </div>
                    <!-- /.dropdown-cart -->

                    <!-- ============================================================= SHOPPING CART DROPDOWN : END============================================================= -->
                </div>
                <!-- /.top-cart-row -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container -->
    </div>
    <!-- /.main-header -->

    <!-- ============================================== NAVBAR ============================================== -->
    <!-- /.header-nav -->
    <!-- ============================================== NAVBAR : END ============================================== -->

</header>