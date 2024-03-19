// Global variable to maintain the value of the id parameter
var baseId = 1;
var recId = 1;

function duplicateBaseCase() {
    // Clone the entire container
    var containerClone = document.getElementById("baseCase").cloneNode(true);

    // Get the condition and operation fields from the clone
    var conditionClone = containerClone.querySelector('#condition');
    var operationClone = containerClone.querySelector('#operation');

    containerClone.id = "baseCase" + baseId;
    conditionClone.id = "condition" + baseId;
    operationClone.id = "operation" + baseId;

    var parentID;

    if(baseId === 1){
        parentID = "baseCase"
    }else{
        parentID = "baseCase" + (baseId - 1)
    }
    // Increment the value of the id parameter
    baseId++;


    // Add the clone below the original container
    var originalContainer = document.getElementById(parentID);
    originalContainer.parentNode.insertBefore(containerClone, originalContainer.nextSibling);


}

function eliminateBaseCase() {
    // Decrement the value of the id parameter
    if(baseId > 1){
        baseId--;
        // Remove the last cloned base case
        var containerToRemove = document.getElementById("baseCase" + baseId);
        containerToRemove.parentNode.removeChild(containerToRemove);
    }
}

function duplicateRecursiveCase() {
    // Clone the entire container
    var containerClone = document.getElementById("recursiveCase").cloneNode(true);

    // Get the recID, downCode, and upCode fields from the clone

    var downCodeClone = containerClone.querySelector('#downCode');
    var upCodeClone = containerClone.querySelector('#upCode');

    // Make the conditionRec field visible
    var recConditionField = containerClone.querySelector('#recCondition');
    var recConditionFieldLabel = containerClone.querySelector('#recConditionLabel');
    recConditionField.removeAttribute('hidden');
    recConditionFieldLabel.removeAttribute('hidden');

    // Change the IDs of the clones
    containerClone.id = "recursiveCase" + recId;
    downCodeClone.id = "downCode" + recId;
    recConditionField.id = "recCondition" + recId;
    upCodeClone.id = "upCode" + recId;

    var parentID;

    if (recId === 1) {
        parentID = "recursiveCase";
    } else {
        parentID = "recursiveCase" + (recId - 1);
    }

    // Increment the value of the recursiveId parameter
    recId++;

    // Add the clone below the original container
    var originalContainer = document.getElementById(parentID);
    originalContainer.parentNode.insertBefore(containerClone, originalContainer.nextSibling);

    duplicateRecursiveCode();
    document.getElementById(downCodeClone.id).addEventListener("change", function() {
        handleChange(downCodeClone.id);
    });

    document.getElementById(upCodeClone.id).addEventListener("change", function() {
        handleChange(upCodeClone.id);
    });

    document.getElementById(recConditionField.id).addEventListener("change", function() {
        handleChange(recConditionField.id);
    });
}

function eliminateRecursiveCase() {
    // Decrement the value of the id parameter
    if(recId > 1){
        recId--;
        // Remove the last cloned base case
        var containerToRemove = document.getElementById("recursiveCase" + recId);
        containerToRemove.parentNode.removeChild(containerToRemove);
        eliminateRecursiveCode();
    }

}
