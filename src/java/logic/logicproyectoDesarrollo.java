
package logic;

import bean.*;
import dao.*;
import java.util.List;

public class logicproyectoDesarrollo {
    
    public String agregarNuevo(beanproyectoDesarrollo nuevo){
        beanproyectoDesarrollo proyecto = new beanproyectoDesarrollo();
        daoproyectoDesarrollo  daonuevo = new daoproyectoDesarrollo();
        proyecto.setIdCliente(nuevo.getIdCliente());
        proyecto.setIdTrabajador(nuevo.getIdTrabajador());
        proyecto.setNombre(nuevo.getNombre());
        proyecto.setInicio(nuevo.getInicio());
        proyecto.setFin(nuevo.getFin());
        return daonuevo.agregar(nuevo);
    }
    
    public List listar(){
        daoproyectoDesarrollo daonuevo = new daoproyectoDesarrollo();
        return daonuevo.listar();
    }
}
