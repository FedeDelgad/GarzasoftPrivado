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

@WebServlet(name = "controladorRequerimiento", urlPatterns = {"/controladorRequerimiento"})
public class controladorRequerimiento extends HttpServlet {

    beanproyecto proyecto = new beanproyecto();
    beancliente cliente = new beancliente();
    beantrabajador trabajador = new beantrabajador();
    logicrequerimiento logicre = new logicrequerimiento();
    logicproyecto logicpro = new logicproyecto();
    logiccliente logicli = new logiccliente();
    logictrabajador logictrab = new logictrabajador();
    logicdesarrollo logicdesarrollo = new logicdesarrollo();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        switch (accion) {
            case "agregarRequerimiento":
                agregarRequerimiento(request, response);
                break;
            case "agregarFuncionalidad":
                agregarFuncionalidad(request, response);
                break;
            case "checkList":
                checkList(request, response);
                break;
            case "listarRequerimiento":
                listarRequerimiento(request, response);
                break;
            case "listarFuncionalidad":
                listarFuncionalidad(request, response);
                break;
            case "actualizarRequerimiento":
                actualizarRequerimiento(request, response);
                break;
            case "actualizarFuncionalidad":
                actualizarFuncionalidad(request, response);
                break;
            case "eliminarRequerimiento":
                eliminarRequerimiento(request, response);
                break;
            case "eliminarFuncionalidad":
                eliminarFuncionalidad(request, response);
                break;
            case "cambiarEstado":
                cambiarEstado(request, response);
                break;
        }
    }

    public void agregarRequerimiento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        try {
            beanrequerimiento beanre = new beanrequerimiento();
            beanre.setIddesarrollo(Integer.parseInt(request.getParameter("iddesarrollo")));
            beanre.setNombre(request.getParameter("nombrere"));
            out.print(logicre.agregarRequerimiento(beanre));
        } catch (NumberFormatException e) {
            out.print(e);
        }

        request.getRequestDispatcher("controladorRequerimiento?accion=listarRequerimiento").forward(request, response);

    }

    public void agregarFuncionalidad(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        try {
            beanrequerimiento beanre = new beanrequerimiento();
            beanre.setIddesarrollo(Integer.parseInt(request.getParameter("iddesarrollo")));
            beanre.setNombre(request.getParameter("nombrere"));
            out.print(logicre.agregarFuncionalidad(beanre));
        } catch (NumberFormatException e) {
            out.print(e);
        }

        request.getRequestDispatcher("controladorRequerimiento?accion=listarFuncionalidad").forward(request, response);

    }

    public void checkList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int idpro = Integer.parseInt(request.getParameter("iddesarrollo"));
        List<beandesarrollo> listad = logicdesarrollo.listarID(idpro);
        int idproyecto = listad.get(0).getIddesarrollo();
        String nombreproyecto = listad.get(0).getNombreproyecto();
        String nombretrabajador = listad.get(0).getNombretrabajador();
        String apellidotrabajador = listad.get(0).getApellidotrabajador();
        String nombrecliente = listad.get(0).getNombrecliente();
        String apellidocliente = listad.get(0).getApellidocliente();
        request.setAttribute("iddesarrollo", idproyecto);
        request.setAttribute("nombreproyecto", nombreproyecto);
        request.setAttribute("datostrabajador", nombretrabajador + " " + apellidotrabajador);
        request.setAttribute("datoscliente", nombrecliente + " " + apellidocliente);

        String tipodesarrollo = request.getParameter("tipo");
        if (tipodesarrollo.equals("nuevo")) {
            List<beanrequerimiento> listare = logicre.listarRequerimiento(idpro);
            request.setAttribute("listare", listare);
            request.getRequestDispatcher("Requerimientos.jsp").forward(request, response);
        }else if(tipodesarrollo.equals("perfectivo")){
            List<beanrequerimiento> listafun = logicre.listarFuncionalidad(idpro);
            request.setAttribute("listafun", listafun);
            request.getRequestDispatcher("Funcionalidad.jsp").forward(request, response);
        }

    }

    public void listarRequerimiento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idpro = Integer.parseInt(request.getParameter("iddesarrollo"));
        List<beandesarrollo> listad = logicdesarrollo.listarID(idpro);
        int idproyecto = listad.get(0).getIddesarrollo();
        String nombreproyecto = listad.get(0).getNombreproyecto();
        String nombretrabajador = listad.get(0).getNombretrabajador();
        String apellidotrabajador = listad.get(0).getApellidotrabajador();
        String nombrecliente = listad.get(0).getNombrecliente();
        String apellidocliente = listad.get(0).getApellidocliente();
        request.setAttribute("iddesarrollo", idproyecto);
        request.setAttribute("nombreproyecto", nombreproyecto);
        request.setAttribute("datostrabajador", nombretrabajador + " " + apellidotrabajador);
        request.setAttribute("datoscliente", nombrecliente + " " + apellidocliente);

        List<beanrequerimiento> listare = logicre.listarRequerimiento(idpro);
        request.setAttribute("listare", listare);
        request.getRequestDispatcher("Requerimientos.jsp").forward(request, response);
    }

    public void listarFuncionalidad(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idpro = Integer.parseInt(request.getParameter("iddesarrollo"));
        List<beandesarrollo> listad = logicdesarrollo.listarID(idpro);
        int idproyecto = listad.get(0).getIddesarrollo();
        String nombreproyecto = listad.get(0).getNombreproyecto();
        String nombretrabajador = listad.get(0).getNombretrabajador();
        String apellidotrabajador = listad.get(0).getApellidotrabajador();
        String nombrecliente = listad.get(0).getNombrecliente();
        String apellidocliente = listad.get(0).getApellidocliente();
        request.setAttribute("iddesarrollo", idproyecto);
        request.setAttribute("nombreproyecto", nombreproyecto);
        request.setAttribute("datostrabajador", nombretrabajador + " " + apellidotrabajador);
        request.setAttribute("datoscliente", nombrecliente + " " + apellidocliente);

        List<beanrequerimiento> listare = logicre.listarFuncionalidad(idpro);
        request.setAttribute("listafun", listare);
        request.getRequestDispatcher("Funcionalidad.jsp").forward(request, response);
    }

    public void actualizarRequerimiento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        try {
            beanrequerimiento bean = new beanrequerimiento();
            bean.setNombre(request.getParameter("nombrere"));
            bean.setIdrequerimiento(Integer.parseInt(request.getParameter("idre")));
            out.print(logicre.actualizarRequerimiento(bean));
        } catch (NumberFormatException e) {
            out.print(e);
        }

        request.getRequestDispatcher("controladorRequerimiento?accion=listarRequerimiento").forward(request, response);

    }

    public void actualizarFuncionalidad(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        try {
            beanrequerimiento bean = new beanrequerimiento();
            bean.setNombre(request.getParameter("nombrere"));
            bean.setIdfuncionalidad(Integer.parseInt(request.getParameter("idfun")));
            out.print(logicre.actualizarFuncionalidad(bean));
        } catch (NumberFormatException e) {
            out.print(e);
        }

        request.getRequestDispatcher("controladorRequerimiento?accion=listarFuncionalidad").forward(request, response);

    }

    public void eliminarRequerimiento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idre = Integer.parseInt(request.getParameter("idre"));
        logicre.eliminarRequerimiento(idre);
        request.getRequestDispatcher("controladorRequerimiento?accion=listarRequerimiento").forward(request, response);
    }

    public void eliminarFuncionalidad(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idre = Integer.parseInt(request.getParameter("idfun"));
        logicre.eliminarFuncionalidad(idre);
        request.getRequestDispatcher("controladorRequerimiento?accion=listarFuncionalidad").forward(request, response);
    }
    
    public void cambiarEstado(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idreq = Integer.parseInt(request.getParameter("idre"));
        String estado = request.getParameter("estado");
        String dni = request.getParameter("dni");
        String respuesta = logicre.cambiarestado(estado, idreq);
        if(respuesta.equals("true")){
            request.setAttribute("dni", dni);
            request.getRequestDispatcher("controladorproyecto?accion=ProyectoDesdeTrabajador&dni"+dni).forward(request, response);
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
