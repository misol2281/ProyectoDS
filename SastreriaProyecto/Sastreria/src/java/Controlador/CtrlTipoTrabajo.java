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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CtrlTipoTrabajo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CtrlTipoTrabajo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        if(action.equalsIgnoreCase("agregar")){
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
        String tipoTrabajo = request.getParameter("TipoTrabajo");
        String descripcion = request.getParameter("Descripcion");
        
        DAOTipoTrabajo dao = new DAOTipoTrabajo();
        TipoTrabajo tt = new TipoTrabajo();
        tt.setTipoTrabajo(tipoTrabajo);
        tt.setDescripcion(descripcion);
        boolean r = dao.AgregarTipoTrabajo(tt);
        if(r){
            response.getWriter().write("Guardado Exitosamente");
            RequestDispatcher vista = request.getRequestDispatcher(listar);
            vista.forward(request, response);
        }
        else{
            response.getWriter().write("Error al guardar" + tt.getTipoTrabajo() + tt.getDescripcion());
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
