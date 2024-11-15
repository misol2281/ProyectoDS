// Esperar a que el documento esté completamente cargado
document.addEventListener("DOMContentLoaded", function() {
    var abrir = document.getElementById("abrirAgregar");

    // Agregar el evento de clic al botón
    abrir.addEventListener("click", function() {
        // Abrir otro JSP en una nueva ventana
        const pestanaAbrir = window.open("vistas/vistaTipoTrabajo/agregarTipoTrabajo.jsp", "_blank", "width=800,height=600");

        pestanaAbrir.onload = function () {
            var agregar = pestanaAbrir.document.getElementById("agregar"); // Contenedor dentro de la ventana emergente
            var cerrarAgregar = pestanaAbrir.document.getElementById("cerrarAgregar"); // Botón cerrar en la ventana emergente

            // Configurar el evento de clic para cerrar la ventana emergente
            cerrarAgregar.onclick = function() {
                if (window.opener) { 
                    window.opener.location.reload(); // Recargar la página principal
                }
                pestanaAbrir.close(); // Cerrar la ventana emergente
            };

            // Detectar el clic fuera del contenedor para cerrar la ventana emergente
            pestanaAbrir.document.body.addEventListener("click", function(event) {
                if (!agregar.contains(event.target)) { // Si el clic es fuera del contenedor
                    if (window.opener) { 
                        window.opener.location.reload(); // Recargar la página principal
                    }
                    pestanaAbrir.close(); // Cerrar la ventana emergente
                }
            });
        };
    });
});

// Funciones adicionales
function confirmarBorrar(id) {
    if (confirm("¿Desea eliminar este registro?")) {
        window.location.href = "CtrlTipoTrabajo?accion=Eliminar&id=" + id;
    }
}

function actualizarRegistro() {
    const id = document.getElementById('id').value;
    const tipoTrabajo = document.getElementById('TipoTrabajo').value;
    const descripcion = document.getElementById('Descripcion').value;
    window.location.href = "CtrlTipoTrabajo?accion=Editar&id=" + id + "&tt=" + tipoTrabajo + "&dc=" + descripcion;
}

function editarRegistro(id) {
    window.location.href = "CtrlTipoTrabajo?accion=Enviar&id=" + id;
}

function mostrarLista() {
    window.location.href = "vistas/vistaTipoTrabajo/listarTipoTrabajo.jsp";
}
