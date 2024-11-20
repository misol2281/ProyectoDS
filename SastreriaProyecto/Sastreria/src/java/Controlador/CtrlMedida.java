/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Entidad.Medida;
import Modelo.DAOMedida;
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
 * @author Eduardo Morales
 */

@WebServlet(name = "CtrlMedida", urlPatterns = {"/CtrlMedida"})
public class CtrlMedida extends HttpServlet {
    
    String listarMedida = "vistas/vistaMedida/listarMedida.jsp";
    String agregarMedida = "vistas/vistaMedida/agregarMedida.jsp";
    //String editarEstiloRopa = "vistas/vistaEstiloRopa/editarEstiloRopa.jsp";
    
    Medida m = new Medida();
    DAOMedida dao = new DAOMedida();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CtrlMedida</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CtrlMedida at " + request.getContextPath() + "</h1>");
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
            acceso = listarMedida;
        }
        else if (action.equalsIgnoreCase("agregarMedida")){
            acceso=agregarMedida;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String Medida = request.getParameter("txtm");
            String Descripcion = request.getParameter("txtdes");
            m.setMedida(Medida);
            m.setDescripcion(Descripcion);
            dao.AgregarMedida(m);
            acceso=listarMedida;

        }
       /* else if (action.equalsIgnoreCase("EditarMedida")){
            request.setAttribute("idma", request.getParameter("id"));
            acceso=editarMedida;//puede ser error ma y es m
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            int id = Integer.parseInt(request.getParameter("txtid"));
            String Medida = request.getParameter("txter");
            String Descripcion = request.getParameter("txtdes");
            m.setId(id);
            m.setMedida(Medida);
            m.setDescripcion(Descripcion);
            dao.EditarEstiloRopa(m);
            acceso=listarMedida;
        }
        else if (action.equalsIgnoreCase("Eliminar")){
            int id = Integer.parseInt(request.getParameter("id"));
            m.setId(id);
            dao.EliminarMedida(id);
            acceso=listarMedida;
}*/
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
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
