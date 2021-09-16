function submitCheck(){
    var res = true;
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if(username == ""){
        document.getElementById("nameNotice").innerHTML = "用户名不能为空";
        res = false;
    }
    if(password == ""){
        document.getElementById("pswdNotice").innerHTML = "密码不能为空";
        res = false;
    }
    return res;
}
function nameChange(){
    var name = document.getElementById("username").value;
    if(name != "")
        document.getElementById("nameNotice").innerText = "";
}
function pswdChange(){
    var password = document.getElementById("password").value;
    if(password != "")
        document.getElementById("pswdNotice").innerText = "";
}