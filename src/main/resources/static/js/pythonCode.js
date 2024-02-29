document.addEventListener("DOMContentLoaded", function() {
    // Obtener los elementos del formulario
    const conditionSelect = document.getElementById("condition");
    const operationSelect = document.getElementById("operation");
    const downCodeSelect = document.getElementById("downCode");
    const upCodeSelect = document.getElementById("upCode");
    const codeBlock = document.querySelector(".language-python code");

    // Función para actualizar el código en Python
    function updatePythonCode() {
        const conditionValue = conditionSelect.value;
        const operationValue = operationSelect.value;
        const downCodeValue = downCodeSelect.value;
        const upCodeValue = upCodeSelect.value;

        const pythonCode = `
def sumatorio_recursivo(n):
    if ${conditionValue}:
        return ${operationValue}
    else:
        return sumatorio_recursivo(${downCodeValue}) + ${upCodeValue}
        `;

        codeBlock.textContent = pythonCode;
    }

    // Evento para actualizar el código en Python cuando se cambian las selecciones del formulario
    conditionSelect.addEventListener("change", updatePythonCode);
    operationSelect.addEventListener("change", updatePythonCode);
    downCodeSelect.addEventListener("change", updatePythonCode);
    upCodeSelect.addEventListener("change", updatePythonCode);

    // Llamar a la función una vez al cargar la página para inicializar el código en Python
    updatePythonCode();
});