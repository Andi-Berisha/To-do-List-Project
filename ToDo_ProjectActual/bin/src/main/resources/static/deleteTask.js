let div = document.getElementById("data");
let status = document.getElementById("status");


document
    .querySelector("form.viewRecordUser")
    .addEventListener("submit", function (stop) {
        stop.preventDefault();
        let id = document.getElementById("newUserName").value;

        console.log(id)

        deleteUser(id)
    });



function deleteUser(id) {
    fetch("http://localhost:8081/task/delete/" + id, {
        method: 'delete',
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
    }).then(function (response) {
        if (response.status !== 200) {
            //location.reload();
            msg();
            return;
        }

        response.json().then(function (response) {
            console.log("Expecting error code to be 204 when deleting: " + response.status);

        });
    })


}

function msg() {
    let p = document.createElement("a");
    p.href = "/HTML/Andi/Index.html"
    p.innerText = "Successfully deleted, click here to go back"
    p.setAttribute("class", "success")

    status.appendChild(p);
}

// function displayData(data) {
//     div.innerText = ''

//     let name = document.createElement("p")
//     let surname = document.createElement("p")


//     name.innerText = data.user_name;
//     surname.innerText = data.user_surname;


//     let listOfTasks = document.createElement("ul");

//     for (let i = 0; i < data.tasks.length; i++) {
//         let task = document.createElement("li")
//         let isComplete = document.createElement("li")

//         task.innerText = data.tasks[i].task_name;
//         isComplete.innerText = `Completed? ${data.tasks[i].hasTaskBeenCompletedCheck}`;

//         listOfTasks.appendChild(task)
//         listOfTasks.appendChild(isComplete)

//     }

//     div.appendChild(name)
//     div.appendChild(surname)
//     div.appendChild(listOfTasks)



// }
