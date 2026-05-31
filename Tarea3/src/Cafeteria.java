import java.util.*;

public class Cafeteria implements CrudPedido{

    private String nombreCafeteria;
    private HashSet<Cliente> clientes;
    private Map<String, Double> mapaPedidos;

    public Cafeteria(String nombreCafeteria) {

        this.nombreCafeteria = nombreCafeteria;
        this.clientes = new HashSet<>();
        this.mapaPedidos = new HashMap<>();

    }

    public void registrarCliente(Cliente cliente){

        boolean agregado = clientes.add(cliente);

        if(agregado){
            System.out.println("Registrado!");
        }else{
            System.out.println("Cliente repetido");
        }

    }

    public void mostrarClientes() {

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public Cliente buscarClientePorCorreo(String correo){

        for(Cliente c : clientes){
            if(c.getCorreo().equalsIgnoreCase(correo)){
                return c;
            }
        }

        return null;
    }


    @Override
    public void registrarPedido(String correo, double consumo) {
        Cliente cliente = buscarClientePorCorreo(correo);
        if(cliente == null) {

            System.out.println(
                    "Cliente inexistente"
            );

            return;
        }

        if(consumo <= 0) {

            System.out.println(
                    "Consumo invalido"
            );

            return;
        }

        mapaPedidos.put(
                cliente.getCodigoCliente(),
                consumo
        );

        if(!mapaPedidos.containsKey(cliente.getCodigoCliente())){
            System.out.println("Pedido inexistente");
            return;
        }
    }
    public void mostrarPedidos() {

        if (mapaPedidos.isEmpty()) {
            System.out.println("No hay datos disponibles.");
            return;
        }

        for (Map.Entry<String, Double> pedido : mapaPedidos.entrySet()) {

            System.out.println(
                    "Codigo: " + pedido.getKey()
                            + " | Consumo: $" + pedido.getValue()
            );

        }
    }
    @Override
    public void actualizarPedido(String correo, double nuevoConsumo) {
        Cliente cliente = buscarClientePorCorreo(correo);

        if(!mapaPedidos.containsKey(
                cliente.getCodigoCliente()
        )){
            System.out.println(
                    "Pedido inexistente"
            );
            return;
        }

        mapaPedidos.put(cliente.getCodigoCliente(), nuevoConsumo
        );
    }

    @Override
    public void eliminarPedido(String correo) {
        Cliente cliente = buscarClientePorCorreo(correo);

        mapaPedidos.remove(cliente.getCodigoCliente());


    }

    @Override
    public double promedioConsumo() {

        if(mapaPedidos.isEmpty()) {
            return 0;
        }

        double suma = 0;

        for(double consumo :
                mapaPedidos.values()) {

            suma += consumo;

        }

        return suma /
                mapaPedidos.size();

    }

    @Override
    public String mejorCliente() {

        if (mapaPedidos.isEmpty()) {
            return "No hay datos disponibles.";
        }

        String codigoMayor = "";
        double mayorConsumo = 0;

        for (Map.Entry<String, Double> pedido : mapaPedidos.entrySet()) {

            if (pedido.getValue() > mayorConsumo) {

                mayorConsumo = pedido.getValue();
                codigoMayor = pedido.getKey();

            }
        }

        for (Cliente cliente : clientes) {

            if (cliente.getCodigoCliente().equals(codigoMayor)) {

                return "Mejor cliente: " + cliente.getNombre() + " | Código: " + cliente.getCodigoCliente() + " | Consumo: $" + mayorConsumo;
            }
        }

        return "Cliente no encontrado.";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cafeteria cafeteria = (Cafeteria) o;
        return Objects.equals(clientes, cafeteria.clientes) && Objects.equals(mapaPedidos, cafeteria.mapaPedidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientes, mapaPedidos);
    }
}
