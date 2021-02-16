let status = document.getElementById("status");

document
    .querySelector("form.viewRecordUser")
    .addEventListener("submit", function (stop) {
        stop.preventDefault();

        let userID = document.getElementById("userID").value;
        let newUserName = document.getElementById("newUserName").value
        let newUserSurname = document.getElementById("newUserSurname").value;

        console.log(userID, newUserName, newUserSurname);



        let user = {
            "id": userID,
            "user_name": newUserName,
            "user_surname": newUserSurname
        }

        console.log("Data to post", user)


        UpdateUser(user, userID)
    });

function UpdateUser(data, id) {
    fetch("http://localhost:8081/user/update/" + id, {
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
    p.innerText = "Successfully Updated User, click here to go back"
    p.setAttribute("class", "success")

    status.appendChild(p);
}