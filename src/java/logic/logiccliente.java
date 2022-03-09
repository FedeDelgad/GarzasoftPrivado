/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import bean.beancliente;
import dao.daocliente;

/**
 *
 * @author hp
 */
public class logiccliente {
     public beancliente validar(String dni , String contra){
        daocliente dacli =new daocliente();
        return (dacli.validar(dni, contra));
    }
    
    
    
}
