<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>List Computers</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<style>
    .center {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
</style>
<body>
<main>
    <div class="container">
        <h2>List Computers</h2>

        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Computer Id</th>
                <th>Computer Name</th>
                <th>Producer</th>
                <th>Description</th>
                <th>Year Making</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="c">
                <tr>
                    <td>${c.getComId()}</td>
                    <td>${c.getComName()}</td>
                    <td>${c.getProducer()}</td>
                    <td>${c.getDescription()}</td>
                    <td>${c.getYearMaking()}</td>
                    <td>
                        <fmt:formatNumber type="currency" currencySymbol="" value="${c.getPrice()}"></fmt:formatNumber>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/Computer/Detail?id=${c.getComId()}"
                           class="btn btn-info btn-sm">Detail</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div>
            <a href="${pageContext.request.contextPath}/Computer/Create" class="btn btn-primary">Add new</a>
        </div>
    </div>
</main>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script>
    <c:if test="${not empty success}">
    alert("${success}");
    </c:if>
    <c:if test="${not empty error}">
    alert("${error}");
    </c:if>
</script>
</body>
</html>
