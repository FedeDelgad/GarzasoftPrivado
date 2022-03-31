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
    
    public List listarPorTrabajador(String dni){
        daoproyecto pro = new daoproyecto();
        return pro.listarPorTrabajador(dni);
    }
    
    public List listarPorCliente(String dni){
        daoproyecto daopp = new daoproyecto();
        return daopp.listarPorCliente(dni);
    }
    
    public List listarPorTrabajadorSoporte(String dni){
        daoproyecto pross = new daoproyecto();
        return pross.listarPorTrabajadorSoporte(dni);
    }
    
    public String eliminar(int id){
        daoproyecto proyecto = new daoproyecto();
        return proyecto.eliminar(id);
    }

    public String cambiarestado(String estado, int id){
        daoproyecto proye = new daoproyecto();
        return proye.cambiarEstado(estado, id);
    }
}
