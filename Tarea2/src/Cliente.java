import java.util.Objects;

public class Cliente {

    private String nombre;
    private String cedula;
    private int edad;
    private String telefono;

    public Cliente(String nombre, String cedula, int edad, String telefono) {
        this.nombre = nombre;
        setCedula(cedula);
        setEdad(edad);
        setTelefono(telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setCedula(String cedula) {
        if (cedula == null || !cedula.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                    "Cedula invalida. Debe tener 10 digitos.");
        }
        this.cedula = cedula;
    }

    public void setEdad(int edad) {
        if (edad < 15 || edad > 60) {
            throw new IllegalArgumentException(
                    "Edad debe estar entre 15 y 60.");
        }
        this.edad = edad;
    }

    public void setTelefono(String telefono) {
        if (!telefono.matches("\\d+")) {
            throw new IllegalArgumentException(
                    "Telefono invalido.");
        }
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Cliente))
            return false;

        Cliente otro = (Cliente) obj;

        return cedula.equals(otro.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }

    @Override
    public String toString() {
        return "Cedula: " + cedula
                + " | Nombre: " + nombre
                + " | Edad: " + edad
                + " | Telefono: " + telefono;
    }
}