<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Create Computer</title>
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
        <h2>Create Computer</h2>

        <table class="table table-bordered table-striped">
            <tbody>
            <tr>
                <td>Computer Id</td>
                <td>${c.getComName()}</td>
            </tr>
            <tr>
                <td>Producer</td>
                <td>${c.getProducer()}</td>
            </tr>
            <tr>
                <td>Description</td>
                <td>${c.getDescription()}</td>
            </tr>
            <tr>
                <td>Year Making</td>
                <td>${c.getYearMaking()}</td>
            </tr>
            <tr>
                <td>Year Making</td>
                <td>
                    <fmt:formatNumber type="currency" currencySymbol="" value="${c.getPrice()}"></fmt:formatNumber>
                </td>
            </tr>
            </tbody>
        </table>
        <div>
            <button type="submit" class="btn btn-primary">Add new</button>
            <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Back</a>
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
