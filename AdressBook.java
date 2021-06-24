
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class AdressBook {

    //Atributos
    private HashMap<String,String> Contactos;

    // Metodos
    public AdressBook(){
        Contactos= new HashMap<String,String>();
    }

    public void Load() {
        String inputFilename = "C:/CHIDO/AdressBook/AgendaTelefonos.csv";
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFilename));

            String line;
            Integer pos;
            String numTelf;
            String Nombre;
            while ((line = bufferedReader.readLine()) != null) {
                pos = line.indexOf(',');
                if (pos>=0) {
                   numTelf = line.substring(0,pos);
                   Nombre = line.substring(pos+1,line.length());
                   this.Create(numTelf, Nombre);
                }
            }
        } catch(IOException e) {
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }

            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }

    }

    public void Save() {
        String outputFilename = "C:/CHIDO/AdressBook/AgendaTelefonos.csv";
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(outputFilename));

            for (Map.Entry<String,String> entry : Contactos.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                String line = String.format("%s,%s", key, value);
                bufferedWriter.write(line + "\n");
            }

        } catch(IOException e) {
            System.out.println("IOException catched while writing: " + e.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }

    }

    public void List() {
        System.out.println("\n=== Contactos ===");
        for (Map.Entry<String,String> entry : Contactos.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            String output = String.format("%s : %s", key, value);
            System.out.println(output);
        }
    }

    public void Create(String NumTelef, String NombrePers) {
        Contactos.put(NumTelef, NombrePers);
    }

    public void Delete(String NumTelef) {
        Contactos.remove(NumTelef);
    }
}
