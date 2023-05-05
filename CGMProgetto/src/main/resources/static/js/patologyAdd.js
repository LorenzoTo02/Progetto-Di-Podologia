const patologyInput = document.querySelector("#patology");
const patologyadd = document.querySelector("#addPatology");
const URL = "http://localhost:9026/api/patologyType"

patologyadd.addEventListener("click", uploadPatology);

function Patology(name){
    this.name = name;
}

function uploadPatology(){
    if(patologyInput.value != null){
        let p = new Patology(patologyInput.value);
        fetch(URL, {
            method: 'POST',
            headers: {
                
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(p) 
        })
        .then(data => {data.json
            console.log(data.ok); 
            if(data.ok){
                showOkToast();
                setInterval(function goback(){
                    window.location.replace("/");
                }, 450)
            }   
        }) 
        .then(response => {
            console.log(response)      
        })
    }
}

function showOkToast(){
    const toastLiveExample = document.getElementById('okToast');
    const toast = new bootstrap.Toast(toastLiveExample);
    toast.show();   
}