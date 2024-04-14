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

function getSubproblem(source, code, destiny, destiny2) {
    var downCode = document.getElementById(code).value;
    var input = document.getElementById(source).value;
    var url = document.getElementById("apiSubUrl").value;

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
        .then(function (response) {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Error submitting form. Response status: ' + response.status);
            }
        })
        .then(function (data) {
            console.log('Response body:', data);
            document.getElementById(destiny).textContent = data;

            var url2 = document.getElementById("apiSolUrl").value;
            var initialValue = document.getElementById(destiny).textContent;

            var data2 = initialValue;

            var options2 = {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: data2
            };

            fetch(url2, options2)
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
        })
        .catch(function (error) {
            console.error('There was a problem with the fetch request:', error.message);
        });
}


document.getElementById("input").addEventListener("change", function() {
    getSolution('input','solution');
    getSubproblem('input', 'downCode','subproblem','subsolution');
});

document.getElementById("downCode").addEventListener("change", function() {
    getSubproblem('input', 'downCode', 'subproblem','subsolution');
});
