package Conexion;


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
public class Conexion2 {

    Connection conexion2;
    Statement consulta2;
    public String ruta;

    /**
     * Constructor del objeto de class Conexion
     */
    public Conexion2(String ruta) {
        /**
         * la Ruta para la base de datos
         */
        this.ruta = ruta;
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
            conexion2 = DriverManager.getConnection("jdbc:sqlite:" + ruta);
            consulta2 = conexion2.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
