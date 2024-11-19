/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Entidad.TipoTrabajo;
import Modelo.DAOTipoTrabajo;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Cristian
 */
@WebServlet(name = "CtrlTipoTrabajo", urlPatterns = {"/CtrlTipoTrabajo"})
public class CtrlTipoTrabajo extends HttpServlet {

    String listar = "vistas/vistaTipoTrabajo/listarTipoTrabajo.jsp";
    String agregar = "vistas/vistaTipoTrabajo/agregarTipoTrabajo.jsp";
    String editar = "vistas/vistaTipoTrabajo/editarTipoTrabajo.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Guardando..</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Procesando...</h1>");
            out.println("<script>");
            out.println("window.close();");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("agregar")){
            acceso=agregar;
        }
        else if (action.equalsIgnoreCase("Eliminar")) {
            int id = 0;
            try {
                id = Integer.parseInt(request.getParameter("id"));
                if (id > 0) {
                    DAOTipoTrabajo dao = new DAOTipoTrabajo();
                    boolean eliminado = dao.EliminarTipoTrabajo(id);

                    if (eliminado) {
                        System.out.println("Dato eliminado correctamente.");
                    } else {
                        System.out.println("No se pudo eliminar el dato.");
                    }
                } else {
                    System.out.println("El ID debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: El ID proporcionado no es un número válido.");
            }

            acceso = listar;
        }
        else if(action.equalsIgnoreCase("Enviar")){
            try{
                int id = Integer.parseInt(request.getParameter("id"));
                DAOTipoTrabajo dao = new DAOTipoTrabajo();
                TipoTrabajo tt = new TipoTrabajo();
                tt = dao.BuscarPorId(id);
                if(tt!=null){
                   request.setAttribute("id", tt.getId()); 
                   request.setAttribute("TipoTrabajo", tt.getTipoTrabajo());
                   request.setAttribute("Descripcion", tt.getDescripcion());
                   acceso = editar; 
                }
            }
            catch(Exception e){
                System.out.println("Error al enviar registro");
            }
        }
        
        else if (action.equalsIgnoreCase("Editar")){
            try{
                int id = Integer.parseInt(request.getParameter("id"));
                String tt = request.getParameter("tt");
                String dc = request.getParameter("dc");
                TipoTrabajo TT = new TipoTrabajo();
                TT.setId(id);
                TT.setTipoTrabajo(tt);
                TT.setDescripcion(dc);
                DAOTipoTrabajo dao = new DAOTipoTrabajo();
                dao.EditarTipoTrabajo(TT);
            }
            catch(Exception e){
                System.out.println("Error al actualizar" + e.getMessage());
            }
            acceso = listar;
        }
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
        }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        String tipoTrabajo = request.getParameter("TipoTrabajo");
        String descripcion = request.getParameter("Descripcion");
        if (tipoTrabajo == null || descripcion == null) {
            System.out.println("Recibo datos null");
        }
        DAOTipoTrabajo dao = new DAOTipoTrabajo();
        TipoTrabajo tt = new TipoTrabajo();
        tt.setTipoTrabajo(tipoTrabajo);
        tt.setDescripcion(descripcion);
        boolean r = dao.AgregarTipoTrabajo(tt);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
