import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ReservaCancha sistema = new ReservaCancha();

        int op;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Registrar reserva");
            System.out.println("4. Actualizar reserva");
            System.out.println("5. Eliminar reserva");
            System.out.println("6. Mostrar reservas");
            System.out.println("7. Buscar cliente");
            System.out.println("8. Total horas");
            System.out.println("9. Cliente mayor reserva");
            System.out.println("10. Acerca del sistema");
            System.out.println("11. Salir");
            System.out.print("Opcion: ");

            op = sc.nextInt();
            sc.nextLine();

            try {

                switch (op) {

                    case 1:

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Cedula: ");
                        String cedula = sc.nextLine();

                        System.out.print("Edad: ");
                        int edad = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Telefono: ");
                        String telefono = sc.nextLine();

                        Cliente c =
                                new Cliente(
                                        nombre,
                                        cedula,
                                        edad,
                                        telefono);

                        sistema.registrarCliente(c);

                        break;

                    case 2:

                        sistema.mostrarClientes();

                        break;

                    case 3:

                        System.out.print("Cedula: ");
                        cedula = sc.nextLine();

                        System.out.print("Horas: ");
                        int horas = sc.nextInt();
                        sc.nextLine();

                        sistema.registrarReserva(
                                cedula,
                                horas);

                        break;

                    case 4:

                        System.out.print("Cedula: ");
                        cedula = sc.nextLine();

                        System.out.print("Nuevas horas: ");
                        horas = sc.nextInt();
                        sc.nextLine();

                        sistema.actualizarReserva(
                                cedula,
                                horas);

                        break;

                    case 5:

                        System.out.print("Cedula: ");
                        cedula = sc.nextLine();

                        sistema.eliminarReserva(
                                cedula);

                        break;

                    case 6:

                        sistema.mostrarReservas();

                        break;

                    case 7:

                        System.out.print("Cedula: ");
                        cedula = sc.nextLine();

                        Cliente cli =
                                sistema.buscarPorCedula(
                                        cedula);

                        if (cli != null)
                            System.out.println(cli);
                        else
                            System.out.println(
                                    "Cliente no encontrado.");

                        break;

                    case 8:

                        System.out.println(
                                "Total horas: "
                                        + sistema.calcularTotalHoras());

                        break;

                    case 9:

                        System.out.println(
                                sistema.clienteMayorReserva());

                        break;

                    case 10:

                        System.out.println(
                                "Sistema de Reservas Deportivas");

                        break;

                    case 11:

                        System.out.println(
                                "Fin del programa");

                        break;

                    default:

                        System.out.println(
                                "Opcion invalida");
                }

            } catch (IllegalArgumentException e) {

                System.out.println(
                        "Error: " + e.getMessage());
            }

        } while (op != 11);

        sc.close();
    }
}