/*
 * AJAX针对所有的数据类型的函数
 *
 * @param {type} sync 是否异步传输 默认是true是异步。 false就是同步传输
 * @param {type} cache 是否开启缓存
 * @param {type} type ajax的传输类型 POST 或 GET
 * @param {type} url  是传输的目标url （注意：这个url要非常注意，如果路径不对就会导致错误  !--所以是重点--）
 * @param {type} datatype 传输数据的类型可以是 text:纯文本 | html:HTML信息包括script标签会在插入DOM时执行 | script:返回纯文本JavaScript代码 | json:json数据 | jsonp:jsonp数据格式 | xml:返回XML文档
 * @param {type} data 是要传输的数据（注意:数据是什么格式datatype就要是对应的格式，否则传输失败）
 * @param {type} func 当ajax执行成功之后跳转到自己的函数  注意:这里只需要写上自己函数的名称即可
 * @returns {undefined}
 */
var Aurl='';

function ajax_datatypeByHtml(type, url, html_data, func) {//data数据可以为空
    $.ajax({
        type: type,
        url: Aurl+url,
        dataType: "html",
        data: html_data,
        beforSend: function () {
            // 禁用按钮防止重复提交
            $("#submit").attr({disabled: "disabled"});
        },
        error: function (data) {
            //请求失败时被调用的函数
            //console.log("传输失败3:" + data);
        },
        success: function (data) {
            func(data);
        }
    });
}

function ajax_datatypeByData(type, url, json_data, func) {//data数据可以为空(同上) 异步 同时掉接口
    $.ajax({
        type: type,
        url: Aurl+url,
        dataType: "json",
        data: json_data,
        async:true,
        beforSend: function () {
            // 禁用按钮防止重复提交
            $("#submit").attr('disabled',"disabled");

        },
        error: function (data) {
            //请求失败时被调用的函数
            alert("传输失败4:" + data);
        },
        success: function (data) {
            func(data);
        },
        /* complete: function () {

         console.log($("body").height()+'jj')
         }*/
    });
}



