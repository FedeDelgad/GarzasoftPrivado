package logic;

import bean.beancliente;
import dao.daocliente;
import java.util.List;

public class logiccliente {

    public beancliente validar(String dni, String contra) {
        daocliente dacli = new daocliente();
        return (dacli.validar(dni, contra));
    }

    public beancliente cliente(int idcliente) {
        daocliente dacli = new daocliente();
        return (dacli.cliente(idcliente));
    }
    
    public String actualizar(beancliente cli) {
        beancliente bcliente = new beancliente();
        daocliente dcliente = new daocliente();
        bcliente.setTelefonocli(cli.getTelefonocli());
        bcliente.setCorreocli(cli.getCorreocli());
        bcliente.setIdcliente(cli.getIdcliente());
        return dcliente.actualizar(bcliente);
    }

    public String actualizarclave(beancliente cli, String clavenueva) {
        beancliente bcliente = new beancliente();
        daocliente dcliente = new daocliente();
        bcliente.setClavecli(cli.getClavecli());
        bcliente.setIdcliente(cli.getIdcliente());
        return dcliente.actualizarclave(bcliente, clavenueva);
    }

    public String agregarC(beancliente bCli) {
        beancliente bcliente = new beancliente();
        daocliente dcliente = new daocliente();

        if(dcliente.buscar(bCli.getDnicli())){
            return "El cliente ya existe.";
        }else{
            bcliente.setNombrecli(bCli.getNombrecli());        
            bcliente.setApellidocli(bCli.getApellidocli());
            bcliente.setTelefonocli(bCli.getTelefonocli());
            bcliente.setCorreocli(bCli.getCorreocli());
            bcliente.setClavecli(bCli.getClavecli());
            bcliente.setIngresocli(bCli.getIngresocli());
            bcliente.setCondicioncli("nuevo");
            bcliente.setEliminacli("activo");
            bcliente.setDnicli(bCli.getDnicli());
            bcliente.setSexocli(bCli.getSexocli());
            return (dcliente.agregar(bcliente));
        }
    }
        
    public String eliminarC(int idcliente) {
        daocliente dcliente = new daocliente();      
        return dcliente.eliminar(idcliente);
    }
    
    public List listarC() {
        daocliente dcliente = new daocliente();
        return dcliente.listar();
    }
    
}
