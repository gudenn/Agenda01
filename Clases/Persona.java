package Clases;


/**
 * Clase Persona
 *
 * @author equipo de programacion Agil
 */
public class Persona {

    private String id;
    private String nombre;
    private String apellido;
    private String cumpleaño;
    private String telefono;
    private String email;

    public Persona(String id, String nombre, String apellido,
            String cumpleaño, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cumpleaño = cumpleaño;
        this.telefono = telefono;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String primer_apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCumpleaño() {
        return cumpleaño;
    }

    public void setCumpleaño(String cumpleaño) {
        this.cumpleaño = cumpleaño;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String setTelefono(String telefono) {
        return this.telefono = telefono;
    }
}
