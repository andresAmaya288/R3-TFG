function submitForm() {
    var proId = document.getElementById("proId").value;

    var formData = {
        conditions: [],
        operations: [],
        upCodes: [],
        downCodes: []
    };

    var i = 0;
    var aux = true;
    while (aux) {
        var operationField = document.getElementById("operation" + i);
        var conditionField = document.getElementById("condition" + i);
        var upCodeField = document.getElementById("upCode" + i);
        var downCodeField = document.getElementById("downCode" + i);

        if (!operationField && !conditionField && !upCodeField && !downCodeField) {
            if (i === 0) {
                operationField = document.getElementById("operation");
                conditionField = document.getElementById("condition");
                upCodeField = document.getElementById("upCode");
                downCodeField = document.getElementById("downCode");
            } else {
                aux = false;
            }
        }

        if (operationField && conditionField) {
            formData.operations.push(operationField.value);
            formData.conditions.push(conditionField.value);
        }

        if (upCodeField && downCodeField) {
            formData.upCodes.push(upCodeField.value);
            formData.downCodes.push(downCodeField.value);
        }

        // Actualizar auxiliar si algún campo no es nulo
        aux = (upCodeField && downCodeField) || (operationField && conditionField);
        i++;
    }

    var url = '/api/problem/' + proId + '/solution';
    var options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
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

document.getElementById("proForm").addEventListener("submit", function(event) {
    event.preventDefault();
    submitForm();
});

