package controlador;

import bean.*;
import dao.*;
import logic.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "controladorproyecto", urlPatterns = {"/controladorproyecto"})
public class controladorproyecto extends HttpServlet {

    beantrabajador trabajador = new beantrabajador();
    beancliente cliente = new beancliente();
    daotrabajador daotra = new daotrabajador();
    daocliente daocliente = new daocliente();
    logictrabajador logictra = new logictrabajador();
    logiccliente logicliente = new logiccliente();
    logicproyectoDesarrollo logicdesarrollo = new logicproyectoDesarrollo();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        switch (accion) {
            case "agregar":
                agregarNuevo(request, response);
                break;
            case "listar":
                listar(request, response);
                break;
            case "inicio":
                inicio(request, response);
                break;
            case "capturarDatosTrabajdor":
                capturarDatosTrabajador(request, response);
                break;
            case "cargarDatos":
                listaDatos(request, response);
                break;
        }
    }

    public void capturarDatosTrabajador(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        //capturar datos
        String nombreproyecto = request.getParameter("nombreproyecto");
        String inicio = request.getParameter("inicio");
        String fin = request.getParameter("fin");
        int id = Integer.parseInt(request.getParameter("idtrabajador"));
        String nombre = request.getParameter("nombretrabajador");
        String apellido = request.getParameter("apellidotrabajador");

        //retornar datos cuando se refresca la pagina
        request.setAttribute("nombreproyecto", nombreproyecto);
        request.setAttribute("inicio", inicio);
        request.setAttribute("fin", fin);
        request.setAttribute("idtrabajador", id);
        request.setAttribute("nombretrabajador", nombre);
        request.setAttribute("apellidotrabajador", apellido);
        List<beantrabajador> listaTrabajador = logictra.listar();
        List<beancliente> listaCliente = logicliente.listarC();
        request.setAttribute("listaTrabajador", listaTrabajador);
        request.setAttribute("listaCliente", listaCliente);
        request.getRequestDispatcher("ProyectoDesarrolloNuevo.jsp").forward(request, response);
    }

    public void agregarNuevo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        beanproyectoDesarrollo nuevo = new beanproyectoDesarrollo();
        try {
            nuevo.setIdCliente(Integer.parseInt(request.getParameter("idcliente")));
            nuevo.setIdTrabajador(Integer.parseInt(request.getParameter("idtrabajador")));
            nuevo.setNombre(request.getParameter("nombreproyecto"));
            nuevo.setInicio(request.getParameter("inicio"));
            nuevo.setFin(request.getParameter("fin"));
            out.print(logicdesarrollo.agregarNuevo(nuevo));
        } catch (NumberFormatException e) {
            out.print(e);
        }
        request.getRequestDispatcher("controladorproyecto?accion=listar").forward(request, response);
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<beanproyectoDesarrollo> listadesarrollo = logicdesarrollo.listar();
        request.setAttribute("listadesarrollo", listadesarrollo);
        request.getRequestDispatcher("CrudProyectoDesarrollo.jsp").forward(request, response);
    }
    
    public void inicio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<beanproyectoDesarrollo> listadesarrollo = logicdesarrollo.listar();
        request.setAttribute("listainicio", listadesarrollo);
        request.getRequestDispatcher("VistaInicioAdmin.jsp").forward(request, response);
    }

    public void listaDatos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<beantrabajador> listaTrabajador = logictra.listar();
        List<beancliente> listaCliente = logicliente.listarC();
        request.setAttribute("listaTrabajador", listaTrabajador);
        request.setAttribute("listaCliente", listaCliente);
        request.getRequestDispatcher("ProyectoDesarrolloNuevo.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
