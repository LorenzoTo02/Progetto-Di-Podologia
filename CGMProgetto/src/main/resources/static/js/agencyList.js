
const URL = "http://localhost:9026/api/agency"

fetch(URL)
.then(data => {
    return data.json()
})
.then(response => {

    buttonBuilder(response);
    console.log(response);
});

function buttonBuilder(listaAziende){
    listaAziende.forEach(azienda => {
        let name = azienda.name;
        let id = azienda.id;
        
        let button = document.createElement("a");
        button.setAttribute("class","btn btn-primary agencyButton");
        button.setAttribute("href","/companies/agency?id=" + id);
        button.textContent = name;

        let buttonBox = document.createElement("div");
        buttonBox.setAttribute("class","d-flex justify-content-center");

        let colDiv = document.createElement("div");
        colDiv.setAttribute("class","col-md-6 col-12 mb-3");

        buttonBox.appendChild(button);
        colDiv.appendChild(buttonBox);
        agencyContainer.appendChild(colDiv);


    });
}

let agencyContainer = document.querySelector("#agencyContainer");