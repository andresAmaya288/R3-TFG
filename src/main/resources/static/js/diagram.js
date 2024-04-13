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

    var data = "downCode=" + encodeURIComponent(downCode) + "&input=" + encodeURIComponent(input);

    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    // Set up the response callback
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                document.getElementById('subproblem').textContent = xhr.responseText;
                // Update some interface element if needed
            } else {
                console.log('Request error. Status code:', xhr.status);
            }
        }
    };

    // Send the request with the data
    xhr.send(data);
}




document.getElementById("input").addEventListener("change", function() {
    getSolution("/api/sol/recursiveSum",'input','solution');
    getSubproblem("/api/sub/recursiveSum");
});
document.getElementById("subproblem").addEventListener("change", function() {
    getSolution("/api/sol/recursiveSum",'subproblem','subsoluion')
});