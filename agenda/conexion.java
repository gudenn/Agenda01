/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 * Write a description of class Conexion here.
 * 
 * @author Rey Salcedo 
 * @version (a version number or a date)
 */
public class Conexion{
	Connection conexion;
	Statement consulta;
	public String ruta;

    /**
     * Constructor for objects of class Conexion
     */
    public Conexion()
    {
        ruta = "c:/Users/hp/Documents/UMSS - Agiles/Beta 10/agenda/build/classes/BD/registro.db";
        //ruta = "../BD/registro.db";
    }
    public void conectar(){
		try {
	            Class.forName("org.sqlite.JDBC");
	        }
	        catch (ClassNotFoundException e) {
	            JOptionPane.showMessageDialog(null, e.getMessage());
	        }	 
			try {
                            conexion = DriverManager.getConnection("jdbc:sqlite:"+ruta);
                            consulta = conexion.createStatement();
			} catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
	}
    
}
