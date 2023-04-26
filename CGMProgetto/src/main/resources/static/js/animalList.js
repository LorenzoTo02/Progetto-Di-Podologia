
const URLParams = new URLSearchParams(window.location.search);
let id = URLParams.get("id");
const URL = "http://localhost:9026/api/animal/agency/" + id;

fetch(URL)
.then(data => {
    return data.json()
})
.then(response => {

    tableBuilder(response);
    console.log(response);
});

function tableBuilder(animalsList){
    let htmlCode = '';
    animalsList.forEach(animal => {
        htmlCode += 
        `<tr class="fs-3">
                <th scope="row">${animal.id}</th>
                <td>${animal.earTag}</td>
                <td>${animal.birthday}</td>
                <td>${calcolaEta(animal.birthday)} anni</td>
                <td>${calcolaEtaMesi(animal.birthday)} mesi</td>
                <td>${buttonBuilder(animal)}</td>
        </tr>`;

    });

    table.innerHTML = htmlCode;
}


function buttonBuilder(animal){
    let htmlCode =
    `   <a href="http://localhost:9026/companies/agency/animal?agency=${animal.agency.id}&id=${animal.id}" class="btn btn-outline-primary fs-2" type="button"">
            Vedi
        </a>`
    return htmlCode;
}


let table = document.querySelector("#tbodyTable");
let button = document.querySelector("#buttonSearch");
let buttonReload = document.querySelector("#buttonReload");
let inputSearch = document.querySelector("#inputEarTag");

button.addEventListener("click", search);
buttonReload.addEventListener("click", reload);


function search(){
    let inputValue = document.querySelector("#inputEarTag").value;
    console.log(inputValue);
    // if(inputValue.length == 6){
        console.log("ciclo if");
        let UrlSearch = "http://localhost:9026/api/animal/agency?id=" + URLParams.get("id") + "&earTag=" + inputValue;

        table.removeChild;

        fetch(UrlSearch)
            .then(data => {
            return data.json()
        })
            .then(response => {

                tableBuilder(response);

                console.log(response);
        });


    //}

}

function reload(){
    inputSearch.value = "";
    fetch(URL)
        .then(data => {
        return data.json()
    })
        .then(response => {

        tableBuilder(response);
        console.log(response);
    });
}

function calcolaEta(birthday){
    let d = new Date(birthday);
    console.log(typeof birthday);

    let today = Date.now();

    let age = today - d.getTime();
    
    return Math.round(age * (3.171 * Math.pow(10,-11)));
}


function calcolaEtaMesi(birthday){
    let d = new Date(birthday);
    console.log(typeof birthday);

    let today = Date.now();

    let age = today - d.getTime();

    return Math.round(age * (3.805 * Math.pow(10,-10)));
}