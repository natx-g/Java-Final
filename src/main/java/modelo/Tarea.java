package modelo;

import java.io.Serializable;

// Implementación de Serializable y programación defensiva
public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;
    private String descripcion;
    private boolean hecha;

    public Tarea(String descripcion) {
        // Programación defensiva
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede ser nula o vacía");
        }
        this.descripcion = descripcion;
        this.hecha = false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        // Programación defensiva
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede ser nula o vacía");
        }
        this.descripcion = descripcion;
    }

    public boolean isHecha() {
        return hecha;
    }

    public void setHecha(boolean hecha) {
        this.hecha = hecha;
    }
}
