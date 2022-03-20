package dao;

import bean.beancliente;
import config.conexion;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class daocliente {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    /*validar cliente */
    public beancliente validar(String dni, String clave) {
        beancliente bcli = new beancliente();
        String sql = "select * from cliente where dni=? and clave=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            while (rs.next()) {
                bcli.setIdcliente(rs.getInt("idcliente"));
                bcli.setNombrecli(rs.getString("nombre"));
                bcli.setApellidocli(rs.getString("apellido"));
                bcli.setClavecli(rs.getString("clave"));
                bcli.setDnicli(rs.getString("dni"));
            }
        } catch (SQLException e) {
            return null;
        }
        return bcli;
    }

    /*capturar un cliente*/
    public beancliente cliente(int idcliente) {
        beancliente bcli = new beancliente();
        String sql = "select *from cliente where idcliente=" + idcliente;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                bcli.setIdcliente(rs.getInt("idcliente"));
                bcli.setNombrecli(rs.getString("nombre"));
                bcli.setApellidocli(rs.getString("apellido"));
                bcli.setDnicli(rs.getString("dni"));
                bcli.setTelefonocli(rs.getString("telefono"));
                bcli.setCorreocli(rs.getString("correo"));
                bcli.setClavecli(rs.getString("clave"));
            }
        } catch (SQLException e) {
            return null;
        }
        return bcli;
    }

    public String actualizar(beancliente cliente) {
        String out;
        String sql = "update cliente set dni=?,nombre=?,apellido=?,telefono=?,genero=?,fechaIngreso=?,correo=? where idcliente=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getDnicli());
            ps.setString(2, cliente.getNombrecli());
            ps.setString(3, cliente.getApellidocli());
            ps.setString(4, cliente.getTelefonocli());
            ps.setString(5, cliente.getSexocli());
            ps.setString(6, cliente.getIngresocli());
            ps.setString(7, cliente.getCorreocli());
            ps.setInt(8, cliente.getIdcliente());
            ps.executeUpdate();
            out = "Correcto...";
        } catch (SQLException e) {
            out = "Error" + e.getMessage();
        }
        return out;
    }

    /*metodo para actualizar clave*/
    public String actualizarclave(beancliente cli, String clavenueva) {
        String out;
        String sql = "Update cliente set clave=? where idcliente=? and clave=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, clavenueva);
            ps.setInt(2, cli.getIdcliente());
            ps.setString(3, cli.getClavecli());
            ps.executeUpdate();
            out = "Correcto...";
        } catch (SQLException e) {
            out = "Error" + e.getMessage();
        }
        return out;
    }

    public List listar() {
        ArrayList<beancliente> listac = new ArrayList<>();
        String sql = "select*from cliente where estado='activo'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                beancliente cliB = new beancliente();
                cliB.setIdcliente(rs.getInt("idcliente"));
                cliB.setDnicli(rs.getString("dni"));
                cliB.setNombrecli(rs.getString("nombre"));
                cliB.setApellidocli(rs.getString("apellido"));
                cliB.setTelefonocli(rs.getString("telefono"));
                cliB.setSexocli(rs.getString("genero"));
                cliB.setIngresocli(rs.getString("fechaIngreso"));
                cliB.setCorreocli(rs.getString("correo"));
                cliB.setClavecli(rs.getString("clave"));
                cliB.setCondicioncli(rs.getString("condicion"));
                listac.add(cliB);
            }
        } catch (SQLException e) {
            out.print("ERROR" + e);
        }
        return listac;
    }

    public String agregar(beancliente cliente) {
        String out;
        String sql = "INSERT INTO cliente (dni,nombre,apellido,telefono,genero,fechaIngreso,correo,clave,condicion,estado) values(?,?,?,?,?,?,?,?,?,?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getDnicli());
            ps.setString(2, cliente.getNombrecli());
            ps.setString(3, cliente.getApellidocli());
            ps.setString(4, cliente.getTelefonocli());
            ps.setString(5, cliente.getSexocli());
            ps.setString(6, cliente.getIngresocli());
            ps.setString(7, cliente.getCorreocli());
            ps.setString(8, cliente.getClavecli());
            ps.setString(9, "nuevo");
            ps.setString(10, "activo");
            ps.executeUpdate();
            out = "Agregado correctamente...";
        } catch (SQLException e) {
            out = "Error" + e.getMessage();
        }
        return out;
    }

    public String eliminar(int idcliente) {
        String out;
        String sql = "DELETE from cliente where idcliente=" + idcliente;
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

    public boolean buscar(String dni) {
        String sql = "SELECT * FROM cliente WHERE dni = " + dni;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            return false;
        }
    }
}
