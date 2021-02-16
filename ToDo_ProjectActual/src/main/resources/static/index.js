let div = document.getElementById("read");
fetch('http://localhost:8081/user/readAll/')
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
                console.log(data)
                readAll(data)


            });
        }
    )
    .catch(function (err) {
        console.log('Fetch Error :-S', err);
    });


function readAll(data) {
    let listOfUsers = document.createElement("ul");
    for (let i = 0; i < data.length; i++) {
        let id = document.createElement("li")
        let name = document.createElement("li")
        let surname = document.createElement("li")
        let span = document.createElement("span")
        let task = document.createElement("ul")

        for (let j = 0; j < data[i].tasks.length; j++) {
            let id = document.createElement("li")
            let task_name = document.createElement("li")



            id.innerText = `Task ID: ${data[i].tasks[j].id}`
            task_name.innerText = `Task Name: ${data[i].tasks[j].task_name}`

            task.appendChild(id)
            task.appendChild(task_name)
        }


        name.innerText = `Name: ${data[i].user_name}`;
        surname.innerText = `Surname: ${data[i].user_surname}`;
        id.innerText = `User ID: ${data[i].id}`;
        span.innerText = "\n"


        listOfUsers.appendChild(id)
        listOfUsers.appendChild(name)
        listOfUsers.appendChild(surname)
        listOfUsers.appendChild(task);
        listOfUsers.appendChild(span);
    }
    div.appendChild(listOfUsers);
}