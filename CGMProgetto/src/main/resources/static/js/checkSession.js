
let role = sessionStorage.getItem("role");
if(role != "ADMIN"){
    window.location.replace("/error")
}