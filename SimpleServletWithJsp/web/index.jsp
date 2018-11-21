<%--
  Created by IntelliJ IDEA.
  User: Дмитро
  Date: 20.11.2018
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JSP Timing</title>
  </head>
  <body>
  <h5> time counter after pushing of button</h5>
  <jsp:useBean id="calendar" class="java.util.GregorianCalendar"/>
  <form name="Simple" action="timeaction" method="post">
  <input type="hiden" name="time" value="${calendar.timeInMillis}"/>
  <input type="submit" name="button" value="Count time"/>
  </form>
  </body>
</html>
