package Clases;

import Conexion.Operaciones;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase Evento
 * esta es la clase evento
 * @author SONY
 */
public class Evento {
    private int id;
    private String nota;
    private String nombre;
    private String fecha;
    private String[] horaInicio= new String[2];
    private String[] horaFinalizacion=new String[2];
    private String horaIni;
    private String horaFin;
    private String minutoFin;
    private String minutoIni;
    private JTable contactos=new JTable();
    private Operaciones operaciones=new Operaciones();
    
    public Evento(int id,String nombre,String fecha,String hora_ini,String hora_fin, String not)
    {
        this.nota=not;
         this.id=id;
         this.nombre = nombre;
         this.fecha = fecha;
         this.horaInicio=hora_ini.split(":");
         this.horaFinalizacion=hora_fin.split(":");
         
         this.horaIni = horaInicio[0];
         this.horaFin = horaFinalizacion[0];
         this.minutoIni=horaInicio[1];
         this.minutoFin=horaFinalizacion[1];
         operaciones.listarPersonasEnEvento((DefaultTableModel)contactos.getModel(), this.id);
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public void setFecha(String fecha)
    {
            this.fecha = fecha;
    }
    public void setHora_Ini(String hora_ini)
    {
         this.horaIni = hora_ini;
    }
    public void setHora_Fin(String hora_fin)
    {
         this.horaFin = hora_fin;
    }
    public void setMinuto_Fin(String minuto_fin)
    {
         this.minutoFin = minuto_fin;
    }
    public void setMinuto_Ini(String minuto_ini)
    {
         this.minutoIni = minuto_ini;
    }
    public void set_contactos(JTable contactos)
    {
      this.contactos=contactos;
    }
    public void set_notas(JTable contactos)
    {
      
    }
  public int get_id()
  {
  return id;
  }
  public JTable get_contactos()
  {
      return contactos;
  }
    public String getNombre()
    {
        return nombre;
    }
     public String getFecha()
     {
          return fecha;
     }
     public String getHora_Ini()
     {
         String[] hora=horaIni.split(":");
         return hora[0];
     }
     public String getHora_Fin()
     {
         return horaFin;
     }
     public String getMinuto_ini()
     {
         return minutoIni;
     }
     public String getMinuto_Fin()
     {
         return minutoFin;
     }
     public String get_nota()
     {
         return nota;
     }
     public void set_nota(String not)
     {
         nota=not;   
     }
 }
    

