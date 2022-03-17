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

    public String agregarC(beancliente bCli) {
        beancliente bcliente = new beancliente();
        daocliente dcliente = new daocliente();

        if (dcliente.buscar(bCli.getDnicli())) {
            return "El cliente ya existe.";
        } else {
            bcliente.setDnicli(bCli.getDnicli());
            bcliente.setNombrecli(bCli.getNombrecli());
            bcliente.setApellidocli(bCli.getApellidocli());
            bcliente.setTelefonocli(bCli.getTelefonocli());
            bcliente.setSexocli(bCli.getSexocli());
            bcliente.setCorreocli(bCli.getCorreocli());
            bcliente.setClavecli(bCli.getClavecli());
            bcliente.setIngresocli(bCli.getIngresocli());
            return (dcliente.agregar(bcliente));
        }
    }

    public String actualizar(beancliente cli) {
        beancliente bcliente = new beancliente();
        daocliente dcliente = new daocliente();

        bcliente.setIdcliente(cli.getIdcliente());
        bcliente.setDnicli(cli.getDnicli());
        bcliente.setNombrecli(cli.getNombrecli());
        bcliente.setApellidocli(cli.getApellidocli());
        bcliente.setTelefonocli(cli.getTelefonocli());
        bcliente.setSexocli(cli.getSexocli());
        bcliente.setIngresocli(cli.getIngresocli());
        bcliente.setCorreocli(cli.getCorreocli());

        return dcliente.actualizar(bcliente);
    }

    public String eliminarC(int idcliente) {
        daocliente dcliente = new daocliente();
        return dcliente.eliminar(idcliente);
    }

    public List listarC() {
        daocliente dcliente = new daocliente();
        return dcliente.listar();
    }

    public String actualizarclave(beancliente cli, String clavenueva) {
        beancliente bcliente = new beancliente();
        daocliente dcliente = new daocliente();
        bcliente.setClavecli(cli.getClavecli());
        bcliente.setIdcliente(cli.getIdcliente());
        return dcliente.actualizarclave(bcliente, clavenueva);
    }

}
