function submitForm() {
    var proId = document.getElementById("proId").value;

    var formData = {
        conditions: [],
        operations: [],
        upCodes: [],
        downCodes: [],
        recConditions: []
    };

    var i = 0;
    var aux = true;
    while (aux) {
        var operationField = document.getElementById("operation" + i);
        var conditionField = document.getElementById("condition" + i);
        var upCodeField = document.getElementById("upCode" + i);
        var downCodeField = document.getElementById("downCode" + i);
        var recConditionField = document.getElementById("recCondition" + i);

        if (!operationField && !conditionField && !upCodeField && !downCodeField && !recConditionField) {
            if (i === 0) {
                operationField = document.getElementById("operation");
                conditionField = document.getElementById("condition");
                upCodeField = document.getElementById("upCode");
                downCodeField = document.getElementById("downCode");
                recConditionField = "";
            } else {
                aux = false;
            }
        }

        if (operationField && conditionField ) {
            formData.operations.push(operationField.value);
            formData.conditions.push(conditionField.value);

        }

        if (upCodeField && downCodeField && (recConditionField || i === 0)) {
            formData.upCodes.push(upCodeField.value);
            formData.downCodes.push(downCodeField.value);
            formData.recConditions.push(recConditionField.value);
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
                element.innerHTML = '<a style="font-weight: bold; color: green;">Enhorabuena!!</a> has resuelto el problema';
            } else {
                element.innerHTML = '<a style="font-weight: bold; color: red;">X</a> Uups, parece que has fallado, pero puedes intentarlo de nuevo!';
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




