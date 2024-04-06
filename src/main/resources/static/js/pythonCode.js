// Definir la función para manejar el cambio

function handleChange(id){
    const idValue = document.getElementById(id).value;
    document.getElementById(id + "Py").innerText = idValue;
}

function duplicateRecursiveCode() {
    // Clone the entire container
    var containerClone = document.getElementById("addRecursiveCase").cloneNode(true);

    // Get the condition and operation fields from the clone
    var conditionClone = containerClone.querySelector('#recConditionPyI');
    var downCodeClone = containerClone.querySelector('#downCodePyI');
    var upCodeClone = containerClone.querySelector('#upCodePyI');

    // Increment the value of the id parameter
    var id = document.querySelectorAll('#addRecursiveCase').length;

    containerClone.id = "addRecursiveCase" + id;
    conditionClone.id = "recCondition" + id + "Py";
    downCodeClone.id = "downCode" + id + "Py";
    upCodeClone.id = "upCode" + id + "Py";

    // Make the cloned case visible
    containerClone.style.display = "block";

    // Add the clone below the original container
    var originalContainer = document.getElementById("addRecursiveCase");
    originalContainer.parentNode.insertBefore(containerClone, originalContainer.nextSibling);
}
function eliminateRecursiveCode() {
    // Get all cloned elements of the recursive case
    var recursiveCodes = document.querySelectorAll('[id^="addRecursiveCase"]');

    // Check if there are cloned elements
    if (recursiveCodes.length > 1) {
        // Get the last cloned element
        var lastRecursiveCode = recursiveCodes[recursiveCodes.length - 1];

        // Remove the last cloned element
        lastRecursiveCode.parentNode.removeChild(lastRecursiveCode);
    } else {
        console.log("No more recursive codes to eliminate.");
    }
}

function eliminateBaseCode() {

    var baseCodes = document.querySelectorAll('[id^="addBaseCase"]');

    // Check if there are cloned elements
    if (baseCodes.length > 1) {
        // Get the last cloned element
        var lastBaseCode = baseCodes[baseCodes.length - 1];
        // Remove the last cloned element
        lastBaseCode.parentNode.removeChild(lastBaseCode);
    } else {
        console.log("No more base codes to eliminate.");
    }

}

function duplicateBaseCode() {
    // Clone the entire container
    var containerClone = document.getElementById("addBaseCase").cloneNode(true);

    // Get the condition and operation fields from the clone
    var conditionClone = containerClone.querySelector('#conditionPyI');
    var operationClone = containerClone.querySelector('#operationPyI');

    // Increment the value of the id parameter
    var id = document.querySelectorAll('#addBaseCase').length;

    containerClone.id = "addBaseCase" + id;
    conditionClone.id = "condition" + id + "Py";
    operationClone.id = "operation" + id + "Py";

    // Make the cloned case visible
    containerClone.style.display = "block";

    // Add the clone below the original container
    var originalContainer = document.getElementById("addBaseCase");
    originalContainer.parentNode.insertBefore(containerClone, originalContainer.nextSibling);
}


// Agregar un listener de evento change al input
document.getElementById("condition").addEventListener("change", function() {
    handleChange("condition");
});

document.getElementById("operation").addEventListener("change", function() {
    handleChange("operation");
});

document.getElementById("downCode").addEventListener("change", function() {
    handleChange("downCode");
});

document.getElementById("upCode").addEventListener("change", function() {
    handleChange("upCode");
});
