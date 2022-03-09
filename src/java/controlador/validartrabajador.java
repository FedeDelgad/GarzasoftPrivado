/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bean.beantrabajador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.logictrabajador;

/**
 *
 * @author hp
 */
public class validartrabajador extends HttpServlet {
beantrabajador btra=new beantrabajador();
    logictrabajador ltrab=new logictrabajador();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String accion=request.getParameter("accion");
       
       HttpSession obSesion = request.getSession();
       /*ingresa al panel del trabajador*/
          if(accion.equalsIgnoreCase("ingresar")){
           String usuario=request.getParameter("usuario");
           String clave=request.getParameter("password");
           btra=ltrab.validar(usuario, clave);
           if(btra.getDni()!=null){
               obSesion.setAttribute("trabajador", btra);
               request.setAttribute("rpta1","Bienvenido");
               request.getRequestDispatcher("trab-principal.jsp").forward(request, response);
           }else{
               request.setAttribute("rpta2", "Credenciales Incorrectos");
              request.getRequestDispatcher("logeo.jsp").forward(request, response);   
           }
          } 
          
         /*salir del panel del trabajador*/
         
         if(accion.equalsIgnoreCase("cerrar")){
             obSesion.setAttribute("trabajador", null);
              obSesion.invalidate();
              request.getRequestDispatcher("logeo.jsp").forward(request, response); 
         }
          
         
       
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
