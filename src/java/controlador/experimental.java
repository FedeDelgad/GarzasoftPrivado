
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


public class experimental extends HttpServlet {

    logictrabajador ltrab = new logictrabajador();
    logictrabajador logic = new logictrabajador();
    beantrabajador btrab = new beantrabajador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch(accion){
            case "agregar":
                agregar(request, response);
                break;
            case "listar":
                listar(request, response);
                break;
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
        } catch (NumberFormatException e) {
            out.print(e);
        }
        request.getRequestDispatcher("experimental?accion=listar").forward(request, response);
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        List<beantrabajador> listatrabajador = logic.listar();
        out.print("<table>");
        for(int i=0; i< listatrabajador.size(); i++){
            beantrabajador tra = new beantrabajador();
            out.print("<tr>");
            out.print("<td style= 'align:center'>"+tra.getDni()+"</td>");
            out.print("<td style= 'align:center'>"+tra.getNombre()+"</td>");
            out.print("<td style= 'align:center'>"+tra.getApellido()+"</td>");
            out.print("<td style= 'align:center'>"+tra.getTelefono()+"</td>");
            out.print("<td style= 'align:center'>"+tra.getCorreo()+"</td>");
            out.print("<td style= 'align:center'>"+tra.getCondicion()+"</td>");
            out.print("</tr>");
        }
        out.print("<table>");
        request.setAttribute("listaTrabajador", listatrabajador);
        request.getRequestDispatcher("experimental.jsp").forward(request, response);
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
