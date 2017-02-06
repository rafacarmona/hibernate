/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaMenuPrincipal;


/**
 *
 * @author Rafa
 */
public class CtrlMenuPrincipal {
    VistaMenuPrincipal vista;
    /**
     * metodo que abre la pestaña de insertar Clientes y trabajadores.
     */
    public void abrirInsertarClientesYTrabajadores() {
        new CtrlInsertarClienteYTrabajador(vista);
    }
    
    public void abrirVerClientesYTrabajadores(){
        new CtrlVerClientesYTrabajadores();
    }
    
}
