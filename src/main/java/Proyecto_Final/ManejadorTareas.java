package Proyecto_Final;

import modelo.ListaTareas;
import modelo.Tarea;
import java.util.Scanner;

public class ManejadorTareas {
    private Scanner scanner;

    public ManejadorTareas() {
        this.scanner = new Scanner(System.in);
    }

    public void gestionarTareas(ListaTareas lista) {
        int opcion;
        do {
            System.out.println("Gestión de Tareas:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Marcar tarea como realizada");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarTarea(lista);
                    break;
                case 2:
                    eliminarTarea(lista);
                    break;
                case 3:
                    marcarTareaComoRealizada(lista);
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private void agregarTarea(ListaTareas lista) {
        System.out.println("Ingrese la descripción de la nueva tarea:");
        String descripcion = scanner.nextLine();
        lista.agregarTarea(descripcion);
        System.out.println("Tarea agregada.");
    }

    private void eliminarTarea(ListaTareas lista) {
        lista.mostrarDetalles();
        System.out.println("Ingrese el índice de la tarea a eliminar:");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        Tarea tarea = lista.getTareas().get(indice);
        lista.eliminarTarea(tarea);
        System.out.println("Tarea eliminada.");
    }

    private void marcarTareaComoRealizada(ListaTareas lista) {
        lista.mostrarDetalles();
        System.out.println("Ingrese el índice de la tarea a marcar como realizada:");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        lista.marcarTareaComoRealizada(indice);
        //try....
    }
}
