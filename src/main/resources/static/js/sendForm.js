function submitForm() {
    // Get the values of the form fields
    var condition = document.getElementById("condition").value;
    var operation = document.getElementById("operation").value;
    var downCode = document.getElementById("downCode").value;
    var upCode = document.getElementById("upCode").value;
    var proId = document.getElementById("proId").value;

    // Create an object with the form data
    var formData = {
        condition: condition,
        operation: operation,
        downCode: downCode,
        upCode: upCode
    };


    // Set up the request
    var url = '/api/problem/'+ proId + '/solution'; // Replace {{id}} with the corresponding ID
    var options = {
        method: 'POST', // Request method (in this case, POST)
        headers: {
            'Content-Type': 'application/json' // Specify that we're sending JSON
        },
        body: JSON.stringify(formData) // Convert the JavaScript object to JSON
    };

    // Make the request using the fetch API
    fetch(url, options)
        .then(function(response) {
            // Check if the request was successful
            if (response.ok) {
                // Process the response if needed
                return response.json();
            } else {
                // Handle request errors
                throw new Error('Error submitting form. Response status: ' + response.status);
            }
        })
        .then(function(data) {
            // Print the response body
            console.log('Response body:', data);
            // Print true or false based on the response
            console.log('Response is:', data === true ? 'true' : 'false');

            element = document.getElementById("solutionFeedback");
            if(data === true){
                element.innerHTML= '<a style="font-weight: bold; color: green;">Enhorabuena!!</a> Has resuelto el problema';
            }else {
                element.innerHTML= '<a style="font-weight: bold; color: red;">X</a> Ups, parece que has fallado el problema, puedes volver a intentarlo';
            }
        })
        .catch(function(error) {
            // Handle network or other errors
            console.error('There was a problem with the fetch request:', error.message);
        });
}

// Add a 'submit' event listener to the form to call the submitForm function
document.getElementById("proForm").addEventListener("submit", function(event) {
    // Prevent the form from being submitted by default
    event.preventDefault();
    // Call the submitForm function
    submitForm();
});
