package Proyecto_Final;

import modelo.ListaTareas;
import java.util.List;
import java.util.Scanner;

// Uso de ArrayList y encapsulación
public class ListasTareas {
    private List<ListaTareas> listas;

    public ListasTareas() {
        this.listas = ManejadorArchivos.cargarListas();
    }

    public void agregarLista(ListaTareas lista) {
        listas.add(lista);
    }

    public void eliminarLista(int indice) {
        if (indice >= 0 && indice < listas.size()) {
            listas.remove(indice);
            System.out.println("Lista eliminada.");
        } else {
            System.out.println("Índice no válido.");
        }
    }

    public ListaTareas obtenerLista(int indice) {
        if (indice >= 0 && indice < listas.size()) {
            return listas.get(indice);
        } else {
            System.out.println("Índice no válido.");
            return null;
        }
    }

    public void verListas() {
        for (int i = 0; i < listas.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, listas.get(i).getNombre());
        }
    }

    public ListaTareas seleccionarLista() {
        Scanner scanner = new Scanner(System.in);
        verListas();
        System.out.println("Seleccione el número de la lista con la que desea trabajar:");
        int seleccion = scanner.nextInt() - 1;
        return obtenerLista(seleccion);
    }

    public void eliminarLista() {
        ListaTareas lista = seleccionarLista();
        if (lista != null) {
            listas.remove(lista);
            System.out.printf("Lista '%s' eliminada.%n", lista.getNombre());
        }
    }

    public void actualizarLista() {
        ListaTareas lista = seleccionarLista();
        if (lista != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el nuevo nombre para la lista:");
            String nuevoNombre = scanner.nextLine();
            lista.setNombre(nuevoNombre);
            System.out.printf("Lista actualizada a '%s'.%n", lista.getNombre());
        }
    }

    public void guardarListas() {
        ManejadorArchivos.guardarListas(listas);
    }
}
