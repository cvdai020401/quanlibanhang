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
<body class="text-center">

<main class="form-signin col-4 offset-4">
    <form:form action="/login" method="post" modelAttribute="account">
        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

        <div class="form-floating">
            <form:input path="id" class="form-control" placeholder="name@example.com"/>
            <label >Username</label>
            <form:errors path="id"></form:errors>
        </div>
        <div class="form-floating">
            <form:password path="password" class="form-control"  placeholder="Password"/>
            <label >Password</label>
            <form:errors path="password"></form:errors>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
    </form:form>
</main>



</body>
</html>