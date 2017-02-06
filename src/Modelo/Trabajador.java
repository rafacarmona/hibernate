/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rafa
 */
/*
catalog = bbdd name
*/

@Entity
@Table(name= "trabajador", catalog= "hibernatesillero")
public class Trabajador implements Serializable{
    /**
     * Definimos los atributos de la clase.
     * nombre es el nombre del trabajador (nombre + Apellidos)
     * DNI es el dni del usuario. (en este ejemplo no es necesario )
     * ocupacion es la ocupacion que ocupa el trabajador. 
     */
    
   @Id
   @Column(name="DNI_trab")
   private String DNI;
   
   @Column(name = "nombre", unique = false, nullable = false)
   private String nombre;
     
   @Column(name = "ocupacion", unique = false, nullable = true)
   private String ocupacion;
   
   //@Column(name = "clientes", nullable = true)

   @OneToMany (fetch = FetchType.LAZY, mappedBy = "trabajador", cascade = CascadeType.ALL)
   public List<Clientes> listaDeClientes;

    public Trabajador(String nombre, String DNI, String ocupacion) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.ocupacion = ocupacion;
    }

    public Trabajador(String nombre, String DNI, String ocupacion,  List<Clientes> listaDeClientes) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.ocupacion = ocupacion;
        this.listaDeClientes = listaDeClientes;
    }

    public Trabajador() {
        
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

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
    public  List<Clientes> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setListaDeClientes(List<Clientes> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }
   
}
