/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.EmpleadoDAO;
import Entidad.Empleados;
import jakarta.servlet.RequestDispatcher;
import java.sql.Date;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ControladorEmpleado extends HttpServlet {
    
    String listar = "vistas/vistasEmpleado/listar.jsp";
    String add = "vistas/vistasEmpleado/add.jsp";
    String edit = "vistas/vistasEmpleado/edit.jsp";
    Empleados e = new Empleados();
    EmpleadoDAO edao = new EmpleadoDAO();
    int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorEmpleado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEmpleado at " + request.getContextPath() + "</h1>");
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
            acceso = listar;
        }else if(action.equalsIgnoreCase("add")){
            acceso = add;
        }else if(action.equalsIgnoreCase("Agregar")){
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String dui = request.getParameter("txtdui");
            Date fechanaci = Date.valueOf(request.getParameter("txtfnaci"));
            String telefono = request.getParameter("txtTelefono");
            char genero = request.getParameter("genero").charAt(0);
            String estadocivil = request.getParameter("estadocivil");
            String correo = request.getParameter("txtCorreo");
            int idcargo = Integer.parseInt(request.getParameter("txtCargo"));
            e.setNombre(nombre);
            e.setApellido(apellido);
            e.setDUI(dui);
            e.setFechaNacimiento(fechanaci);
            e.setTelefono(telefono);
            e.setGenero(genero);
            e.setEstadoCivil(estadocivil);
            e.setCorreo(correo);
            e.setIdCargo(idcargo);
            edao.add(e);
            acceso = listar;
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idemp", request.getParameter("id"));
            acceso = edit;
        }else if(action.equalsIgnoreCase("Actualizar")){
            id = Integer.parseInt(request.getParameter("txtid"));
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String dui = request.getParameter("txtdui");
            Date fechanaci = Date.valueOf(request.getParameter("txtfnaci"));
            String telefono = request.getParameter("txtTelefono");
            char genero = request.getParameter("genero").charAt(0);
            String estadocivil = request.getParameter("txtEstadoCivil");
            String correo = request.getParameter("txtCorreo");
            int idcargo = Integer.parseInt(request.getParameter("txtCargo"));
            e.setId(id);
            e.setNombre(nombre);
            e.setApellido(apellido);
            e.setDUI(dui);
            e.setFechaNacimiento(fechanaci);
            e.setTelefono(telefono);
            e.setGenero(genero);
            e.setEstadoCivil(estadocivil);
            e.setCorreo(correo);
            e.setIdCargo(idcargo);
            edao.edit(e);
            acceso = listar;
        }else if(action.equalsIgnoreCase("eliminar")){
            id = Integer.parseInt(request.getParameter("id"));
            e.setId(id);
            edao.eliminar(id);
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
