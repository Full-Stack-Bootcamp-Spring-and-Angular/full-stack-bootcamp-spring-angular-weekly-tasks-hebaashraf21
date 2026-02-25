<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Details</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Product Details</h2>

    <table class="table table-bordered">
        <tr>
            <th>ID</th>
            <td>${product.id}</td>
        </tr>
        <tr>
            <th>Name</th>
            <td>${product.name}</td>
        </tr>
        <tr>
            <th>Image</th>
            <td>
                <img src="${pageContext.request.contextPath}/${product.imagePath}" width="80" height="80"/>
            </td>
        </tr>
        <tr>
            <th>Price</th>
            <td>${product.productDetails.price}</td>
        </tr>
        <tr>
            <th>Manufacturer</th>
            <td>${product.productDetails.manufacturer}</td>
        </tr>
        <tr>
            <th>Expiration Date</th>
            <td>
                <fmt:formatDate value="${product.productDetails.expirationDate}" pattern="yyyy-MM-dd"/>
            </td>
        </tr>
        <tr>
            <th>Available</th>
            <td>
                <c:choose>
                    <c:when test="${product.productDetails.available}">Yes</c:when>
                    <c:otherwise>No</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
