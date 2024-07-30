package Proyecto_Final;

import modelo.ListaTareas;
import modelo.Tarea;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

// Métodos estáticos y manejo de excepciones con try-with-resources
public class ManejadorArchivos {

    public static void guardarListas(List<ListaTareas> listas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("listasTareas.txt"))) {
            for (ListaTareas lista : listas) {
                writer.write(lista.getNombre() + "\n");
                for (Tarea tarea : lista.getTareas()) {
                    String estado = tarea.isHecha() ? "[X]" : "[ ]";
                    writer.write("  - " + estado + " " + tarea.getDescripcion() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar las listas de tareas: " + e.getMessage());
        }
    }

    public static List<ListaTareas> cargarListas() {
        List<ListaTareas> listas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("listasTareas.txt"))) {
            String linea;
            ListaTareas listaActual = null;
            Pattern pattern = Pattern.compile("^  - ");
            while ((linea = reader.readLine()) != null) {
                if (!pattern.matcher(linea).find()) {
                    listaActual = new ListaTareas(linea.trim());
                    listas.add(listaActual);
                } else if (listaActual != null) {
                    String estado = linea.trim().substring(3, 6);
                    String descripcion = linea.trim().substring(7);
                    Tarea tarea = new Tarea(descripcion);
                    tarea.setHecha(estado.equals("[X]"));
                    listaActual.agregarTarea(tarea);
                }
            }
        } catch (IOException e) {
            System.out.println("No se encontraron listas guardadas. Se creará una nueva lista.");
        }
        return listas;
    }
}
