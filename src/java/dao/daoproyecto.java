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
            pst.setString(6, "PENDIENTE");
            pst.setString(7, "activo");
            pst.executeUpdate();
            respuesta = "true";
        } catch (SQLException e) {
            respuesta = "Error " + e.getMessage();
        }
        return respuesta;
    }

    public List listar() {
        String sql = "select proyecto.idproyecto,cliente.idcliente,trabajador.idtrabajador,proyecto.nombre,cliente.nombre,cliente.apellido,trabajador.nombre,trabajador.apellido,proyecto.inicio,proyecto.fin,proyecto.estado\n"
                + "from proyecto inner join cliente on proyecto.idcliente=cliente.idcliente inner join trabajador on proyecto.idtrabajador=trabajador.idtrabajador where eliminadoLogico='activo';";
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
    
    public List listarID(int id){
        String sql ="select*from proyectodesarrolloporid where idproyecto="+id;
        List<beanproyecto> listaid = new ArrayList<>();
        try {
            pst = cn.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                beanproyecto pronuevo = new beanproyecto();
                pronuevo.setIdProyecto(rs.getInt("idproyecto"));
                pronuevo.setNombre(rs.getString("nombre"));
                pronuevo.setInicio(rs.getString("inicio"));
                pronuevo.setFin(rs.getString("fin"));
                pronuevo.setEstado(rs.getString("estado"));
                pronuevo.setIdTrabajador(rs.getInt("idtrabajador"));
                pronuevo.setNombreTrabajador(rs.getString("nombretrabajador"));
                pronuevo.setApellidoTrabajador(rs.getString("apellidotrabajador"));
                pronuevo.setIdDesarrollo(rs.getInt("iddesarrollo"));
                pronuevo.setTipo(rs.getString("tipo"));
                listaid.add(pronuevo);
            }
        } catch (SQLException e) {
            return null;
        }
        return listaid;
    }

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
    
    public List listarPorTrabajador(String dni){
        List<beanproyecto> listatra = new ArrayList<>();
        String sql="select*from listaportrabajador where estado='pendiente' and dni='"+dni+"'";
        try {
            pst = cn.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                beanproyecto proyecto2 = new beanproyecto();
                proyecto2.setIdTrabajador(rs.getInt("idtrabajador"));
                proyecto2.setIdProyecto(rs.getInt("idproyecto"));
                proyecto2.setIdDesarrollo(rs.getInt("iddesarrollo"));
                proyecto2.setIdCliente(rs.getInt("idcliente"));
                proyecto2.setNombreCliente(rs.getString("nombreCliente"));
                proyecto2.setApellidoCliente(rs.getString("apellido"));
                proyecto2.setNombre(rs.getString("nombre"));
                proyecto2.setInicio(rs.getString("inicio"));
                proyecto2.setFin(rs.getString("fin"));
                proyecto2.setEstado(rs.getString("estado"));
                proyecto2.setTipo(rs.getString("tipo"));
                listatra.add(proyecto2);
            }
        } catch (SQLException e) {
            return null;
        }
        return listatra;
    }
    
    public List listarPorCliente(String dni){
        List<beanproyecto> listatra = new ArrayList<>();
        String sql="select*from listaporcliente where dni='"+dni+"'";
        try {
            pst = cn.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                beanproyecto proyecto2 = new beanproyecto();
                proyecto2.setIdTrabajador(rs.getInt("idtrabajador"));
                proyecto2.setIdProyecto(rs.getInt("idproyecto"));
                proyecto2.setIdDesarrollo(rs.getInt("iddesarrollo"));
                proyecto2.setIdCliente(rs.getInt("idcliente"));
                proyecto2.setNombreTrabajador(rs.getString("nombreTrabajador"));
                proyecto2.setApellidoTrabajador(rs.getString("apellido"));
                
                proyecto2.setNombre(rs.getString("nombre"));
                proyecto2.setInicio(rs.getString("inicio"));
                proyecto2.setFin(rs.getString("fin"));
                proyecto2.setEstado(rs.getString("estado"));
                proyecto2.setTipo(rs.getString("tipo"));
                listatra.add(proyecto2);
            }
        } catch (SQLException e) {
            return null;
        }
        return listatra;
    }
    
    public List listarPorTrabajadorSoporte(String dni){
        List<beanproyecto> listatrasoporte = new ArrayList<>();
        String sql="select*from listaportrabajadorsoporte where eliminadoLogico='activo' and dni='"+dni+"'";
        try {
            pst = cn.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                beanproyecto proyecto2 = new beanproyecto();
                proyecto2.setIdProyecto(rs.getInt("idproyecto"));
                proyecto2.setIdSoporte(rs.getInt("idsoporte"));
                proyecto2.setIdCliente(rs.getInt("idcliente"));
                proyecto2.setNombre(rs.getString("nombre"));
                proyecto2.setInicio(rs.getString("inicio"));
                proyecto2.setFin(rs.getString("fin"));
                proyecto2.setEstado(rs.getString("estado"));
                proyecto2.setTipo(rs.getString("tipo"));
                listatrasoporte.add(proyecto2);
            }
        } catch (SQLException e) {
            return null;
        }
        return listatrasoporte;
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
    
    public String cambiarEstado(String estado, int idpro){
        String sql = "update proyecto set estado='"+estado+"' where idproyecto="+idpro;
        try {
            pst = cn.getConnection().prepareStatement(sql);
            pst.executeUpdate();
            respuesta = "true";
        } catch (SQLException e) {
            respuesta = "error";
        }
        return respuesta; 
    }

}
