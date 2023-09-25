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

        <h1>What is your question?</h1>
        <form:form action="/questions/new" method="post" modelAttribute="pregunta">
                <p>
                    <form:label path="question" class="form-label">Question</form:label>
                    <form:errors path="question" />
                    <form:textarea path="question" class="form-control"/>
                </p>
                <p>
                    <label class="form-label">Tags (separado por ",")</label>
                    <input name="etiquetas" class="form-control" />
                </p>
                <div class="d-flex justify-content-md-end m-2">
                    <input type="submit" class="btn btn-info" value="Create">
                </div>
            </form:form>
    </body>
    </html>