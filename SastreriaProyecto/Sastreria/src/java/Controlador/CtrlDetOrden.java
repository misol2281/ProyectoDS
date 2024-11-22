/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Entidad.DetalleOrden;
import Entidad.Orden;
import Modelo.DAODetalleOrden;
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
            out.println("<h1>Procesando...</h1>");
            out.println("</body>");
            out.println("<script>");
            out.println("  window.location.href = \"vistas/vistaDetOrden/ListarDetOrden.jsp\";");
            out.println("</script>");
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
                System.out.println("id: "+id);
                if (id > 0) {
                    DAODetalleOrden dao = new DAODetalleOrden();
                    boolean eliminado = dao.eliminarDetOrden(id);

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
                DAODetalleOrden dao = new DAODetalleOrden();
                DetalleOrden dO = new DetalleOrden();
                dO = dao.buscarPorId(id);
                
                if(dO!=null){
                   request.setAttribute("id", dO.getId()); 
                   request.setAttribute("idER",dO.getIdEstiloRopa());
                   request.setAttribute("idTT", dO.getIdTipoTrabajo());
                   request.setAttribute("idO", dO.getIdOrden());
                   request.setAttribute("instrucciones", dO.getInstrucciones());
                   request.setAttribute("subTotal", dO.getSubTotal());
                   acceso = editar; 
                }
            }
            catch(Exception e){
                System.out.println("Error al enviar registro");
            }
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            try{
            int idER = Integer.parseInt(request.getParameter("idEstiloRopa"));
            int idTT = Integer.parseInt(request.getParameter("idTipoTrabajo"));
            int idO = Integer.parseInt(request.getParameter("idO"));
            String ins = request.getParameter("instrucciones");
            float subTotal = Float.parseFloat(request.getParameter("subTotal"));
            DAODetalleOrden dao = new DAODetalleOrden();
            DetalleOrden dO = new DetalleOrden();
            dO.setIdEstiloRopa(idER);
            dO.setIdTipoTrabajo(idTT);
            dO.setIdOrden(idO);
            dO.setInstrucciones(ins);
            dO.setSubTotal(subTotal);
            boolean actualizarDetOrden = dao.actualizarDetOrden(dO);
            if(!actualizarDetOrden){
                System.out.println("No se actualizo correctamente");        
            }
            }catch(NumberFormatException e){
                System.out.println("Error al pasar dato: "+e.getMessage());

            }
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
                
        try{
        int idER = Integer.parseInt(request.getParameter("idEstiloRopa"));
        int idTT = Integer.parseInt(request.getParameter("idTipoTrabajo"));
        int idO = Integer.parseInt(request.getParameter("idO"));
        String ins = request.getParameter("instrucciones");
        float subTotal = Float.parseFloat(request.getParameter("subTotal"));
        DAODetalleOrden dao = new DAODetalleOrden();
        DetalleOrden dO = new DetalleOrden();
        dO.setIdEstiloRopa(idER);
        dO.setIdTipoTrabajo(idTT);
        dO.setIdOrden(idO);
        dO.setInstrucciones(ins);
        dO.setSubTotal(subTotal);
        boolean agregarDetOrden = dao.agregarDetOrden(dO);
        if(!agregarDetOrden){
            System.out.println("No se agrego correctamente");        
        }
        }catch(NumberFormatException e){
            System.out.println("Error al pasar dato: "+e.getMessage());
            
        }
        response.sendRedirect("../vistas/vistaDetOrden/ListarDetOrden.jsp");

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
