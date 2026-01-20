<head>
    <title>Age Result</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-5 text-center">
    <div class="card p-4 shadow-sm bg-white rounded">
        <h1 class="mb-4">Age Calculator App</h1>
        <h3>Your age is:</h3>
        <p class="fs-4">${year} years, ${month} months, ${day} days</p>
        <a href="${pageContext.request.contextPath}/showForm" class="btn btn-secondary mt-3">Calculate Again</a>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
</body>
</html>