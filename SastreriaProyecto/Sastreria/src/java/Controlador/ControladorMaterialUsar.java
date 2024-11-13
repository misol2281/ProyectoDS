/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Entidad.MaterialUsar;
import Modelo.MaterialUsarDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ControladorMaterialUsar extends HttpServlet {
    
    String listar = "vistas/vistasMaterialUsar/listar.jsp";
    String add = "vistas/vistasMaterialUsar/add.jsp";
    String edit = "vistas/vistasMaterialUsar/edit.jsp";
    MaterialUsar mu = new MaterialUsar();
    MaterialUsarDAO mudao = new MaterialUsarDAO();
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
            out.println("<title>Servlet ControladorMaterialUsar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorMaterialUsar at " + request.getContextPath() + "</h1>");
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
            int idMaterial = Integer.parseInt(request.getParameter("txtidMaterial"));
            int idDetalleOrden = Integer.parseInt(request.getParameter("txtidDetalleOrden"));
            int idUnidadMedida = Integer.parseInt(request.getParameter("txtidUnidadMedida"));
            String Caracteristicas = request.getParameter("txtCaractMaterial");
            int Cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
            float Precio = Float.parseFloat(request.getParameter("txtPrecio"));
            float SubTotal = Float.parseFloat(request.getParameter("txtSubTotal"));
            mu.setIdMaterial(idMaterial);
            mu.setIdDetalleOrden(idDetalleOrden);
            mu.setIdUnidadMedida(idUnidadMedida);
            mu.setCaracteristicas(Caracteristicas);
            mu.setCantidad(Cantidad);
            mu.setPrecio(Precio);
            mu.setSubTotal(SubTotal);
            mudao.add(mu);
            acceso = listar;
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idmtu", request.getParameter("id"));
            acceso = edit;
        }else if(action.equalsIgnoreCase("Actualizar")){
            id = Integer.parseInt(request.getParameter("txtid"));
            int idMaterial = Integer.parseInt(request.getParameter("txtidMaterial"));
            int idDetalleOrden = Integer.parseInt(request.getParameter("txtidDetalleOrden"));
            int idUnidadMedida = Integer.parseInt(request.getParameter("txtidUnidadMedida"));
            String Caracteristicas = request.getParameter("txtCaractMaterial");
            int Cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
            float Precio = Float.parseFloat(request.getParameter("txtPrecio"));
            float SubTotal = Float.parseFloat(request.getParameter("txtSubTotal"));
            mu.setId(id);
            mu.setIdMaterial(idMaterial);
            mu.setIdDetalleOrden(idDetalleOrden);
            mu.setIdUnidadMedida(idUnidadMedida);
            mu.setCaracteristicas(Caracteristicas);
            mu.setCantidad(Cantidad);
            mu.setPrecio(Precio);
            mu.setSubTotal(SubTotal);
            mudao.edit(mu);
            acceso = listar;
        }else if(action.equalsIgnoreCase("eliminar")){
            id = Integer.parseInt(request.getParameter("id"));
            mu.setId(id);
            mudao.eliminar(id);
            acceso = listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
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
