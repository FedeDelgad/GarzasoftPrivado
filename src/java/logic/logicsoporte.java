
package logic;

import bean.*;
import dao.*;
import java.util.List;

public class logicsoporte {
    
    public String agregarSoporte(int idproyecto, String actividad){

        daosoporte daoso = new daosoporte();
        return daoso.agregarSoporte(idproyecto,actividad);
    }
    
    public List listarSoporte(){
        daosoporte daoso = new daosoporte();
        return daoso.lista();
    }
}
