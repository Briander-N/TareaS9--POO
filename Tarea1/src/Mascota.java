import java.util.Objects;
public class Mascota {
    private String codigo;
    private String nombre;
    private String tipo;
    private int edad;


    public Mascota(String codigo, String nombre, String tipo, int edad) {
        setCodigo(codigo);
        setNombre(nombre);
        setTipo(tipo);
        setEdad(edad);
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El codigo no puede estar vacio");
        }
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (!tipo.equalsIgnoreCase("Perro") &&
                !tipo.equalsIgnoreCase("Gato") &&
                !tipo.equalsIgnoreCase("Conejo") &&
                !tipo.equalsIgnoreCase("Otro")) {

            throw new IllegalArgumentException("Tipo invalido");
        }

        this.tipo = tipo;
    }
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 0 || edad > 20) {
            throw new IllegalArgumentException("Edad fuera de rango");
        }
        this.edad = edad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Mascota)) return false;

        Mascota otra = (Mascota) obj;
        return codigo.equals(otra.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo +
                ", Nombre: " + nombre +
                ", Tipo: " + tipo +
                ", Edad: " + edad;
    }
}
