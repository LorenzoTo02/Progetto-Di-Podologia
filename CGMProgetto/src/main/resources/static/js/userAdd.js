const username = document.querySelector("#username");
const password = document.querySelector("#password");
const roleQuerySelector = document.querySelector("#role");
const addBtn = document.querySelector("#addUser");
const errorForm = document.querySelector("#errorForm");

const URL = "http://localhost:9026/api/user"

addBtn.addEventListener("click", checkUser);

function User(username, password, role){
    this.username = username;
    this.password = password;
    this.role = role;
}

function checkUser(){
    let usernameValue = username.value;
    let passwordValue = password.value;
    let roleValue = roleQuerySelector.value;
    console.log(password.value);
    console.log(usernameValue.length);

    if(usernameValue.length >= 8 && usernameValue.length <= 20){
        if(passwordValue.length >= 8 && passwordValue.length <= 20){
            let user = new User(usernameValue, passwordValue, roleValue);
            sendUser(user);
        } else {
            showErrorToast();
            errorForm.removeAttribute("hidden");
        }
    } else {
        showErrorToast();
        errorForm.removeAttribute("hidden");
    }
}

function sendUser(user){

    fetch(URL,{
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
    // .then(response => response.json())
    .then(data => {
        showOkToast();
        removeValues();
        console.log("OK");
        
    
    })
    .catch(error =>{
        console.log(error);
        errorForm.removeAttribute("hidden");
    })
}

function removeValues(){
    username.value = '';
    password.value = '';
}

function showOkToast(){
    const toastLiveExample = document.getElementById('okToast')  
    const toast = new bootstrap.Toast(toastLiveExample)
    toast.show()
}
function showErrorToast(){
    const toastLiveExample = document.getElementById('errorToast')  
    const toast = new bootstrap.Toast(toastLiveExample)
    toast.show()
}
