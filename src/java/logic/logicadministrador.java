/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import bean.beanadministrador;
import dao.daoadministrador;

/**
 *
 * @author hp
 */
public class logicadministrador {
   
     public beanadministrador validar(String dni , String contra){
        daoadministrador daadm =new daoadministrador();
        return (daadm.validar(dni, contra));
    }
    
   public beanadministrador administrador(int idadmnistrador){
      daoadministrador daadm =new daoadministrador();
      return daadm.trabajador(idadmnistrador);
   } 
    
    
    
}
