<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<div class="page-header">
    <div class="page-header-top">
        <div class="container">
            <div class="page-logo">
                <a href="javascript:;" style="cursor:default"><img id="page-logo-img"
                                                                   src="${rootPath}/static/metronic/admin/layout3/img/logo-default_cq.png"
                                                                   alt="logo" class="logo-default"></a>
            </div>
            <a href="javascript:;" class="menu-toggler"></a>

            <div class="top-menu">
                <ul class="nav navbar-nav pull-right">
                    <!--li class="dropdown dropdown-user dropdown-dark">
                        <a href="javascript:;" onclick="pageHeader.openPim2('${userId}');" class="dropdown-toggle"
                           data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                            <span class="username username-hide-mobile">名单制2.0</span>
                        </a>
                    </li-->
                    <li class="droddown dropdown-separator">
                        <span class="separator"></span>
                    </li>
                    <li class="dropdown dropdown-extended dropdown-dark dropdown-notification"
                        id="header_notification_bar">
                        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                           data-close-others="true">
                            <i class="icon-bell"></i>
                            <span class="badge badge-default"><%--<span id="viewsLength_1"></span>--%></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="external">
                                <%--<h3>你有 <strong><span id="viewsLength_2"></span> 待办</strong> 任务</h3>
                                <a href="${rootPath}/workTaskCon/forwardWaitDoTask">查看所有</a>--%>
                            </li>
                            <li>
                                <ul class="dropdown-menu-list scroller" style="height: 250px;"
                                    data-handle-color="#637283" id="views_1">
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="droddown dropdown-separator">
                        <span class="separator"></span>
                    </li>
                    <li class="dropdown dropdown-extended dropdown-dark dropdown-inbox" id="header_inbox_bar">
                        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                           data-close-others="true">
                            <span class="circle">0</span>
                            <span class="corner"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="external">
                                <h3>你有 <strong><span id=""></span> 新</strong> 消息</h3>
                                <a href="javascript:;">查看所有</a>
                            </li>
                            <li>
                                <ul class="dropdown-menu-list scroller" style="height: 275px;width: 200px"
                                    data-handle-color="#637283"><%--scroller--%>

                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown dropdown-user dropdown-dark">
                        <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
                           data-close-others="true">
                            <img alt="" class="img-circle" src="${rootPath}/workbenchCon/getUserPhotoStream">
              <span class="username username-hide-mobile">
              <c:choose>
                  <c:when test="${sessionScope.tmUser.userName!=null and fn:trim(sessionScope.tmUser.userName) != ''}">
                      ${sessionScope.tmUser.userName}
                  </c:when>
                  <c:otherwise>
                      用户设置
                  </c:otherwise>
              </c:choose>
              </span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-default">
                            <li>
                                <a href="${rootPath}/userCon/forwardModUserInfo">
                                    <i class="icon-user"></i> 个人信息 </a>
                            </li>
                            <li>
                                <a href="${rootPath}/userCon/forwardPhoneMessageSet">
                                    <i class="icon-calendar"></i> 短息提醒 </a>
                            </li>
                            <li>
                                <a href="${rootPath}/userCon/forwardModUserPwd">
                                    <i class="icon-envelope-open"></i> 密码修改</a>
                            </li>
                            <li class="divider">
                            </li>
                            <li>
                                <a href="${rootPath}/lock">
                                    <i class="icon-lock"></i> 锁屏 </a>
                            </li>
                            <li>
                                <a href="${rootPath}/logout">
                                    <i class="icon-key"></i> 退出 </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="page-header-menu">
        <div class="container">
            <div class="hor-menu ">
                <ul class="nav navbar-nav">
                    <li class="">
                        <a class="commonIndexMenuA" href="${rootPath}/index">首页</a>
                    </li>
                    <%--<li class="menu-dropdown mega-menu-dropdown ">--%>
                        <%--<a data-hover="megamenu-dropdown" data-close-others="true" data-toggle="dropdown"--%>
                           <%--href="javascript:;" class="dropdown-toggle">--%>
                            <%--业务视图 <i class="fa fa-angle-down"></i>--%>
                        <%--</a>--%>
                        <%--<ul class="dropdown-menu pull-left">--%>
                            <%--<span id="menu_1"></span>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                    <li class="menu-dropdown classic-menu-dropdown ">
                        <a data-hover="megamenu-dropdown" data-close-others="true" data-toggle="dropdown"
                           href="javascript:;">
                            我的工作 <i class="fa fa-angle-down"></i>
                        </a>
                        <ul class="dropdown-menu pull-left">
                            <span id="menu_2"></span>
                        </ul>
                    </li>
                    <li class="menu-dropdown mega-menu-dropdown ">
                        <a data-hover="megamenu-dropdown" data-close-others="true" data-toggle="dropdown"
                           href="javascript:;" class="dropdown-toggle">
                            综合查询 <i class="fa fa-angle-down"></i>
                        </a>
                        <ul class="dropdown-menu" style="min-width: 480px">
                            <li>
                                <div class="mega-menu-content">
                                    <div class="row">
                                        <span id="menu_4"></span>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>

                    <li class="menu-dropdown classic-menu-dropdown ">
                        <a data-hover="megamenu-dropdown" data-close-others="true" data-toggle="dropdown"
                           href="javascript:;">
                            后评价 <i class="fa fa-angle-down"></i>
                        </a>
                        <ul class="dropdown-menu pull-left">
                            <span id="menu_8"></span>
                        </ul>
                    </li>
                   <%-- <li class="menu-dropdown classic-menu-dropdown ">
                        <a data-hover="megamenu-dropdown" data-close-others="true" data-toggle="dropdown"
                           href="javascript:;">
                            工单监控 <i class="fa fa-angle-down"></i>
                        </a>
                        <ul class="dropdown-menu pull-left">
                            <span id="menu_9"></span>
                        </ul>
                    </li>--%>
                   <%-- <li class="menu-dropdown classic-menu-dropdown ">
                        <a data-hover="megamenu-dropdown" data-close-others="true" data-toggle="dropdown"
                           href="javascript:;">
                            规则引擎 <i class="fa fa-angle-down"></i>
                        </a>
                        <ul class="dropdown-menu pull-left">
                            <span id="menu_5"></span>
                        </ul>
                    </li>--%>
                    <li class="menu-dropdown mega-menu-dropdown ">
                        <a data-hover="megamenu-dropdown" data-close-others="true" data-toggle="dropdown"
                           href="javascript:;" class="dropdown-toggle">
                            标准模版库 <i class="fa fa-angle-down"></i>
                        </a>
                        <ul class="dropdown-menu" style="min-width: 230px"><%--280px--%>
                            <li>
                                <div class="mega-menu-content">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <ul class="mega-menu-submenu">
                                                <span id="menu_6"></span>

                                            </ul>
                                        </div>

                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li class="menu-dropdown">
                        <a class="commonIndexMenuA" href="javascript:;" target="_blank" class="tooltips"
                           data-container="body" data-placement="bottom" data-html="true">
                            关于我们 </a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</div>

<script src="${rootPath}/static/module/workbench/page-header.js" async type="text/javascript"></script>
<script type="text/javascript">
    /**如果发现使用的是系统默认密码，就强制修改密码*/
    var currentUrl = window.location.href;
    var flag = '${sessionScope.updatePasswdFlag}' == 'true' ? true : false;
    if (flag && currentUrl.indexOf('userCon/forwardModUserPwd') < 0) {
        layer.alert('<span style="color: red;font-size: larger">您目前使用的是系统初始化密码</span>' +
                '<br>请修改密码后继续使用!', {
            closeBtn: 0,
            icon: 3,
            title: false
        }, function () {
            window.location.href = rootPath + '/userCon/forwardModUserPwd';
        });

    }
</script>
<script type="text/javascript">
    /**如果電話為空就提示添加電話號碼**/
    var currentUrl = window.location.href;
    var flag = '${sessionScope.updateUserTelFlag}' == 'true' ? true : false;
    if (flag && currentUrl.indexOf('userCon/forwardModUserInfo') < 0) {
        layer.alert('<span style="color: red;font-size: larger">您的电话号码为空，请录入手机号码</span>' +
                '<br>请完善手机号码后继续使用!', {
            closeBtn: 0,
            icon: 3,
            title: false
        }, function () {
            window.location.href = rootPath + '/userCon/forwardModUserInfo';
        });
    }

    /*$(function () {
        window.toastr &&
        window.setTimeout(function () {
            //info,success,warning,error
            window.toastr.success('<br/><a href="' + rootPath + '/orderInfoCon/forwardOrderInfo.htm?orderNum=JLCC201606203660.00004796&workInstId=00022554&sessionOperId=90">您有一个待办任务，前往办理！</a>', '消息推送', {
                "closeButton": true,
                "tapToDismiss": false,
                "debug": false,
                "onclick": null,
                "positionClass": "toast-bottom-right",
                "showDuration": "2000",
                "hideDuration": "2000",
                "timeOut": "-1",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut",
                messageStyle: {height: "100px"}, //y,message增加样式功能
                isHover: false //y,鼠标移动后是否启动hover方法，即是否关闭
            });
        }, 1000)
    })*/
</script>
