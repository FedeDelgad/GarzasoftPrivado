/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.beancliente;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public class daocliente {
    conexion cn= new  conexion();
     Connection con;
     PreparedStatement ps;
     ResultSet rs;
     
    /*validar cliente */
     public beancliente validar(String dni, String clave){
         beancliente bcli =new beancliente();
         String sql="select * from cliente where dni=? and clave=?";
         
         try{
             con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, clave);
            rs=ps.executeQuery();
             while(rs.next()){
              bcli.setIdcliente(rs.getInt("idcliente"));
              bcli.setNombrecli(rs.getString("nombre"));
              bcli.setApellidocli(rs.getString("apellido"));
              bcli.setClavecli(rs.getString("clave"));
              bcli.setDnicli(rs.getString("dni"));
            }  
             
         }    catch(Exception e){
            
        }
         
         return bcli;
     }
    
    /*capturar un cliente*/ 
       public beancliente cliente(int idcliente){
         beancliente bcli =new beancliente();
         String sql="select *from cliente where idcliente="+idcliente;
         try{
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
             while(rs.next()){
               bcli.setIdcliente(rs.getInt("idcliente"));
               bcli.setNombrecli(rs.getString("nombre"));
               bcli.setApellidocli(rs.getString("apellido"));
               bcli.setDnicli(rs.getString("dni"));
               bcli.setTelefonocli(rs.getString("telefono"));
               bcli.setCorreocli(rs.getString("correo"));
               bcli.setClavecli(rs.getString("clave"));
           }
          
           }catch(Exception e){
               
           }
         return bcli;
     }
       
      /*metodo actualizar cliente*/ 
       
       public String actualizar ( beancliente cli){
         String out;
         String sql="update cliente set telefono=? , correo=? where idcliente=?";
          try{
              con=cn.getConnection();
              ps=con.prepareStatement(sql);
              ps.setString(1,cli.getTelefonocli());
              ps.setString(2,cli.getCorreocli());
              ps.setInt(3, cli.getIdcliente());
              ps.executeUpdate();
             out = "Correcto...";
                }catch(Exception e)
             {
                 out = "Error" + e.getMessage();
             }

              return out;
     }
       
     /*metodo para actualizar clave*/  
       
     public String actualizarclave(beancliente cli, String clavenueva){
                String out;
         String sql="Update cliente set clave=? where idcliente=? and clave=?";
          try{
              con=cn.getConnection();
              ps=con.prepareStatement(sql);
              ps.setString(1, clavenueva);
              ps.setInt(2, cli.getIdcliente());
              ps.setString(3, cli.getClavecli());
              ps.executeUpdate();
             out = "Correcto...";
                }catch(Exception e)
             {
                 out = "Error" + e.getMessage();
             }

              return out;  
     }
     
}
