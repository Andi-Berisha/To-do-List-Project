let div = document.getElementById("data");
let status = document.getElementById("status");


document
    .querySelector("form.viewRecordUser")
    .addEventListener("submit", function (stop) {
        stop.preventDefault();
        let id = document.getElementById("newUserName").value;

        console.log(id)

        sendData(id)
    });


function sendData(id) {
    fetch('http://localhost:8081/user/read/' + id)
        .then(
            function (response) {
                if (response.status !== 200) {
                    console.log('A problem was encountered. Status Code: ' +
                        response.status);
                    let p = document.createElement("p")
                    p.innerText = "User not found, try again"
                    status.appendChild(p)
                    return;
                }

                response.json().then(function (data) {
                    // console.log("MY DATA OBJ", data)

                    // document.querySelector("input#id").value = data.id
                    // document.querySelector("input#user_name").value = data.user_name
                    console.log(data)
                    displayData(data)


                });
            }
        )
        .catch(function (err) {
            console.log('Fetch Error :-S', err);
        });
}


function displayData(data) {
    div.innerText = ''

    let name = document.createElement("p")
    let surname = document.createElement("p")


    name.innerText = data.user_name;
    surname.innerText = data.user_surname;


    let listOfTasks = document.createElement("ul");

    for (let i = 0; i < data.tasks.length; i++) {
        let task = document.createElement("li")
        let isComplete = document.createElement("li")

        // Add string literals later
        task.innerText = data.tasks[i].task_name;
        isComplete.innerText = `Completed: ${data.tasks[i].hasTaskBeenCompletedCheck}`;

        listOfTasks.appendChild(task)
        listOfTasks.appendChild(isComplete)

    }

    div.appendChild(name)
    div.appendChild(surname)
    div.appendChild(listOfTasks)



}
