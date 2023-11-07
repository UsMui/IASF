<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="mt-4">List Customer</h1>
    <table class="table table-bordered mt-3">
        <thead>
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Age</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${customer.name}</td>
                <td>${customer.age}</td>
                <td>${customer.address}</td>
                <td>
                    <form method="get" action="/customer/delete" onsubmit="return confirm('Are you sure you want to delete this customer?')">
                        <input type="hidden" name="id" value="${customer.id}">
                        <button class="btn btn-danger" type="submit">Delete</button>
                    </form>
                    <form method="get" action="/customer/update">
                        <input type="hidden" name="id" value="${customer.id}">
                        <button class="btn btn-warning" type="submit">Update</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
