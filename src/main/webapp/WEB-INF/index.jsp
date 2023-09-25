<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</head>

<body class="container p-3">
    <h1>Questions Dashboard</h1>
    <table class="table table-bordered">
        <thead class="table-active border border-dark">
            <th>Question</th>
            <th>Tags</th>
        </thead>
        <c:forEach var="i" items="${questions}">
            <tr>
                <td>
                    <a href="questions/${i.id}">
                        <c:out value="${i.question}" />
                    </a>
                </td>
                <td>
                    <c:forEach var="j" items="${i.tags}">
                        <c:out value="${j.subject}" />
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class=" d-flex justify-content-end gap-3">
        <a href="/questions/new" class="btn btn-secondary ">New Question</a>
    </div>
</body>

</html>