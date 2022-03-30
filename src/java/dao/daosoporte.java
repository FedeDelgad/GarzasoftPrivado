
package dao;
import bean.*;
import config.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class daosoporte {
    
    conexion cn = new conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String respuesta;
    
    public String agregarSoporte(int idproyecto, String actividad){
        String sql = "insert into soporte(idproyecto,actividad,tipo) values("+idproyecto+",'"+actividad+"','soporte')";
        try{
            pst = cn.getConnection().prepareStatement(sql);
            pst.executeUpdate();
            respuesta = "Se agrego correctamente...";
        }catch(SQLException e){
            respuesta = "Error " + e.getMessage();
        }
        return respuesta;
    }
    
    public List lista(){
        String sql = "select*from listasoporte where eliminadoLogico='activo'";
        List<beansoporte> lista = new ArrayList<>();
        try{
            pst = cn.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                beansoporte soporte = new beansoporte();
                soporte.setIdsoporte(rs.getInt("idsoporte"));
                soporte.setIdsoporte(rs.getInt("idproyecto"));
                soporte.setIdcliente(rs.getInt("idcliente"));
                soporte.setIdtrabajdor(rs.getInt("idtrabajador"));
                soporte.setActividad(rs.getString("actividad"));
                soporte.setTipo(rs.getString("tipo"));
                soporte.setNombreproyecto(rs.getString("nombre"));
                soporte.setInicio(rs.getString("inicio"));
                soporte.setFin(rs.getString("fin"));
                soporte.setEstadoproyecto(rs.getString("estado"));
                soporte.setNombrecliente(rs.getString("nombreCliente"));
                soporte.setApellidocliente(rs.getString("apellidoCliente"));
                soporte.setNombretrabajador(rs.getString("nombreTrabajador"));
                soporte.setApellidotrabajador(rs.getString("apellidoTrabajador"));
                lista.add(soporte);
            }
        }catch(SQLException e){
            return null;
        }
        return lista;
    }
}
