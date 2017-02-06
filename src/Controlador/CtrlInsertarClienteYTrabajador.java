/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.conexionHibernate;
import Modelo.Clientes;
import Vista.VistaInsertar;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 *
 * @author Rafa
 */
public class CtrlInsertarClienteYTrabajador {

    //Declaramos la vista.
    VistaInsertar vista;
    //Tablas
    //declaramos el table model no editable.
    TableModelNoEditableClass tableModelNoEditableTablaUno;
    TableModelNoEditableClass tableModelNoEditableTablaDos;

    public CtrlInsertarClienteYTrabajador(JFrame parent) {
        //Instanciamos la vista.
        this.vista = new VistaInsertar(parent, true);
        //le indicamos que donde estamos es el controlador.
        vista.setController(this);
        // la ponemos en el medio y la hacemos visible 
        //Inicializamos el tableModel.
        tableModelNoEditableTablaUno = new TableModelNoEditableClass();
        tableModelNoEditableTablaDos = new TableModelNoEditableClass();
        //Le setteamos a la tabla el modelo.
        vista.getjTableVerClientesParaInsertar().setModel(tableModelNoEditableTablaUno);
        vista.getjTableVerClientesInsertados().setModel(tableModelNoEditableTablaDos);
        //Falta el rellenar
        ColumnasTablaUno(tableModelNoEditableTablaUno);
        rellenarTablaClientes(tableModelNoEditableTablaUno);
        ColumnasTablaDos(tableModelNoEditableTablaDos);

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

    }

    /**
     *
     * @return
     */
    public boolean insertarClientes() {
        //Declaramos las variables.
        String nombre, DNI;
        int nHabitacion, nNoches;
        //le asignamos el texto que haya en el Field a las variables.
        nombre = vista.getjTextFieldNombre().getText();
        DNI = vista.getjTextFieldDNINombe().getText();
        //Comprobamos la longitud de los campos.
        if (nombre.length() == 0) {
            JOptionPane.showMessageDialog(null, "Error nombre vacio.", "Error!", ERROR_MESSAGE);
            return false;
        }
        if (DNI.length() != 9) {
            JOptionPane.showMessageDialog(null, "Error. La longitud del dni no es 9.", "Error!", ERROR_MESSAGE);
            return false;
        }
        if (vista.getjTextFieldNhabitacion().getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Error Numero de habitacion vacio.", "Error!", ERROR_MESSAGE);
            return false;
        }
        if (vista.getjTextFieldNnoches().getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Error numero de noches vacio", "Error!", ERROR_MESSAGE);
            return false;
        }
        //Lo hacemos después por que el integer no puede hacer efecto a nada(si no hay nada en el campo daría error)
        nHabitacion = Integer.parseInt(vista.getjTextFieldNhabitacion().getText());
        nNoches = Integer.parseInt(vista.getjTextFieldNnoches().getText());
        //Ahora comprobaremos que el DNI introducido no existe.
        if (conexionHibernate.conexionHibernate().comprobarCliente(DNI)) {
            JOptionPane.showMessageDialog(null, "Este DNI ya se encuentra en la bbdd", "Error!", ERROR_MESSAGE);
            return false;
        } else {
            conexionHibernate.conexionHibernate().crearClientes(nombre, DNI, nHabitacion, nNoches, null);
            JOptionPane.showMessageDialog(null, "Insertado Con éxito!.", "Insertado Correctamente", INFORMATION_MESSAGE);
            return true;
        }

    }

    /**
     * Insertar trabajador.
     *
     * @return
     */
    public boolean InsertarTrabajador() {
        //comprobamos si los campos están vacios
        String nombre, DNI, ocupacion;
        nombre = vista.getjTextFieldNombreTrabajador().getText();
        DNI = vista.getjTextFieldDNITrabajador().getText();
        ocupacion = vista.getjTextFieldOcupacion().getText();
        if (nombre.length() == 0) {
            JOptionPane.showMessageDialog(null, "Error campo nombre vacio.", "Error!", ERROR_MESSAGE);
            return false;
        }
        if (DNI.length() != 9) {
            JOptionPane.showMessageDialog(null, "Error campo Dni vacio, ", "Error!", ERROR_MESSAGE);
            return false;
        }
        if (ocupacion.length() == 0) {
            JOptionPane.showMessageDialog(null, "Error campo de ocupacion vacio.", "Error!", ERROR_MESSAGE);
            return false;
        }
        //primero tenemos que recoger los datos para insertar.
        int numColumns = vista.getjTableVerClientesInsertados().getRowCount();
        //comparo con una lista de empleados y voy añadiendo los que tengan el dni igual.
        List<Clientes> listaDeClientesParaComparar;
        List<Clientes> listaClientes = new ArrayList();
        listaDeClientesParaComparar = conexionHibernate.conexionHibernate().mostrarCliente();

        for (int i = 0; i < numColumns; i++) {
            String dni = vista.getjTableVerClientesInsertados().getValueAt(i, 1).toString();
            for (Clientes c : listaDeClientesParaComparar) {
                if (dni.equals(c.getDNI())) {
                    listaClientes.add(c);
                }
            }
        }
        if (listaClientes == null) {
            conexionHibernate.conexionHibernate().crearTrabajador(nombre, DNI, ocupacion, null);
            JOptionPane.showMessageDialog(null, "Insertado Con éxito!.", "Insertado Correctamente", INFORMATION_MESSAGE);
            return false;
        }else{
        conexionHibernate.conexionHibernate().crearTrabajador(nombre, DNI, ocupacion, listaClientes);
        JOptionPane.showMessageDialog(null, "Insertado Con éxito!.", "Insertado Correctamente", INFORMATION_MESSAGE);
        return true;   
        }
    }

    //Falta el insertar los clientes en los trabajadores.
    /**
     *
     * @param modeloTabla
     */
    public void ColumnasTablaUno(TableModelNoEditableClass modeloTabla) {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("DNI");
    }

    public void ColumnasTablaDos(TableModelNoEditableClass modeloTabla) {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("DNI");
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
        Object[] columna = new Object[2];

        List<Clientes> listaClientes;
        listaClientes = conexionHibernate.conexionHibernate().mostrarCliente();
        for (Clientes c : listaClientes) {
            columna[0] = c.getNombre();
            columna[1] = c.getDNI();
            modeloTabla.addRow(columna);
        }
        return true;
    }
    //Obtenemos el Cliente de una columna y lo pasamos a la otra.

    /**
     * primero conseguimos el tablemodel en el que escribimos, lo casteamos y lo
     * ponemos como tablemodel no editable. Conseguimos la fila seleccionada, si
     * no hemos conseguido ninguna será -1. Conseguimos el nombre de la columna
     * y lo pasamos a String. Creamos el objeto y añadimos la row. seteamos el
     * modelo. Ahora lo que hacemos es de Ver Cliente borrar el Cliente pasado.
     *
     * @return
     */
    public boolean pasarDeVerClienteAEscribir() {
        TableModelNoEditableClass tmEscribirCliente = (TableModelNoEditableClass) vista.getjTableVerClientesInsertados().getModel();
        int fila = vista.getjTableVerClientesParaInsertar().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una Row.", "Error!", ERROR_MESSAGE);
            return false;
        }
        //sacamos el valor de cada columna.
        String clienteSeleccionado = vista.getjTableVerClientesParaInsertar().getValueAt(fila, 0).toString();
        String DNISeleccionado = vista.getjTableVerClientesParaInsertar().getValueAt(fila, 1).toString();
        Object[] columnasArellenar = new Object[2];
        //Le pasamos las columnas.
        columnasArellenar[0] = clienteSeleccionado;
        columnasArellenar[1] = DNISeleccionado;
        tmEscribirCliente.addRow(columnasArellenar);
        vista.getjTableVerClientesInsertados().setModel(tmEscribirCliente);

        TableModelNoEditableClass tmVerCliente;
        tmVerCliente = (TableModelNoEditableClass) vista.getjTableVerClientesParaInsertar().getModel();
        tmVerCliente.removeRow(fila);
        vista.getjTableVerClientesParaInsertar().setModel(tmVerCliente);
        vista.getjTableVerClientesParaInsertar().repaint();
        return true;
    }

    /**
     * Lo mismo que el metodo anterior pero al contrario.
     *
     * @return
     */
    public boolean pasarDeEscribirClienteAVer() {
        TableModelNoEditableClass tmEscribirCliente = (TableModelNoEditableClass) vista.getjTableVerClientesParaInsertar().getModel();
        int fila = vista.getjTableVerClientesInsertados().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una Row.", "Error!", ERROR_MESSAGE);
            return false;
        }
        String clienteSeleccionado = vista.getjTableVerClientesInsertados().getValueAt(fila, 0).toString();
        String DNISeleccionado = vista.getjTableVerClientesInsertados().getValueAt(fila, 1).toString();
        Object[] columnasArellenar = new Object[2];
        columnasArellenar[0] = clienteSeleccionado;
        columnasArellenar[1] = DNISeleccionado;
        tmEscribirCliente.addRow(columnasArellenar);
        vista.getjTableVerClientesParaInsertar().setModel(tmEscribirCliente);

        TableModelNoEditableClass tmVerCliente;
        tmVerCliente = (TableModelNoEditableClass) vista.getjTableVerClientesInsertados().getModel();
        tmVerCliente.removeRow(fila);
        vista.getjTableVerClientesInsertados().setModel(tmVerCliente);
        vista.getjTableVerClientesParaInsertar().repaint();
        return true;
    }

}
