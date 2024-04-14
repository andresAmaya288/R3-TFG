function getSolution(source,destiny) {

    var initialValue = document.getElementById(source).value;
    var url = document.getElementById("apiSolUrl").value;
    // Create an object with the data to send
    var data = initialValue;

    // Create the HTTP request
    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, true);
    xhr.setRequestHeader('Content-Type', 'application/json');

    // Set up the response callback
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                document.getElementById(destiny).textContent = xhr.responseText;
            } else {
                console.log('Request error. Status code:', xhr.status);
            }
        }
    };

    // Send the request with the form data in JSON format
    xhr.send(encodeURIComponent(data));
}

function getSubproblem(source, code, destiny, final) {

    var downCode = document.getElementById(code).value;
    var input = document.getElementById(source).value;
    var url = document.getElementById("apiSubUrl").value;

    var data = {
        input: input,
        downCode:downCode
    };


    var options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };

    fetch(url, options)
        .then(function(response) {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Error submitting form. Response status: ' + response.status);
            }
        })
        .then(function(data) {
            console.log('Response body:', data);
            document.getElementById('subproblem').textContent = data;

        })
        .catch(function(error) {
            console.error('There was a problem with the fetch request:', error.message);
        });

    getSolution(destiny,final);

}


document.getElementById("input").addEventListener("change", function() {
    getSolution('input','solution');
    getSubproblem('input', 'downCode', 'subproblem','subsolution');
});

document.getElementById("downCode").addEventListener("change", function() {
    getSubproblem('input', 'downCode', 'subproblem','subsolution');
});
