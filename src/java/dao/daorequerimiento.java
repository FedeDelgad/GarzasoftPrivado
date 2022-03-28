/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.*;
import config.conexion;
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
public class daorequerimiento {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String respuesta;

    public String agregar(beanrequerimiento reque) {
        String sql = "insert into requerimientonuevo(iddesarrollo,nombre,situacion) values(?,?,?)";
        try {
            pst = cn.getConnection().prepareStatement(sql);
            pst.setInt(1, reque.getIddesarrollo());
            pst.setString(2, reque.getNombre());
            pst.setString(3, "pendiente");
            pst.executeUpdate();
            respuesta = "Se agregro correctamente...";
        } catch (SQLException e) {
            respuesta = "error";
        }
        return respuesta;
    }

    public List listar(int iddesarrollo) {
        List<beanrequerimiento> lista = new ArrayList<>();
        String sql = "select*from requerimientonuevo where iddesarrollo="+iddesarrollo;
        try {
            pst = cn.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                beanrequerimiento re = new beanrequerimiento();
                re.setIdrequerimiento(rs.getInt("idrequerimiento"));
                re.setIddesarrollo(rs.getInt("iddesarrollo"));
                re.setNombre(rs.getString("nombre"));
                re.setEstado(rs.getString("situacion"));
                lista.add(re);
            }
        } catch (SQLException e) {
            return null;
        }

        return lista;
    }
}
