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
        int opcion = 0;
        do {
            System.out.println("Gestión de Tareas:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Marcar tarea como realizada");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine()); // si tiene entra en blanco
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Por favor, seleccione una opción dentro del rango.");
                continue; // Volver al inicio del bucle
            }

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
                    System.out.println("Opción no válida. Por favor, seleccione una opción dentro del rango.");
            }
        } while (opcion != 4);
    }

    private void agregarTarea(ListaTareas lista) {
        String descripcion;
        do {
            System.out.println("Ingrese la descripción de la nueva tarea:");
            descripcion = scanner.nextLine().trim();
            if (descripcion.isEmpty()) {
                System.out.println("Descripción no válida. Por favor, ingrese una descripción.");
            }
        } while (descripcion.isEmpty());

        // Verificar si la tarea ya existe
        for (Tarea t : lista.getTareas()) {
            if (t.getDescripcion().equals(descripcion)) {
                System.out.println("La tarea ya existe. Por favor, elige otro nombre.");
                return;
            }
        }
        lista.agregarTarea(descripcion);
        System.out.println("Tarea agregada.");
    }

    private void eliminarTarea(ListaTareas lista) {
        lista.mostrarDetalles();
        System.out.println("Ingrese el índice de la tarea a eliminar:");
        int indice;
        try {
            indice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Índice no válido. Por favor, ingrese un número.");
            return;
        }
        if (indice < 0 || indice >= lista.getTareas().size()) {
            System.out.println("Índice no válido. Por favor, seleccione un índice dentro del rango.");
            return;
        }
        Tarea tarea = lista.getTareas().get(indice);
        lista.eliminarTarea(tarea);
        System.out.println("Tarea eliminada.");
    }

    private void marcarTareaComoRealizada(ListaTareas lista) {
        lista.mostrarDetalles();
        System.out.println("Ingrese el índice de la tarea a marcar como realizada:");
        int indice;
        try {
            indice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Índice no válido. Por favor, ingrese un número.");
            return;
        }
        if (indice < 0 || indice >= lista.getTareas().size()) {
            System.out.println("Índice no válido. Por favor, seleccione un índice dentro del rango.");
            return;
        }
        lista.marcarTareaComoRealizada(indice);
    }
}
