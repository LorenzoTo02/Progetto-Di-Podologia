let table = document.querySelector("#tbodyTable");
const URL = "http://localhost:9026/api/patologyType"

fetch(URL)
    .then(data => {
        return data.json()
    })
    .then(response => {

        tableBuilder(response);
        console.log(response);
        
    });

function tableBuilder(patologies) {
    htmlCode = '';
    patologies.forEach(patology => {
        htmlCode += `
            <tr class="fs-3">
                <th scope="row">${patology.name}</th>
                <td class="d-flex justify-content-center">${deleteButtonBuilder(patology)}</td>
            </tr>`;
    });
    table.innerHTML = htmlCode;
}

function deleteButtonBuilder(patology){
    return `<a class="btn btn-danger" id="${patology.id}" onclick="deleteButton(${patology.id})"><i class="bi bi-trash"></i></a>`;
}

function deleteButton(id){
    fetch(URL + "?id=" + id, {
        method: 'DELETE',
    })
        .then(res => {res.text()
            if(res.ok){
                showOkToast();
                setInterval(function returnBack(){
                    window.location.reload();
                }, 450)
            }
        }) // or res.json()
        .then(res => console.log(res))
}

function showOkToast(){

    const toastLiveExample = document.getElementById('okToast')
    
    const toast = new bootstrap.Toast(toastLiveExample)

    toast.show()
        
    
}