
// Esperar a que el documento esté completamente cargado
document.addEventListener("DOMContentLoaded", function() {
    var abrir = document.getElementById("abrirAgregar");
    
    // Agregar el evento de clic al botón
    abrir.addEventListener("click", function() {
        // Abrir otro JSP en una nueva ventana
        const pestanaAbrir = window.open("vistas/vistaTipoTrabajo/agregarTipoTrabajo.jsp", "_blank", "width=800,height=600"); 
        pestanaAbrir.onload = function () {
            
        console.log("La nueva pestaña ha cargado");
        agregar.style.display = "block";
        var agregar = document.getElementById("agregar");
        var cerrarAgregar = document.getElementById("cerrarAgregar");
        cerrarAgregar.onclick = function() {
            agregar.style.display = "none";
        }
        window.onclick = function(event) {
            if (event.target === agregar) {
                agregar.style.display = "none";
            }
        };
        };
                });
});
function confirmarBorrar(){
    if(confirm("Desea eliminar este registro?")){
        console.log("Registro eliminado");
        }
    }
    

        
  
