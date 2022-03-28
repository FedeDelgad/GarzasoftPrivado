package dao;

import bean.*;
import config.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class daoproyecto {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String respuesta;

    public int buscarPorNombre(String nombre) {
        int idproyecto = 0;
        String sql = "select idproyecto from proyecto where nombre='" + nombre + "';";
        try {
            pst = cn.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                idproyecto = rs.getInt("idproyecto");
            }

        } catch (SQLException e) {
            return idproyecto;
        }
        return idproyecto;
    }

    public String agregar(beanproyecto nuevo) {
        String sql = "insert into proyecto(idcliente,idtrabajador,nombre,inicio,fin,estado,eliminadoLogico) values(?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, nuevo.getIdCliente());
            pst.setInt(2, nuevo.getIdTrabajador());
            pst.setString(3, nuevo.getNombre());
            pst.setString(4, nuevo.getInicio());
            pst.setString(5, nuevo.getFin());
            pst.setString(6, "pendiente");
            pst.setString(7, "activo");
            pst.executeUpdate();
            respuesta = "true";
        } catch (SQLException e) {
            respuesta = "Error " + e.getMessage();
        }
        return respuesta;
    }

    /*
    public String agregarProDesarrollo(int idproyecto) {
        String sql = "insert into desarrollo(idproyecto,eliminadoLogico) values(" + idproyecto + ",'activo')";
        try {
            pst = cn.getConnection().prepareStatement(sql);
            pst.executeUpdate();
            respuesta = "Se agrego correctamente...";
        } catch (SQLException e) {
            respuesta = "Error " + e.getMessage();
        }
        return respuesta;
    }*/

    public List listar() {
        String sql = "select proyecto.idproyecto,cliente.idcliente,trabajador.idtrabajador,proyecto.nombre,cliente.nombre,cliente.apellido,trabajador.nombre,trabajador.apellido,proyecto.inicio,proyecto.fin,proyecto.estado\n"
                + "from proyecto inner join cliente on proyecto.idcliente=cliente.idcliente inner join trabajador on proyecto.idtrabajador=trabajador.idtrabajador where elimnadoLogico='activo';";
        List<beanproyecto> lista = new ArrayList<>();
        try {
            pst = cn.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                beanproyecto pronuevo = new beanproyecto();
                pronuevo.setIdProyecto(rs.getInt("proyecto.idproyecto"));
                pronuevo.setIdCliente(rs.getInt("cliente.idcliente"));
                pronuevo.setIdTrabajador(rs.getInt("trabajador.idtrabajador"));
                pronuevo.setNombreCliente(rs.getString("cliente.nombre"));
                pronuevo.setNombreTrabajador(rs.getString("trabajador.nombre"));
                pronuevo.setNombre(rs.getString("proyecto.nombre"));
                pronuevo.setInicio(rs.getString("proyecto.inicio"));
                pronuevo.setFin(rs.getString("proyecto.fin"));
                pronuevo.setEstado(rs.getString("proyecto.estado"));
                lista.add(pronuevo);
            }
        } catch (SQLException e) {
            return null;
        }
        return lista;
    }

    /*
    public List listaDesarrollo() {
        String sql = "select desarrollo.iddesarrollo,proyecto.idproyecto,proyecto.idcliente,proyecto.idtrabajador,proyecto.nombre,proyecto.inicio,\n"
                + "proyecto.fin,cliente.nombre,cliente.apellido,trabajador.nombre,trabajador.apellido,proyecto.estado from desarrollo inner join\n"
                + "proyecto on desarrollo.idproyecto=proyecto.idproyecto inner join cliente on proyecto.idcliente=cliente.idcliente\n"
                + "inner join trabajador on proyecto.idtrabajador=trabajador.idtrabajador where desarrollo.eliminadoLogico='activo';";
        List<beandesarrollo> listade = new ArrayList<>();
        try {
            pst = cn.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                beandesarrollo desarrollo = new beandesarrollo();
                desarrollo.setIddesarrollo(rs.getInt("desarrollo.iddesarrollo"));
                desarrollo.setNombreproyecto(rs.getString("proyecto.nombre"));
                desarrollo.setInicio(rs.getString("proyecto.inicio"));
                desarrollo.setFin(rs.getString("proyecto.fin"));
                desarrollo.setNombrecliente(rs.getString("cliente.nombre"));
                desarrollo.setApellidocliente(rs.getString("cliente.apellido"));
                desarrollo.setNombretrabajador(rs.getString("trabajador.nombre"));
                desarrollo.setApellidotrabajador(rs.getString("trabajador.apellido"));
                desarrollo.setEstadoproyecto(rs.getString("proyecto.estado"));
                listade.add(desarrollo);
            }
        } catch (SQLException e) {
            return null;
        }
        return listade;
    }

    public List listarDesarrolloPorID(int iddesarrollo) {
        String sql = "select desarrollo.iddesarrollo,proyecto.idproyecto,proyecto.idcliente,proyecto.idtrabajador,proyecto.nombre,proyecto.inicio,\n"
                + "proyecto.fin,cliente.nombre,cliente.apellido,trabajador.nombre,trabajador.apellido,proyecto.estado from desarrollo inner join\n"
                + "proyecto on desarrollo.idproyecto=proyecto.idproyecto inner join cliente on proyecto.idcliente=cliente.idcliente\n"
                + "inner join trabajador on proyecto.idtrabajador=trabajador.idtrabajador where desarrollo.iddesarrollo=" + iddesarrollo;
        List<beandesarrollo> lista = new ArrayList<>();
        try {
            pst = cn.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                beandesarrollo desarrollo = new beandesarrollo();
                desarrollo.setIddesarrollo(rs.getInt("desarrollo.iddesarrollo"));
                desarrollo.setNombreproyecto(rs.getString("proyecto.nombre"));
                desarrollo.setInicio(rs.getString("proyecto.inicio"));
                desarrollo.setFin(rs.getString("proyecto.fin"));
                desarrollo.setNombrecliente(rs.getString("cliente.nombre"));
                desarrollo.setApellidocliente(rs.getString("cliente.apellido"));
                desarrollo.setNombretrabajador(rs.getString("trabajador.nombre"));
                desarrollo.setApellidotrabajador(rs.getString("trabajador.apellido"));
                desarrollo.setEstadoproyecto(rs.getString("proyecto.estado"));
                lista.add(desarrollo);
            }
        } catch (SQLException e) {
            return null;
        }
        return lista;
    }
    */

    public List listarCliente(int id) {
        List<beanproyecto> listaprocli = new ArrayList<>();
        String sql = "select * from proyecto where idcliente=" + id;
        try {
            pst = cn.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                beanproyecto proyecto = new beanproyecto();
                proyecto.setIdProyecto(rs.getInt("idproyecto"));
                proyecto.setIdCliente(rs.getInt("idcliente"));
                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setInicio(rs.getString("inicio"));
                proyecto.setFin(rs.getString("fin"));
                proyecto.setEstado(rs.getString("estado"));
                listaprocli.add(proyecto);
            }
        } catch (SQLException e) {
            return null;
        }
        return listaprocli;
    }

    public String actualizar(beanproyecto proyecto) {
        String sql = "update proyecto set idtrabajador=?,nombre=?,inicio=?,fin=?,estado=? where idproyecto=?";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, proyecto.getIdTrabajador());
            pst.setString(2, proyecto.getNombre());
            pst.setString(3, proyecto.getInicio());
            pst.setString(4, proyecto.getFin());
            pst.setString(5, proyecto.getEstado());
            pst.setInt(6, proyecto.getIdProyecto());
            pst.executeUpdate();
            respuesta = "true";
        } catch (SQLException e) {
            respuesta = "Error " + e.getMessage();
        }
        return respuesta;
    }

    public String eliminar(int idproyecto) {
        String sql = "update proyecto set eliminadoLogico='eliminado' where idproyecto=" + idproyecto;
        try {
            pst = cn.getConnection().prepareStatement(sql);
            pst.executeUpdate();
            respuesta = "Se ha eliminado correctamente";
        } catch (SQLException e) {
            respuesta = "Error" + e.getMessage();
        }
        return respuesta;
    }
   
}
