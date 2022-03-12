package controlador;

import bean.beanadministrador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.logicadministrador;

public class validaradministrador extends HttpServlet {

    beanadministrador badm = new beanadministrador();
    logicadministrador ladm = new logicadministrador();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        HttpSession obSesion = request.getSession();

        switch (accion) {
            case "ingresar":
                String usuario = request.getParameter("usuario");
                String clave = request.getParameter("password");
                badm = ladm.validar(usuario, clave);
                if (badm.getDniadmi() != null) {
                    obSesion.setAttribute("administrador", badm);
                    request.setAttribute("rpta1", "Bienvenido");
                    request.getRequestDispatcher("DashboardAdministrador.jsp").forward(request, response);
                } else {
                    request.setAttribute("rpta2", "Credenciales Incorrectos");
                    request.getRequestDispatcher("logeo.jsp").forward(request, response);
                }
                break;
            case "cerrar":
                obSesion.setAttribute("administrador", null);
                obSesion.invalidate();
                request.getRequestDispatcher("logeo.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
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
    }

}
