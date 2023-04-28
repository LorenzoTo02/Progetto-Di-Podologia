const URLParams = new URLSearchParams(window.location.search);
let id = URLParams.get("id");
let value = URLParams.get("agency");

const URL = "http://localhost:9026/api/animal/" + id;


fetch(URL)
.then(data => {
    return data.json()
})
.then(response => {

    animalBuilder(response);
    console.log(response);
});



function animalBuilder(animal){

    let earTag = animal.earTag;
    let data = animal.birthday; 

    orecchino.textContent = earTag;
    age.textContent = data;
    console.log(data);
    idSix.textContent = earTag.substring(8,14);
    
    
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

    let select = document.querySelector("#patology");

    let malattia = new Patology();

    switch (select.value) {
        case "1":
            malattia.setPatology("DERMATITE");
            break;
        case "2":
            malattia.setPatology("ASCESSO");
            break;
        case "3":
            malattia.setPatology("FLEMMONE");
            break;

        default:
            break;
    }

    console.log(select.value);
    console.log(malattia);

    fetch(URLPOST, {
        method: 'POST',
        headers: {
            
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(malattia) 
    })
    .then(data => data.json) 
    .then(response => {
        console.log(response);
    })

}


// ----- PULSANTE CARTELLA CLINICA

let buttonMedical = document.querySelector("#buttonMedical");

buttonMedical.setAttribute("href","http://localhost:9026/companies/agency/animal/medical?id=" + id + "&agency=" + value);


