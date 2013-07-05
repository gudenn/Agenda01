
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author SONY
 */
public class Evento {
    private int id;
    private String nota;
    private String nombre;
    private String fecha;
    private String[] hora_inicio= new String[2];
    private String[] hora_finalizacion=new String[2];
    private String hora_ini;
    private String hora_fin;
    private String minuto_fin;
    private String minuto_ini;
    private JTable contactos=new JTable();
    private Operaciones operaciones=new Operaciones();
    
    public Evento(int id,String nombre,String fecha,String hora_ini,String hora_fin, String not)
    {
        this.nota=not;
         this.id=id;
         this.nombre = nombre;
         this.fecha = fecha;
         this.hora_inicio=hora_ini.split(":");
         this.hora_finalizacion=hora_fin.split(":");
         
         this.hora_ini = hora_inicio[0];
         this.hora_fin = hora_finalizacion[0];
         this.minuto_ini=hora_inicio[1];
         this.minuto_fin=hora_finalizacion[1];
         operaciones.listar_Personas_en_evento((DefaultTableModel)contactos.getModel(), this.id);
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
         this.hora_ini = hora_ini;
    }
    public void setHora_Fin(String hora_fin)
    {
         this.hora_fin = hora_fin;
    }
    public void setMinuto_Fin(String minuto_fin)
    {
         this.minuto_fin = minuto_fin;
    }
    public void setMinuto_Ini(String minuto_ini)
    {
         this.minuto_ini = minuto_ini;
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
         String[] hora=hora_ini.split(":");
         return hora[0];
     }
     public String getHora_Fin()
     {
         return hora_fin;
     }
     public String getMinuto_ini()
     {
         return minuto_ini;
     }
     public String getMinuto_Fin()
     {
         return minuto_fin;
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
    

