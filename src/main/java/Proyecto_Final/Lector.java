package Proyecto_Final;

import java.util.Scanner;

public class Lector {
    private Scanner scanner;

    public Lector() {
        this.scanner = new Scanner(System.in);
    }

    public short leerOpcion() {
        return scanner.nextShort();
    }

    public void cerrar() {
        scanner.close();
    }
}
