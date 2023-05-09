let role = sessionStorage.getItem("role");

const adminBtn = document.querySelector("#adminBtn");

// console.log("admin nascosto");
console.log(role);

if(role == "ADMIN"){

    adminBtn.removeAttribute("hidden");
}