fetch('https://pokeapi.co/api/v2/pokemon/pikachu')
    .then(
        function (response) {
            if (response.status !== 200) {
                console.log('Looks like there was a problem. Status Code: ' +
                    response.status);
                return;
            }

            // Examine the text in the response
            response.json().then(function (data) {
                console.log(data);
                displayName(data)
            });
        }
    )
    .catch(function (err) {
        console.log('Fetch Error :-S', err);
    });

function displayName(data) {
    let name = document.querySelector("div#Body")
    let n = document.createElement("button")
    n.innerText = data.name
    name.appendChild(n)
}

