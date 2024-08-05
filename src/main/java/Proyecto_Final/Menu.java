package Proyecto_Final;

import modelo.ListaTareas;
import java.util.Scanner;

public class Menu {
    private ListasTareas listasTareas;
    private ManejadorTareas manejadorTareas;
    private Scanner scanner;

    public Menu() {
        this.listasTareas = new ListasTareas();
        this.manejadorTareas = new ManejadorTareas();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Crear nueva lista de tareas");
            System.out.println("2. Ver listas de tareas");
            System.out.println("3. Ver tareas de lista");
            System.out.println("4. Actualizar lista de tareas");
            System.out.println("5. Eliminar lista de tareas");
            System.out.println("6. Gestionar tareas de lista");
            System.out.println("7. Guardar y Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine()); // Leer la entrada como String y convertir a int
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Por favor, seleccione una opción dentro del rango.");
                continue; // Volver al inicio del bucle
            }

            switch (opcion) {
                case 1:
                    crearNuevaLista();
                    break;
                case 2:
                    verListas();
                    break;
                case 3:
                    verTareasDeLista();
                    break;
                case 4:
                    actualizarLista();
                    break;
                case 5:
                    eliminarLista();
                    break;
                case 6:
                    gestionarTareasDeLista();
                    break;
                case 7:
                    guardarYSalir();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción dentro del rango.");
            }
        } while (opcion != 7);
    }

    private void crearNuevaLista() {
        System.out.println("Ingrese el nombre de la nueva lista:");
        String nombre = scanner.nextLine();
        ListaTareas nuevaLista = new ListaTareas(nombre);
        listasTareas.agregarLista(nuevaLista);
        System.out.println("Lista creada.");
    }

    private void verListas() {
        listasTareas.verListas();
    }

    private void verTareasDeLista() {
        ListaTareas lista = listasTareas.seleccionarLista();
        if (lista != null) {
            lista.mostrarDetalles();
        }
    }

    private void actualizarLista() {
        listasTareas.actualizarLista();
    }

    private void eliminarLista() {
        listasTareas.eliminarLista();
    }

    private void gestionarTareasDeLista() {
        ListaTareas lista = listasTareas.seleccionarLista();
        if (lista != null) {
            manejadorTareas.gestionarTareas(lista);
        }
    }

    private void guardarYSalir() {
        listasTareas.guardarListas();
        System.out.println("Listas guardadas. Saliendo del programa.");
    }
}
