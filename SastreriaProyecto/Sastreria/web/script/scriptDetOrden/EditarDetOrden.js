document.addEventListener("DOMContentLoaded", function () {
    console.log("hola");
    const inputER = document.getElementById("ER");
    const inputTT = document.getElementById("TT");
    const inputO = document.getElementById("orden");
    const idER = document.getElementById("idEstiloRopa").value;
    const datalistER = document.getElementById("lsER");
    const idTT = document.getElementById("idTipoTrabajo").value;
    const datalistTT = document.getElementById("lsTT");
    const idO = document.getElementById("idO").value;
    const datalistO = document.getElementById("lsOrden");
    
    
    const optionsER = datalistER.options; 
    for (let option of optionsER) {
        if (option.getAttribute("data-id") === idER) { 
            inputER.value = option.value; 
            break;
        }
    }
    
    const optionsTT = datalistTT.options; 
    for (let option of optionsTT) {
        if (option.getAttribute("data-id") === idTT) { 
            inputTT.value = option.value; 
            break;
        }
    }
    
    const optionsO = datalistO.options; 
    for (let option of optionsO) {
        if (option.value === idO) { 
            inputO.value = option.value; 
            break;
        }
    }
    
    inputER.addEventListener("input", function() {
        const option = document.querySelector(`#lsER option[value="${this.value}"]`);
        document.getElementById("idEstiloRopa").value = option ? option.getAttribute("data-id") : "";
    });

    // Manejo de empleado
    inputTT.addEventListener("input", function () {
        const option = document.querySelector(`#lsTT option[value="${this.value}"]`);
        document.getElementById("idTipoTrabajo").value = option ? option.getAttribute("data-id") : "";
        
    });
    
    inputO.addEventListener("input", function () {
        const option = document.querySelector(`#lsOrden option[value="${this.value}"]`);
        document.getElementById("idO").value = option ? option.value : "";
    });
});
