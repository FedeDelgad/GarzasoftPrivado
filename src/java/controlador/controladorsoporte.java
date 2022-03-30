
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

@WebServlet(name = "controladorsoporte", urlPatterns = {"/controladorsoporte"})
public class controladorsoporte extends HttpServlet {

    logictrabajador logictra = new logictrabajador();
    logiccliente logicliente = new logiccliente();
    logicproyecto logicproyecto = new logicproyecto();
    logicsoporte logicsoporte = new logicsoporte();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch(accion){
            case "agregar":
                agregar(request,response);
                break;
            case "actualizar":
                break;
            case "listar":
                listar(request,response);
                break;
            case "eliminar":
            break;
        }
    }

    public void agregar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String respuesta;
        beanproyecto proyecto = new beanproyecto();
        try {
            proyecto.setIdCliente(Integer.parseInt(request.getParameter("idcliente")));
            int idtrabajador = Integer.parseInt(request.getParameter("idtrabajador"));
            //proyecto.setIdTrabajador(Integer.parseInt(request.getParameter("idtrabajador")));
            proyecto.setIdTrabajador(idtrabajador);
            String nombre = request.getParameter("nombreproyecto");
            proyecto.setNombre(nombre);
            proyecto.setInicio(request.getParameter("inicio"));
            proyecto.setFin(request.getParameter("fin"));
            respuesta = logicproyecto.agregar(proyecto);
            if (respuesta.equals("true")) {
                String actividad = request.getParameter("actividad");
                int idproyecto = logicproyecto.bucarPorNombre(nombre);
                String res2 = logicsoporte.agregarSoporte(idproyecto, actividad);
                if(res2.equals("true")){
                    String dispo = "ocupado";
                    logictra.actualizarDisponibilidad(dispo, idtrabajador);
                    request.getRequestDispatcher("controladorsoporte?accion=listar").forward(request, response);
                }
                
            } else {
                out.print("Error");
                request.getRequestDispatcher("CrudProyectoSoporte.jsp").forward(request, response);
            }

        } catch (NumberFormatException e) {
            out.print(e);
            request.getRequestDispatcher("CrudProyectoSoporte.jsp").forward(request, response);
        }
    }
    
    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<beansoporte> listasoporte = logicsoporte.listarSoporte();
        request.setAttribute("listasoporte", listasoporte);
        request.getRequestDispatcher("CrudProyectoSoporte.jsp").forward(request, response);
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
