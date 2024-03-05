// Global variable to maintain the value of the id parameter
var id = 1;

function duplicate(elementId) {
    // Clone the entire container
    var containerClone = document.getElementById(elementId).cloneNode(true);

    // Get the condition and operation fields from the clone
    var conditionClone = containerClone.querySelector('#condition');
    var operationClone = containerClone.querySelector('#operation');

    containerClone.id = elementId + id;
    conditionClone.id = "condition" + id;
    operationClone.id = "operation" + id;

    // Increment the value of the id parameter
    id++;

    // Add the clone below the original container
    var originalContainer = document.getElementById(elementId);
    originalContainer.parentNode.insertBefore(containerClone, originalContainer.nextSibling);
}

