/*
 * Package agenda.
 */


//import Objetos.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

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
   public ResultSet consultar_otra_bd(String sql,String ruta) {
    
    conexion2 conexion_two=new conexion2(ruta);
    conexion_two.conectar();
    ResultSet resultado = null;
    try {
        
      resultado = conexion_two.consulta2.executeQuery(sql);
      
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
            + ",'" + persona.getnombre()
            + "','" + persona.getapellido()
            + "','" + persona.get_cumpleaño()
            + "','" + persona.gettelefono()
            + "','" + persona.getEmail()+ "')");
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
  
  public void nombrePersonas(JTable table) {
    ResultSet resultado = null;
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.setRowCount(0);
    tableModel.setColumnCount(0);
    String sql = "select id,nombre from Persona";
    try {
      resultado = consultar(sql);
      if (resultado != null) {
        int numeroColumna = resultado.getMetaData().getColumnCount();
        for (int j = 1; j <= numeroColumna; j++) {
          tableModel.addColumn(resultado.getMetaData().getColumnName(j));
        }
        tableModel.addColumn("marcar");
        //por la columna marcar aumentamos una columna mas
        
        while (resultado.next()) {
          Object[] objetos = new Object[numeroColumna+1];
          for (int i = 1; i <= numeroColumna; i++) {
            objetos[i - 1] = resultado.getObject(i);
          }
          objetos[numeroColumna]=false;
          tableModel.addRow(objetos);
          table.setModel(tableModel);
          
          Celda_CheckBox s=new Celda_CheckBox();
          //Se crea el JCheckBox en la columna indicada en getColumn, en este caso, la primera columna
        table.getColumnModel().getColumn( 2 ).setCellEditor( new Celda_CheckBox() );
        //para pintar la columna con el CheckBox en la tabla, en este caso, la primera columna
        table.getColumnModel().getColumn( 2 ).setCellRenderer(new Render_CheckBox()); 
          
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
  public void actualizar_bd(String ruta)
  {

  String sql_persona="select * from persona";
  String sql_evento="select * from evento";
  ResultSet resultado_persona = null;
  ResultSet resultado_evento = null;
  try {
      
      resultado_persona = consultar_otra_bd(sql_persona,ruta);
      resultado_evento = consultar_otra_bd(sql_evento,ruta);
      insertar("delete from persona");
      insertar("delete from evento");      
      String nuevos_fila="";
      while(resultado_persona.next())
      {   
          nuevos_fila=resultado_persona.getObject(1)+",'"+resultado_persona.getString(2)+" "+resultado_persona.getString(3)+"','"+resultado_persona.getString(4)+" "+resultado_persona.getString(5)+"'";
          insertar("insert into persona(id,nombre,apellido) values("+nuevos_fila+")");
       }
      while(resultado_evento.next())
      {
          nuevos_fila=resultado_evento.getObject(1)+",'"+resultado_evento.getString(2)+"','"+resultado_evento.getString(3)+"','"+resultado_evento.getString(4)+"','"+resultado_evento.getString(5)+"'";
          insertar("insert into evento(id_evento,nombre_evento,fecha,horaini,horafin) values("+nuevos_fila+")");
       }
      
  }catch (SQLException e) {
      System.out.println("Mensaje:" + e.getMessage());
      System.out.println("Estado:" + e.getSQLState());
      System.out.println("Codigo del error:" + e.getErrorCode());
      JOptionPane.showMessageDialog(null, "" + e.getMessage());
    }
  
  }

}