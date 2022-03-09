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
    
     
     
     
     
}
