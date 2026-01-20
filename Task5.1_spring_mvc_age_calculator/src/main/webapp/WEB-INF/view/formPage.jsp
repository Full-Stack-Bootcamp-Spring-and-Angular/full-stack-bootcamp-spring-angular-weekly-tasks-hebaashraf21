<head>
    <title>Age Calculator</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h1 class="text-center mb-4">Age Calculator App</h1>
    <div class="row justify-content-center">
        <div class="col-md-4">
            <form action="processForm" method="GET" class="card p-4 shadow-sm bg-white rounded">
                <div class="mb-3">
                    <label for="year" class="form-label">Year</label>
                    <input type="text" class="form-control" id="year" name="year" placeholder="Enter year">
                </div>
                <div class="mb-3">
                    <label for="month" class="form-label">Month</label>
                    <input type="text" class="form-control" id="month" name="month" placeholder="Enter month">
                </div>
                <div class="mb-3">
                    <label for="day" class="form-label">Day</label>
                    <input type="text" class="form-control" id="day" name="day" placeholder="Enter day">
                </div>
                <button type="submit" class="btn btn-primary w-100">Calculate Age</button>
            </form>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
</body>
</html>