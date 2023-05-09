
const btn = document.querySelector("#loginBtn");
const URL = "http://localhost:9026/auth"
const errorContent = document.querySelector("#error");

function Authentication(username, password){
    this.username = username;
    this.password = password;
}

if(sessionStorage.getItem("username") != null){
    window.location.replace("/");
}

function checkLogin(){

	let username = document.querySelector("#username");
    let pass = document.querySelector("#pass");
    let auth = new Authentication(username.value, pass.value);
    console.log(auth);

    fetch(URL, {
        method: 'POST',
        headers: {
        
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(auth) 
    })
    .then(response => response.json())
    .then(data => {
        if(data != null){
            console.log("Data ok");
            console.log(data);
            sessionStorage.setItem("UserId",data.userId);
            sessionStorage.setItem("role", data.role);
            sessionStorage.setItem("username", data.username);
            sessionStorage.setItem("loginDate", data.loginDate);
            window.location.replace("/");
        }
    
    })
    .catch(error =>{
        errorContent.removeAttribute("hidden")
        pass.value = '';
        username.value = '';
    })
}




btn.addEventListener("click", checkLogin);