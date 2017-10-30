import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Pour ce bloc d'instruction, je récupère l'entrée utilisateur. Ainsi, je passe à ma variable de type File le chemin d'accès.
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le chemin du répertoire que vous souhaitez lister :");
        String chemin = sc.nextLine();
        File fichier = new File(chemin);
        //Je vérifie que le chemin d'accès existe
        if (fichier.exists()) {
            System.out.println("Ce chemin d'accés existe ");
            //Je crée un tableau de string permettant de lister le contenu du dossier choisi auparavant
            String[] contenuDuDossier = fichier.list();

            //Je demande l'extension souhaitée à l'utilisateur
            System.out.println("Entrez l'extension de fichier que vous souhaitez lister : ");
            Scanner scExtension = new Scanner(System.in);
            String extension = scExtension.next(); // J'utulise next() et non pas nextLine() pour ne pas écraser l'ancienne entrée utilisateur

            // Je parcours mon tableau de string avec une boucle for
            int i;
            for (i=0; i < contenuDuDossier.length; i++){
                //Je compare les extensions avec la fonction endWith()
                if(contenuDuDossier[i].endsWith(extension) == true ){
                    //J'affiche le résultat
                    System.out.println(contenuDuDossier[i]);
                }else
                    System.out.println("Aucun fichier de cette extension n'existe dans ce dossier.");
            }
        }
        else{
            System.out.println("Ce chemin d'accès n'est pas correct");
        }
    }
}
