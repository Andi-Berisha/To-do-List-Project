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
    fetch("http://localhost:8081/user/delete/" + id, {
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

