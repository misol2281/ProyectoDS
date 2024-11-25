/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Entidad.Usuario;
import Modelo.DAOUsuario;
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

@WebServlet(name = "CtrlUsuario", urlPatterns = {"/CtrlUsuario"})
public class CtrlUsuario extends HttpServlet {
    
    String listarUsuario = "vistas/vistaUsuario/listarUsuario.jsp";
    String agregarUsuario = "vistas/vistaUsuario/agregarUsuario.jsp";
    String editarUsuario = "vistas/vistaEstiloRopa/editarEstiloRopa.jsp";
    
    Usuario u = new Usuario();
    DAOUsuario dao = new DAOUsuario();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CtrlUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CtrlUsuario at " + request.getContextPath() + "</h1>");
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
            acceso = listarUsuario;
        }
     /*   else if (action.equalsIgnoreCase("agregarEstiloRopa")){
            acceso=agregarUsuario;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String Usuario = request.getParameter("txter");
            String Descripcion = request.getParameter("txtdes");
            u.setUsuario(Usuario);
            u.setDescripcion(Descripcion);
            dao.AgregarUsuario(u);
            acceso=listarUsuario;

        }
        else if (action.equalsIgnoreCase("EditarEstiloRopa")){
            request.setAttribute("idesr", request.getParameter("id"));
            
            acceso=editarUsuario;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            int id = Integer.parseInt(request.getParameter("txtid"));
            String Usuario = request.getParameter("txter");
            String Descripcion = request.getParameter("txtdes");
            u.setId(id);
            u.setUsuario(Usuario);
            u.setDescripcion(Descripcion);
            
            boolean editado=dao.EditarUsuario(u);
            if(editado){
                System.out.println("editado");
            }
            else {
                System.out.println("No se edito");
            }
            acceso=listarUsuario;
        }
        else if (action.equalsIgnoreCase("EliminarUsuario")){
            int id = Integer.parseInt(request.getParameter("id"));
            u.setId(id);
            dao.EliminarUsuario(id);
            acceso=listarUsuario;
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
        String usuario = request.getParameter("usuario");
        String contra = request.getParameter("contra");
        int idRol = 0;
        int idEmpleado = 0;
        idRol = Integer.parseInt(request.getParameter("idRol"));
        idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        if (usuario == null || contra == null || idRol == 0 || idEmpleado==0) {
            System.out.println("Recibo datos null");
        }
        DAOUsuario dao = new DAOUsuario();
        Usuario u = new Usuario();
        u.setUsuario(usuario);
        u.setContrasenia(contra);
        u.setIdRol(idRol);
        u.setIdEmpleado(idEmpleado);
        boolean r = dao.registrarUsuario(u);
        if(r){
            System.out.println("Usuario agregado exitosamente");
        }else{
            System.out.println("Error al registrar usuario");
        }
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
