

const URLParams = new URLSearchParams(window.location.search);
let id = URLParams.get("id");

const URL = "http://localhost:9026/api/agency/" + id;

let listButtonString = "/companies/agency/list?id=" + id;

const deleteAgency = document.querySelector("#deleteAgencyButton");

fetch(URL)
.then(data => {
    return data.json()
})
.then(response => {

    titleBuilder(response);
    console.log(response);
});

function titleBuilder(azienda){
    titolo1.textContent = azienda.name;
    titolo2.textContent = azienda.name;
    titolo3.innerHTML = azienda.name;
}



let titolo1 = document.querySelector("#titoloPagina")
let titolo2 = document.querySelector("#titoloPagina2")
let titolo3 = document.querySelector("#spanAgency")
let button = document.querySelector("#buttonList");

button.setAttribute("href",listButtonString);


console.log(id);

// -------------------- MODAL -------------------------



// const myModal = document.getElementById('myModal')
// const myInput = document.getElementById('myInput')

// myModal.addEventListener('shown.bs.modal', () => {
//   myInput.focus()
// })

let pulsante = document.querySelector("#addButton");


pulsante.addEventListener("click", addAnimal);

function Animale(earTag, birthday) {
    this.earTag = earTag;
    this.birthday = birthday;
};

function addAnimal(){
    let earTag = document.getElementById("earTag").value;
    let dataNascita = document.getElementById("dataNascita").value;

    if(earTag.match(`[A-Z]{2}[0-9]{12}`)){
        const URLPOST = "http://localhost:9026/api/animal/agency?value=" + id;



        let animale = new Animale(earTag, dataNascita);

        fetch(URLPOST, {
            method: 'POST',
            headers: {
            
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(animale) 
        })
        .then(data => {data.json
            if(data.ok){
                closeModal();
                showOkToast();
            } else {
                showErrorToast();
            }
        }) 
        .then(response => {
            console.log(response);
        })


        } else {
            showErrorToast();
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

let error = document.querySelector("#errors");

let modalError = new bootstrap.Modal("#ConfirmDeleteModal");

const modal = new bootstrap.Modal("#staticBackdrop");

function closeModal(){
    modal.hide();
}

deleteAgency.addEventListener("click", deleteAgencyFunction);



function deleteAgencyFunction(){
    let confirm = document.querySelector("#confirmDelete");
    
    error.innerHTML = "";

    if(confirm.value == "CONFERMA"){
        modalError.hide();
        deleteFetch();
    } else {
        error.innerHTML = "Digitare 'CONFERMA' per eliminare l'azienda"
    }

}

function deleteFetch(){
    const URLDELETE = "http://localhost:9026/api/agency/" + id;
    fetch(URLDELETE, {
        method: 'DELETE',
    })
        .then(res => {res.text()
            if(res.ok){
                window.location.replace("/");
            }
        })
        .then(res => console.log(res))
}


