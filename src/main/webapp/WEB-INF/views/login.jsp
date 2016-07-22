<%@ include file="/WEB-INF/views/includes.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Custom Login Page</title>
        <link type="text/css" rel="stylesheet" href="<c:url value='/static/css/styles.css' />"></link>
    </head>
    
    <body style="background-color: #D1D1E8" onload='document.loginForm.username.focus();'>  
		<h1 align='center' style="color: blue; font-size: 40px; font-weight: bold; font-family: Calibri, verdana, helvetica, sans-serif;"><u>Custom Login Page</u></h1>  
     		
   		<center>
   			<span class="dark">${error}</span>
   			<h3 style="color: blue; font-size: 20px; font-weight: bold; font-family: Calibri, verdana, helvetica, sans-serif;">Login Required:</h3>
		</center>
	</body>
</html>