import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ControlVacunas control = new ControlVacunas();

        int opcion;

        do {

            System.out.println("\n=== MENU ===");
            System.out.println("1. Registrar mascota");
            System.out.println("2. Mostrar mascotas");
            System.out.println("3. Registrar vacuna");
            System.out.println("4. Actualizar vacuna");
            System.out.println("5. Eliminar vacuna");
            System.out.println("6. Mostrar vacunas");
            System.out.println("7. Buscar mascota");
            System.out.println("8. Buscar vacuna");
            System.out.println("9. Acerca del sistema");
            System.out.println("10. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            try {

                switch (opcion) {

                    case 1:

                        System.out.print("Codigo: ");
                        String codigo = sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Tipo: ");
                        String tipo = sc.nextLine();

                        System.out.print("Edad: ");
                        int edad = sc.nextInt();
                        sc.nextLine();

                        Mascota mascota =
                                new Mascota(codigo, nombre, tipo, edad);

                        control.registrarMascota(mascota);
                        break;

                    case 2:
                        control.mostrarMascotas();
                        break;

                    case 3:

                        System.out.print("Codigo mascota: ");
                        codigo = sc.nextLine();

                        System.out.print("Vacuna: ");
                        String vacuna = sc.nextLine();

                        control.registrarVacuna(codigo, vacuna);
                        break;

                    case 4:

                        System.out.print("Codigo mascota: ");
                        codigo = sc.nextLine();

                        System.out.print("Nueva vacuna: ");
                        vacuna = sc.nextLine();

                        control.actualizarVacuna(codigo, vacuna);
                        break;

                    case 5:

                        System.out.print("Codigo mascota: ");
                        codigo = sc.nextLine();

                        control.eliminarVacuna(codigo);
                        break;

                    case 6:
                        control.mostrarVacunas();
                        break;

                    case 7:

                        System.out.print("Codigo mascota: ");
                        codigo = sc.nextLine();

                        Mascota m = control.buscarPorCodigo(codigo);

                        if (m != null)
                            System.out.println(m);
                        else
                            System.out.println("No encontrada");

                        break;

                    case 8:

                        System.out.print("Codigo mascota: ");
                        codigo = sc.nextLine();

                        System.out.println(
                                control.buscarVacuna(codigo)
                        );

                        break;

                    case 9:
                        System.out.println("Sistema Veterinario");
                        break;

                    case 10:
                        System.out.println("Fin del programa");
                        break;

                    default:
                        System.out.println("Opcion invalida");
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (opcion != 10);

        sc.close();
    }
}
