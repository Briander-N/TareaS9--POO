public class Cliente extends Persona{
    private String codigoCliente;
    private String tipoMembresia;

    public Cliente(String nombre, String correo, int edad, String codigoCliente, String tipoMembresia) {
        super(nombre, correo, edad);
        this.codigoCliente = codigoCliente;
        setTipoMembresia(tipoMembresia);
    }

    public void setTipoMembresia(String tipoMembresia) {
        if(!tipoMembresia.equalsIgnoreCase("Gold") && !tipoMembresia.equalsIgnoreCase("Silver") && !tipoMembresia.equalsIgnoreCase("Premium")){
            throw new IllegalArgumentException(
                    "Membresia invalida"
            );
        }
        this.tipoMembresia = tipoMembresia;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }


    @Override
    public String getCorreo() {
        return super.getCorreo();
    }

}
