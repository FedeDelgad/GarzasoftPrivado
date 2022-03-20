package dao;

import bean.beanadministrador;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class daoadministrador {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public beanadministrador validar(String dni, String clave) {
        beanadministrador badm = new beanadministrador();
        String sql = "select * from administrador where dni=? and clave=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            while (rs.next()) {
                badm.setIdadministrador(rs.getInt("idadministrador"));
                badm.setNombreadmi(rs.getString("nombre"));
                badm.setApellidosadmi(rs.getString("apellido"));
                badm.setClaveadmi(rs.getString("clave"));
                badm.setDniadmi(rs.getString("dni"));
            }
        } catch (SQLException e) {
            return null;
        }
        return badm;
    }

    public beanadministrador administrador(int idadministrador) {
        beanadministrador badm = new beanadministrador();
        String sql = "select *from administrador where idadministrador=" + idadministrador;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                badm.setIdadministrador(rs.getInt("idadministrador"));
                badm.setNombreadmi(rs.getString("nombre"));
                badm.setApellidosadmi(rs.getString("apellido"));
                badm.setDniadmi(rs.getString("dni"));
                badm.setTelefonoadmi(rs.getString("telefono"));
                badm.setCorreoadmi(rs.getString("correo"));
                badm.setClaveadmi(rs.getString("clave"));
            }

        } catch (SQLException e) {
            return null;
        }
        return badm;
    }

    public String actualizarclave(beanadministrador admi, String clavenueva) {
        String out;
        String sql = "Update administrador set clave=? where idadministrador=? and clave=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, clavenueva);
            ps.setInt(2, admi.getIdadministrador());
            ps.setString(3, admi.getClaveadmi());
            ps.executeUpdate();
            out = "Correcto...";
        } catch (SQLException e) {
            out = "Error" + e.getMessage();
        }

        return out;
    }
    
    /*metodo de actualizar administrador*/
    public String actualizar(beanadministrador adm) {
        String out;
        String sql = "update administrador set telefono=? , correo=? where idadministrador=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, adm.getTelefonoadmi());
            ps.setString(2, adm.getCorreoadmi());
            ps.setInt(3, adm.getIdadministrador());
            ps.executeUpdate();
            out = "Correcto...";
        } catch (SQLException e) {
            out = "Error" + e.getMessage();
        }
        return out;
    }

}
