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
public class CtrlDetOrden extends HttpServlet {

    String listar = "vistas/vistaDetOrden/ListarDetOrden.jsp";
    String editar = "vistas/vistaDetOrden/editarDetOrden.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CtrlDetOrden</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CtrlDetOrden at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        else if (action.equalsIgnoreCase("Eliminar")) {
            int id = 0;
            try {
                id = Integer.parseInt(request.getParameter("id"));
                if (id > 0) {
                    DAOOrden dao = new DAOOrden();
                    boolean eliminado = dao.EliminarOrden(id);

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
        else if(action.equalsIgnoreCase("Enviar")){
            try{
                int id = Integer.parseInt(request.getParameter("id"));
                DAOOrden dao = new DAOOrden();
                Orden o = new Orden();
                o = dao.BuscarPorId(id);
                System.out.println("valor: "+o.getIdCliente() + o.getMontoTotal());
                if(o!=null){
                   request.setAttribute("id", o.getId()); 
                   request.setAttribute("idCliente",o.getIdCliente());
                   request.setAttribute("idEmpleado", o.getIdEmpleado());
                   request.setAttribute("fechaOrden", o.getFechaOrden());
                   request.setAttribute("fechaEntrega", o.getFechaEntrega());
                   request.setAttribute("monto", o.getMontoTotal());
                   acceso = editar; 
                }
            }
            catch(Exception e){
                System.out.println("Error al enviar registro");
            }
        }
        
        else if (action.equalsIgnoreCase("Editar")){
            int id = Integer.parseInt(request.getParameter("id"));
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try{
            Date fechaOrden = sdf.parse(request.getParameter("fechaOrden"));
            Date fechaEntrega = sdf.parse(request.getParameter("fechaEntrega"));
            float montoTotal = Float.parseFloat(request.getParameter("monto"));
            DAOOrden dao = new DAOOrden();
            Orden o = new Orden();
            o.setId(id);
            o.setIdCliente(idCliente);
            o.setIdEmpleado(idEmpleado);
            o.setFechaOrden(fechaOrden);
            o.setFechaEntrega(fechaEntrega);
            o.setMontoTotal(montoTotal);
            dao.EditarOrden(o);
        }catch(NumberFormatException | ParseException e){
            System.out.println("Error al pasar dato: "+e.getMessage());
        }
            acceso = listar;
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
