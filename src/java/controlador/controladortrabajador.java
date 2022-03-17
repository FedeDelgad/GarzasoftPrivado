package controlador;

import bean.beantrabajador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.logictrabajador;

public class controladortrabajador extends HttpServlet {

    logictrabajador ltrab = new logictrabajador();
    logictrabajador logic = new logictrabajador();
    beantrabajador btrab = new beantrabajador();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        switch (accion) {
            case "perfil":
                int idtrabajador = Integer.parseInt(request.getParameter("idtrabajador"));
                request.setAttribute("untrabajador", ltrab.trabajador(idtrabajador));
                request.getRequestDispatcher("trab-perfil.jsp").forward(request, response);
                break;
            case "actualizar":
                String claveantigua = request.getParameter("claveantigua");
                String clavenueva = request.getParameter("clavenueva");
                String rclavenueva = request.getParameter("rclavenueva");
                String clave = request.getParameter("clave");
                int id = Integer.parseInt(request.getParameter("idtrabajador"));
                if (claveantigua.equalsIgnoreCase("") && clavenueva.equalsIgnoreCase("") && rclavenueva.equalsIgnoreCase("")) {
                    btrab.setTelefono(request.getParameter("telefono"));
                    btrab.setCorreo(request.getParameter("correo"));
                    btrab.setIdtrabajador(Integer.parseInt(request.getParameter("idtrabajador")));
                    ltrab.actualizar(btrab);
                    request.setAttribute("rpta", "correcto");
                } else {
                    if (clave.equals(claveantigua) && clavenueva.equalsIgnoreCase(rclavenueva)
                            && clavenueva != "" && rclavenueva != "") {
                        btrab.setTelefono(request.getParameter("telefono"));
                        btrab.setCorreo(request.getParameter("correo"));
                        btrab.setIdtrabajador(Integer.parseInt(request.getParameter("idtrabajador")));
                        ltrab.actualizar(btrab);
                        btrab.setClave(claveantigua);
                        ltrab.actualizarclave(btrab, clavenueva);
                        request.setAttribute("rpta", "correcto");
                    } else {
                        request.setAttribute("rpta", "incorrecto");
                    }

                }
                request.getRequestDispatcher("controladortrabajador?accion=perfil&idtrabajador=" + id).forward(request, response);
                break;
            case "agregar":
                agregar(request, response);
                break;
            case "listar":
                listar(request, response);
                break;
            case "modificar":
                modificar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    public void agregar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        beantrabajador trabajador = new beantrabajador();
        try {
            trabajador.setDni(request.getParameter("dni"));
            trabajador.setNombre(request.getParameter("nombre"));
            trabajador.setApellido(request.getParameter("apellido"));
            trabajador.setTelefono(request.getParameter("telefono"));
            trabajador.setSexo(request.getParameter("genero"));
            trabajador.setIngreso(request.getParameter("ingreso"));
            trabajador.setClave(request.getParameter("clave"));
            trabajador.setCorreo(request.getParameter("correo"));
            out.print(logic.agregar(trabajador));
        } catch (Exception e) {
            out.print(e);
        }
        request.getRequestDispatcher("controladortrabajador?accion=listar").forward(request, response);
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<beantrabajador> listatrabajador = logic.listar();
        request.setAttribute("listaTrabajador", listatrabajador);
        request.getRequestDispatcher("CrudTrabajador.jsp").forward(request, response);
    }

    public void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        beantrabajador trabajador = new beantrabajador();
        try {
            trabajador.setIdtrabajador(Integer.parseInt(request.getParameter("id")));
            trabajador.setDni(request.getParameter("dni"));
            trabajador.setNombre(request.getParameter("nombre"));
            trabajador.setApellido(request.getParameter("apellido"));
            trabajador.setTelefono(request.getParameter("telefono"));
            trabajador.setSexo(request.getParameter("genero"));
            trabajador.setIngreso(request.getParameter("ingreso"));
            trabajador.setCorreo(request.getParameter("correo"));
            out.print(logic.actualizar(trabajador));
        } catch (NumberFormatException e) {
            out.print(e);
        }
        request.getRequestDispatcher("controladortrabajador?accion=listar").forward(request, response);
    }

    public void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        logic.eliminar(id);
        request.getRequestDispatcher("controladortrabajador?accion=listar").forward(request, response);
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
