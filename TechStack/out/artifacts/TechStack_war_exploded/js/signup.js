function submitCheck(){
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var nameNotice = document.getElementById("nameNotice");
    var pswdNotice = document.getElementById("pswdNotice");
    var isSubmit = true;

    if(username == ""){
        isSubmit = false;
        nameNotice.innerText = "用户名不能为空";
    }
    if(new String(username).indexOf(" ") != -1){
        isSubmit = false;
        nameNotice.innerText = "用户名中不能包含空格";
    }
    if(password.length < 6){
        isSubmit = false;
        pswdNotice.innerText = "密码不能少于6位";
    }
    var passwordString = new String(password);
    for(var i = 0; i < password.length; i ++){
        var c = passwordString.charAt(i);
        if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '1' && c <= '9') || c == '@' || c == '-' || c == '_' || c == '.')){
            isSubmit = false;
            pswdNotice.innerText += " 密码中只能包含字母数字@.-_";
            break;
        }
    }
    return isSubmit;
}
function nameChange(){
    document.getElementById("nameNotice").innerText = "";
}
function pswdChange(){
    document.getElementById("pswdNotice").innerText = "";
}