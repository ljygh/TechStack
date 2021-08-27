function edit(){
    document.getElementById("form").style.display = "block";
}
function cancel(){
    document.getElementById("form").style.display = "none";
}
function submitCheck(){
    console.log("submit check");
    var pswd = document.getElementById("pswd").value;
    var confirmPswd = document.getElementById("confirmPswd").value;
    var isPass = true;
    if(pswd.length < 6){
        isPass = false;
        document.getElementById("pswdNotice").innerText = "密码不能少于6位";
    }
    var pswdString = new String(pswd);
    for(var i = 0; i < pswd.length; i ++){
        var c = pswdString.charAt(i);
        if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '1' && c <= '9') || c == '@' || c == '-' || c == '_' || c == '.')){
            isPass = false;
            pswdNotice.innerText = " 密码中只能包含字母数字@.-_";
            break;
        }
    }
    if(pswd != confirmPswd){
        isPass = false;
        document.getElementById("confirmPswdNotice").innerText = "密码不一致";
    }
    console.log(isPass);
    return isPass;
}
function pswdChange(){
    document.getElementById("pswdNotice").innerText = "";
}
function confirmPswdChange(){
    document.getElementById("confirmPswdNotice").innerText = "";
}
function logOutConfirm(){
    return confirm("确认退出登录？");
}
function closeAccountConfirm(){
    return confirm("确认注销账户？ 这样做您将不能用此账户登录，并且该操作不能测回！");
}
function showCreateStackForm(){
    document.getElementById("createStackForm").style.display = "block";
}
function cancelCreateStack(){
    document.getElementById("createStackForm").style.display = "none";
}