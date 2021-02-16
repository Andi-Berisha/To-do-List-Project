let status = document.getElementById("status");

document
    .querySelector("form.viewRecordUser")
    .addEventListener("submit", function (stop) {
        stop.preventDefault();

        let name = document.getElementById("name").value
        let userID = document.getElementById("userID").value

        console.log(name);


        let newTask = {

            "task_name": name,
            "hasTaskBeenCompletedCheck": false,
            "user": {
                "id": userID
            }
        }

        console.log("Data to post", newTask)


        createUser(newTask)
    });

function createUser(data) {
    fetch("http://localhost:8081/task/create", {
        method: 'post',
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        },
        body: JSON.stringify(data)
    })
        .then(function (data) {
            console.log('Request succeeded with JSON response', data);
            console.log("created!");
            msg();

        })
        .catch(function (error) {
            console.log('Request failed', error);
        });
}


function msg() {
    let p = document.createElement("a");
    p.href = "/HTML/Andi/Index.html"
    p.innerText = "Task Successfully Created, click here to go back"
    p.setAttribute("class", "success")

    status.appendChild(p);
}
