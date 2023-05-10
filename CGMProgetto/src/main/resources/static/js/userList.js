const URL = "http://localhost:9026/api/user"
const table = document.querySelector("#tbodyTable");

addEventListener("load", loadData);


function loadData(){
    fetch(URL)
        .then(data => {
            return data.json()
        })
        .then(response => {

            tableBuilder(response);
   
        });
}

function tableBuilder(users){
    let htmlCode = '';
    users.forEach(user => {
        htmlCode += `
        <tr class="fs-3">
            <th scope="row">${user.id}</th>
            <td>${user.username}</th>
            <td>${user.role}</td>
            <td>${deleteButtonBuilder(user.id)}</td>
        </tr>
        `
    });

    table.innerHTML = htmlCode;
}

function deleteButtonBuilder(id){
    return `<a class="btn btn-danger" id="${id}" onclick="deleteButton(${id})"><i class="bi bi-trash"></i></a>`
}

function deleteButton(id){
    fetch('http://localhost:9026/api/user/' + id, {
        method: 'DELETE',
    })
        .then(res => {res.text()
            if(res.ok){
                showOkToast();
                loadData();
            }
        }) // or res.json()
        .then(res => console.log(res))

    // window.location.reload();
}

function showOkToast(){

    const toastLiveExample = document.getElementById('okToast')
    
    const toast = new bootstrap.Toast(toastLiveExample)

    toast.show()
        
    
}