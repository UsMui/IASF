<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <c:if test="${customerupdate == null}">
        <h1>Create</h1>
        <form action="/customer/createOrUpdate" method="post" modelAttribute="customer">
            <input type="hidden" name="id" value="${customer.id}" />
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="${customer.name}" />
            </div>
            <div class="form-group">
                <label for="age">Age</label>
                <input type="text" class="form-control" id="age" name="age" value="${customer.age}" />
            </div>
            <div class="form-group">
                <label for="address">Address</label>
                <input type="text" class="form-control" id="address" name="address" value="${customer.address}" />
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </c:if>
    <c:if test="${customerupdate != null}">
        <h1>Update ${customerupdate.name}</h1>
        <form action="/customer/update" method="post" modelAttribute="customerupdate">
            <input type="hidden" name="id" value="${customerupdate.id}" />
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control"  name="name" value="${customerupdate.name}" />
            </div>
            <div class="form-group">
                <label for="age">Age</label>
                <input type="text" class="form-control"  name="age" value="${customerupdate.age}" />
            </div>
            <div class="form-group">
                <label for="address">Address</label>
                <input type="text" class="form-control"  name="address" value="${customerupdate.address}" />
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
    </c:if>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
