/*
 * Package agenda.
 */
package agenda;

import Objetos.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Clase Operaciones
 * @author equipo de programacion Agil
 */
public class Operaciones extends Conexion {

  /**
   * Constructor for objects of class Operaciones
   */
  public Operaciones() {
    // initialise instance variables
  }

  public void insertarDatos(String nombEven, String fecha, String hrsIni, String hrsFin) {
    int num;
    num = 10000 + (int) (Math.random() * 100000);
    insertar("insert into EVENTO (id_evento,nombre_evento,fecha,horaini,horafin) values ('" + String.valueOf(num) + "','" + nombEven + "','" + fecha + "','" + hrsIni + "','" + hrsFin + "')");
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

  public void guardarUsuario(Persona persona) {
    insertar("insert into Persona values(" + persona.getId()
            + ",'" + persona.getPrimer_nombre()
            + "','" + persona.getEmail()
            + "','" + persona.getPrimer_apellido()
            + "','" + persona.getSegundo_apellido() + "')");
  }

  public void totalPersonas(DefaultTableModel tableModel) {
    ResultSet resultado = null;
    tableModel.setRowCount(0);
    tableModel.setColumnCount(0);
    String sql = "select * from Persona";
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

  public ResultSet get_eventos(String fecha) {
    String auxfecha = "'" + fecha + "'";
    String sql = "select * from EVENTO where fecha=" + auxfecha;
    System.out.println(sql);
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
}