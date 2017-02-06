/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Rafa
 */
@Entity
@Table(name = "clientes", catalog = "hibernatesillero")
public class Clientes implements Serializable {

    /**
     * nombre=nombre del cliente DNI es el dni del cliente (no tiene por que
     * calcularse en este ejemplo) NHabitacion es el numero de habitacion que
     * ocupa el cliente NNoches es el numero de noches que ocupa el cliente
     */
    @Column(name = "nombre", unique = false, nullable = false)
    private String nombre;

    @Id
    @Column(name="DNI")
    private String DNI;

    @Column(name = "NHabitacion", unique = false, nullable = true)
    private int NHabitacion;

    @Column(name = "NNoches", unique = false, nullable = true)
    private int NNoches;

    @ManyToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn(name = "DNI_trab", nullable = true)
    private Trabajador trabajador;

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador Trabajador) {
        this.trabajador = Trabajador;
    }

    public Clientes(String nombre, String DNI, int NHabitacion, int NNoches, Trabajador Trabajador) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.NHabitacion = NHabitacion;
        this.NNoches = NNoches;
        this.trabajador = Trabajador;
    }

      public Clientes(String nombre, String DNI, int NHabitacion, int NNoches) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.NHabitacion = NHabitacion;
        this.NNoches = NNoches;
    }

    /**
     * Constructor por defecto.
     */
    public Clientes() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getNHabitacion() {
        return NHabitacion;
    }

    public void setNHabitacion(int NHabitacion) {
        this.NHabitacion = NHabitacion;
    }

    public int getNNoches() {
        return NNoches;
    }

    public void setNNoches(int NNoches) {
        this.NNoches = NNoches;
    }
}
