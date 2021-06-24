import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Principal {
    public static void main( String[] args) throws IOException {
        // Declara Variables
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        // Mensaje de Bienvenida
        System.out.println("PROGRAMA PARA UNA AGENDA DE CONTACTOS");

        //Crea Agenda
        AdressBook agenda = new AdressBook();

        //Carga la Agenda del archivo C:/CHIDO/AdressBook/AgendaTelefonos.csv
        agenda.Load();

        // Entra a un Loop donde Muestra opciones, ejecuta opcion seleccionda
        // y sale cuando se da la opciòn de salir
        String numTelef;
        String nombre;
        char opcion = 'Z';
        while ( Character.toUpperCase(opcion) != 'S' ) {
            System.out.println("");
            System.out.println("Opciones:");
            System.out.println("  L/L: Lista de Contactos");
            System.out.println("  C/C: Crea los Concactos");
            System.out.println("  D/d: Borra los Contactos");
            System.out.println("  S/s: Salir");
            System.out.println("Dime tu opcion:");

            // Lee opciòn seleccionada por el usuario
            opcion = entrada.readLine().charAt(0);
            System.out.println("");

            // Ejecuta opciòn seleccionada por el usuario
            switch (Character.toUpperCase(opcion)) {
                case 'L':
                    agenda.List();
                    System.out.println("");
                    break;

                case 'C':
                    System.out.println("Dime el Telefono:");
                    numTelef = entrada.readLine();
                    System.out.println("Dime el Nombre:");
                    nombre = entrada.readLine();
                    agenda.Create(numTelef, nombre);
                    System.out.println("");
                    break;

                case 'D':
                    System.out.println("Dime el Telefono:");
                    numTelef = entrada.readLine();
                    agenda.Delete(numTelef);
                    System.out.println("");
                    break;


            }
        }

        // Guarda la agenda en el archivo C:/CHIDO/AdressBook/AgendaTelefonos.csv
        agenda.Save();

        // Mensaje de Despedida
        System.out.println("FIN DE PROGRAMA");
    }

}
