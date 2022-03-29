package controlador;

import bean.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.*;

public class controladorLogin extends HttpServlet {

    beanadministrador admin = new beanadministrador();
    beantrabajador trabajador = new beantrabajador();
    beancliente cliente = new beancliente();
    logicadministrador logicadmin = new logicadministrador();
    logictrabajador logictrabajador = new logictrabajador();
    logiccliente logiccliente = new logiccliente();
    logicproyecto logicpro = new logicproyecto();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession obSesion = request.getSession();
        String accion = request.getParameter("accion");
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        switch (accion) {
            case "Admin":
                admin = logicadmin.validar(usuario, clave);
                if (admin.getDniadmi() != null) {
                    obSesion.setAttribute("administrador", admin);
                    request.setAttribute("respuestaadmin", "Bienvenido");
                    
                    request.getRequestDispatcher("DashboardAdministrador.jsp").forward(request, response);
                } else {
                    request.setAttribute("respuesta", "Usuario o Contraseña incorrectos...");
                    request.getRequestDispatcher("logeo.jsp").forward(request, response);
                }
                break;
            case "trabajador":
                trabajador = logictrabajador.validar(usuario, clave);
                if (trabajador.getDni() != null) {
                    obSesion.setAttribute("trabajador", trabajador);
                    request.setAttribute("respuestaadmin", "Bienvenido");
                    request.getRequestDispatcher("DashboardTrabajador.jsp").forward(request, response);
                } else {
                    request.setAttribute("respuesta", "Usuario o Contraseña incorrectos...");
                    request.getRequestDispatcher("logeo.jsp").forward(request, response);
                }
                break;
            case "cliente":
                cliente = logiccliente.validar(usuario, clave);
                if (cliente.getDnicli() != null) {
                    obSesion.setAttribute("cliente", cliente);
                    request.setAttribute("respuestaadmin", "Bienvenido");
                    request.getRequestDispatcher("DashboardCliente.jsp").forward(request, response);
                } else {
                    request.setAttribute("respuesta", "Usuario o Contraseña incorrectos...");
                    request.getRequestDispatcher("logeo.jsp").forward(request, response);
                }
                break;
            case "cerrar":
                obSesion.setAttribute("cerrar", null);
                obSesion.invalidate();
                request.getRequestDispatcher("logeo.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("respuesta", "Usuario o Contraseña incorrectos...");
                request.getRequestDispatcher("logeo.jsp").forward(request, response);

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
