package Conexion;

import Clases.Persona;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.*;
import javax.swing.table.*;

/**
 * Clase Operaciones
 *
 * @author equipo de programacion Agil
 */
public class Operaciones extends Conexion {

    /**
     * Constructor for objects of class Operaciones
     */
    public Operaciones() {
        // initialise instance variables
    }

    /**
     * Borramos un Evento
     * @param id la clave de identificacion de un evento
     */
    public void borrarEvento(int id) {
        insertar("delete from EVENTo where id_evento=" + id);
    }

    public void insertarDatos(String nombEven, String fecha, String hrsIni, 
                              String hrsFin, String nota, JTable contactos) {
        int num;
        num = 10000 + (int) (Math.random() * 100000);
        int idPersona = 0;
        insertar("insert into EVENTO (id_evento,nombre_evento,fecha,horaini,horafin,nota) "
                + "values ('" + String.valueOf(num) + "','" + nombEven + "',"
                + "'" + fecha + "','" + hrsIni + "','" + hrsFin + "','" + nota + "')");



        for (int i = 0; i < contactos.getRowCount(); i++) {
            if ((Boolean) contactos.getModel().getValueAt(i, 2)) {
                idPersona = (Integer) contactos.getValueAt(i, 0);
                insertar("insert into evento_persona (id,id_evento,id_persona) "
                        + "values (" + num + "," + num + "," + idPersona + ")");
            }
        }


    }

    public boolean insertar(String sql) {

        boolean valor = true;
        conectar();
        try {
            consulta.executeUpdate(sql);
        } catch (SQLException e) {
            valor = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            try {
                consulta.close();
                conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return valor;
    }

    public ResultSet consultar(String sql) {
        conectar();
        ResultSet resultado = null;
        try {
            resultado = consulta.executeQuery(sql);

        } catch (SQLException e) {
            System.out.println("Mensaje:" + e.getMessage());
            System.out.println("Estado:" + e.getSQLState());
            System.out.println("Codigo del error:" + e.getErrorCode());
            JOptionPane.showMessageDialog(null, "" + e.getMessage());
        }
        return resultado;
    }

    public ResultSet consultarOtraBd(String sql, String ruta) {

        Conexion2 conexionTwo = new Conexion2(ruta);
        conexionTwo.conectar();
        ResultSet resultado = null;
        try {

            resultado = conexionTwo.consulta2.executeQuery(sql);

        } catch (SQLException e) {
            System.out.println("Mensaje:" + e.getMessage());
            System.out.println("Estado:" + e.getSQLState());
            System.out.println("Codigo del error:" + e.getErrorCode());
            JOptionPane.showMessageDialog(null, "" + e.getMessage());
        }
        return resultado;
    }

    public void grabarActualizado() {
        insertar("UPDATE version SET  actualizado = 'TRUE' WHERE id = '1' ");
    }

    public boolean estaActualizado() {
        ResultSet resultado = null;
        String actual = "FALSE";
        try {
            resultado = consultar("SELECT actualizado FROM version WHERE id = '1' ");
            if (resultado != null) {
                while (resultado.next()) {
                    actual = (String) resultado.getObject(0);
                }
            }
        } catch (SQLException e) {
            System.out.println("no se pudo obtener la version del software");
        }

        if (actual.equals("FALSE")) {
            return false;
        } else {
            return true;
        }
    }

    public void guardarUsuario(Persona persona) {
        insertar("insert into Persona values(" + persona.getId()
                + ",'" + persona.getNombre()
                + "','" + persona.getApellido()
                + "','" + persona.getCumpleaño()
                + "','" + persona.getTelefono()
                + "','" + persona.getEmail() + "')");
    }

    public void totalPersonas(DefaultTableModel tableModel) {
        ResultSet resultado = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "select nombre,apellido,cumpleaño,telefono,email from Persona";
        try {
            resultado = consultar(sql);
            if (resultado != null) {
                int numeroColumna = resultado.getMetaData().getColumnCount();
                for (int j = 1; j <= numeroColumna; j++) {
                    tableModel.addColumn(resultado.getMetaData().getColumnName(j));
                }
                while (resultado.next()) {
                    Object[] objetos = new Object[numeroColumna];
                    for (int i = 1; i <= numeroColumna; i++) {
                        objetos[i - 1] = resultado.getObject(i);
                    }
                    tableModel.addRow(objetos);
                }
            }
        } catch (SQLException e) {
        } finally {
            try {
                consulta.close();
                conexion.close();
                if (resultado != null) {
                    resultado.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void listarPersonasEnEvento(DefaultTableModel tableModel, int id_evento) {
        ResultSet resultado = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "select p.nombre from Persona p, evento e, evento_persona ep "
                    + "where  e.id_evento=" + id_evento 
                    + " and e.id_evento=ep.id_evento and ep.id_persona=p.id";
        try {
            resultado = consultar(sql);
            if (resultado != null) {
                int numeroColumna = resultado.getMetaData().getColumnCount();
                for (int j = 1; j <= numeroColumna; j++) {
                    tableModel.addColumn(resultado.getMetaData().getColumnName(j));
                }
                while (resultado.next()) {
                    Object[] objetos = new Object[numeroColumna];
                    for (int i = 1; i <= numeroColumna; i++) {
                        objetos[i - 1] = resultado.getObject(i);
                    }
                    tableModel.addRow(objetos);
                }
            }
        } catch (SQLException e) {
        } finally {
            try {
                consulta.close();
                conexion.close();
                if (resultado != null) {
                    resultado.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public DefaultTableModel nombrePersonas() {
        ResultSet resultado = null;
        DefaultTableModel tableModel = new DefaultTableModel();

        String sql = "select id,nombre from Persona";
        try {
            resultado = consultar(sql);
            if (resultado != null) {
                int numeroColumna = resultado.getMetaData().getColumnCount();
                for (int j = 1; j <= numeroColumna; j++) {
                    tableModel.addColumn(resultado.getMetaData().getColumnName(j));
                }
                tableModel.addColumn("marcar");


                while (resultado.next()) {
                    Object[] objetos = new Object[3];
                    for (int i = 1; i <= numeroColumna; i++) {
                        objetos[i - 1] = resultado.getObject(i);
                    }
                    objetos[2] = false;
                    tableModel.addRow(objetos);
                }

            }
        } catch (SQLException e) {
        } finally {
            try {
                consulta.close();
                conexion.close();
                if (resultado != null) {
                    resultado.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tableModel;
    }

    public ResultSet getEventos(String fecha) {
        String auxFecha = "'" + fecha + "'";
        String sql = "select * from EVENTO where fecha=" + auxFecha;
        //System.out.println(sql);
        conectar();
        ResultSet resultado = null;
        try {
            resultado = consulta.executeQuery(sql);

        } catch (SQLException e) {
            System.out.println("Mensaje:" + e.getMessage());
            System.out.println("Estado:" + e.getSQLState());
            System.out.println("Codigo del error:" + e.getErrorCode());
            JOptionPane.showMessageDialog(null, "" + e.getMessage());
        }
        return resultado;
    }

    public void actualizarBd(String ruta) {

        String sqlPersona = "select * from persona";
        String sqlEvento = "select * from evento";
        ResultSet resultadoPersona = null;
        ResultSet resultadoEvento = null;
        try {

            resultadoPersona = consultarOtraBd(sqlPersona, ruta);
            resultadoEvento = consultarOtraBd(sqlEvento, ruta);
            insertar("delete from persona");
            insertar("delete from evento");
            String nuevosFila = "";
            while (resultadoPersona.next()) {
                nuevosFila = resultadoPersona.getObject(1) + ","
                        + "'" + resultadoPersona.getString(2) + " "
                        + "" + resultadoPersona.getString(3) + "',"
                        + "'" + resultadoPersona.getString(4) + " "
                        + "" + resultadoPersona.getString(5) + "'";
                insertar("insert into persona(id,nombre,apellido) "
                        + "values(" + nuevosFila + ")");
            }
            while (resultadoEvento.next()) {
                nuevosFila = resultadoEvento.getObject(1) + ","
                             + "'" + resultadoEvento.getString(2) + "','" 
                             + resultadoEvento.getString(3) + "','" 
                             + resultadoEvento.getString(4) + "','" 
                             + resultadoEvento.getString(5) + "'";
                insertar("insert into evento"
                        + "(id_evento,nombre_evento,fecha,horaini,horafin) "
                        + "values(" + nuevosFila + ")");
            }

        } catch (SQLException e) {
            System.out.println("Mensaje:" + e.getMessage());
            System.out.println("Estado:" + e.getSQLState());
            System.out.println("Codigo del error:" + e.getErrorCode());
            JOptionPane.showMessageDialog(null, "" + e.getMessage());
        }

    }
}