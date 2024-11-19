document.addEventListener("DOMContentLoaded", function() {
    var abrir = document.getElementById("abrirAgregar");
    abrir.addEventListener("click", function() {
        // Abrir otro JSP en una nueva ventana
        const pestanaAbrir = window.open("vistas/vistaOrden/agregarOrden.jsp", "_blank", "width=800,height=600");

        // Usar el evento onload de la ventana emergente para asegurar que esté completamente cargada
        pestanaAbrir.onload = function () {
            var cerrarAgregar = pestanaAbrir.document.getElementById("cerrarAgregar"); // Botón cerrar en la ventana emergente
            var agregarRegistro = pestanaAbrir.document.getElementById("btnAgregar"); // Botón de agregar registro
            var lsCliente = pestanaAbrir.document.getElementById("cliente");
            var lsEmpleado = pestanaAbrir.document.getElementById("empleado");

            // Evento para cerrar la ventana emergente
            cerrarAgregar.onclick = function() {
                pestanaAbrir.close();
                window.location.reload(); // Recargar la página principal después de cerrar
            };

            // Enviar los datos del formulario al controlador cuando se hace clic en "Agregar"
            agregarRegistro.onclick = function() {
                window.location.reload();
            };

            // Manejo de cliente
            lsCliente.addEventListener("input", function() {
                const option = pestanaAbrir.document.querySelector(`#lsClientes option[value="${this.value}"]`);
                pestanaAbrir.document.getElementById("idCliente").value = option ? option.getAttribute("data-id") : "";
            });

            // Manejo de empleado
            lsEmpleado.addEventListener("input", function () {
                const option = pestanaAbrir.document.querySelector(`#lsEmpleados option[value="${this.value}"]`);
                pestanaAbrir.document.getElementById("idEmpleado").value = option ? option.getAttribute("data-id") : "";
            });
        };
    });
});


function confirmarBorrar(id) {
    if (confirm("¿Desea eliminar este registro?")) {
        window.location.href = "CtrlOrden?accion=Eliminar&id=" + id;
    }
}

function actualizarRegistro() {
    const id = document.getElementById('id').value;
    const tipoTrabajo = document.getElementById('TipoTrabajo').value;
    const descripcion = document.getElementById('Descripcion').value;
    window.location.href = "CtrlTipoTrabajo?accion=Editar&id=" + id + "&tt=" + tipoTrabajo + "&dc=" + descripcion;
}

function editarRegistro(id) {
    window.location.href = "CtrlOrden?accion=Enviar&id=" + id;
}

