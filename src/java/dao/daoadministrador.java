/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.beanadministrador;
import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public class daoadministrador {
    
        
     conexion cn= new  conexion();
     Connection con;
     PreparedStatement ps;
     ResultSet rs;
     /*validar Administrador */
      public beanadministrador validar(String dni, String clave){
         beanadministrador badm =new beanadministrador();
         String sql="select * from administrador where dni=? and clave=?";
         
         try{
             con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, clave);
            rs=ps.executeQuery();
             while(rs.next()){
              badm.setIdadministrador(rs.getInt("idadministrador"));
              badm.setNombreadmi(rs.getString("nombre"));
              badm.setApellidosadmi(rs.getString("apellido"));
              badm.setClaveadmi(rs.getString("clave"));
              badm.setDniadmi(rs.getString("dni"));
            }      
         }    catch(Exception e){    
        }
         
         return badm;
     }
    
    /*capturar a administrador*/
      
        public beanadministrador trabajador(int idadministrador){
         beanadministrador badm =new beanadministrador();
         String sql="select *from administrador where idadministrador="+idadministrador;
         try{
           con=cn.getConnection();
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
             while(rs.next()){
              badm.setIdadministrador(rs.getInt("idadministrador"));
              badm.setNombreadmi(rs.getString("nombre"));
               badm.setApellidosadmi(rs.getString("apellido"));
               badm.setDniadmi(rs.getString("dni"));
               badm.setTelefonoadmi(rs.getString("telefono"));
               badm.setCorreoadmi(rs.getString("correo"));
               badm.setClaveadmi(rs.getString("clave"));
           }
          
           }catch(Exception e){
               
           }
         return badm;
     }
    
}
