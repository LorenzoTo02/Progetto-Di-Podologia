const URLParams = new URLSearchParams(window.location.search);
let id = URLParams.get("id");

const URL = "http://localhost:9026/api/agency/" + id;

let listButtonString = "/companies/agency/list?id=" + id;



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
}



let titolo1 = document.querySelector("#titoloPagina")
let titolo2 = document.querySelector("#titoloPagina2")
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

    const URLPOST = "http://localhost:9026/api/animal/agency?value=" + id;



    let animale = new Animale(earTag, dataNascita);

   

    fetch(URLPOST, {
        method: 'POST',
        headers: {
            
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(animale) 
    })
    .then(data => data.json) 
    .then(response => {
        console.log(response);
    })

}




