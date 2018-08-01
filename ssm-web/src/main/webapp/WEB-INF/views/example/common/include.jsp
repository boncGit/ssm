<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>

<!-- Jquery -->
<script src="${rootPath}/static/example/jquery/jquery-2.2.3.min.js" type="text/javascript"></script>

<!-- Bootstrap -->
<link href="${rootPath}/static/example/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
<script src="${rootPath}/static/example/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

<script>
    function toIndex() {
        window.location.href = '${rootPath}/';
    }
</script>