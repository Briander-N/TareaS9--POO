import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class ControlVacunas implements CrudVacuna {
    private Set<Mascota> mascotas;
    private Map<String, String> vacunas;

    public ControlVacunas() {
        mascotas = new HashSet<>();
        vacunas = new HashMap<>();
    }


    public void registrarMascota(Mascota mascota) {

        boolean agregado = mascotas.add(mascota);

        if (agregado) {
            System.out.println("Mascota registrada.");
        } else {
            System.out.println("La mascota ya existe.");
        }
    }

    public Mascota buscarPorCodigo(String codigo) {

        for (Mascota m : mascotas) {
            if (m.getCodigo().equals(codigo)) {
                return m;
            }
        }

        return null;
    }

    @Override
    public void registrarVacuna(String codigoMascota, String vacuna) {

        if (buscarPorCodigo(codigoMascota) == null) {
            System.out.println("La mascota no existe.");
            return;
        }

        vacunas.put(codigoMascota, vacuna);
        System.out.println("Vacuna registrada.");
    }
    @Override
    public void actualizarVacuna(String codigoMascota, String nuevaVacuna) {

        if (!vacunas.containsKey(codigoMascota)) {
            System.out.println("No existe vacuna registrada.");
            return;
        }

        vacunas.put(codigoMascota, nuevaVacuna);
        System.out.println("Vacuna actualizada.");
    }

    @Override
    public void eliminarVacuna(String codigoMascota) {

        if (!vacunas.containsKey(codigoMascota)) {
            System.out.println("No existe vacuna registrada.");
            return;
        }

        vacunas.remove(codigoMascota);
        System.out.println("Vacuna eliminada.");
    }

    @Override
    public void mostrarVacunas() {

        if (vacunas.isEmpty()) {
            System.out.println("No hay datos disponibles.");
            return;
        }

        for (Map.Entry<String, String> dato : vacunas.entrySet()) {
            System.out.println(
                    "Codigo: " + dato.getKey() +
                            " -> Vacuna: " + dato.getValue()
            );
        }
    }

    @Override
    public String buscarVacuna(String codigoMascota) {
        return vacunas.get(codigoMascota);
    }

    public void mostrarMascotas() {

        if (mascotas.isEmpty()) {
            System.out.println("No hay mascotas registradas.");
            return;
        }

        for (Mascota m : mascotas) {
            System.out.println(m);
        }
    }
}
