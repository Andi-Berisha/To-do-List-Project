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

        })
        .catch(function (error) {
            console.log('Request failed', error);
        });
}
