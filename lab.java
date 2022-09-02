import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class lab {

    public static void main(String[] args) {
        String nombredelarchivo;
        Scanner hjet = new Scanner(System.in);
        System.out.println("Digiteme el nombre de su archivo 'Clientes'");
        nombredelarchivo = hjet.nextLine();
        llenar(hjet, nombredelarchivo);
        hjet.close();
    }

    // Esto es para hacer los archivos
    public static void llenar(Scanner hjet, String nombredelarchivo) {
        String cedula = "0", nombre, dir;
        int hay_cliente, cedulaint, usuariosc, num = 0;
        int[] ordenador = new int[10000];
        String[] informacion = new String[10000];
        // Escritura del archivo
        try (FileWriter filew = new FileWriter(nombredelarchivo + ".txt", true)) {
            PrintWriter printw = new PrintWriter(filew);

            System.out.println("Hay registros? 1=si - 2=no");
            hay_cliente = hjet.nextInt();
            while (hay_cliente == 1) {
                System.out.println("¿Cuantas cedulas quiere ingresar?");
                usuariosc = hjet.nextInt();
                // Ordenamiento de las cedulas
                while (num < usuariosc) {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("Cedula");
                    cedula = hjet.next();
                    cedulaint = Integer.valueOf(cedula);
                    System.out.println("Digite la informacion de la cedula: " + cedula);
                    System.out.println("Nombre");
                    nombre = hjet.next();
                    System.out.println("Direccion");
                    dir = hjet.next();
                    System.out.println("Celular");
                    String celular = hjet.next();
                    System.out.println("Email");
                    String email = hjet.next();
                    ordenador[num] = cedulaint;
                    informacion[num]= "\t" + nombre + "\t" + dir + "\t" + celular + "\t" + email;
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    num++;
                }
                // Enlazar la cedula con lo demas
                ordenar(ordenador, usuariosc, informacion);
                for (int i = ordenador.length - usuariosc; i < ordenador.length; i++) {
                        printw.println(ordenador[i] + informacion[i]);                    
                }
                System.out.println("Hay registos? 1=si - 2=no");
                hay_cliente = hjet.nextInt();
            }
            printw.close();

        } catch (IOException e) {
            System.out.println("No se encontro");
        }

    }

    // Ordenar por burbuja
    public static void ordenar(int ordenador[], int uwu, String informacion[]) {
        System.out.println("Ordenando...");
        int contadordecambios = 0;
        for (boolean orden = false; !orden;) {
            for (int i = 0; i < ordenador.length - 1; i++) {
                if (ordenador[i] > ordenador[i + 1]) {
                    int aux = ordenador[i];
                    ordenador[i] = ordenador[i + 1];
                    ordenador[i + 1] = aux;
                    String aux2=informacion[i];
                    informacion[i] = informacion[i + 1];
                    informacion[i + 1] = aux2;
                    contadordecambios++;
                }
            }
            if (contadordecambios == 0) {
                orden = true;
            }
            contadordecambios = 0;
        }
        for (int i = ordenador.length - uwu; i < ordenador.length; i++) {
            System.out.println(ordenador[i]);

        }

    }
}
    
