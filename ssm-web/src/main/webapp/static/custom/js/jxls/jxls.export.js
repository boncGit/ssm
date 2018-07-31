/**
 * Created by zhulijun on 2015/6/1.
 */
//调用样例
//function exportTo(){
//    var statementId="com.watchme.system.user.dao.TmUserMapper.selectMapList";
//    exportJxls("tm_user.xlsx","用户导出.xlsx",statementId,$("#exp").serialize());
//}

jQuery.extend({
    //转换为json 字符串
    toJSON : function (object){
        var type = typeof object;
        if ('object' == type){
            if (Array == object.constructor){
                type = 'array';
            } else if (RegExp == object.constructor){
                type = 'regexp';
            } else{
                type = 'object';
            }
        }
        switch(type){
            case 'undefined':
            case 'unknown':
                return;
                break;
            case 'function':
            case 'boolean':
            case 'regexp':
                return object.toString();
                break;
            case 'number':
                return isFinite(object) ? object.toString() : 'null';
                break;
            case 'string':
                return '"' + object.replace(/(\\|\")/g,"\\$1").replace(/\n|\r|\t/g,function(){
                        var a = arguments[0];
                        return  (a == '\n') ? '\\n':(a == '\r') ? '\\r':(a == '\t') ? '\\t': ""
                    }) + '"';
                break;
            case 'object':
                if (object === null) return 'null';
                var results = [];
                for (var property in object) {
                    var value = jQuery.toJSON(object[property]);
                    if (value !== undefined)
                        results.push(jQuery.toJSON(property) + ':' + value);
                }
                return '{' + results.join(',') + '}';
                break;
            case 'array':
                var results = [];
                for(var i = 0; i < object.length; i++){
                    var value = jQuery.toJSON(object[i]);
                    if (value !== undefined) results.push(value);
                }
                return '[' + results.join(',') + ']';
                break;
        }
    },
    //转换字符串为json 对象
    evalJSON : function (strJson){
        return eval( "(" + strJson + ")");
    },
    //cookie
    cookie : function(name, value, options) {
        if (typeof value != 'undefined') {// name and value given, set cookie
            options = options || {};
            if (value === null) {
                value = '';
                options.expires = -1;
            }
            var expires = '';
            if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
                var date;
                if (typeof options.expires == 'number') {
                    date = new Date();
                    date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
                } else {
                    date = options.expires;
                }
                expires = '; expires=' + date.toUTCString(); // use expires attribute, max-age is not supported by IE
            }
            var path = options.path ? '; path=' + options.path : '';
            var domain = options.domain ? '; domain=' + options.domain : '';
            var secure = options.secure ? '; secure' : '';
            document.cookie = [name, '=', encodeURIComponent(value), expires, path, domain, secure].join('');
        } else { // only name given, get cookie
            var cookieValue = null;
            if (document.cookie && document.cookie != '') {
                var cookies = document.cookie.split(';');
                for (var i = 0; i < cookies.length; i++) {
                    var cookie = jQuery.trim(cookies[i]);
                    // Does this cookie string begin with the name we want?
                    if (cookie.substring(0, name.length + 1) == (name + '=')) {
                        cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                        break;
                    }
                }
            }
            return cookieValue;
        }
    }
});
function exportJxls(templateName,expName,statementId,params){
    var exportURL=rootPath+"/myBaseCon/exportJxls?tempName="+templateName+"&expName="+expName+"&statementId="+statementId+"&"+params;
    if(confirm("您确定导出吗？")){
        $('#expTemp').remove();
        $("<div id='expTemp'></div>").appendTo($(document.body)).css('display','none')
            .append('<iframe name="IF_4down" width="0" height="0"></iframe>')
            .append('<form id="exportform" action="'+ exportURL +'" method="post" target="IF_4down" accept-charset="UTF-8">'+
            '<input type="hidden" id="reportName" name="reportName"/>'+
            '<input type="hidden" id="periodText_" name="periodText_"/>'+
            '<input type="hidden" id="headerJSON" name="headerJSON"/></form>');
        $("#reportName").val(expName);
        document.charset = "UTF-8";
        $("#exportform").submit().remove();
    };
}

function exportJxlsNoPrivilege(templateName,expName,statementId,params){
    var exportURL=rootPath+"/sgReportExlCon/exportJxlsNoPrivilege?tempName="+templateName+"&expName="+expName+"&statementId="+statementId+"&"+params;
    if(confirm("您确定导出吗？")){
        $('#expTemp').remove();
        $("<div id='expTemp'></div>").appendTo($(document.body)).css('display','none')
            .append('<iframe name="IF_4down" width="0" height="0"></iframe>')
            .append('<form id="exportform" action="'+ exportURL +'" method="post" target="IF_4down" accept-charset="UTF-8">'+
                '<input type="hidden" id="reportName" name="reportName"/>'+
                '<input type="hidden" id="periodText_" name="periodText_"/>'+
                '<input type="hidden" id="headerJSON" name="headerJSON"/></form>');
        $("#reportName").val(expName);
        document.charset = "UTF-8";
        $("#exportform").submit().remove();
    };
}

function exportJxlsNew(id,statementId,params,excelName){
    var headers = [];
    var $table = $("#"+id);
    $table.find('tr').each(function(i,p){
        var header=[];
        $(p).find('th').each(function(j,p1){
            var columnName = $(p1).attr("data-field");
            var headerName = $(p1).text();
            var headerCol = $(p1).attr('colspan');
            var headerRow = $(p1).attr('rowspan');

            header.push({headerName:headerName,headerCol:headerCol,headerRow:headerRow,columnName:columnName});
        });
        if(header.length>0){
            headers.push(header);
        }

    });

    var exportURL=rootPath+'/reportCon/exportRule?'+params
       +"&statementId="+statementId;
    if(confirm("您确定导出吗？")){
        $('#expTemp').remove();
        $("<div id='expTemp'></div>").appendTo($(document.body)).css('display','none')
            .append('<iframe name="IF_4down" width="0" height="0"></iframe>')
            .append('<form id="exportform" action="'+ exportURL +'" method="post" target="IF_4down" accept-charset="UTF-8">'+
                '<input type="hidden" id="reportName" name="reportName"/>'+
                '<input type="hidden" id="headers" name="headers"/></form>');
        $("#reportName").val(excelName);
        $("#headers").val($.toJSON(headers));
        document.charset = "UTF-8";
        $("#exportform").submit().remove();
    };

}