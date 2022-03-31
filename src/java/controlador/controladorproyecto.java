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
            case "ProyectoDesdeTrabajador":
                ProyectoDesdeTrabajador(request, response);
                break;
            case "cambiarEstado":
                cambioestado(request, response);
                break;
            case "cliente":
                cliente(request, response);
                break;
            case "detallecliente":
                detallecliente(request, response);
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
        int cant = lista.size();
        if (cant == 0) {
            request.getRequestDispatcher("VistaProyectoVacio.jsp").forward(request, response);
        } else {

            String nombreproyecto = lista.get(0).getNombre();
            String inicio = lista.get(0).getInicio();
            String fin = lista.get(0).getFin();
            int iddesarrollo = lista.get(0).getIdDesarrollo();
            int idproyecto = lista.get(0).getIdProyecto();
            String estado = lista.get(0).getEstado();
            if (iddesarrollo != 0) {
                request.setAttribute("nombreproyecto", nombreproyecto);
                request.setAttribute("inicio", inicio);
                request.setAttribute("fin", fin);
                request.setAttribute("idproyecto", idproyecto);
                request.setAttribute("estadopro", estado);
                String tipo = lista.get(0).getTipo();
                if (tipo.equals("nuevo")) {
                    List<beanrequerimiento> requerimientos = logicre.listarRequerimiento(iddesarrollo);
                    int totalre = requerimientos.size();
                    int requerimientosRealizados = 0;
                    int requerimientosFaltantes = 0;
                    for (int i = 0; i < requerimientos.size(); i++) {
                        if ("PENDIENTE".equals(requerimientos.get(i).getEstado()) || "EN PROCESO".equals(requerimientos.get(i).getEstado())) {
                            requerimientosFaltantes = requerimientosFaltantes + 1;
                        } else if ("REALIZADO".equals(requerimientos.get(i).getEstado())) {
                            requerimientosRealizados = requerimientosRealizados + 1;
                        }
                    }
                    request.setAttribute("realizados", requerimientosRealizados);
                    request.setAttribute("faltantes", requerimientosFaltantes);
                    request.setAttribute("totalre", totalre);
                    request.setAttribute("requerimientos", requerimientos);
                    request.getRequestDispatcher("VistaInicioTrabajador.jsp").forward(request, response);
                } else if (tipo.equals("perfectivo")) {
                    List<beanrequerimiento> funci = logicre.listarFuncionalidad(iddesarrollo);
                    int totalre = funci.size();
                    int funre = 0;
                    int funfalta = 0;
                    for (int i = 0; i < funci.size(); i++) {
                        if ("PENDIENTE".equals(funci.get(i).getEstado()) || "EN PROCESO".equals(funci.get(i).getEstado())) {
                            funfalta = funfalta + 1;
                        } else if ("REALIZADO".equals(funci.get(i).getEstado())) {
                            funre = funre + 1;
                        }
                    }
                    request.setAttribute("realizados", funre);
                    request.setAttribute("faltantes", funfalta);
                    request.setAttribute("totalre", totalre);
                    request.setAttribute("requerimientos", funci);
                    request.getRequestDispatcher("VistaInicioTrabajador.jsp").forward(request, response);
                }

            }
        }

    }

    public void ProyectoDesdeTrabajador(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String dni = request.getParameter("dni");
        List<beanproyecto> lista = logicproyecto.listarPorTrabajador(dni);
        if (lista.isEmpty()) {
            request.getRequestDispatcher("VistaProyectoVacio.jsp").forward(request, response);
        } else {

            String nombreproyecto = lista.get(0).getNombre();
            String inicio = lista.get(0).getInicio();
            String fin = lista.get(0).getFin();
            String dtcliente = lista.get(0).getNombreCliente() + " " + lista.get(0).getApellidoCliente();
            String estado = lista.get(0).getEstado();
            int iddesarrollo = lista.get(0).getIdDesarrollo();
            int idproyecto = lista.get(0).getIdProyecto();
            if (iddesarrollo != 0) {
                request.setAttribute("nombreproyecto", nombreproyecto);
                request.setAttribute("inicio", inicio);
                request.setAttribute("fin", fin);
                request.setAttribute("cliente", dtcliente);
                request.setAttribute("estadopro", estado);
                request.setAttribute("idproyecto", idproyecto);
                String tipo = lista.get(0).getTipo();
                if (tipo.equals("nuevo")) {
                    List<beanrequerimiento> requerimientos = logicre.listarRequerimiento(iddesarrollo);
                    int requerimientosFaltantes = 0;
                    for (int i = 0; i < requerimientos.size(); i++) {
                        if ("PENDIENTE".equals(requerimientos.get(i).getEstado())) {
                            requerimientosFaltantes = requerimientosFaltantes + 1;
                        }
                    }
                    request.setAttribute("faltantes", requerimientosFaltantes);
                    request.setAttribute("requerimientos", requerimientos);
                    request.getRequestDispatcher("VistaProyectoTrabajador.jsp").forward(request, response);
                } else if (tipo.equals("perfectivo")) {
                    List<beanrequerimiento> funci = logicre.listarFuncionalidad(iddesarrollo);
                    int funfalta = 0;
                    for (int i = 0; i < funci.size(); i++) {
                        if ("PENDIENTE".equals(funci.get(i).getEstado()) || "EN PROCESO".equals(funci.get(i).getEstado())) {
                            funfalta = funfalta + 1;
                        }
                    }
                    request.setAttribute("faltantes", funfalta);
                    request.setAttribute("funcionalidad", funci);
                    request.getRequestDispatcher("ProTrabajadorFuncionalidad.jsp").forward(request, response);
                }

            }
        }

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

    public void cambioestado(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int idproyecto = Integer.parseInt(request.getParameter("idproyecto"));
        int refaltantes = Integer.parseInt(request.getParameter("faltantes"));
        String estadopro = request.getParameter("estado");
        String dni = request.getParameter("dni2");
        int idtrabajador = Integer.parseInt(request.getParameter("idtrabajador"));
        if (refaltantes == 0) {
            String res = logicproyecto.cambiarestado(estadopro, idproyecto);
            if (res.equals("true")) {
                logictra.actualizarDisponibilidad("libre", idtrabajador);
                request.getRequestDispatcher("controladorproyecto?accion=trabajador&dni=" + dni).forward(request, response);
            }

        } else if (refaltantes > 0) {
            request.getRequestDispatcher("controladorproyecto?accion=ProyectoDesdeTrabajador&dni=" + dni).forward(request, response);
        }
    }

    public void cliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String dni = request.getParameter("dni");
        List<beanproyecto> lista = logicproyecto.listarPorCliente(dni);
        int cant = lista.size();
        if (cant == 0) {
            request.getRequestDispatcher("VistaProyectoVacio.jsp").forward(request, response);
        } else {
            String estado;
            String estadoactual = null;
            String nombreproactual = null;
            int idproyecto = 0;
            String nombretrabajador = null;
            String apellidotrabajador = null;
            String correotra;
            String telefonotra;
            for (int i = 0; i < lista.size(); i++) {
                estado = lista.get(i).getEstado();
                if (estado.equals("PENDIENTE")) {
                    nombreproactual = lista.get(i).getNombre();
                    idproyecto = lista.get(i).getIdProyecto();
                    nombretrabajador = lista.get(i).getNombreTrabajador();
                    apellidotrabajador = lista.get(i).getApellidoTrabajador();
                    estadoactual = lista.get(i).getEstado();
                }
                request.setAttribute("nombreproyecto", nombreproactual);
                request.setAttribute("idproyecto", idproyecto);
                request.setAttribute("nombretrabajador", nombretrabajador);
                request.setAttribute("apellidotrabajador", apellidotrabajador);
                request.setAttribute("estado", estadoactual);
                request.setAttribute("listaproyectos", lista);
                request.getRequestDispatcher("VistaInicioCliente.jsp").forward(request, response);
            }

            /*
            String nombreproyecto = lista.get(0).getNombre();
            String inicio = lista.get(0).getInicio();
            String fin = lista.get(0).getFin();
            int iddesarrollo = lista.get(0).getIdDesarrollo();
            int idproyecto = lista.get(0).getIdProyecto();
            String estado = lista.get(0).getEstado();
            if (iddesarrollo != 0) {
                request.setAttribute("nombreproyecto", nombreproyecto);
                request.setAttribute("inicio", inicio);
                request.setAttribute("fin", fin);
                request.setAttribute("idproyecto", idproyecto);
                request.setAttribute("estadopro", estado);
                String tipo = lista.get(0).getTipo();
                if (tipo.equals("nuevo")) {
                    List<beanrequerimiento> requerimientos = logicre.listarRequerimiento(iddesarrollo);
                    int totalre = requerimientos.size();
                    int requerimientosRealizados = 0;
                    int requerimientosFaltantes = 0;
                    for (int i = 0; i < requerimientos.size(); i++) {
                        if ("PENDIENTE".equals(requerimientos.get(i).getEstado()) || "EN PROCESO".equals(requerimientos.get(i).getEstado())) {
                            requerimientosFaltantes = requerimientosFaltantes + 1;
                        } else if ("REALIZADO".equals(requerimientos.get(i).getEstado())) {
                            requerimientosRealizados = requerimientosRealizados + 1;
                        }
                    }
                    request.setAttribute("realizados", requerimientosRealizados);
                    request.setAttribute("faltantes", requerimientosFaltantes);
                    request.setAttribute("totalre", totalre);
                    request.setAttribute("requerimientos", requerimientos);
                    request.getRequestDispatcher("VistaInicioTrabajador.jsp").forward(request, response);
                } else if (tipo.equals("perfectivo")) {
                    List<beanrequerimiento> funci = logicre.listarFuncionalidad(iddesarrollo);
                    int totalre = funci.size();
                    int funre = 0;
                    int funfalta = 0;
                    for (int i = 0; i < funci.size(); i++) {
                        if ("PENDIENTE".equals(funci.get(i).getEstado()) || "EN PROCESO".equals(funci.get(i).getEstado())) {
                            funfalta = funfalta + 1;
                        } else if ("REALIZADO".equals(funci.get(i).getEstado())) {
                            funre = funre + 1;
                        }
                    }
                    request.setAttribute("realizados", funre);
                    request.setAttribute("faltantes", funfalta);
                    request.setAttribute("totalre", totalre);
                    request.setAttribute("requerimientos", funci);
                    request.getRequestDispatcher("VistaInicioTrabajador.jsp").forward(request, response);
                }

            }*/
        }

    }

    public void detallecliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idproyecto = Integer.parseInt(request.getParameter("idproyecto"));
        List<beanproyecto> listade = logicproyecto.listarID(idproyecto);
        String nombreproyecto = listade.get(0).getNombre();
        String inicio = listade.get(0).getInicio();
        String fin = listade.get(0).getFin();
        String trabajadordatos = listade.get(0).getNombreTrabajador() + " " + listade.get(0).getApellidoTrabajador();
        String estado = listade.get(0).getEstado();
        String tipo = listade.get(0).getTipo();
        int iddesarrollo = listade.get(0).getIdDesarrollo();
        int cantidad;
        if (iddesarrollo != 0) {
            if (tipo.equals("nuevo")) {
                List<beanrequerimiento> listare = logicre.listarRequerimiento(iddesarrollo);
                cantidad = listare.size();
                request.setAttribute("cantidad", cantidad);
                request.setAttribute("listadetalle", listare);
            } else if (tipo.equals("perfectivo")) {
                List<beanrequerimiento> listafun = logicre.listarFuncionalidad(iddesarrollo);
                cantidad = listafun.size();
                request.setAttribute("cantidad", cantidad);
                request.setAttribute("listadetalle", listafun);

            }
            request.setAttribute("nombreproyecto", nombreproyecto);
            request.setAttribute("inicio", inicio);
            request.setAttribute("fin", fin);
            request.setAttribute("trabajador", trabajadordatos);
            request.setAttribute("estado", estado);
            request.getRequestDispatcher("VistaDetalleCliente.jsp").forward(request, response);
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
