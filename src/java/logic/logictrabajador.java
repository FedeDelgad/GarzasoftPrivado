/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import bean.beantrabajador;
import dao.daotrabajador;

/**
 *
 * @author hp
 */
public class logictrabajador {
    public beantrabajador validar(String dni , String contra){
        daotrabajador datrab =new daotrabajador();
        return (datrab.validar(dni, contra));
    }
    
    public beantrabajador trabajador(int idtrabajador){
        daotrabajador datrab =new daotrabajador();
        return (datrab.trabajador(idtrabajador));
    }
    
    public String actualizar(beantrabajador trab){
        beantrabajador btrabajador=new beantrabajador();
        daotrabajador dtrabajador=new daotrabajador();
        btrabajador.setTelefono(trab.getTelefono());
        btrabajador.setCorreo(trab.getCorreo());
        btrabajador.setIdtrabajador(trab.getIdtrabajador());
        return dtrabajador.actualizar(btrabajador);
    }
    public String actualizarclave(beantrabajador trab ,String clavenueva){
         beantrabajador btrabajador=new beantrabajador();
         daotrabajador dtrabajador=new daotrabajador();
         btrabajador.setClave(trab.getClave());
         btrabajador.setIdtrabajador(trab.getIdtrabajador());
         return dtrabajador.actualizarclave(trab, clavenueva);
    }
    
}
