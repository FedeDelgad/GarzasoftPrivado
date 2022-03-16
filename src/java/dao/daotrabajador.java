package dao;

import bean.beantrabajador;
import config.conexion;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.lang.System.out;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class daotrabajador {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    /*validar trabajador */
    public beantrabajador validar(String dni, String clave) {
        beantrabajador btra = new beantrabajador();
        String sql = "select * from trabajador where dni=? and clave=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            while (rs.next()) {
                btra.setIdtrabajador(rs.getInt("idtrabajador"));
                btra.setNombre(rs.getString("nombre"));
                btra.setApellido(rs.getString("apellido"));
                btra.setClave(rs.getString("clave"));
                btra.setDni(rs.getString("dni"));
            }
        } catch (SQLException e) {
            return null;
        }
        return btra;
    }

    /*capturar un trabajador*/
    public beantrabajador trabajador(int idtrabajador) {
        beantrabajador btra = new beantrabajador();
        String sql = "select *from trabajador where idtrabajador=" + idtrabajador;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                btra.setIdtrabajador(rs.getInt("idtrabajador"));
                btra.setNombre(rs.getString("nombre"));
                btra.setApellido(rs.getString("apellido"));
                btra.setDni(rs.getString("dni"));
                btra.setTelefono(rs.getString("telefono"));
                btra.setCorreo(rs.getString("correo"));
                btra.setClave(rs.getString("clave"));
            }
        } catch (SQLException e) {
            return null;
        }
        return btra;
    }

    /*metodo actualizar trabajador */
    public String actualizar(beantrabajador trab) {
        String out;
        String sql = "update trabajador set telefono=? , correo=? where idtrabajador=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, trab.getTelefono());
            ps.setString(2, trab.getCorreo());
            ps.setInt(3, trab.getIdtrabajador());
            ps.executeUpdate();
            out = "Correcto...";
        } catch (SQLException e) {
            out = "Error" + e.getMessage();
        }
        return out;
    }

    /* metodo para actualizar clave*/
    public String actualizarclave(beantrabajador trab, String clavenueva) {
        String out;
        String sql = "Update trabajador set clave=? where idtrabajador=? and clave=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, clavenueva);
            ps.setInt(2, trab.getIdtrabajador());
            ps.setString(3, trab.getClave());
            ps.executeUpdate();
            out = "Correcto...";
        } catch (SQLException e) {
            out = "Error" + e.getMessage();
        }
        return out;
    }

}
