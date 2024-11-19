document.addEventListener("DOMContentLoaded", function () {
    const inputC = document.getElementById("cliente");
    const inputE = document.getElementById("empleado");
    const idCliente = document.getElementById("idCliente").value;
    const datalistC = document.getElementById("lsClientes");
    const idEmpleado = document.getElementById("idEmpleado").value;
    const datalistE = document.getElementById("lsEmpleados");
    if (!datalistC) {
        console.error("El elemento datalist con ID 'lsClientes' no se encontró.");
        return;
    }
    const optionsC = datalistC.options; 
    for (let option of optionsC) {
        if (option.getAttribute("data-id") === idCliente) { 
            inputC.value = option.value; 
            break;
        }
    }
    if (!datalistE) {
        console.error("El elemento datalist con ID 'lsEmpleado' no se encontró.");
        return;
    }
    const optionsE = datalistE.options; 
    for (let option of optionsE) {
        if (option.getAttribute("data-id") === idEmpleado) { 
            inputE.value = option.value; 
            break;
        }
    }
});

         
