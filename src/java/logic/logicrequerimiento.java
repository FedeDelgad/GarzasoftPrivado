
package logic;

import bean.beanrequerimiento;
import dao.daorequerimiento;
import java.util.List;

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
    
    public String actualizar(beanrequerimiento req){
        beanrequerimiento reque = new beanrequerimiento();
        daorequerimiento dao = new daorequerimiento();
        reque.setNombre(req.getNombre());
        reque.setIdrequerimiento(req.getIdrequerimiento());
        return dao.actualizarDesdeAdmin(reque);
    }
    
    public String eliminar(int id){
        daorequerimiento daore = new daorequerimiento();
        return daore.eliminar(id);
    }
}
