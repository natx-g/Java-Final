package modelo;

// Interfaz para polimorfismo
public interface Gestionable {
    void agregarTarea(Tarea tarea);
    void eliminarTarea(Tarea tarea);
    void marcarTareaComoRealizada(int indice);
}