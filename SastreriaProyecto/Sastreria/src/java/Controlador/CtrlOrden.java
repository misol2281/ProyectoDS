/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Entidad.Orden;
import Modelo.DAOOrden;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Cristian
 */
@WebServlet(name = "CtrlOrden", urlPatterns = {"/CtrlOrden"})
public class CtrlOrden extends HttpServlet {

    String listar = "vistas/vistaOrden/listarOrden.jsp";
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


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
        Date fechaOrden = sdf.parse(request.getParameter("fechaOrden"));
        Date fechaEntrega = sdf.parse(request.getParameter("fechaEntrega"));
        float montoTotal = Float.parseFloat(request.getParameter("monto"));
        DAOOrden dao = new DAOOrden();
        Orden o = new Orden();
        o.setIdCliente(idCliente);
        o.setIdEmpleado(idEmpleado);
        o.setFechaOrden(fechaOrden);
        o.setFechaEntrega(fechaEntrega);
        o.setMontoTotal(montoTotal);
        dao.AgregarOrden(o);
        }catch(NumberFormatException | ParseException e){
            System.out.println("Error al pasar dato: "+e.getMessage());
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
