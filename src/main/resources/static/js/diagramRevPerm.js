function getSolution(source,destiny) {

    var initialValue = document.getElementById(source).value;
    var url = document.getElementById("apiSolUrl").value;

    if(initialValue == null){
        initialValue = document.getElementById(source).textContent;
    }

    // Create an object with the data to send
    var data = initialValue;

    // Create the HTTP request
    var options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body:data
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

function getSubproblem(source, code, destinyA, destinyB, destiny2A, destiny2B) {
    var downCode = document.getElementById(code).value;
    var input = document.getElementById(source).value;
    var url = document.getElementById("apiSubUrl").value;
    var url2 = document.getElementById("apiSolUrl").value;

    var data = {
        input: input,
        downCode: downCode
    };

    var options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };

    fetch(url, options)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error submitting form. Response status: ' + response.status);
            }
            return response.json();
        })
        .then(data => {
            console.log('Response body:', data);

            var valueA = data.sol1;
            var valueB = data.sol2;

            document.getElementById(destinyA).textContent = valueA;
            document.getElementById(destinyB).textContent = valueB;

            var data2 =  valueA;

            var options2 = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: data2
            };

            return fetch(url2, options2);
        })
        .then(response2 => {
            if (!response2.ok) {
                throw new Error('Error submitting form. Response status: ' + response2.status);
            }
            return response2.json();
        })
        .then(data2 => {
            console.log('Response body:', data2);
            document.getElementById(destiny2A).textContent = data2;
            valueB = document.getElementById(destinyB).textContent;

            var data3 =  valueB;

            var options3 = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: data3
            };

            return fetch(url2, options3);
        })
        .then(response3 => {
            if (!response3.ok) {
                throw new Error('Error submitting form. Response status: ' + response3.status);
            }
            return response3.json();
        })
        .then(data3 => {
            console.log('Response body:', data3);
            document.getElementById(destiny2B).textContent = data3;
        })
        .catch(error => {
            console.error('There was a problem with the fetch request:', error.message);
        });
}


document.getElementById("input").addEventListener("change", function() {
    getSolution('input','solution',);
    getSubproblem('input', 'downCode','subproblem1', 'subproblem2','subsolution1','subsolution2');
});

document.getElementById("downCode").addEventListener("change", function() {
    getSubproblem('input', 'downCode','subproblem1', 'subproblem2','subsolution1','subsolution2');
});