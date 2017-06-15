<%@ include file="/WEB-INF/views/includes.jsp"%>

<%-- Redirected because we can't set the welcome page to a virtual URL. --%>
<%-- <%response.sendRedirect("loginPage.htm");%> --%>

<c:redirect url="/loginPage.htm"/>