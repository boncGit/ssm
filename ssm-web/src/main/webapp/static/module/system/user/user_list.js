/**
 * Created by huangpeng on 2015/5/18.
 */

/**
 * 分页插件参数及表单参数回传
 * @param params
 * @returns {*}
 */
function queryParams(params) {
    return getQueryParams(params, "searchForm");
}
/**
 * 表单信息reset
 */
function reset(){
    $('#searchForm').resetForm();
}
/**
 * 页面查询，调用表格插件的refresh方法
 */
function search(){
    $('#table').bootstrapTable('refresh');
}

/**
 * 页面信息修改
 */
function showUpdateUser() {
    var selections = $('#table').bootstrapTable('getSelections');
    if(selections.length == 0){
        layer.msg('请选择一行数据进行操作！', function(){});
        return;
    }
    var $modal = $('#update-modal');
    $('body').modalmanager('loading');
    //setTimeout(function(){
        $modal.load(rootPath+'/userCon/showUpdateUser?userId='+selections[0].userId, '', function(){
            $modal.modal();
            initPopupValid("updateUserForm");//给弹出中的表单添加验证
        });
    //}, 500);
}
/**
 * 子页面点击提交后的回调函数
 */
function updateUser(btn){
    if(!$("#updateUserForm").valid()) return;
    $(btn).button('loading');//屏蔽提交按钮，防止二次提交
    $.ajax({
        url: rootPath+"/userCon/updateUser",
        type: "POST",
        data : $('#updateUserForm').serializeArray(),
        success: function(data,textStatus) {
            layer.msg('数据修改成功！');
            //setTimeout(function(){//延时1秒，模拟后台操作
                $('#update-modal').modal("hide");
                $("#table").bootstrapTable('refresh');//刷新表格
                $(btn).button('reset')//释放被屏蔽的按钮
            //}, 2000);//隐藏弹出层
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){
            layer.msg('数据修改失败！');
            $(btn).button('reset')//释放被屏蔽的按钮
        }
    });
}
/**
 * 页面信息新增
 */
function showAddUser() {
	layer.open({
        type: 2,
        title: '个人信息维护',
        shadeClose: true,
        shade: 0.8,
        area: ['100%', '100%'],
        content: rootPath + "/userCon/showAddUser?iframe=show&decorator=decorator_blank",
        maxmin: true
    });
}

function addUser(){
    if(!$("#userForm").valid()) return;


    //ajax提交


}

/**
 * 删除用户
 */
function deleteUser() {
    var selections = $('#table').bootstrapTable('getSelections');
    if(selections.length == 0){
        layer.msg('请选择数据进行操作！', function(){});
        return;
    }
   var userId = selections[0].userId;
   layer.open({
       content: '用户信息一旦删除，将无法恢复！！！确定要删除吗?',
       btn: ['确定', "取消"],
       shade: false,
       offset: '200px',
       yes: function (index, layero) {
           $.ajax({
               type: "POST",
               url: rootPath + "/userCon/deleteUserLT",
               data:{"userId":userId},
               dataType: "json",
               success : function(data,textstatus) {
                   $("#table").bootstrapTable('refresh');//刷新表格
                   if(data.flag = 1) {
                       layer.msg(data.msg, {icon: 1});
                   }
               },
               error:function(data,textstatus){
                   if(data.flag = 0) {
                       layer.msg(data.msg, {icon: 2});
                   }
               }
           });
       },
       cancel: function (index) {
       }
   });
}
/**
 * 密码重置
 */
function userReset() {
    var selections = $('#table').bootstrapTable('getSelections');
    if(selections.length == 0){
        layer.msg('请选择数据进行操作！', function(){});
        return;
    }
    var userId = selections[0].userId;
    var userType = "LT";
    layer.open({
        content: '用户密码重置?',
        btn: ['确定', "取消"],
        shade: false,
        offset: '200px',
        yes: function (index, layero) {
            $.ajax({
                type: "POST",
                url: rootPath + "/userCon/userReset",
                data:{"userId":userId,userType:userType},
                dataType: "json",
                success : function(data,textstatus) {
                    $("#table").bootstrapTable('refresh');//刷新表格
                    if(data.flag = 1) {
                        layer.msg(data.msg, {icon: 1});
                    }
                },
                error:function(data,textstatus){
                    if(data.flag = 0) {
                        layer.msg(data.msg, {icon: 2});
                    }
                }
            });
        },
        cancel: function (index) {
        }
    });
}

