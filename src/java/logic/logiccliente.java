package logic;

import bean.beancliente;
import dao.daocliente;

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

}
