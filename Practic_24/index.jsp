<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-16" />
        <title>БеБеБе</title>
    </head>

    <body>
    <form action="result.jsp">
        <p>Введите x:</p>
        <br>
        <input type="number" name="x" max="0">
        <p>Введите n:</p>
        <br>
        <input type="number" name="n" min="1">
        <input type="submit" value="Загрузить" />
    </form>
    </body>

</html>