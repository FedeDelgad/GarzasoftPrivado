/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bean.beancliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.logiccliente;

public class controladorcliente extends HttpServlet {

    logiccliente lcli = new logiccliente();
    beancliente bcli = new beancliente();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        switch (accion) {

            case "perfil":
                int idcliente = Integer.parseInt(request.getParameter("idcliente"));
                request.setAttribute("uncliente", lcli.cliente(idcliente));
                request.getRequestDispatcher("cli-perfil.jsp").forward(request, response);
                break;
            case "actualizarClave":
                String claveantigua = request.getParameter("claveantigua");
                String clavenueva = request.getParameter("clavenueva");
                String rclavenueva = request.getParameter("rclavenueva");
                String clave = request.getParameter("clave");
                int id = Integer.parseInt(request.getParameter("idcliente"));
                if (claveantigua.equalsIgnoreCase("") && clavenueva.equalsIgnoreCase("") && rclavenueva.equalsIgnoreCase("")) {
                    bcli.setTelefonocli(request.getParameter("telefono"));
                    bcli.setCorreocli(request.getParameter("correo"));
                    bcli.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
                    lcli.actualizar(bcli);
                    request.setAttribute("rpta", "correcto");
                } else {
                    if (clave.equals(claveantigua) && clavenueva.equalsIgnoreCase(rclavenueva)
                            && clavenueva != "" && rclavenueva != "") {
                        bcli.setTelefonocli(request.getParameter("telefono"));
                        bcli.setCorreocli(request.getParameter("correo"));
                        bcli.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
                        lcli.actualizar(bcli);
                        bcli.setClavecli(claveantigua);
                        lcli.actualizarclave(bcli, clavenueva);
                        request.setAttribute("rpta", "correcto");
                    } else {
                        request.setAttribute("rpta", "incorrecto");
                    }
                }
                request.getRequestDispatcher("controladorcliente?accion=perfil&idcliente=" + id).forward(request, response);
                break;
            case "agregar":
                agregar(request, response);
                /*
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
                    res = lcli.agregarC(bcli);
                    out.print(res);
                } catch (Exception e) {
                    out.print(e);
                }
                request.getRequestDispatcher("controladorcliente?accion=listar").forward(request, response);*/
                break;
            case "actualizar":
                modificar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                /*
                PrintWriter out2 = response.getWriter();
                int idcli = Integer.parseInt(request.getParameter("idcli"));
                try {
                    String res = lcli.eliminarC(idcli);
                    out2.print(res);
                } catch (Exception e) {
                    out2.print(e);
                }*/
                break;
            case "listar":
                listar(request, response);
                break;
            default:
                throw new AssertionError();

        }
    }

    public void agregar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        try {
            String res;
            bcli.setDnicli(request.getParameter("dni"));
            bcli.setNombrecli(request.getParameter("nombre"));
            bcli.setApellidocli(request.getParameter("apellido"));
            bcli.setTelefonocli(request.getParameter("telefono"));
            bcli.setSexocli(request.getParameter("genero"));
            bcli.setCorreocli(request.getParameter("correo"));
            bcli.setClavecli(request.getParameter("contra"));
            bcli.setIngresocli(request.getParameter("fecha"));

            res = lcli.agregarC(bcli);
            out.print(res);
        } catch (Exception e) {
            out.print(e);
        }
        request.getRequestDispatcher("controladorcliente?accion=listar").forward(request, response);
    }

    public void listar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<beancliente> lista = lcli.listarC();
        request.setAttribute("listaCliente", lista);
        request.getRequestDispatcher("CrudCliente.jsp").forward(request, response);
    }

    public void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        String res;
        try {
            beancliente cliente = new beancliente();
            cliente.setIdcliente(Integer.parseInt(request.getParameter("id")));
            cliente.setNombrecli(request.getParameter("nombre"));
            cliente.setApellidocli(request.getParameter("apellido"));
            cliente.setTelefonocli(request.getParameter("telefono"));
            cliente.setCorreocli(request.getParameter("correo"));
            cliente.setIngresocli(request.getParameter("fecha"));
            cliente.setDnicli(request.getParameter("dni"));
            cliente.setSexocli(request.getParameter("genero"));
            res = lcli.actualizar(cliente);
            out.print(res);
        } catch (NumberFormatException e) {
            out.print(e);
        }
        request.getRequestDispatcher("controladorcliente?accion=listar").forward(request, response);
    }

    public void eliminar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("idCliente"));
        lcli.eliminarC(id);
        request.getRequestDispatcher("controladorcliente?accion=listar").forward(request, response);
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
