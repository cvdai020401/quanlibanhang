<%@page contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
        </header>
        <main class="container col-12 mb-5">
          <div class="row">
              <div class="col-sm">
                  <form:form action="${product.id == null ? '/admin/add' : '/admin/edit'}" method="post" modelAttribute="product" enctype="multipart/form-data">
                      <div class="mb-3" hidden>
                          <label class="form-label">Mã sản phẩm</label>
                          <form:input path="id" class="form-control"  aria-describedby="emailHelp"/>
                          <form:errors path="name"></form:errors>
                      </div>
                      <div class="mb-3">
                          <label class="form-label">Tên sản phẩm</label>
                          <form:input path="name" class="form-control"  aria-describedby="emailHelp"/>
                          <form:errors path="name"></form:errors>
                      </div>
                      <div class="mb-3">
                          <label class="form-label">Giá</label>
                          <form:input path="price" class="form-control"  aria-describedby="emailHelp"/>
                          <form:errors path="price"></form:errors>
                      </div>
                      <div class="mb-3">
                          <label class="form-label">Loại sản phẩm</label>
                          <form:select path="categoryId" class="form-control" items="${category}" itemValue="id" itemLabel="name" delimiter=" "/>
                      </div>
                      <div class="mb-3">
                          <label class="form-label">Hình ảnh</label>
                          <form:input path="image" class="form-control"  aria-describedby="emailHelp"/>
                      </div>
                      <c:if test="${product.id == null}">
                          <input type="submit" class="btn btn-primary" value="Thêm mới"></input>
                      </c:if>
                      <c:if test="${product.id != null}">
                          <input type="submit" class="btn btn-danger" value="Cập nhật"></input>
                      </c:if>
                      <a href="" class="btn btn-success">Làm mới</a>
                  </form:form>
              </div>
              <div class="col-sm">
                  <img src="${product.image}" style="width: 300px; height: 200px" alt="">
              </div>
          </div>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Ảnh</th>
                    <th scope="col">Tên sản phẩm</th>
                    <th scope="col">Giá</th>
                    <th scope="col">Ngày tạo</th>
                    <th scope="col">Loại sản phẩm</th>
                    <th scope="col">Trạng thái</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td>
                            <img src="${item.image}" style="width: 50px; height: 50px" alt="">
                        </td>
                        <td>${item.name}</td>
                        <td> <fmt:formatNumber pattern="#,###" value="${item.price}">
                        </fmt:formatNumber></td>
                        <td>${item.createDate}</td>
                        <td>${item.categoryId.name}</td>
                        <td>${item.avaiable ? 'Còn hàng' : 'Hết hàng'}</td>
                        <td>
                           <c:if test="${item.avaiable}">
                               <a href="/admin?id=${item.id}"> <i class="fa fa-refresh"></i></a>
                               <a href="/admin/delete?id=${item.id}"><i class="fa fa-trash"></i></a>
                           </c:if>

                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
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