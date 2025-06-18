<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%!
String Formula(String xStr, String nStr) {
    try {
        double x = Double.parseDouble(xStr);
        double n = Double.parseDouble(nStr);

        if (x < -1) {
            double res = 0;
            for (double i = 0; i <= n; i++) {
                res += Math.pow(-1, i + 1) / ((2 * i + 1) * Math.pow(x, 2 * i + 1));
            }
            res -= Math.PI / 2;
            return String.format("Результат функции = %f", res);
        } else {
            return "Значение x не верно (x должно быть меньше -1)";
        }
    } catch (NumberFormatException e) {
        return "Ошибка: неверный формат числа";
    } catch (Exception e) {
        return "Ошибка вычисления: " + e.getMessage();
    }
}
%>
<!DOCTYPE html>
    <head>
            <meta charset="UTF-8" />
            <title>БеБеБе</title>
    </head>
    <body>
        X = <% out.println(request.getParameter("x")); %>
        <br>
        N = <% out.println(request.getParameter("n")); %>
        <p><%= Formula(request.getParameter("x"), request.getParameter("n")) %></p>
    </body>
</html>