const logoutBtn = document.querySelector("#logoutBtn");

logoutBtn.addEventListener("click", function logout(){
    sessionStorage.clear();
    window.location.reload();
})