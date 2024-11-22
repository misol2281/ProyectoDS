/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Entidad.TipoMedida;
import Modelo.DAOTipoMedida;
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

@WebServlet(name = "CtrlTipoMedida", urlPatterns = {"/CtrlTipoMedida"})
public class CtrlTipoMedida extends HttpServlet {
    
    String listarTipoMedida = "vistas/vistaTipoMedida/listarTipoMedida.jsp";
    String agregarTipoMedida = "vistas/vistaTipoMedida/agregarTipoMedida.jsp";
    String editarTipoMedida = "vistas/vistaTipoMedida/editarTipoMedida.jsp";
    
     TipoMedida tme = new TipoMedida();
    DAOTipoMedida dao = new DAOTipoMedida();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CtrlTipoMedida</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CtrlTipoMedida at " + request.getContextPath() + "</h1>");
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
        if(action.equalsIgnoreCase("listarTipoMedida")){
            acceso = listarTipoMedida;
        }
        else if (action.equalsIgnoreCase("agregar")){
            acceso=agregarTipoMedida;
        }
         else if(action.equalsIgnoreCase("Agregar")){
            String TipoMedida = request.getParameter("txttm");
            String Descripcion = request.getParameter("txtdes");
            tme.setTipoMedida(TipoMedida);
            tme.setDescripcion(Descripcion);
            dao.AgregarTipoMedida(tme);
            acceso=listarTipoMedida;

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

