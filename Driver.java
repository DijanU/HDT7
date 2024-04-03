import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        String database = "texto.txt";

        UVGBST<String> tree = new UVGBST<>();

        String menu = "=== Translator/Traductor ===\n" +
                "Ingresa una oracion en ingles y traduciremos todo lo que podamos.";

        Scanner scanner = new Scanner(System.in);

        // CSV reader
        try (BufferedReader br = new BufferedReader(new FileReader(database))) {
            String encabezado = br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");

                String english = valores[0];
                String espanol = valores[1];
                tree.add(english, espanol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print tree content
        System.out.println("Contenido del árbol:");
        tree.getRoot().traverseInOrder();

        while (true) { // Infinite loop, you may want to add an exit condition
            String outputString = "";
            System.out.println(menu);
            System.out.println("Ingrese tu oracion: ");
            String opcion = scanner.nextLine();
            String[] input = opcion.split(" ");

            for (String word : input) {
                Association<String, String> translatedWord = tree.get(word);
                if (translatedWord == null) {
                    outputString += "*" + word + "* ";
                } else {
                    outputString += translatedWord + " ";
                }
            }

            // Print the translated sentence
            System.out.println("Oración traducida:");
            System.out.println(outputString);
        }
    }
}

