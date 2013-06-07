/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.agenda;

/**
 *
 * @author SONY
 */
public class Evento {
    private String nombre;
    private String fecha;
    private String hora_ini;
    private String hora_fin;
    
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
         return hora_ini;
     }
     public String getHora_Fin()
     {
         return hora_fin;
     }
     
 }
    

