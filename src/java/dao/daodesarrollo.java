/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.*;
import config.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cleiv
 */
public class daodesarrollo {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String respuesta;

    public String agregarDesarrolloNuevo(int idproyecto) {
        String sql = "insert into desarrollo(idproyecto,eliminadoLogico,tipo) values(" + idproyecto + ",'activo','nuevo')";
        try {
            pst = cn.getConnection().prepareStatement(sql);
            pst.executeUpdate();
            respuesta = "Se agrego correctamente...";
        } catch (SQLException e) {
            respuesta = "Error " + e.getMessage();
        }
        return respuesta;
    }

    public String agregarDesarrolloPerfectivo(int idproyecto) {
        String sql = "insert into desarrollo(idproyecto,eliminadoLogico,tipo) values(" + idproyecto + ",'activo','perfectivo')";
        try {
            pst = cn.getConnection().prepareStatement(sql);
            pst.executeUpdate();
            respuesta = "Se agrego correctamente...";
        } catch (SQLException e) {
            respuesta = "Error " + e.getMessage();
        }
        return respuesta;
    }

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

    
}
