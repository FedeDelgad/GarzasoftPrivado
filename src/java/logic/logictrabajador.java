package logic;

import bean.beantrabajador;
import dao.daotrabajador;
import java.util.List;

public class logictrabajador {

    public beantrabajador validar(String usuario, String clave) {
        daotrabajador datrab = new daotrabajador();
        return (datrab.validar(usuario, clave));
    }

    public beantrabajador trabajador(int idtrabajador) {
        daotrabajador datrab = new daotrabajador();
        return (datrab.trabajador(idtrabajador));
    }

    public String agregar(beantrabajador beant) {
        beantrabajador beantra = new beantrabajador();
        daotrabajador daotra = new daotrabajador();

        beantra.setDni(beant.getDni());
        beantra.setNombre(beant.getNombre());
        beantra.setApellido(beant.getApellido());
        beantra.setTelefono(beant.getTelefono());
        beantra.setSexo(beant.getSexo());
        beantra.setIngreso(beant.getIngreso());
        beantra.setCorreo(beant.getCorreo());
        beantra.setClave(beant.getClave());
        return daotra.agregar(beantra);
    }

    public String actualizar(beantrabajador beant) {
        beantrabajador beantra = new beantrabajador();
        daotrabajador daotra = new daotrabajador();

        beantra.setIdtrabajador(beant.getIdtrabajador());
        beantra.setDni(beant.getDni());
        beantra.setNombre(beant.getNombre());
        beantra.setApellido(beant.getApellido());
        beantra.setTelefono(beant.getTelefono());
        beantra.setSexo(beant.getSexo());
        beantra.setIngreso(beant.getIngreso());
        beantra.setCorreo(beant.getCorreo());
        return daotra.actualizar(beantra);
    }

    public String actualizarclave(beantrabajador trab, String clavenueva) {
        beantrabajador btrabajador = new beantrabajador();
        daotrabajador dtrabajador = new daotrabajador();
        btrabajador.setClave(trab.getClave());
        btrabajador.setIdtrabajador(trab.getIdtrabajador());
        return dtrabajador.actualizarclave(btrabajador, clavenueva);
    }

    public List listar() {
        daotrabajador dao = new daotrabajador();
        return dao.listar();
    }
    
    public List listarDisponibles() {
        daotrabajador daod = new daotrabajador();
        return daod.listarDisponibles();
    }

    public String eliminar(int id) {
        daotrabajador daotrabajador = new daotrabajador();
        return daotrabajador.eliminar(id);
    }
    
    public String actualizarDisponibilidad(String dis, int idtrabajador){
        daotrabajador daot = new daotrabajador();
        return daot.actualizarDisponibilidad(dis, idtrabajador);
    }
}
