public class Persona {
    private String nombre;
    private String correo;
    private int edad;


    public Persona(String nombre, String correo, int edad) {
        this.nombre = nombre;
        setCorreo(correo);
        setEdad(edad);
    }

    public void setCorreo(String correo) {
        if(correo.contains("@")){
            this.correo = correo;
        }
        else{
            throw new IllegalArgumentException(
                    "Correo Invalido!"
            );
        }
    }


    public void setEdad(int edad) {
        if(edad > 18 && edad < 60){
            this.edad = edad;
        }else{
            throw new IllegalArgumentException(
                    "Edad invalida"
            );
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }
}
