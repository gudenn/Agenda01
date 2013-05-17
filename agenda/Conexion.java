/*
 * Pakage agenda
 */
package agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Crea la connecion a la base de datos
 *
 * @author equipo de programacion Agil
 * @version 1.01
 */
public class Conexion {
  Connection conexion;
  Statement consulta;
  public String ruta;

  /**
   * Constructor del objeto de class Conexion
   */
  public Conexion() {
    /**
     * la Ruta para la base de datos
     */
    ruta = "BD/registro.db";
  }

  /**
   * realizamos la connecion a la base de datos
   */
  public void conectar() {
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
    try {
      conexion = DriverManager.getConnection("jdbc:sqlite:" + ruta);
      consulta = conexion.createStatement();
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, e.getMessage());
    }
  }
}
