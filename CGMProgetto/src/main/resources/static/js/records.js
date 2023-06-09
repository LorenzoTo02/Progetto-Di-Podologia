const URLParams = new URLSearchParams(window.location.search);
let id = URLParams.get("id");
let value = URLParams.get("agency");
const tabellaHistory = document.querySelector("#historyTable");
let nodata = document.querySelector("#no");
let noDataHistory = document.querySelector("#noHistory");

const URL = "http://localhost:9026/api/animal/" + id;
const URLHISTORY = "http://localhost:9026/api/historyPatology/" + id;

onload = getPatologies();

function getPatologies(){
    fetch(URL)
    .then(data => {
        return data.json()
    })
    .then(response => {

        animalBuilder(response);
        console.log(response);
        
    });
    fetch(URLHISTORY)
    .then(data => {
        return data.json()
    })
    .then(response => {

        patologyHistoryBuilder(response);
        console.log(response);
        
    });
}

function animalBuilder(animal){
    let earTag = animal.earTag;
    idSix.textContent = earTag.substring(8,14);

    patologyBuilder(animal.patologies);

}




function patologyBuilder(patologies){
    table.innerHTML = '';
    let htmlCode = '';

    if(patologies.length == 0){
        nodata.classList.remove("d-none");
        nodata.classList.add("d-flex");          
    } else {
        patologies.forEach(patology => {
            nodata.classList.add("d-none");
            htmlCode += 
            `<tr class="fs-3">
                    <th scope="row">${patology.patology}</th>
                    <td>${patology.date}</td>
                    <td class="text-danger fw-bold">${dayPatologyBuilder(patology.date)}</td>
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
        .then(res => {res.text()
            if(res.ok){
                showOkToast();
                getPatologies();
            }
        }) // or res.json()
        .then(res => console.log(res))

    // window.location.reload();
}

function showOkToast(){

    const toastLiveExample = document.getElementById('liveToast')
    
    const toast = new bootstrap.Toast(toastLiveExample)

    toast.show()
        
    
}

function patologyHistoryBuilder(patologies){
    tabellaHistory.innerHTML = '';
    let htmlCode = '';

    if(patologies.length == 0){
        noDataHistory.classList.remove("d-none");
        noDataHistory.classList.add("d-flex");          
    } else {
        noDataHistory.classList.add("d-none");
        patologies.forEach(patology => {
            htmlCode += 
            `<tr class="fs-3">
                    <th scope="row">${patology.patology}</th>
                    <td>${patology.date}</td>
                    <td>${patology.healingDate}</td>
            </tr>`;
        });
        tabellaHistory.innerHTML = htmlCode;
    }
  
}

function dayPatologyBuilder(date){
    let data = Date.parse(date);
    let oggi = Date.now();

    if(Math.round((oggi - data)/86400000) == 1){
        return Math.round((oggi - data)/86400000) + "g";
    }else if(Math.round((oggi - data)/86400000) == 0){
        return "Da oggi";
    }else{
        return Math.round((oggi - data)/86400000) + "gg";
    }

    
}