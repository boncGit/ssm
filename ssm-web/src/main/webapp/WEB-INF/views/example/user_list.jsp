<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap 实例</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!-- 自定义javascript脚本 -->
    <script src="${rootPath}/static/user/user_list.js"></script>
    <script src="${rootPath}/static/user/bootstrap-table.js"></script>
    <script src="${rootPath}/static/user/common.js"></script>
    <script src="${rootPath}/static/user/user_list.js"></script>
</head>
<body>

<div class="container">
    <div class="jumbotron">
        <h1>我的第一个 Bootstrap 页面</h1>
        <p>重置窗口大小，查看响应式效果！</p>
    </div>
    <div class="row">
        <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
            <h3>第一列</h3>
            <p>学的不仅是技术，更是梦想！</p>
            <%--<p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>--%>
        </div>
        <div class="col-sm-4">
            <h3>第二列</h3>
            <%--<p>学的不仅是技术，更是梦想！</p>--%>
            <%--<p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>--%>
        </div>
        <div class="col-sm-4">
            <h3>第三列</h3>
            <%--<p>学的不仅是技术，更是梦想！</p>--%>
            <%--<p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>--%>
        </div>
    </div>
</div>

<div class="page-container">
    <div class="page-content">
        <div class="container">
            <ul class="page-breadcrumb breadcrumb">
                <li>
                    <a href="${rootPath}/index" target="_top">首页</a><i class="fa fa-circle"></i>
                </li>
                <li class="active">用户列表
                </li>
            </ul>
            <div class="row">
                <div class="col-md-12">
                    <div class="portlet light bordered">
                        <div class="portlet-title">
                            <div class="caption">
								<span class="caption-subject font-green-sharp bold uppercase">
								<i class="fa fa-gift"></i> 搜索条件
								</span>
                            </div>
                            <div class="tools">
                                <a href="javascript:;" class="collapse">
                                </a>
                            </div>
                        </div>
                        <div class="portlet-body form">
                            <form action="javascript:;" id="searchForm" class="form-horizontal">
                                <div class="form-body">
                                    <div class="row">
                                        <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
                                            <div class="form-group">
                                                <label class="col-md-4 control-label">姓名：</label>

                                                <div class="col-md-8">
                                                    <input class="form-control" name="userName" type="text">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
                                            <div class="form-group">
                                                <label class="col-md-4 control-label">电话：</label>

                                                <div class="col-md-8">
                                                    <input class="form-control" name="userTel" type="text">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
                                            <div class="form-group">
                                                <label class="col-md-4 control-label">登录帐号：</label>

                                                <div class="col-md-8">
                                                    <input class="form-control" name="userId" type="text">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <div class="text-right">
                                <button type="button" class="btn green" onclick="search()" id="butselect">查询
                                </button>
                                <button type="button" class="btn" onclick="reset()" id="reset">重置
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="portlet light bordered">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-cogs font-green-sharp"></i>
                                <span class="caption-subject font-green-sharp bold uppercase">用户列表</span>
                            </div>
                            <div class="actions btn-set">
                                <button class="btn green-haze btn-circle" onclick="showAddUser()"><i
                                        class="fa fa-check"></i>添加
                                </button>
                                <button class="btn green-haze btn-circle" onclick="userReset()"><i
                                        class="fa fa-check"></i>密码重置
                                </button>
                                <button class="btn red-sunglo btn-circle" onclick="deleteUser()"><i
                                        class="fa fa-check"></i>删除
                                </button>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <table id="table"
                                   class="table table-striped table-bordered table-hover"
                                   data-toggle="table"
                                   data-url="${rootPath}/userCon/qryUsers"
                                   data-method="post"
                                   data-content-type="application/x-www-form-urlencoded"
                                   data-query-params="queryParams"
                                   data-pagination="true"
                                   data-click-to-select="true"
                                   data-side-pagination="server"
                                   data-page-list="[5, 10, 20, 50, 200]"
                                   data-show-refresh="true" <%--显示刷新按钮--%>
                                   data-show-toggle="true" <%--显示卡片视图--%>
                                   data-show-pagination-switch="true"<%--显示“隐藏分页”按钮--%>
                                   data-show-columns="true"<%--显示列选项--%>
                                   data-search="true"
                                   data-search-align="left">
                                    <thead>
                                            <tr>
                                                <th data-radio="true"></th>
                                                <th data-formatter="rowNumFormatter" data-visible="true">#</th>
                                                <th data-field="userId" class="hidden-xs hidden-sm">登录帐号</th>
                                                <th data-field="userName" class="col-xs-1">用户名称</th>
                                                <th data-field="userSex" data-formatter="sexFormatter">性别</th>
                                                <th data-field="userTel">电话</th>
                                                <th data-field="userEmail" class="hidden-xs hidden-sm">邮箱</th>
                                                <th data-field="createTime" class="hidden-xs hidden-sm">创建时间</th>
                                            </tr>
                                    </thead>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
