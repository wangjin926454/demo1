function login() {
    var $userName = $("#userName").eq(0).val();
    var $password = $("#password").eq(0).val();
    var type;
    if($('#type').prop('checked')) {
        type = "1";
    }
    else {
        type="0";
    }
    var userName = $userName;
    var password = $password;
    if(userName==null || userName==="" || password==null || password===""){
        alert("账户密码不能为空");
        return;
    }
    else {
        //alert(userName+","+password);
        $.ajax({
            type: "POST",
            async: false,
            url: "login.do",
            dataType: "json",
            scriptCharset: 'GBK',
            data: {
                userName:userName,
                password:password,
                type:type
            },
            success: function (result) {
                var str = JSON.stringify(result);
                //alert(str);
                var json = JSON.parse(str);
                var type1 = json.type;
                var userName = json.userName;
                //alert(userName);
                var state = json.loginSuccess;
                if(state==="success"){
                    if(type1==="0"){
                        window.location.href="../static/article/admin.html?"+userName;
                    }
                    if(type1==="1"){
                        window.location.href="../static/article/admin.html?"+userName;
                    }
                }
                if(state==="error"){
                    alert("账号或密码有误");
                }

            },
            error: function () {
                alert("系统出错了");
            }
        });
    }
}

