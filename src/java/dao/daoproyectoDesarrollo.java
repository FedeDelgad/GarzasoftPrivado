package dao;

import bean.*;
import config.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class daoproyectoDesarrollo {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String respuesta;

    public String agregar(beanproyectoDesarrollo nuevo) {
        String sql = "insert into proyecto(idcliente,idtrabajador,nombre,inicio,fin,estado,tipo) values(?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, nuevo.getIdCliente());
            pst.setInt(2, nuevo.getIdTrabajador());
            pst.setString(3, nuevo.getNombre());
            pst.setString(4, nuevo.getInicio());
            pst.setString(5, nuevo.getFin());
            pst.setString(6, "pendiente");
            pst.setString(7, "desarrollo");
            pst.executeUpdate();
            respuesta = "Se agrego correctamente...";
        } catch (SQLException e) {
            respuesta = "Error " + e.getMessage();
        }
        return respuesta;
    }

    public List listar() {
        String sql = "select proyecto.idproyecto,cliente.idcliente,trabajador.idtrabajador,proyecto.nombre,cliente.nombre,cliente.apellido,trabajador.nombre,trabajador.apellido,proyecto.inicio,proyecto.fin,proyecto.estado\n"
                + "from proyecto inner join cliente on proyecto.idcliente=cliente.idcliente inner join trabajador on proyecto.idtrabajador=trabajador.idtrabajador;";
        List<beanproyectoDesarrollo> lista = new ArrayList<>();
        try {
            pst = cn.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                beanproyectoDesarrollo pronuevo = new beanproyectoDesarrollo();
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
}
