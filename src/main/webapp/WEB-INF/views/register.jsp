<%@page contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" language="java" %>
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

    <title>Đăng nhập!</title>
</head>
<body>

<main class="col-4 offset-4">
    <h1 style="text-align: center">Register</h1>
    <form:form action="/register" method="post" modelAttribute="register" enctype="multipart/form-data">
        <div class="mb-3">
            <label class="form-label">Username</label>
            <form:input path="username" class="form-control"  aria-describedby="emailHelp"/>
            <form:errors path="username"></form:errors>
        </div>
        <div class="mb-3">
            <label class="form-label">Password</label>
            <form:password path="password" class="form-control"  aria-describedby="emailHelp"/>
            <form:errors path="password"></form:errors>
        </div>
        <div class="mb-3">
            <label class="form-label">Họ Tên</label>
            <form:input path="name" class="form-control"  aria-describedby="emailHelp"/>
            <form:errors path="name"></form:errors>
        </div>
        <div class="mb-3">
            <label class="form-label">Email</label>
            <form:input path="email" class="form-control"  aria-describedby="emailHelp"/>
            <form:errors path="email"></form:errors>
        </div>
        <div class="input-group mb-3">
            <label class="input-group-text" for="inputGroupFile01">Upload</label>
            <input type="file" name="photo" class="form-control" id="inputGroupFile01">
            <form:errors path="photo"></form:errors>
        </div>
        <button type="submit" class="btn btn-primary">Đăng ký</button>
    </form:form>
</main>


</body>
</html>