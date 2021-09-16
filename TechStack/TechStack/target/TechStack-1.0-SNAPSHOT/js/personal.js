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
    document.getElementById("stackName").value = "";
    document.getElementById("stackDescription").value = "";
    document.getElementById("createStackForm").style.display = "none";
}
function addStackCheck(){
    var stackName = document.getElementById("stackName").value;
    var stackDescription = document.getElementById("stackDescription").value;
    var sNameNotice = document.getElementById("sNameNotice");
    var sDescriptionNotice = document.getElementById("sDescriptionNotice");
    var res;
    if(stackName == ""){
        res = false;
        sNameNotice.innerText = "栈名不能为空";
    }
    var stackNameString = new String(stackName);
    for(var i = 0; i < stackNameString.length; i ++){
        if(stackNameString.charAt(i) == ' '){
            res = false;
            sNameNotice.innerText = "栈名中不能包含空格";
            break;
        }
    }
    if(stackDescription == ""){
        res = false;
        sDescriptionNotice.innerText = "简介不能为空";
    }
    return res;
}
function nameChange(){
    document.getElementById("sNameNotice").innerText = "";
}
function descriptionChange(){
    document.getElementById("sDescriptionNotice").innerText = "";
}
function searchStackCheck(){
    var stackname = document.getElementById("searchName").value;
    var searchNameNotice = document.getElementById("searchNameNotice");
    if(stackname == ""){
        searchNameNotice.innerText = "栈名不能为空";
        return false;
    }
    var stackNameString = new String(stackname);
    for(var i = 0; i < stackNameString.length; i ++){
        if(stackNameString.charAt(i) == ' '){
            searchNameNotice.innerText = "栈名中不能包含空格";
            return false;
        }
    }
    return true;
}