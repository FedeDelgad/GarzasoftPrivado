
package dao;

import bean.*;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public String actualizarDesdeAdmin(beanrequerimiento reque){
        String sql = "update requerimientonuevo set nombre=? where idrequerimiento=?";
        try {
            pst = cn.getConnection().prepareStatement(sql);
            pst.setString(1, reque.getNombre());
            pst.setInt(2, reque.getIdrequerimiento());
            pst.executeUpdate();
            respuesta = "Se modifico correctamente...";
        } catch (SQLException e) {
            respuesta = "error";
        }
        return respuesta;
    }
    
    public String eliminar(int id){
        String sql = "delete from requerimientonuevo where idrequerimiento="+id;
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
