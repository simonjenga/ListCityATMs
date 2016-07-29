<%@ include file="/WEB-INF/views/includes.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>List City ATMs</title>
        <script type="text/javascript" src="<c:url value='/static/js/jquery-1.4.2.min.js' />"></script>
        <script type="text/javascript" src="<c:url value='/static/js/atmFormSubmit.js' />"></script>
    </head>
    
    <body style="background-color: #D1D1E8">
    	<div align='right'>
    		<c:if test="${pageContext.request.userPrincipal.name != null}">
	   			Welcome : ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/logout.htm" />" >logout</a>
			</c:if>
		</div>
        <center>        	
        	<h1 style="color: blue; font-size: 40px; font-weight: bold; font-family: Calibri, verdana, helvetica, sans-serif;"><u>List City ATMs</u>.</h1>
	        <table align='center'>
	            <tr align='center'>
	            	<td>City Name: <input type="text" id="city"><br/></td>
	            </tr>	            
	        </table>
        </center>
    </body>
</html>