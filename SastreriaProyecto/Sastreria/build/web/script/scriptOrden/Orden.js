document.addEventListener("DOMContentLoaded", function() {
    var abrir = document.getElementById("abrirAgregar");
    abrir.addEventListener("click", function() {
        // Abrir otro JSP en una nueva ventana
        const pestanaAbrir = window.open("vistas/vistaOrden/agregarOrden.jsp", "_blank", "width=800,height=600");

        pestanaAbrir.onload = function () {
            var cerrarAgregar = pestanaAbrir.document.getElementById("cerrarAgregar"); // Botón cerrar en la ventana emergente
            var agregarRegistro = pestanaAbrir.document.getElementById("btnAgregar"); // Botón de agregar registro
            // Evento para cerrar la ventana emergente
            cerrarAgregar.onclick = function() {
                pestanaAbrir.close();
                window.location.reload(); // Recargar la página principal después de cerrar
            };
            
            // Enviar los datos del formulario al controlador cuando se hace clic en "Agregar"
            agregarRegistro.onclick = function() {
                window.location.reload();
            };
            
        };
    });
});

// Funciones adicionales (como confirmar borrado, editar, etc.)
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
function datosEnviados(){
                console.log("hola");
                
            }