import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String [] args){
        String database = "texto.txt";

        UVGBST <Association<String, String>> tree = new UVGBST<Association<String, String>>();

        //variables de setteo
        boolean run = true;
        ArrayList<String> sentence = new ArrayList<>();
        String menu = "=== Translator/Traductor ===\n"+
        "Ingresa una oracion en ingles y traduciremos todo lo que podamos.";

        Scanner scanner = new Scanner(System.in);

                //lector csv
        try (BufferedReader br = new BufferedReader(new FileReader(database))) {
                String encabezado = br.readLine();
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] valores = linea.split(",");
                    
                    // Extraer los valores del CSV
                    String english = valores[0];
                    String espanol = valores[1];
                    tree.add(new Association<String, String>(english, espanol));
                System.out.println(tree);


                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        System.out.println(tree);
        tree.getRoot().traverseInOrder();

        while(run == true){

            String outputString = "";
            System.out.println(menu);
            System.out.println("Ingrese tu oracion: ");
            String opcion = scanner.nextLine();
            String[] input = opcion.split(" ");

            for (int i = 0; i < input.length; i++) {
                if (tree.get(input[i]) == null){
                    sentence.add("*"+input[i]+"*");
                }
                else {
                    sentence.add(tree.get(input[i]));
                }
            }

            for (int i = 0; i < sentence.size(); i++) {
                outputString = outputString + sentence.get(i);
            }
            
        }
        

    }
}
