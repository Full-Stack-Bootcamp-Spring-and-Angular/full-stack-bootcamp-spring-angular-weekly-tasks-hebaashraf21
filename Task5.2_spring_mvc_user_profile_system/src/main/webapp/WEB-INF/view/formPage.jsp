<html>
    <head>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

        <%--        import Bootstrap--%>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

    </head>
    <body background="${pageContext.request.contextPath}/resources/images/background.jpg">
        <form action="processForm">
            <input type="text" placeholder="firstName" name="firstName">
            <input type="text" placeholder="lastName" name="lastName">
            <input type="text" placeholder="email" name="email">
            <input type="text" placeholder="city" name="city">
            <input type="date" placeholder="birthdate" name="birthdate">

            <input type="submit" class="btn btn-danger">
        </form>
    </body>
</html>

