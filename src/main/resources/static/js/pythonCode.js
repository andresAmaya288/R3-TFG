// Definir la función para manejar el cambio
function handleChange() {
    // Obtener el valor del input
    const condition = document.getElementById("condition").value;
    const operation = document.getElementById("operation").value;
    const downCode = document.getElementById("downCode").value;
    const upCode = document.getElementById("upCode").value;

    document.getElementById("condPy").innerText = condition;
    document.getElementById("opPy").innerText = operation;
    document.getElementById("downPy").innerText = downCode;
    document.getElementById("upPy").innerText = upCode;
}

// Agregar un listener de evento change al input
document.getElementById("condition").addEventListener("change", handleChange);
document.getElementById("operation").addEventListener("change", handleChange);
document.getElementById("downCode").addEventListener("change", handleChange);
document.getElementById("upCode").addEventListener("change", handleChange);
handleChange()