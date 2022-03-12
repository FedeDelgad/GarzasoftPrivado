/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bean.beanadministrador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.logicadministrador;

/**
 *
 * @author hp
 */
public class controladoradministrador extends HttpServlet {

    logicadministrador ladm= new logicadministrador();
    beanadministrador badm=new beanadministrador();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String accion =request.getParameter("accion");
           switch(accion){
              
             case "perfil":
                    
                 /*int idadministrador=Integer.parseInt(request.getParameter("idadministrador"));
                    request.setAttribute("unadministrador", ladm.administrador(idadministrador));*/
                    request.getRequestDispatcher("../Perfiles/PerfilAdministrador.jsp").forward(request, response);
             break;
             case "actualizar":
                    String claveantigua=request.getParameter("claveantigua");
                    String clavenueva=request.getParameter("clavenueva");
                    String rclavenueva=request.getParameter("rclavenueva");
                    String clave= request.getParameter("clave");
                    int id=Integer.parseInt(request.getParameter("idadministrador"));
                        if(claveantigua.equalsIgnoreCase("")&&clavenueva.equalsIgnoreCase("")&&rclavenueva.equalsIgnoreCase(""))
                        {
                             badm.setTelefonoadmi(request.getParameter("telefono"));
                             badm.setCorreoadmi(request.getParameter("correo"));
                             badm.setIdadministrador(Integer.parseInt(request.getParameter("idadministrador")));
                             ladm.actualizar(badm);
                             request.setAttribute("rpta", "correcto");
                        }else{
                             if( clave.equals(claveantigua) && clavenueva.equalsIgnoreCase(rclavenueva)&& 
                                 clavenueva!="" && rclavenueva!="")
                             {
                              badm.setTelefonoadmi(request.getParameter("telefono"));
                              badm.setCorreoadmi(request.getParameter("correo"));
                              badm.setIdadministrador(Integer.parseInt(request.getParameter("idadministrador")));
                              ladm.actualizar(badm);
                              badm.setClaveadmi(claveantigua);
                              ladm.actualizarclave(badm, clavenueva);
                              request.setAttribute("rpta", "correcto");    
                             }else{
                               request.setAttribute("rpta","incorrecto");
                             }

                         }
                    request.getRequestDispatcher("controladoradministrador?accion=perfil&idadministrador="+id).forward(request, response);     

             break;
              default:
                 throw new AssertionError();
       
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
