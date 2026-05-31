import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReservaCancha implements CrudReserva {

    private Set<Cliente> clientes;
    private Map<String, Integer> reservas;

    public ReservaCancha() {
        clientes = new HashSet<>();
        reservas = new HashMap<>();
    }

    public void registrarCliente(Cliente c) {

        boolean agregado = clientes.add(c);

        if (!agregado) {
            System.out.println("Cliente duplicado.");
        } else {
            System.out.println("Cliente registrado.");
        }
    }

    public Cliente buscarPorCedula(String cedula) {

        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }

        return null;
    }

    public void mostrarClientes() {

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes.");
            return;
        }

        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    public void mostrarReservas() {

        if (reservas.isEmpty()) {
            System.out.println("No hay datos disponibles.");
            return;
        }

        for (Map.Entry<String, Integer> e : reservas.entrySet()) {

            Cliente c = buscarPorCedula(e.getKey());

            System.out.println(
                    c.getNombre()
                            + " -> "
                            + e.getValue()
                            + " horas");
        }
    }

    @Override
    public void registrarReserva(String cedula, int horas) {

        if (buscarPorCedula(cedula) == null) {
            System.out.println("Cliente inexistente.");
            return;
        }

        if (horas < 1 || horas > 5) {
            System.out.println("Las horas deben estar entre 1 y 5.");
            return;
        }

        reservas.put(cedula, horas);

        System.out.println("Reserva registrada.");
    }

    @Override
    public void actualizarReserva(String cedula, int horas) {

        if (!reservas.containsKey(cedula)) {
            System.out.println("Reserva no encontrada.");
            return;
        }

        reservas.put(cedula, horas);

        System.out.println("Reserva actualizada.");
    }

    @Override
    public void eliminarReserva(String cedula) {

        if (!reservas.containsKey(cedula)) {
            System.out.println("Reserva no encontrada.");
            return;
        }

        reservas.remove(cedula);

        System.out.println("Reserva eliminada.");
    }

    @Override
    public int calcularTotalHoras() {

        int total = 0;

        for (int horas : reservas.values()) {
            total += horas;
        }

        return total;
    }

    @Override
    public String clienteMayorReserva() {

        if (reservas.isEmpty()) {
            return "No hay datos disponibles.";
        }

        String cedulaMax = "";
        int max = 0;

        for (Map.Entry<String, Integer> e : reservas.entrySet()) {

            if (e.getValue() > max) {
                max = e.getValue();
                cedulaMax = e.getKey();
            }
        }

        Cliente c = buscarPorCedula(cedulaMax);

        return c.getNombre() + " -> " + max + " horas";
    }
}