package dao;

import bean.beantrabajador;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public String agregar(beantrabajador trabajador) {
        String respuesta;
        String sql = "insert into trabajador(dni,nombre,apellido,telefono,genero,fechaIngreso,correo,clave,condicion,estado) values(?,?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, trabajador.getDni());
            ps.setString(2, trabajador.getNombre());
            ps.setString(3, trabajador.getApellido());
            ps.setString(4, trabajador.getTelefono());
            ps.setString(5, trabajador.getSexo());
            ps.setString(6, trabajador.getIngreso());
            ps.setString(7, trabajador.getCorreo());
            ps.setString(8, trabajador.getClave());
            ps.setString(9, "nuevo");
            ps.setString(10, "activo");
            ps.executeUpdate();
            respuesta = "Registro Correcto...";
        } catch (SQLException e) {
            return "Error";
        }
        return respuesta;
    }

    public List listar() {
        List<beantrabajador> lista = new ArrayList<>();
        String sql = "select*from trabajador where estado='activo'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                beantrabajador beant = new beantrabajador();
                beant.setIdtrabajador(rs.getInt("idtrabajador"));
                beant.setDni(rs.getString("dni"));
                beant.setNombre(rs.getString("nombre"));
                beant.setApellido(rs.getString("apellido"));
                beant.setTelefono(rs.getString("telefono"));
                beant.setSexo(rs.getString("genero"));
                beant.setCorreo(rs.getString("correo"));
                beant.setIngreso(rs.getString("fechaIngreso"));
                beant.setClave(rs.getString("clave"));
                beant.setCondicion(rs.getString("condicion"));
                lista.add(beant);
            }
        } catch (SQLException e) {
            return null;
        }
        return lista;
    }

    public String actualizar(beantrabajador trabajador) {
        String out;
        String sql = "update trabajador set dni=?,nombre=?,apellido=?,telefono=?,genero=?,fechaIngreso=?,correo=? where idtrabajador=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, trabajador.getDni());
            ps.setString(2, trabajador.getNombre());
            ps.setString(3, trabajador.getApellido());
            ps.setString(4, trabajador.getTelefono());
            ps.setString(5, trabajador.getSexo());
            ps.setString(6, trabajador.getIngreso());
            ps.setString(7, trabajador.getCorreo());
            ps.setInt(8, trabajador.getIdtrabajador());
            ps.executeUpdate();
            out = "Correcto...";
        } catch (SQLException e) {
            out = "Error" + e.getMessage();
        }
        return out;
    }

    public String eliminar(int id) {
        String out;
        String sql = "delete from trabajador where idtrabajador=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            out = "Eliminado Correctamente";
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
