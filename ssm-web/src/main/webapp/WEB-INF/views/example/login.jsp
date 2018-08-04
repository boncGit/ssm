<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
    <%@include file="common/include.jsp" %>
    <script>
        function login(){
            var userName = $("#userName").val();
            var password = $("#password").val();

            //form表单提交方式
            $("#loginForm").submit();

            //ajax 提交方式
            <%--$.ajax({--%>
                <%--type : "POST", //提交方式--%>
                <%--url : "${rootPath}/login",//路径--%>
                <%--data : {userName:userName,password:password},//数据，这里使用的是Json格式进行传输--%>
                <%--success : function(result) {//返回数据根据结果进行相应的处理--%>
                   <%--console.log(result)--%>
                <%--}--%>
            <%--});--%>
        }
    </script>
</head>
<body>
    <div class="container">
    <div class="row">
        <div class="col-lg-8">
            <br/>
            <div class="panel panel-default">
                <form class="login-form" id="loginForm" action="${rootPath}/login" method="post">
                    <div class="form-group">
                        <label class="control-label visible-ie8 visible-ie9">用户名</label>

                        <div class="input-icon">
                            <i class="fa fa-user"></i>
                            <input id="userName" class="form-control placeholder-no-fix" type="text" autocomplete="off"
                                   placeholder="用户名"
                                   name="username"/><span id="userNameError">${errorMessage}</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label visible-ie8 visible-ie9">密码</label>

                        <div class="input-icon">
                            <i class="fa fa-lock"></i>
                            <input id = "password" class="form-control placeholder-no-fix" type="password" autocomplete="off"
                                   placeholder="密码"
                                   name="password"/><span id="passwordError">${errorMessage}</span>
                        </div>
                    </div>
                    <div class="form-actions form-group">
                        <button onclick="login()" type="submit" style="background-color: #f58728;border-color: #f38323;" class="btn btn-primary btn-lg btn-block">
                            登录
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
