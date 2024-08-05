package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Herencia de Elemento, implementación de interfaces y Serializable
public class ListaTareas extends Elemento implements Gestionable, Serializable {
    private static final long serialVersionUID = 1L;
    private final LocalDate fechaCreacion;
    private List<Tarea> tareas;

    public ListaTareas(String nombre) {
        super(nombre); // Uso de constructor de la clase base
        this.fechaCreacion = LocalDate.now();
        this.tareas = new ArrayList<>(); // Uso de ArrayList
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    @Override
    public void agregarTarea(Tarea tarea) {
        // Programación defensiva
        if (tarea == null) {
            throw new IllegalArgumentException("La tarea no puede ser nula");
        }
        // Verificar si la tarea ya existe
        for (Tarea t : tareas) {
            if (t.getDescripcion().equals(tarea.getDescripcion())) {
                System.out.println("La tarea ya existe. Por favor, elige otro nombre.");
                return;
            }
        }
        tareas.add(tarea);
    }

    // Sobrecarga de métodos
    public void agregarTarea(String descripcion) {
        // Programación defensiva
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede ser nula o vacía");
        }
        // Verificar si la tarea ya existe
        for (Tarea t : tareas) {
            if (t.getDescripcion().equals(descripcion)) {
                System.out.println("La tarea ya existe. Por favor, elige otro nombre.");
                return;
            }
        }
        Tarea tarea = new Tarea(descripcion);
        tareas.add(tarea);
    }

    @Override
    public void eliminarTarea(Tarea tarea) {
        // Programación defensiva
        if (tarea == null || !tareas.contains(tarea)) {
            throw new IllegalArgumentException("La tarea no existe en la lista");
        }
        tareas.remove(tarea);
    }

    @Override
    public void marcarTareaComoRealizada(int indice) {
        // Programación defensiva
        if (indice < 0 || indice >= tareas.size()) {
            throw new IndexOutOfBoundsException("Índice no válido");
        }
        Tarea tarea = tareas.get(indice);
        tarea.setHecha(true);
        System.out.println("Tarea marcada como realizada.");
    }

    @Override
    public void mostrarDetalles() {
        System.out.printf("Lista de Tareas: %s%n", getNombre());
        for (int i = 0; i < tareas.size(); i++) {
            Tarea tarea = tareas.get(i);
            String estado = tarea.isHecha() ? "[X]" : "[ ]";
            System.out.printf("%d. %s %s%n", i , estado, tarea.getDescripcion());
        }
    }
}
