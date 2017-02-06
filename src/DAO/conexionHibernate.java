/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Clientes;
import Modelo.Trabajador;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Rafa
 */
public class conexionHibernate {

    /**
     * SINGLETON.
     */
    private static conexionHibernate conexionHiber = null;

    /**
     * Singleton.
     *
     * @return
     */
    public static conexionHibernate conexionHibernate() {

        if (conexionHiber != null) {
            return conexionHiber;
        } else {
            conexionHiber = new conexionHibernate();
            return conexionHiber;
        }
    }
    private Session ss = NewHibernateUtil.getSessionFactory().openSession();

    /**
     * Devuelve la sesión de hibernate.
     *
     * @return
     */
    /**
     * Crear un trabajador.Le pasamos los datos de trabajador y lo creamos.
     *
     * @param nombre
     * @param DNI
     * @param ocupacion
     * @param listaDeClientes
     */
    public void crearTrabajador(String nombre, String DNI, String ocupacion, List<Clientes> listaDeClientes) {

        Trabajador trabajador;
        //Iniciamos la transaccion
        ss.beginTransaction();
        //creamos el objeto trabajador. Si El objeto Clientes que le pasamos es null lo crea sin el.
        if (listaDeClientes == null) {
            trabajador = new Trabajador(nombre, DNI, ocupacion);
            //Lo metemos en la bbdd
            ss.persist(trabajador);
            //le hacemos el commit y lo cerramos
            ss.getTransaction().commit();
        } else {
            trabajador = new Trabajador(nombre, DNI, ocupacion, listaDeClientes);
            //Lo metemos en la bbdd
            ss.persist(trabajador);
            //le hacemos el commit y lo cerramos
            ss.getTransaction().commit();
            for (Clientes c : listaDeClientes) {
                annadirClienteaTrabajador(trabajador, c);
            }
        }

        //ss.close();
    }

    /**
     * Creamos un cliente. Le pasamos los datos, crea un objeto y lo mete en la
     * bbdd.
     *
     * @param nombre
     * @param DNI
     * @param NHabitacion
     * @param NNoches
     * @param Trabajador
     */
    public void crearClientes(String nombre, String DNI, int NHabitacion, int NNoches, Trabajador Trabajador) {
        Clientes cliente;
        //Iniciamos la transaccion.
        ss.beginTransaction();
        //creamos el objeto cliente. si el objeto cliente que pasamos es null lo crea sin el.( debería ser siempre null)
        if (Trabajador == null) {
            cliente = new Clientes(nombre, DNI, NHabitacion, NNoches);
        } else {
            cliente = new Clientes(nombre, DNI, NHabitacion, NNoches, Trabajador);
        }
        //Lo metemos en la bbdd
        ss.persist(cliente);
        //le hacemos el commit y lo cerramos
        ss.getTransaction().commit();
        ss.close();
    }

    /**
     * Le pasamos el objeto trabajador que queramos borrar.
     *
     * @param trabajador
     */
    public void borrarTrabajador(Trabajador trabajador) {
        //Iniciamos la transaccion.
        ss.beginTransaction();
        //borramos el objeto que le pasamos.
        ss.delete(trabajador);
        //commit
        ss.getTransaction().commit();
        //cerramos la sesión.
        //ss.close();
    }

    /**
     * Le pasamos el objeto cliente que queramos borrar.
     *
     * @param cliente
     */
    public void borrarCliente(Clientes cliente) {
        //Iniciamos la transaccion.
        ss.beginTransaction();
        //borramos el objeto que le pasamos.
        ss.delete(cliente);
        //commit
        ss.getTransaction().commit();
        //cerramos la sesión.
        //ss.close();
    }

    /**
     * Le pasamos el DNI, si el dni no existe devolverá un objeto tipo NULL, en
     * cambio si existe devolverá un objeto que nosea null, indicando que el
     * objeto existe.
     *
     * @param DNI
     * @return
     */
    public boolean comprobarCliente(String DNI) {
        ss.beginTransaction();
        //creamos el cliente para comprobar.
        Clientes c = new Clientes();
        c = (Clientes) ss.get(Clientes.class, (String) DNI);
        if (c != null) {
            // ss.close();
            return true;
        } else {
            //ss.close();
            return false;
        }

    }

    /**
     * devuelve una list de Clientes.
     *
     * @return
     */
    public List mostrarCliente() {
        ss.close();
        ss = NewHibernateUtil.getSessionFactory().openSession();
        //creamos la clase
        Clientes cliente;
        //creamos donde se almacenará 
        List<Clientes> listaClientes = new ArrayList();
        //muestra todos los clientes
        Query q = ss.createQuery("from Clientes");
        Iterator<Clientes> it = q.iterate();

        while (it.hasNext()) {
            cliente = (Clientes) it.next();
            listaClientes.add(cliente);
        }
        return listaClientes;
    }

    /**
     * devuelve una list de Clientes.
     *
     * @return
     */
    public List mostrarTrabajador() {
        ss.close();
        ss = NewHibernateUtil.getSessionFactory().openSession();
        //creamos la clase
        Trabajador trabajador;
        //creamos donde se almacenará 
        List<Trabajador> listaClientes = new ArrayList();
        //muestra todos los clientes
        Query q = ss.createQuery("from Trabajador");
        Iterator<Trabajador> it = q.iterate();

        while (it.hasNext()) {
            trabajador = (Trabajador) it.next();
            listaClientes.add(trabajador);
        }
        return listaClientes;
    }

    public boolean annadirClienteaTrabajador(Trabajador trabajador, Clientes cliente) {
        try {
            //    Session ss = NewHibernateUtil.getSessionFactory().openSession();
            ss.beginTransaction();
            cliente.setTrabajador(trabajador);
            ss.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
