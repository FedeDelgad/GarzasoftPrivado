/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bean.beancliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.logiccliente;

/**
 *
 * @author hp
 */
public class controladorcliente extends HttpServlet {
    logiccliente lcli = new logiccliente();
    beancliente bcli =new beancliente();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String accion =request.getParameter("accion");
         switch(accion){
              
             case "perfil":
                    int idcliente=Integer.parseInt(request.getParameter("idcliente"));
                    request.setAttribute("uncliente", lcli.cliente(idcliente));
                    request.getRequestDispatcher("cli-perfil.jsp").forward(request, response);
                break;
             case "actualizar":
                    String claveantigua=request.getParameter("claveantigua");
                    String clavenueva=request.getParameter("clavenueva");
                    String rclavenueva=request.getParameter("rclavenueva");
                    String clave= request.getParameter("clave");
                    int id=Integer.parseInt(request.getParameter("idcliente"));
                        if(claveantigua.equalsIgnoreCase("")&&clavenueva.equalsIgnoreCase("")&&rclavenueva.equalsIgnoreCase(""))
                        {
                             bcli.setTelefonocli(request.getParameter("telefono"));
                             bcli.setCorreocli(request.getParameter("correo"));
                             bcli.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
                             lcli.actualizar(bcli); 
                             request.setAttribute("rpta", "correcto");
                        }else{
                             if( clave.equals(claveantigua) && clavenueva.equalsIgnoreCase(rclavenueva)&& 
                                 clavenueva!="" && rclavenueva!="")
                             {
                               bcli.setTelefonocli(request.getParameter("telefono"));
                               bcli.setCorreocli(request.getParameter("correo"));
                               bcli.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
                               lcli.actualizar(bcli);
                               bcli.setClavecli(claveantigua);
                               lcli.actualizarclave(bcli, clavenueva);
                              request.setAttribute("rpta", "correcto");    
                             }else{
                               request.setAttribute("rpta","incorrecto");
                             }
                         }
                    request.getRequestDispatcher("controladorcliente?accion=perfil&idcliente="+id).forward(request, response);     
                 break;
             case "agregar":
                    PrintWriter out = response.getWriter();
                    try {
                        String res;
                        bcli.setNombrecli(request.getParameter("nombre"));
                        bcli.setApellidocli(request.getParameter("apellido"));
                        bcli.setTelefonocli(request.getParameter("telefono"));
                        bcli.setCorreocli(request.getParameter("correo"));
                        bcli.setClavecli(request.getParameter("contra"));
                        bcli.setIngresocli(request.getParameter("fecha"));
                        bcli.setCondicioncli("nuevo");
                        bcli.setEliminacli("activo");
                        bcli.setDnicli(request.getParameter("dni"));
                        bcli.setSexocli(request.getParameter("genero"));
                        
                        res=lcli.agregarC(bcli);
                        out.print(res);
                    } catch (Exception e) {
                        out.print(e);
                    }
                    response.sendRedirect("CrudCliente.jsp");
                 break;
             case "eliminar":
                    PrintWriter out2 = response.getWriter();
                    int idcli = Integer.parseInt(request.getParameter("idcli"));
                    try {
                        String res = lcli.eliminarC(idcli);
                        out2.print(res);
                    } catch (Exception e) {
                        out2.print(e);
                    }
                 break;
             case "listar":
                    
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
