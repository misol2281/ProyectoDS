
package Controlador;

import Entidad.Cliente;
import Modelo.ClienteDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ControladorCliente extends HttpServlet {
    
    String listar = "vistas/vistasCliente/listar.jsp";
    String add = "vistas/vistasCliente/add.jsp";
    String edit = "vistas/vistasCliente/edit.jsp";
    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
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
            out.println("<title>Servlet ControladorCliente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCliente at " + request.getContextPath() + "</h1>");
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
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String telefono = request.getParameter("txtTelefono");
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setTelefono(telefono);
            cdao.add(c);
            acceso = listar;
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idcli", request.getParameter("id"));
            acceso = edit;
        }else if(action.equalsIgnoreCase("Actualizar")){
            id = Integer.parseInt(request.getParameter("txtid"));
            String nombre = request.getParameter("txtNombre");
            String apellido = request.getParameter("txtApellido");
            String telefono = request.getParameter("txtTelefono");
            c.setId(id);
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setTelefono(telefono);
            cdao.edit(c);
            acceso = listar;
        }else if(action.equalsIgnoreCase("eliminar")){
            id = Integer.parseInt(request.getParameter("id"));
            c.setId(id);
            cdao.eliminar(id);
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
