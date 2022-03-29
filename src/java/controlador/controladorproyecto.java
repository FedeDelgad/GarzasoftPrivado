package controlador;

import bean.*;
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
    logictrabajador logictra = new logictrabajador();
    logiccliente logicliente = new logiccliente();
    logicproyecto logicproyecto = new logicproyecto();
    logicdesarrollo logicdesarrollo = new logicdesarrollo();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        switch (accion) {
            case "actualizar":
                actualizar(request, response);
                break;
            case "listar":
                listar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            case "listarporlcliente":
                listarporcliente(request, response);
                break;
            case "inicio":
                inicio(request, response);
                break;
            case "cargarDatos":
                listaDatos(request, response);
                break;
            case "listarID":
                listarID(request, response);
                break;
        }
    }

    public void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        beanproyecto proyecto = new beanproyecto();
        try {
            proyecto.setIdTrabajador(Integer.parseInt(request.getParameter("idtrabajador")));
            proyecto.setNombre(request.getParameter("nombreproyecto"));
            proyecto.setInicio(request.getParameter("inicio"));
            proyecto.setFin(request.getParameter("fin"));
            proyecto.setEstado(request.getParameter("estado"));
            proyecto.setIdProyecto(Integer.parseInt(request.getParameter("idproyecto")));
            logicproyecto.actualizar(proyecto);

        } catch (NumberFormatException e) {
            out.print(e);
        }
        request.getRequestDispatcher("controladordesarrollo?accion=listaDesarrollo").forward(request, response);

    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<beanproyecto> listadesarrollo = logicproyecto.listar();
        request.setAttribute("listadesarrollo", listadesarrollo);
        request.getRequestDispatcher("CrudProyectoDesarrollo.jsp").forward(request, response);
    }

    public void listarporcliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idcliente = Integer.parseInt(request.getParameter("idcliente"));
        List<beanproyecto> listaprocli = logicproyecto.listarPorCliente(idcliente);
        request.setAttribute("listaporcliente", listaprocli);
        request.getRequestDispatcher("VistaInicioCliente.jsp").forward(request, response);
    }

    public void inicio(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<beantrabajador> listatrabajador = logictra.listar();
        List<beancliente> listacliente = logicliente.listarC();
        List<beanproyecto> listaproyectos = logicproyecto.listar();
        int cantidadtrabajador = listatrabajador.size();
        int cantidadcliente = listacliente.size();
        int cantidadproyecto = listaproyectos.size();
        request.setAttribute("cantidadtrabajador", cantidadtrabajador);
        request.setAttribute("cantidadcliente", cantidadcliente);
        request.setAttribute("cantidadproyecto", cantidadproyecto);
        request.setAttribute("listainicio", listaproyectos);
        request.getRequestDispatcher("VistaInicioAdmin.jsp").forward(request, response);
    }

    public void listaDatos(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<beantrabajador> listaTrabajador = logictra.listar();
        List<beancliente> listaCliente = logicliente.listarC();
        request.setAttribute("listaTrabajador", listaTrabajador);
        request.setAttribute("listaCliente", listaCliente);
        request.getRequestDispatcher("ProyectoDesarrolloNuevo.jsp").forward(request, response);
    }

    public void listarID(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int idpro = Integer.parseInt(request.getParameter("iddesarrollo"));
        List<beandesarrollo> listad = logicdesarrollo.listarID(idpro);
        int idproyecto = listad.get(0).getIddesarrollo();
        String nombreproyecto = listad.get(0).getNombreproyecto();
        String nombretrabajador = listad.get(0).getNombretrabajador();
        String apellidotrabajador = listad.get(0).getApellidotrabajador();
        String nombrecliente = listad.get(0).getNombrecliente();
        String apellidocliente = listad.get(0).getApellidocliente();
        request.setAttribute("idproyecto", idproyecto);
        request.setAttribute("nombreproyecto", nombreproyecto);
        request.setAttribute("datostrabajador", nombretrabajador + " " + apellidotrabajador);
        request.setAttribute("datoscliente", nombrecliente + " " + apellidocliente);
        request.getRequestDispatcher("Requerimientos.jsp").forward(request, response);
    }

    public void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idproyecto = Integer.parseInt(request.getParameter("idproyecto"));
        logicproyecto.eliminar(idproyecto);
        request.getRequestDispatcher("controladordesarrollo?accion=listaDesarrollo").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
