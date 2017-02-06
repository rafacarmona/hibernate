/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.conexionHibernate;
import Modelo.Clientes;
import Modelo.Trabajador;
import Vista.vistaVerClientesYTrabajadores;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author Rafa
 */
public class CtrlVerClientesYTrabajadores {

    //Icono
    //ImageIcon iconoEliminar = new ImageIcon("./resources/eliminar.png");
    //
    vistaVerClientesYTrabajadores vista;
    TableModelNoEditableClass tableModelNoEditableClientes;
    TableModelNoEditableClass tableModelNoEditableTrabajadores;
    //Esta tabla que muestra cada cliente que tiene cada trabajador.
    TableModelNoEditableClass tableModelNoEditableVerClientesEnTrabajadores;

    public CtrlVerClientesYTrabajadores() {
        vista = new vistaVerClientesYTrabajadores();
        //le decimos quien es el controlador
        vista.setController(this);
        tableModelNoEditableClientes = new TableModelNoEditableClass();
        tableModelNoEditableTrabajadores = new TableModelNoEditableClass();
        tableModelNoEditableVerClientesEnTrabajadores = new TableModelNoEditableClass();
        vista.getjTableClientes().setModel(tableModelNoEditableClientes);
        //hacemos que no se puedan organizar las columnas de la tabla.
        vista.getjTableClientes().getTableHeader().setReorderingAllowed(false);
        //trabajadores
        vista.getjTableTrabajadores().setModel(tableModelNoEditableTrabajadores);
        vista.getjTableClientesEnTrabajadores().setModel(tableModelNoEditableVerClientesEnTrabajadores);
        vista.getjTableTrabajadores().getTableHeader().setReorderingAllowed(false);
        //Rellenar Columnas
        ColumnasVerCLiente(tableModelNoEditableClientes);
        ColumnasVerTrabajador(tableModelNoEditableTrabajadores);
        ColumnasVerClientesEnTrabajador(tableModelNoEditableVerClientesEnTrabajadores);
        //falta rellena tabla.
        rellenarTablaClientes(tableModelNoEditableClientes);
        rellenarTablaTrabajadores(tableModelNoEditableTrabajadores);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);

    }

    /**
     *
     * @param modeloTabla
     */
    public void ColumnasVerCLiente(TableModelNoEditableClass modeloTabla) {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("DNI");
        modeloTabla.addColumn("Numero de habitación");
        modeloTabla.addColumn("Numero de noches");
        modeloTabla.addColumn("Eliminar");
    }

    /**
     *
     * @param modeloTabla
     */
    public void ColumnasVerTrabajador(TableModelNoEditableClass modeloTabla) {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("DNI");
        modeloTabla.addColumn("Ocupacion");
        modeloTabla.addColumn("Eliminar");
    }

    public void ColumnasVerClientesEnTrabajador(TableModelNoEditableClass modeloTabla) {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("DNI");
        modeloTabla.addColumn("Numero de habitación");
        modeloTabla.addColumn("Numero de noches");
    }

    /**
     *
     * @param modeloTabla
     * @return
     */
    public boolean rellenarTablaClientes(TableModelNoEditableClass modeloTabla) {
        //borra los registros de la tabla y los vuelve a rellenar
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }

        Object[] columna = new Object[5];
        List<Clientes> listaClientes;
        listaClientes = conexionHibernate.conexionHibernate().mostrarCliente();
        for (Clientes c : listaClientes) {
            columna[0] = c.getNombre();
            columna[1] = c.getDNI();
            columna[2] = c.getNHabitacion();
            columna[3] = c.getNNoches();
            columna[4] = "Borrar";
            modeloTabla.addRow(columna);
        }
        return true;

    }

    /**
     * Eliminar cliente, recoge la fila y el dni del cliente, si la columna que
     * se presiona es la 4 se llama al metodo de borrar al cliente.
     *
     * @return
     */
    public boolean eliminarCliente() {
        //cargamos el cliente clicado
        int fila = vista.getjTableClientes().getSelectedRow();
        String nombreCliente = vista.getjTableClientes().getValueAt(fila, 0).toString();
        String dniCliente = vista.getjTableClientes().getValueAt(fila, 1).toString();
        int nHabitacion = Integer.parseInt(vista.getjTableClientes().getValueAt(fila, 2).toString());
        int nNoches = Integer.parseInt(vista.getjTableClientes().getValueAt(fila, 3).toString());
        //borra los registros de la tabla y los vuelve a rellenar
        if (vista.getjTableClientes().getSelectedColumn() == 4) {
            int opcion = JOptionPane.showConfirmDialog(null, "Estás seguro de que quieres borrar el cliente?", "Borrar Cliente", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                //Clientees
                Clientes cliente;
                cliente = new Clientes(nombreCliente, dniCliente, nHabitacion, nNoches);
                //comprobamos el cliente
                if (conexionHibernate.conexionHibernate().comprobarCliente(dniCliente)) {
                    conexionHibernate.conexionHibernate().borrarCliente(cliente);
                    JOptionPane.showMessageDialog(null, "Borrado con exito", "Exito!", INFORMATION_MESSAGE);
                    rellenarTablaClientes(tableModelNoEditableClientes);
                    vista.getjTableClientes().repaint();
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Error, no se pudo insertar.", "Error!", ERROR_MESSAGE);
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    /**
     * rellena la tabla con los trabajadores.
     *
     * @param modeloTabla
     * @return
     */
    public boolean rellenarTablaTrabajadores(TableModelNoEditableClass modeloTabla) {
        //borra los registros de la tabla y los vuelve a rellenar
        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
        //Nombre variables que vamos a sacar de las columnas.
        //creamos el objeto de las columnas
        Object[] columna = new Object[4];

        List<Trabajador> listaTrabajadores;
        listaTrabajadores = conexionHibernate.conexionHibernate().mostrarTrabajador();
        //selectsDeTrabajadorYCliente.devolverSelectsTrabajadorYCliente().listarTrabajadores();
        for (Trabajador t : listaTrabajadores) {
            columna[0] = t.getNombre();
            columna[1] = t.getDNI();
            columna[2] = t.getOcupacion();
            columna[3] = "Borrar";
            modeloTabla.addRow(columna);
        }
        return true;
    }
    
    /**
     * Eliminamos el trabajador.
     * @return 
     */
    public boolean eliminarTrabajador() {
        //cargamos el trabajador clicado
        int fila = vista.getjTableTrabajadores().getSelectedRow();
        String nombreTrabajador = vista.getjTableTrabajadores().getValueAt(fila, 0).toString();
        String dniTrabajador = vista.getjTableTrabajadores().getValueAt(fila, 1).toString();
        String ocupacionTrabajador = vista.getjTableTrabajadores().getValueAt(fila, 2).toString();
        //borra los registros de la tabla y los vuelve a rellenar
       Trabajador trabajador = new Trabajador(nombreTrabajador, dniTrabajador, ocupacionTrabajador);
        if (vista.getjTableTrabajadores().getSelectedColumn() == 3) {
            int opcion = JOptionPane.showConfirmDialog(null, "Estás seguro de que quieres borrar el trabajador?", "Borrar trabajador", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                conexionHibernate.conexionHibernate().borrarTrabajador(trabajador);
                    JOptionPane.showMessageDialog(null, "Borrado con exito", "Exito!", INFORMATION_MESSAGE);
                    rellenarTablaTrabajadores(tableModelNoEditableTrabajadores);
                    vista.getjTableClientesEnTrabajadores().repaint();
                    vista.getjTableTrabajadores().repaint();
                    return true;
                
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    /**
     * Abrimos los clientes que tienen de dni_trabajador el mismo que el del
     * trabajador clicado
     *
     * @param modeloTabla
     * @return
     *
     * public boolean rellenarTablaClientesEnTrabajadores() {
     * TableModelNoEditableClass modeloTabla = (TableModelNoEditableClass)
     * vista.getjTableClientesEnTrabajadores().getModel(); //cargamos el
     * trabajador clicado int fila =
     * vista.getjTableTrabajadores().getSelectedRow(); String dniTrabajador =
     * vista.getjTableTrabajadores().getValueAt(fila, 1).toString(); //borra los
     * registros de la tabla y los vuelve a rellenar while
     * (modeloTabla.getRowCount() > 0) { modeloTabla.removeRow(0); }
     * System.out.println(vista.getjTableTrabajadores().getColumnCount()); if
     * (vista.getjTableTrabajadores().getSelectedColumn() == 3) {
     * eliminarTrabajador(); return true; } else {
     *
     * Object[] columna = new Object[4];
     *
     * try {
     * selectsDeTrabajadorYCliente.devolverSelectsTrabajadorYCliente().listarClientes(0,
     * dniTrabajador);
     *
     * for (Clientes c :
     * selectsDeTrabajadorYCliente.devolverSelectsTrabajadorYCliente().listarClientes(1,
     * dniTrabajador)) { columna[0] = c.getNombre(); columna[1] = c.getDNI();
     * columna[2] = c.getNHabitacion(); columna[3] = c.getNNoches();
     * modeloTabla.addRow(columna); }
     * vista.getjTableClientesEnTrabajadores().setModel(modeloTabla);
     * vista.getjTableClientesEnTrabajadores().repaint(); return true; } catch
     * (SQLException ex) { JOptionPane.showMessageDialog(null, "Error SQL." +
     * ex, "Error!", ERROR_MESSAGE); return false; } } }
     */
}
