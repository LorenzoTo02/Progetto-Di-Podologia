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
    idSix.textContent = earTag.substring(8,14);

    patologyBuilder(animal.patologies);

}

let nodata = document.querySelector("#no");


function patologyBuilder(patologies){
    let htmlCode = '';

    if(patologies.length == 0){
        nodata.classList.add("d-flex");      
    } else {
        patologies.forEach(patology => {
            nodata.classList.add("d-none");
            htmlCode += 
            `<tr class="fs-3">
                    <th scope="row">${patology.patology}</th>
                    <td>${patology.date}</td>
                    <td class="d-flex justify-content-center">${deleteButtonBuilder(patology)}</td>
            </tr>`;
            table.innerHTML = htmlCode;
        });
    }

   

    
}

let table = document.querySelector("#tbodyTable");

function deleteButtonBuilder(patology){
    return `<a class="btn btn-danger" id="${patology.id}" onclick="deleteButton(${patology.id})"><i class="bi bi-trash"></i></a>`
}

function deleteButton(id){
    fetch('http://localhost:9026/api/patology/' + id, {
        method: 'DELETE',
    })
        .then(res => res.text()) // or res.json()
        .then(res => console.log(res))

    window.location.reload();
}