/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bean.beanadministrador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.logicadministrador;

/**
 *
 * @author cleiv
 */
@WebServlet(name = "controladoradmin", urlPatterns = {"/controladoradmin"})
public class controladoradmin extends HttpServlet {

    
    logicadministrador ladm= new logicadministrador();
    beanadministrador badm=new beanadministrador();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion =request.getParameter("accion");
        switch(accion){
              
             case "perfil":
                    int idadministrador=Integer.parseInt(request.getParameter("idadministrador"));
                    request.setAttribute("unadministrador", ladm.administrador(idadministrador));
                    request.getRequestDispatcher("PerfilAdministrador.jsp").forward(request, response);
             break;
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
