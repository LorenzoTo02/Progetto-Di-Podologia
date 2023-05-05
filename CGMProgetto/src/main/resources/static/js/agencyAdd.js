const button = document.querySelector("#addAgency");

button.addEventListener("click", caricaAzienda);


function caricaAzienda(){
    let agencyName = document.querySelector("#agency").value;
    if(agencyName == ''){
        showErrorToast();
    } else {
        addAzienda(agencyName);
        showOkToast();
    }

}

function showErrorToast(){

    const toastLiveExample = document.getElementById('liveToast')
    
    const toast = new bootstrap.Toast(toastLiveExample)

    toast.show()
        
    
}
function showOkToast(){

    const toastLiveExample = document.getElementById('okToast')
    
    const toast = new bootstrap.Toast(toastLiveExample)

    toast.show()
        
    
}

function AgencyObj(name){
    this.name = name;
}

const URL = "http://localhost:9026/api/agency"

function addAzienda(nome){

    let agency = new AgencyObj(nome);

    let agencyForm = document.querySelector("#agency");

    console.log(nome);
    console.log(agency);

    fetch(URL, {
        method: 'POST',
        headers: {
            
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(agency) 
    })
    .then(data => {data.json
        console.log(data.ok);
        if(data.ok){
            agencyForm.value = "";
            setInterval(function returnHome() {
                window.location.replace("/");
            }, 200)
        }
    }) 
    .catch(response => {
        console.log(response)
    })
}