<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value='/resources/css/styles.css' />">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Products Data</h2>
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Show Details</th>
                <th>Add/Update</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td> <a href="<c:url value='/products/viewMore?id=${product.id}' />" class="btn btn-info btn-sm">View Details</a></td>
                <td><a href="<c:url value='/products/edit?id=${product.id}' />" class="btn btn-warning btn-sm">Add/Update details</a></td>
                <td><a href="<c:url value='/products/delete?id=${product.id}' />" class="btn btn-danger btn-sm">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value='/products/add' />" class="btn btn-success mb-3">Add New Product</a>
</div>
</body>
</html>
