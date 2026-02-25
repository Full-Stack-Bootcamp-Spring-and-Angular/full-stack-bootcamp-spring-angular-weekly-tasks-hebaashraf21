<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Add New Product</h2>

    <form:form modelAttribute="product" action='/products/save' method="post" enctype="multipart/form-data">


        <div class="mb-3">
            <form:label path="name">Product Name</form:label>
            <form:input path="name" cssClass="form-control"/>
            <form:errors path="name" cssClass="text-danger"/>
        </div>


        <div class="mb-3">
            <form:label path="productDetails.price">Price</form:label>
            <form:input path="productDetails.price" type="number" step="0.01" cssClass="form-control"/>
            <form:errors path="productDetails.price" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <form:label path="productDetails.manufacturer">Manufacturer</form:label>
            <form:input path="productDetails.manufacturer" cssClass="form-control"/>
            <form:errors path="productDetails.manufacturer" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <form:label path="productDetails.expirationDate">Expiration Date</form:label>
            <form:input path="productDetails.expirationDate" type="date" cssClass="form-control"/>
            <form:errors path="productDetails.expirationDate" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label>Product Image</label>
            <input type="file" name="imageFile" class="form-control"/>
        </div>

        <div class="mb-3 form-check">
            <form:checkbox path="productDetails.available" cssClass="form-check-input"/>
            <form:label path="productDetails.available" cssClass="form-check-label">Available</form:label>
        </div>

        <button type="submit" class="btn btn-success">Add Product</button>
    </form:form>
</div>
</body>
</html>
