
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Pour ce bloc d'instruction, je récupère l'entrée utilisateur. Ainsi, je passe à ma variable de type File le chemin d'accès.
        Scanner sc = new Scanner(System.in);
        System.out.println("veuillez saisir le chemin du répertoire que vous souhaiter lister :");
        String chemin = sc.nextLine();
        File fichier = new File(chemin);

        //Je vérifie que le chemin d'accès existe
        if (fichier.exists()) {
            System.out.println("Ce chemin d'accés existe ");
            //Je vérifie que le chemin mène à un dossier
            if (fichier.isDirectory()) {
                System.out.println("Ce chemin d'accés mène a un dossier");
                //Pour récupérer le contenu du dossier voulu  :
                // Je crée une variable contenu de type File directement dans ma boucle for
                // Je lui assigne la fonction listFiles()
                for (File contenu : fichier.listFiles()) {
                    //Je retourne le chemin que je cast dans une string
                    System.out.println(contenu.toString());
                }
             // Sinon il mène à un fichier
            } else {
                System.out.println("Ce chemin d'accés mène à un fichier");
            }
        }
        else {
            System.out.println("Ce chemin d'accès n'est pas correct");
        }

    }
}
