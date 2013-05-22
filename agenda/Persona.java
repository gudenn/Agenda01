/*
 * Package Objetos.
 */
package Objetos;

/**
 * Clase Persona
 *
 * @author equipo de programacion Agil
 */
public class Persona {

  private String id;
  private String primer_nombre;
  private String primer_apellido;
  private String segundo_apellido;
  private String email;

  public Persona(String id, String primer_nombre,  String primer_apellido, String segundo_apellido, String email) {
    this.id               = id;
    this.primer_nombre    = primer_nombre;
    this.primer_apellido  = primer_apellido;
    this.segundo_apellido = segundo_apellido;
    this.email            = email;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPrimer_apellido() {
    return primer_apellido;
  }

  public void setPrimer_apellido(String primer_apellido) {
    this.primer_apellido = primer_apellido;
  }

  public String getPrimer_nombre() {
    return primer_nombre;
  }

  public void setPrimer_nombre(String primer_nombre) {
    this.primer_nombre = primer_nombre;
  }

  public String getSegundo_apellido() {
    return segundo_apellido;
  }

  public void setSegundo_apellido(String segundo_apellido) {
    this.segundo_apellido = segundo_apellido;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


}
