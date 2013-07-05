/*
 * Package agenda.
 */


//import Objetos.Persona;
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
 * @author equipo de programacion Agil
 */
public class Operaciones extends Conexion {

    

  /**
   * Constructor for objects of class Operaciones
   */
  public Operaciones() {
    // initialise instance variables
  }

  public void insertarDatos(String nombEven, String fecha, String hrsIni, String hrsFin,JTable contactos) {
    int num;
    num = 10000 + (int) (Math.random() * 100000);
    int id_persona=0;
    insertar("insert into EVENTO (id_evento,nombre_evento,fecha,horaini,horafin) values ('" + String.valueOf(num) + "','" + nombEven + "','" + fecha + "','" + hrsIni + "','" + hrsFin + "')");
   
        
         
    for(int i=0;i<contactos.getRowCount();i++)
      {
        
       
          if((Boolean)contactos.getModel().getValueAt(i, 2))
          {
              
              id_persona=(Integer)contactos.getValueAt(i, 0);
              insertar("insert into evento_persona (id,id_evento,id_persona) values ("+num+","+num+","+id_persona+")");
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
          actual = (String)resultado.getObject(0);
        }
      }
    } catch (SQLException e) {System.out.println("no se pudo obtener la version del software");}
    
    if (actual.equals("FALSE"))
      return false;
    else
      return true;
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
  public void listar_Personas_en_evento(DefaultTableModel tableModel,int id_evento) {
    ResultSet resultado = null;
    tableModel.setRowCount(0);
    tableModel.setColumnCount(0);
    String sql = "select p.nombre from Persona p, evento e, evento_persona ep where  e.id_evento="+id_evento+" and e.id_evento=ep.id_evento and ep.id_persona=p.id";
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
          objetos[2]=false;
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

  public ResultSet get_eventos(String fecha) {
    String auxfecha = "'" + fecha + "'";
    String sql = "select * from EVENTO where fecha=" + auxfecha;
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