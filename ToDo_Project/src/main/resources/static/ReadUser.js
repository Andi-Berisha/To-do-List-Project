'use strict';


const parameters = new URLSearchParams(window.location.search);

// Obtains ID and passes it as a parameter to getData()
for (let param of params) {
    console.log("Object ID: " + param)
    let id = param[1];
    console.log(id);
    getData(id)
}



function getData(id) {
    fetch('http://localhost:8081/user/read/' + id)
        .then(
            function (response) {
                if (response.status !== 200) {
                    console.log('A problem was encountered. Status Code: ' +
                        response.status);
                    return;
                }

                response.json().then(function (data) {
                    console.log("MY DATA OBJ", data)

                    document.querySelector("input#id").value = data.id
                    document.querySelector("input#user_name").value = data.user_name



                });
            }
        )
        .catch(function (err) {
            console.log('Fetch Error :-S', err);
        });
}


document
    .querySelector("form.viewRecordUser")
    .addEventListener("submit", function (stop) {
        stop.preventDefault();
        let formElements = document.querySelector("form.viewRecord").elements;
        console.log(formElements)

        let id = formElements["id"].value;
        let user_name = formElements["user_name"].value;
        let user_surname = formElements["user_surname"].value;


        let data = {
            "id": id,
            "user_name": user_name

        }
        console.log("Data to post", data)
        console.log(id)

        sendData(data, id)
    });