/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author cleiv
 */
public class beanrequerimiento {
    
    private int idrequerimiento;
    private int idfuncionalidad;
    private int iddesarrollo;
    private String nombre;
    private String estado;
    private int contador;

    public int getIdrequerimiento() {
        return idrequerimiento;
    }

    public void setIdrequerimiento(int idrequerimiento) {
        this.idrequerimiento = idrequerimiento;
    }

    public int getIdfuncionalidad() {
        return idfuncionalidad;
    }

    public void setIdfuncionalidad(int idfuncionalidad) {
        this.idfuncionalidad = idfuncionalidad;
    }

    public int getIddesarrollo() {
        return iddesarrollo;
    }

    public void setIddesarrollo(int iddesarrollo) {
        this.iddesarrollo = iddesarrollo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    
}
