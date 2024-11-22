document.addEventListener("DOMContentLoaded", function () {
    const lsER = document.getElementById("ER");
    const lsTT = document.getElementById("TT");
    const lsOR = document.getElementById("orden");
    
    lsER.addEventListener("input", function() {
        const option = document.querySelector(`#lsER option[value="${this.value}"]`);
        document.getElementById("idEstiloRopa").value = option ? option.getAttribute("data-id") : "";
    });

    // Manejo de empleado
    lsTT.addEventListener("input", function () {
        const option = document.querySelector(`#lsTT option[value="${this.value}"]`);
        document.getElementById("idTipoTrabajo").value = option ? option.getAttribute("data-id") : "";
        
    });
    
    lsOR.addEventListener("input", function () {
        const option = document.querySelector(`#lsOrden option[value="${this.value}"]`);
        document.getElementById("idO").value = option ? option.value : "";
    });
        
});

function confirmarBorrar(id) {
    if (confirm("¿Desea eliminar este registro?")) {
        window.location.href = "CtrlDetOrden?accion=Eliminar&id=" + id;
        
    }
}

function actualizarRegistro() {
    const id = document.getElementById('id').value;
    const tipoTrabajo = document.getElementById('TipoTrabajo').value;
    const descripcion = document.getElementById('Descripcion').value;
    window.location.href = "CtrlTipoTrabajo?accion=Editar&id=" + id + "&tt=" + tipoTrabajo + "&dc=" + descripcion;
}

function redirigir(){
    
    window.location.href = "/Sastreria/vistas/vistaDetOrden/agregarDetOrden.jsp";
}

function editarRegistro(id) {
    window.location.href = "CtrlDetOrden?accion=Enviar&id=" + id;
}