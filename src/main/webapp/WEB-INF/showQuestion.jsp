<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <body class="container">
        <div class="d-flex justify-content-md-end m-2">
            <a href="/" class="btn btn-secondary">Volver</a>
        </div>

        <h1>
            <c:out value="${pregunta.question}" />
        </h1>
        <h2>Tags:</h2>
        <ul class="list-group list-group-horizontal">
            <c:forEach var="i" items="${pregunta.tags}">
                <li class="list-group-item">
                    <c:out value="${i.subject}" />
                </li>
            </c:forEach>
        </ul>
        <div class="d-flex justify-content-around gap-3 mt-md-3">
            <div class="border border-black border-3 p-3 w-50 h-25 overflow-y-scroll" style="max-height: 20em;">
                <h2>Answers:</h2>
                <ul class="list-group list-group-flush">
                    <c:forEach var="i" items="${pregunta.answers}">
                        <li class="list-group-item">
                            <c:out value="${i.answer}" />
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div>
                <h2>Add your answer:</h2>
                <form:form action="/answers/new" method="post" modelAttribute="responder">
                    <input name="preguntaId" type="hidden" value="${pregunta.id}" />
                    <p>
                        <form:label path="answer" class="form-label">Answer:</form:label>
                        <form:errors path="answer" />
                        <form:textarea path="answer" class="form-control" />
                    </p>
                    <div class="d-flex justify-content-md-end m-2">
                        <input type="submit" class="btn btn-info" value="Create">
                    </div>
                </form:form>
            </div>
    </body>

    </html>