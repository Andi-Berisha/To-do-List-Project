document
    .querySelector("form.viewRecordUser")
    .addEventListener("submit", function (stop) {
        stop.preventDefault();

        let name = document.getElementById("name").value
        let surname = document.getElementById("surname").value

        console.log(name, surname);


        let newUser = {
            "user_name": name,
            "user_surname": surname,
            "task": []
        }

        console.log("Data to post", newUser)


        createUser(newUser)
    });

function createUser(data) {
    fetch("http://localhost:8081/user/create", {
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
