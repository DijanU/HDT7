import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
    public static void main(String [] args){
        String database = "texto.txt";

        UVGBST <Association<String, String>> tree = new UVGBST<Association<String, String>>();

        //variables de setteo
        boolean run = true;

        String menu = "Aerolinea XD"+"\n"+
        "1. Crear ususario\n" + 
        "2. iniciar sesion"+"\n"+
        "3. Salir";

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
            System.out.println(menu);
            System.out.println("Ingrese una opcion: ");
            String opcion = scanner.nextLine();
        
        }
        

    }
}
