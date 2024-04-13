function getSolution(url,source,destiny) {

    var source = document.getElementById(source).value;

    // Create an object with the data to send
    var data = source;

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

function getSubproblem(url) {

    var downCode = document.getElementById('downCode').value;
    var input = document.getElementById('input').value;

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

}




document.getElementById("input").addEventListener("change", function() {
    getSolution("/api/sol/recursiveSum",'input','solution');
    getSubproblem("/api/sub/recursiveSum");
});

document.getElementById("downCode").addEventListener("change", function() {
    getSubproblem("/api/sub/recursiveSum");
});