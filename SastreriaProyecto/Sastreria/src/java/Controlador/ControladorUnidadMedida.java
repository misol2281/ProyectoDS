package Controlador;

import Entidad.UnidadMedida;
import Modelo.UnidadMedidaDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ControladorUnidadMedida extends HttpServlet {
    
    String listar = "vistas/vistasUnidadMedida/listar.jsp";
    String add = "vistas/vistasUnidadMedida/add.jsp";
    String edit = "vistas/vistasUnidadMedida/edit.jsp";
    int id;
    UnidadMedida um = new UnidadMedida();
    UnidadMedidaDAO umdao = new UnidadMedidaDAO();

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
            out.println("<title>Servlet ControladorUnidadMedida</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorUnidadMedida at " + request.getContextPath() + "</h1>");
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
            String uni = request.getParameter("txtUnidadM");
            String descripcion = request.getParameter("txtDescripcion");
            um.setUnidadMedida(uni);
            um.setDescripcion(descripcion);
            umdao.add(um);
            acceso = listar;
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idumd", request.getParameter("id"));
            acceso = edit;
        }else if(action.equalsIgnoreCase("Actualizar")){
            id = Integer.parseInt(request.getParameter("txtid"));
            String unimedi = request.getParameter("txtUnidadM");
            String descrip = request.getParameter("txtDescripcion");
            um.setId(id);
            um.setUnidadMedida(unimedi);
            um.setDescripcion(descrip);
            umdao.edit(um);
            acceso = listar;
        }else if(action.equalsIgnoreCase("eliminar")){
            id = Integer.parseInt(request.getParameter("id"));
            um.setId(id);
            umdao.eliminar(id);
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
