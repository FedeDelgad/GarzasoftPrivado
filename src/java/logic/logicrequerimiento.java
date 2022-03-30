
package logic;

import bean.beanrequerimiento;
import dao.daorequerimiento;
import java.util.List;

public class logicrequerimiento {
    
    public String agregarRequerimiento(beanrequerimiento req){
        beanrequerimiento reque = new beanrequerimiento();
        daorequerimiento daore = new daorequerimiento();
        reque.setIddesarrollo(req.getIddesarrollo());
        reque.setNombre(req.getNombre());
        return daore.agregarRequerimiento(reque);
    }
    
    public String agregarFuncionalidad(beanrequerimiento req){
        beanrequerimiento reque = new beanrequerimiento();
        daorequerimiento daore = new daorequerimiento();
        reque.setIddesarrollo(req.getIddesarrollo());
        reque.setNombre(req.getNombre());
        return daore.agregarFuncionalidad(reque);
    }
    
    public List listarRequerimiento(int iddesarrollo){
        daorequerimiento daore = new daorequerimiento();
        return daore.listarRequerimiento(iddesarrollo);
    }
    
    public List listarFuncionalidad(int iddesarrollo){
        daorequerimiento daore = new daorequerimiento();
        return daore.listarFuncionalidad(iddesarrollo);
    }
    
    public String actualizarRequerimiento(beanrequerimiento req){
        beanrequerimiento reque = new beanrequerimiento();
        daorequerimiento dao = new daorequerimiento();
        reque.setNombre(req.getNombre());
        reque.setIdrequerimiento(req.getIdrequerimiento());
        return dao.actualizarRequerimientoDesdeAdmin(reque);
    }
    
    public String actualizarFuncionalidad(beanrequerimiento req){
        beanrequerimiento reque = new beanrequerimiento();
        daorequerimiento dao = new daorequerimiento();
        reque.setNombre(req.getNombre());
        reque.setIdfuncionalidad(req.getIdfuncionalidad());
        return dao.actualizarFuncionalidadDesdeAdmin(reque);
    }
    
    public String eliminarRequerimiento(int id){
        daorequerimiento daore = new daorequerimiento();
        return daore.eliminarRequerimiento(id);
    }
    
    public String eliminarFuncionalidad(int id){
        daorequerimiento daore = new daorequerimiento();
        return daore.eliminarFuncionalidad(id);
    }
    
    public String cambiarestado(String estado, int id){
        daorequerimiento daoreq = new daorequerimiento();
        return daoreq.cambiarEstado(estado, id);
    }
}
