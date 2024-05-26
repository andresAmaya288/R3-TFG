function getSolution(source1, source2,destiny) {

    var initialValue1 = document.getElementById(source1).value;
    var initialValue2 = document.getElementById(source2).value;
    var url = document.getElementById("apiSolUrl").value;

    if(initialValue1 == null){
        initialValue1 = document.getElementById(source1).textContent;
    }
    if(initialValue2 == null){
        initialValue2 = document.getElementById(source2).textContent;
    }

    var data = {
        input1: initialValue1,
        input2: initialValue2
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
            document.getElementById(destiny).textContent = data;

        })
        .catch(function(error) {
            console.error('There was a problem with the fetch request:', error.message);
        });

}

function getSubproblem(source1, source2, code, destinyA, destinyB, destiny2) {
    // Obtener los valores iniciales
    var downCode = document.getElementById(code).value;
    var input1 = document.getElementById(source1).value;
    var input2 = document.getElementById(source2).value;
    var url = document.getElementById("apiSubUrl").value;

    // Crear el objeto con los datos para enviar
    var data = {
        input1: input1,
        input2: input2,
        downCode: downCode
    };

    // Opciones para la solicitud HTTP
    var options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };

    // Primera solicitud HTTP
    fetch(url, options)
        .then(function (response) {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Error submitting form. Response status: ' + response.status);
            }
        })
        .then(function (data) {
            console.log('Response body:', data);

            var valueA = data.sol1;
            var valueB = data.sol2;

            document.getElementById(destinyA).textContent = valueA;
            document.getElementById(destinyB).textContent = valueB;

            var url2 = document.getElementById("apiSolUrl").value;
            var initialValueA = document.getElementById(destinyA).textContent;
            var initialValueB = document.getElementById(destinyB).textContent;


            var data2 = {
                input1: initialValueA,
                input2: initialValueB
            };

            var options2 = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data2)
            };

            return fetch(url2, options2);
        })
        .then(function (response2) {
            if (response2.ok) {
                return response2.json();
            } else {
                throw new Error('Error submitting form. Response status: ' + response2.status);
            }
        })
        .then(function (data2) {
            console.log('Response body:', data2);
            document.getElementById(destiny2).textContent = data2;
        })
        .catch(function (error) {
            console.error('There was a problem with the fetch request:', error.message);
        });
}



document.getElementById("inputA").addEventListener("change", function() {
    getSolution('inputA','inputB','solution');
    getSubproblem('inputA','inputB', 'downCode','subproblemA','subproblemB','subsolution');
});

document.getElementById("inputB").addEventListener("change", function() {
    getSolution('inputA','inputB','solution');
    getSubproblem('inputA','inputB', 'downCode','subproblemA','subproblemB','subsolution');
});
document.getElementById("downCode").addEventListener("change", function() {
    getSubproblem('inputA','inputB', 'downCode','subproblemA','subproblemB','subsolution');
});
