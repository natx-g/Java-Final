package modelo;

// Clase abstracta para implementar polimorfismo y abstracción
public abstract class Elemento {
    private String nombre;

    public Elemento(String nombre) {
        // Programación defensiva
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        // Programación defensiva
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    // Método abstracto para polimorfismo
    public abstract void mostrarDetalles();
}

