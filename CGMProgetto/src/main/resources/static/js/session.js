let sessionInfo = sessionStorage.getItem("username");
console.log(sessionInfo);

if(sessionInfo == null){
    window.location.replace("/login");
}

