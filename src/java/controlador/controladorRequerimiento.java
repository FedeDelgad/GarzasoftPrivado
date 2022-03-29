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
            case "agregar":
                agregar(request, response);
                break;
            case "listar":
                listar(request, response);
                break;
            case "actualizar":
                actualizar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
        }
    }

    public void agregar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        try {
            beanrequerimiento beanre = new beanrequerimiento();
            beanre.setIddesarrollo(Integer.parseInt(request.getParameter("iddesarrollo")));
            beanre.setNombre(request.getParameter("nombrere"));
            out.print(logicre.agregar(beanre));
        } catch (NumberFormatException e) {
            out.print(e);
        }

        request.getRequestDispatcher("controladorRequerimiento?accion=listar").forward(request, response);

    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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

        List<beanrequerimiento> listare = logicre.listar(idpro);
        request.setAttribute("listare", listare);
        request.getRequestDispatcher("Requerimientos.jsp").forward(request, response);
    }

    public void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        try {
            beanrequerimiento bean = new beanrequerimiento();
            bean.setNombre(request.getParameter("nombrere"));
            bean.setIdrequerimiento(Integer.parseInt(request.getParameter("idre")));
            out.print(logicre.actualizar(bean));
        } catch (NumberFormatException e) {
            out.print(e);
        }

        request.getRequestDispatcher("controladorRequerimiento?accion=listar").forward(request, response);

    }

     public void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         int idre = Integer.parseInt(request.getParameter("idre"));
         logicre.eliminar(idre);
         request.getRequestDispatcher("controladorRequerimiento?accion=listar").forward(request, response);
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
