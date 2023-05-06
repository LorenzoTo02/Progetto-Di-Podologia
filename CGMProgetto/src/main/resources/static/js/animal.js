const URLParams = new URLSearchParams(window.location.search);
let id = URLParams.get("id");
let value = URLParams.get("agency");
const textarea = document.querySelector("#descrizioneAnimale");
const descButton = document.querySelector("#descButton");
let animalDescription;
let select = document.querySelector("#patology");
const deleteButton = document.querySelector("#removeAnimal");
const motivation = document.querySelector("#motivation");

const URL = "http://localhost:9026/api/animal/" + id;
const URLPATOLOGY = "http://localhost:9026/api/patologyType"



fetch(URL)
.then(data => {
    return data.json()
})
.then(response => {

    animalBuilder(response);
    console.log(response);
});

fetch(URLPATOLOGY)
    .then(data => {
        return data.json();
    })
    .then(response => {
        patologyOptionBuilder(response)
    });



function animalBuilder(animal){

    let earTag = animal.earTag;
    let data = animal.birthday; 

    orecchino.textContent = earTag;
    age.textContent = data;
    
    idSix.textContent = earTag.substring(8,14);
    textarea.textContent = animal.description;
    animalDescription = animal.description;
    
    
}



let orecchino = document.querySelector("#earTag");
let age = document.querySelector("#age");
let idSix = document.querySelector("#idSix");


// MODAL

let addButton = document.querySelector("#addButton");

addButton.addEventListener("click",patologyPost);


class Patology{
    constructor(){
        this.patology = null;
    }
    setPatology(patologia){
        this.patology = patologia;
    }
}


function patologyPost(){

   

    const URLPOST = "http://localhost:9026/api/patology/animal/" + id;

   

    let malattia = new Patology();
    malattia.setPatology(select.value);
    

    console.log(select.value);
    console.log(malattia);

    fetch(URLPOST, {
        method: 'POST',
        headers: {
            
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(malattia) 
    })
    .then(data => {data.json
        console.log(data.ok); 
        if(data.ok){
            showOkToast();
        }   
    }) 
    .then(response => {
        console.log(response)      
    })
    

}

function showOkToast(){

        const toastLiveExample = document.getElementById('liveToast')
        
        const toast = new bootstrap.Toast(toastLiveExample)

        toast.show()
            
        
}


// ----- PULSANTE CARTELLA CLINICA

let buttonMedical = document.querySelector("#buttonMedical");

buttonMedical.setAttribute("href","http://localhost:9026/companies/agency/animal/medical?id=" + id + "&agency=" + value);

textarea.addEventListener("input", function button() {

    if(textarea.value != animalDescription){
        
        descButton.removeAttribute("hidden");
    } else {
        descButton.setAttribute("hidden","");
    }
})

descButton.addEventListener("click", function updateDescription(){
    
    fetch("http://localhost:9026/api/animal/description?id="+id, {
        method: 'PUT',
        headers: {
        
            'Content-Type': 'application/json'
        },
        body: textarea.value
    })
    .then(data => {data.json
        if(data.ok){
            showOkToast();
            setInterval(function reloadPage(){
                window.location.reload();
            }, 450)
            
        }
    }) 
    .then(response => {
        console.log(response);
    })
});


function showOkToast(){

    const toastLiveExample = document.getElementById('liveToast')
    
    const toast = new bootstrap.Toast(toastLiveExample)

    toast.show()
        
    
}
function showOkDescToast(){

    const toastLiveExample = document.getElementById('okToast')
    
    const toast = new bootstrap.Toast(toastLiveExample)

    toast.show()
        
    
}
function showOkDelToast(){

    const toastLiveExample = document.getElementById('delToast')
    
    const toast = new bootstrap.Toast(toastLiveExample)

    toast.show()
        
    
}

function patologyOptionBuilder(patologiesType){

    let htmlCode = '';
    
    patologiesType.forEach(patologyType => {
        htmlCode += `
            <option value="${patologyType.name}">${patologyType.name.toLowerCase()}</option>
        `;
        console.log(htmlCode);
        console.log(patologyType);
        
    });

    select.innerHTML += htmlCode;
    
}

// DELETE ANIMAL


deleteButton.addEventListener("click", deleteAnimal);

function deleteAnimal(){
    const URLDELETE = "http://localhost:9026/api/animal/" + id + "?motivation=" + motivation.value;
    fetch(URLDELETE, {
        method: 'DELETE',
    })
        .then(res => {res.text()
            if(res.ok){
                showOkDelToast();
                setInterval(function returnBack(){
                    window.history.back();
                }, 450)
            }
        }) // or res.json()
        .then(res => console.log(res))
}