/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import bean.beanrequerimiento;
import dao.daorequerimiento;
import java.util.List;

/**
 *
 * @author cleiv
 */
public class logicrequerimiento {
    
    public String agregar(beanrequerimiento req){
        beanrequerimiento reque = new beanrequerimiento();
        daorequerimiento daore = new daorequerimiento();
        reque.setIddesarrollo(req.getIddesarrollo());
        reque.setNombre(req.getNombre());
        return daore.agregar(reque);
    }
    
    public List listar(int iddesarrollo){
        daorequerimiento daore = new daorequerimiento();
        return daore.listar(iddesarrollo);
    }
}
