package logic;

import bean.*;
import dao.*;
import java.util.List;

public class logicproyecto {

    public String agregar(beanproyecto pro) {
        beanproyecto proyecto = new beanproyecto();
        daoproyecto daoproyecto = new daoproyecto();
        proyecto.setIdCliente(pro.getIdCliente());
        proyecto.setIdTrabajador(pro.getIdTrabajador());
        proyecto.setNombre(pro.getNombre());
        proyecto.setInicio(pro.getInicio());
        proyecto.setFin(pro.getFin());
        return daoproyecto.agregar(pro);
    }

    public String actualizar(beanproyecto pro) {
        beanproyecto proyecto = new beanproyecto();
        daoproyecto daoproyecto = new daoproyecto();
        proyecto.setIdTrabajador(pro.getIdTrabajador());
        proyecto.setNombre(pro.getNombre());
        proyecto.setInicio(pro.getInicio());
        proyecto.setFin(pro.getFin());
        proyecto.setEstado(pro.getEstado());
        proyecto.setIdProyecto(pro.getIdProyecto());
        return daoproyecto.actualizar(proyecto);
    }

    public int bucarPorNombre(String nombre) {
        daoproyecto daopro = new daoproyecto();
        return daopro.buscarPorNombre(nombre);
    }

    public List listar() {
        daoproyecto daonuevo = new daoproyecto();
        return daonuevo.listar();
    }

    public List listarPorCliente(int id) {
        daoproyecto proyecto = new daoproyecto();
        return proyecto.listarCliente(id);
    }
    
    public String eliminar(int id){
        daoproyecto proyecto = new daoproyecto();
        return proyecto.eliminar(id);
    }

}
