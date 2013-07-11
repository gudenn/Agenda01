
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

    public String getapellido() {
        return apellido;
    }

    public void setapellido(String primer_apellido) {
        this.apellido = apellido;
    }

    public String getnombre() {
        return nombre;
    }

    public void set_nombre(String nombre) {
        this.nombre = nombre;
    }

    public String get_cumpleaño() {
        return cumpleaño;
    }

    public void set_cumpleaño(String cumpleaño) {
        this.cumpleaño = cumpleaño;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String gettelefono() {
        return telefono;
    }

    public String settelefono(String telefono) {
        return this.telefono = telefono;
    }
}
