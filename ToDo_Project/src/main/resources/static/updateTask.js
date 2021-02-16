let status = document.getElementById("status");

document
    .querySelector("form.viewRecordUser")
    .addEventListener("submit", function (stop) {
        stop.preventDefault();

        let taskID = document.getElementById("taskID").value;
        let newTaskName = document.getElementById("newTaskName").value
        let isComplete = document.getElementById("TaskCompletionCheck").value
        let userID = document.getElementById("userID").value;


        let task = {

            "id": taskID,
            "task_name": newTaskName,
            "hasTaskBeenCompletedCheck": isComplete,
            "user": {
                "id": userID
            }
        }


        console.log("Data to post", task)


        UpdateUser(task, taskID)
    });

function UpdateUser(data, id) {
    fetch("http://localhost:8081/task/update/" + id, {
        method: 'put',
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(data)
    })
        .then(function (data) {
            console.log('Request succeeded with JSON response', data);
            console.log("updated!");
            msg();

        })
        .catch(function (error) {
            console.log('Request failed', error);
        });
}

function msg() {
    let p = document.createElement("a");
    p.href = "/HTML/Andi/Index.html"
    p.innerText = "Successfully Created, click here to go back"
    p.setAttribute("class", "success")

    status.appendChild(p);
}
