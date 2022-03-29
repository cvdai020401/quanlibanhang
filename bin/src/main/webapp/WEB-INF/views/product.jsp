<%@page contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Trang chủ!</title>
</head>
<body>
<div class="container">
    <div class="row col-10 offset-1">
        <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
            <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                    <use xlink:href="#bootstrap"/>
                </svg>
            </a>

            <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/home" class="nav-link px-2 link-dark">Trang chủ</a></li>
                <li><a href="/products" class="nav-link px-2 link-dark">Sản phẩm</a></li>
                <c:if test="${sessionScope.user != null}">
                    <li><a href="/cart" class="nav-link px-2 link-dark">Giỏ hàng</a></li>
                    <li><a href="#" class="nav-link px-2 link-dark">Đơn hàng</a></li>
                </c:if>
            </ul>

            <c:if test="${sessionScope.user == null}">
                <div class="col-md-3 text-end">
                    <button type="button" class="btn btn-outline-primary me-2">Đăng nhập</button>
                    <button type="button" class="btn btn-primary">Đăng ký</button>
                </div>
            </c:if>
            <c:if test="${sessionScope.user  != null}">
                <div class="col-md-3 text-end">
                    <a href="/logout" class="btn btn-danger">Đăng xuất</a>
                </div>
            </c:if>
        </header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/products?category=1">Giầy nam</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/products?category=2">Giầy nữ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="/products?category=3">Giầy trẻ em</a>
                    </li>
                </ul>
            </div>
        </nav>
        <main class="row col-12 mb-5">
            <c:forEach items="${products}" var="item">
                <div class="card ml-4" style="width: 18rem; margin-left: 10px; margin-bottom: 20px">
                    <img src="${item.image}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${item.name}</h5>
                        <p class="card-text">${item.price}</p>
                        <a href="/cart/add?id=${item.id}" class="btn btn-primary">Add to Cart</a>
                    </div>
                </div>
            </c:forEach>
        </main>
        <footer>
            <div class="col-md-12">
                <div class="inner-content">
                    <p style="text-align: center">Copyright &copy; 2020 FPT POLYTECHNIC</p>
                </div>
            </div>
        </footer>
    </div>
</div>
<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
-->
</body>
</html>