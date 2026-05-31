public interface CrudVacuna {

    void registrarVacuna(String codigoMascota, String vacuna);

    void actualizarVacuna(String codigoMascota, String nuevaVacuna);

    void eliminarVacuna(String codigoMascota);

    void mostrarVacunas();

    String buscarVacuna(String codigoMascota);
}
