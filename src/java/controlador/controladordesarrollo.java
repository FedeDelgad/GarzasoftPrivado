package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.*;
import bean.*;
import java.util.List;

@WebServlet(name = "controladordesarrollo", urlPatterns = {"/controladordesarrollo"})
public class controladordesarrollo extends HttpServlet {

    logictrabajador logictra = new logictrabajador();
    logiccliente logicliente = new logiccliente();
    logicproyecto logicproyecto = new logicproyecto();
    logicdesarrollo logicdesarrollo = new logicdesarrollo();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        switch (accion) {
            case "agregarNuevo":
                agregarNuevo(request, response);
                break;
            case "agregarPerfectivo":
                break;
            case "listaDesarrollo":
                listaDesarrollo(request, response);
                break;
            case "listaNuevos":
                break;
            case "listaPerfecvtivos":
                break;
        }
    }

    public void agregarNuevo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String respuesta;
        beanproyecto nuevo = new beanproyecto();
        try {
            nuevo.setIdCliente(Integer.parseInt(request.getParameter("idcliente")));
            nuevo.setIdTrabajador(Integer.parseInt(request.getParameter("idtrabajador")));
            String nombre = request.getParameter("nombreproyecto");
            nuevo.setNombre(nombre);
            nuevo.setInicio(request.getParameter("inicio"));
            nuevo.setFin(request.getParameter("fin"));
            respuesta = logicproyecto.agregar(nuevo);
            if (respuesta.equals("true")) {
                int iddesarrollo = logicproyecto.bucarPorNombre(nombre);
                out.print(logicdesarrollo.agregarNuevo(iddesarrollo));
                request.getRequestDispatcher("controladordesarrollo?accion=listaDesarrollo").forward(request, response);
            } else {
                out.print("Error");
                request.getRequestDispatcher("ProyectoDesarrolloNuevo.jsp").forward(request, response);
            }

        } catch (NumberFormatException e) {
            out.print(e);
            request.getRequestDispatcher("ProyectoDesarrolloNuevo.jsp").forward(request, response);
        }
    }

    public void listaDesarrollo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<beandesarrollo> listadesarrollo = logicdesarrollo.listaDesarrollo();
        request.setAttribute("listadesarrollo", listadesarrollo);
        request.getRequestDispatcher("CrudProyectoDesarrollo.jsp").forward(request, response);
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
