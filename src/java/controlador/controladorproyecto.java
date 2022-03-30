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
    logicsoporte logicsoporte = new logicsoporte();
    logicrequerimiento logicre = new logicrequerimiento();

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
            case "trabajador":
                listarPorTrabajador(request, response);
                break;
            case "inicio":
                inicio(request, response);
                break;
            case "cargarProNuevo":
                listaDatosNuevo(request, response);
                break;
            case "cargarProPerfectivo":
                listaDatosPerfectivo(request, response);
                break;
            case "cargarProSoporte":
                listaDatosSoporte(request, response);
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
            String tipo = request.getParameter("tipo");
            if (tipo.equals("nuevo") || tipo.equals("perfectivo")) {
                logicproyecto.actualizar(proyecto);
                request.getRequestDispatcher("controladordesarrollo?accion=listaDesarrollo").forward(request, response);
            } else if (tipo.equals("soporte")) {
                String respuesta = logicproyecto.actualizar(proyecto);
                if (respuesta.equals("true")) {
                    int idsoporte = Integer.parseInt(request.getParameter("idsoporte"));
                    String actividad = request.getParameter("actividad");
                    logicsoporte.actualizarSoporte(idsoporte, actividad);
                    request.getRequestDispatcher("controladorsoporte?accion=listar").forward(request, response);
                }

            }
        } catch (NumberFormatException e) {
            out.print(e);
        }

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

    public void listarPorTrabajador(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String dni = request.getParameter("dni");
        List<beanproyecto> lista = logicproyecto.listarPorTrabajador(dni);
        String nombreproyecto = lista.get(0).getNombre();
        String inicio = lista.get(0).getInicio();
        String fin = lista.get(0).getFin();
        int iddesarrollo = lista.get(0).getIdDesarrollo();
        if (iddesarrollo != 0) {
            request.setAttribute("nombreproyecto", nombreproyecto);
            request.setAttribute("inicio", inicio);
            request.setAttribute("fin", fin);
            String tipo = lista.get(0).getTipo();
            if (tipo.equals("nuevo")) {
                List<beanrequerimiento> requerimientos = logicre.listarRequerimiento(iddesarrollo);
                int totalre = requerimientos.size();
                int requerimientosRealizados = 0;
                int requerimientosFaltantes = 0;
                for (int i = 0; i < requerimientos.size(); i++) {
                    if ("pendiente".equals(requerimientos.get(i).getEstado())) {
                        requerimientosFaltantes = requerimientosFaltantes + 1;
                    } else if ("Realizado".equals(requerimientos.get(i).getEstado())) {
                        requerimientosRealizados = requerimientosRealizados + 1;
                    }
                }
                request.setAttribute("realizados", requerimientosRealizados);
                request.setAttribute("faltantes", requerimientosFaltantes);
                request.setAttribute("totalre", totalre);

                request.setAttribute("requerimientos", requerimientos);
            } else if (tipo.equals("perfectivo")) {
                List<beanrequerimiento> funcionalidad = logicre.listarFuncionalidad(iddesarrollo);
                request.setAttribute("requerimientos", funcionalidad);
            }
            request.getRequestDispatcher("VistaInicioTrabajador.jsp").forward(request, response);
        }
        request.getRequestDispatcher("logeo.jsp").forward(request, response);

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

    public void listaDatosNuevo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<beantrabajador> listaTrabajador = logictra.listarDisponibles();
        List<beancliente> listaCliente = logicliente.listarC();
        request.setAttribute("listaTrabajador", listaTrabajador);
        request.setAttribute("listaCliente", listaCliente);
        request.getRequestDispatcher("ProyectoDesarrolloNuevo.jsp").forward(request, response);
    }

    public void listaDatosPerfectivo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<beantrabajador> listaTrabajador = logictra.listarDisponibles();
        List<beancliente> listaCliente = logicliente.listarC();
        request.setAttribute("listaTrabajador", listaTrabajador);
        request.setAttribute("listaCliente", listaCliente);
        request.getRequestDispatcher("ProyectoDesarrolloPerfectivo.jsp").forward(request, response);
    }

    public void listaDatosSoporte(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<beantrabajador> listaTrabajador = logictra.listarDisponibles();
        List<beancliente> listaCliente = logicliente.listarC();
        request.setAttribute("listaTrabajador", listaTrabajador);
        request.setAttribute("listaCliente", listaCliente);
        request.getRequestDispatcher("FormSoporte.jsp").forward(request, response);
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
        String tipo = request.getParameter("tipo");
        if (tipo.equals("nuevo") || tipo.equals("perfectivo")) {
            logicproyecto.eliminar(idproyecto);
            request.getRequestDispatcher("controladordesarrollo?accion=listaDesarrollo").forward(request, response);
        } else if (tipo.equals("soporte")) {
            logicproyecto.eliminar(idproyecto);
            request.getRequestDispatcher("controladorsoporte?accion=listar").forward(request, response);
        }

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
