package logic;

import dao.*;
import java.util.List;

public class logicdesarrollo {

    public String agregarNuevo(int idproyecto) {
        daodesarrollo daode = new daodesarrollo();
        return daode.agregarDesarrolloNuevo(idproyecto);
    }

    public String agregarPerfectivo(int idproyecto) {
        daodesarrollo daode = new daodesarrollo();
        return daode.agregarDesarrolloPerfectivo(idproyecto);
    }

    public List listarID(int iddesarrollo) {
        daodesarrollo daode = new daodesarrollo();
        return daode.listarDesarrolloPorID(iddesarrollo);
    }

    public List listaDesarrollo() {
        daodesarrollo daode = new daodesarrollo();
        return daode.listaDesarrollo();
    }
}
