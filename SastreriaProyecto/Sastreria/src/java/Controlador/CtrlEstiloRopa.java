/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Entidad.EstiloRopa;
import Modelo.DAOEstiloRopa;
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

@WebServlet(name = "CtrlEstiloRopa", urlPatterns = {"/CtrlEstiloRopa"})
public class CtrlEstiloRopa extends HttpServlet {
    
    String listarEstiloRopa = "vistas/vistaEstiloRopa/listarEstiloRopa.jsp";
    String agregarEstiloRopa = "vistas/vistaEstiloRopa/agregarEstiloRopa.jsp";
    String editarEstiloRopa = "vistas/vistaEstiloRopa/editarEstiloRopa.jsp";
    
    EstiloRopa e = new EstiloRopa();
    DAOEstiloRopa dao = new DAOEstiloRopa();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CtrlEstiloRopa</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CtrlEstiloRopa at " + request.getContextPath() + "</h1>");
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
            acceso = listarEstiloRopa;
        }
        else if (action.equalsIgnoreCase("agregarEstiloRopa")){
            acceso=agregarEstiloRopa;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String EstiloRopa = request.getParameter("txter");
            String Descripcion = request.getParameter("txtdes");
            e.setEstiloRopa(EstiloRopa);
            e.setDescripcion(Descripcion);
            dao.AgregarEstiloRopa(e);
            acceso=listarEstiloRopa;

        }
        else if (action.equalsIgnoreCase("EditarEstiloRopa")){
            request.setAttribute("idesr", request.getParameter("id"));
            
            acceso=editarEstiloRopa;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            int id = Integer.parseInt(request.getParameter("txtid"));
            String EstiloRopa = request.getParameter("txter");
            String Descripcion = request.getParameter("txtdes");
            e.setId(id);
            e.setEstiloRopa(EstiloRopa);
            e.setDescripcion(Descripcion);
            
            boolean editado=dao.EditarEstiloRopa(e);
            if(editado){
                System.out.println("editado");
            }
            else {
                System.out.println("No se edito");
            }
            acceso=listarEstiloRopa;
        }
        else if (action.equalsIgnoreCase("EliminarEstiloRopa")){
            int id = Integer.parseInt(request.getParameter("id"));
            e.setId(id);
            dao.EliminarEstiloRopa(id);
            acceso=listarEstiloRopa;
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
