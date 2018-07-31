<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE html>
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>
    <title>投资建设管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta content="" name="description"/>
    <meta content="" name="author"/>


    <!-- 自定义javascript脚本 -->
    <script src="${rootPath}/static/module/system/user/user_list.js"></script>

    <script type="text/javascript">
        jQuery(document).ready(function () {
            Metronic.init(); // init metronic core componets
            Layout.init(); // init layout 菜单初始化需要用到 页脚的滚动到页首控件也用到

        });
    </script>
</head>
<body>
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
                                   data-url="${rootPath}/userCon/queryUserList"
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
                                   data-search-align="left"
                                    >
                                <thead>
                                <tr>
                                    <th <%----%> data-radio="true"></th>
                                    <th data-formatter="rowNumFormatter" data-visible="false">#</th>
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

<div id="add-modal" class="modal  fade" tabindex="-1" data-width="760">
</div>

<div id="update-modal" class="modal fade" tabindex="-1" data-width="760">
</div>


</body>
</html>