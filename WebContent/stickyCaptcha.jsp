<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Sticky CAPTCHA Example</title>
    <link href="sc.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <br>

   
    <img src="<c:url value="stickyCaptcha.png" />"><br />
    <form method="post" action="captchaSubmit.jsp">
        Answer: <input name="answer" /><input type="submit" />
    </form>
  
    <p><a href="remove.jsp">Remove from session</a></p>

<!--     <p><a href="<c:url value="simpleCaptcha.jsp" />">Simple CAPTCHA</a> | Sticky CAPTCHA  | <a href="<c:url value="audioCaptcha.jsp" />">Audio CAPTCHA</a></p>
-->
</body>
</html>
