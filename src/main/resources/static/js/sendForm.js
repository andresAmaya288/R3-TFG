function submitForm() {
    // Get the value of the problem ID
    var proId = document.getElementById("proId").value;

    // Create arrays to store the values of operation, condition, upCode, and downCode fields
    var operations = [];
    var conditions = [];
    var upCodes = [];
    var downCodes = [];

    // Loop through the possible fields and store their values
    var i = 0;
    var aux = true;
    while (aux) {
        var operationField = document.getElementById("operation" + i);
        var conditionField = document.getElementById("condition" + i);
        var upCodeField = document.getElementById("upCode" + i);
        var downCodeField = document.getElementById("downCode" + i);

        // Verificar si alguno de los campos es nulo y, si i es igual a 0, asignar los valores a las variables
        if (!operationField && !conditionField && !upCodeField && !downCodeField) {
            if (i === 0) {
                operationField = document.getElementById("operation");
                conditionField = document.getElementById("condition");
                upCodeField = document.getElementById("upCode");
                downCodeField = document.getElementById("downCode");
            }else{
                aux= true;
            }
        }

        // Verificar si los campos de operation y condition no son nulos
        if (operationField && conditionField) {
            operations.push(operationField.value);
            conditions.push(conditionField.value);
        }
        // Verificar si los campos de upCode y downCode no son nulos
        if (upCodeField && downCodeField) {
            upCodes.push(upCodeField.value);
            downCodes.push(downCodeField.value);
        }

        // Actualizar auxiliar si algún campo no es nulo
        aux = (upCodeField && downCodeField) || (operationField && conditionField);
        i++;
    }


    // Create an object with the form data
    var formData = {
        proId: proId,
        operations: operations,
        conditions: conditions,
        upCodes: upCodes,
        downCodes: downCodes
    };

    // Set up the request
    var url = '/api/problem/' + proId + '/solution';
    var options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    };

    // Make the request using the fetch API
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
            console.log('Response is:', data === true ? 'true' : 'false');

            var element = document.getElementById("solutionFeedback");
            if (data === true) {
                element.innerHTML = '<a style="font-weight: bold; color: green;">Congratulations!!</a> You have solved the problem';
            } else {
                element.innerHTML = '<a style="font-weight: bold; color: red;">X</a> Oops, it seems you have failed the problem, you can try again';
            }
        })
        .catch(function(error) {
            console.error('There was a problem with the fetch request:', error.message);
        });
}

// Add a 'submit' event listener to the form to call the submitForm function
document.getElementById("proForm").addEventListener("submit", function(event) {
    event.preventDefault();
    submitForm();
});
