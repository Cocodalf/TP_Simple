import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le chemin du répertoire que vous souhaitez lister :");
        String chemin = sc.nextLine();
        File fichier = new File(chemin);

        if (fichier.exists() && fichier.isDirectory() == true ){
            System.out.println("Ce chemein est correct, il mène à un dossier.");
        }else if ( fichier.exists() && fichier.isFile() == true){
            System.out.println("Ce chemein est correct, il mène à un fichier.");
        }else
            System.out.println("Ce chemin est incorrect.");

    }

}
