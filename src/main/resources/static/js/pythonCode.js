// Definir la función para manejar el cambio
function handleChange() {
    // Obtener el valor del input
    const condition = document.getElementById("condition").value;
    const operation = document.getElementById("operation").value;
    const downCode = document.getElementById("downCode").value;
    const upCode = document.getElementById("upCode").value;
    const pythonCode = document.getElementById("pythonCode");

    pythonCode.innerHTML=`
def sumatorio_recursivo(n):
    if ${condition}:
        return ${operation}
    else:
        return sumatorio_recursivo(${downCode}) ${upCode}
        `;
}

// Agregar un listener de evento change al input
document.getElementById("condition").addEventListener("change", handleChange);
document.getElementById("operation").addEventListener("change", handleChange);
document.getElementById("downCode").addEventListener("change", handleChange);
document.getElementById("upCode").addEventListener("change", handleChange);
handleChange()