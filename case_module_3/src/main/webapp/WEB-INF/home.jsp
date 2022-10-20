<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/layout/title.jsp"></jsp:include>
</head>

<body class="cnt-home">
<jsp:include page="/layout/header.jsp"></jsp:include>

<div class="body-content outer-top-xs" id="top-banner-and-menu">
    <div class="container">
        <div class="row">
            <jsp:include page="/layout/slide.jsp"></jsp:include>

            <div class="tab-content outer-top-xs">
                <div class="tab-pane in active" id="all">
                    <div class="product-slider">
                        <jsp:include page="/layout/left.jsp"></jsp:include>
                        <div class="owl-carousel home-owl-carousel custom-carousel owl-theme" data-item="2">
                                <c:forEach items="${list}" var="product">

                                <div class="product col-12 col-md-3 col-mb-4" >

                                    <div class="card">
                                        <img class="card-img-top" src="${product.getImage()}" alt="Card image cap">
                                        <div class="card-body">
                                            <h4 class="card-title text-justify text-center"><a href="detail?pid=${product.getId()}"
                                                                               title="View Product">${product.getName()}</a>
                                            </h4>
                                            <p class="card-text text-justify text-center">${product.getDescribes()}</p>
                                            <div class="row">
                                                <div class="col">
                                                    <p class="btn btn-danger btn-block">${product.getPrice()} $</p>
                                                </div>
                                                <div class="col">
                                                    <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>

                            </c:forEach>
                        </div>
                        <br>
                        <button onclick="loadMore()" class="btn btn-primary">Load more</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/layout/scripts_js.jsp"></jsp:include>
<jsp:include page="/layout/footer.jsp"></jsp:include>
</body>
</html>




