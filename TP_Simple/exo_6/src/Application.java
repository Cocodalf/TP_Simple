import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.Scanner;
import java.io.IOException;


public class Application {
    static void fileCopy()throws IOException{
        // Je demande à l'utilisateur le chemin qui mène au fichier que l'on souhaite copier
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le chemin du fichier que vous souhaitez copier  et  ajouter \\nom_du_fichier:");
        String srcPath  = sc.nextLine();

        // Je demande à l'utilisateur le chemin qui mène au fichier dans lequel nous allons effectuer la copie
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Veuillez saisir le chemin du fichier dans lequel vous voulez effectuer la copie et  ajouter \\nom_du_fichier :");
        String destPath = sc1.nextLine();

        // Je déclare des objets qui grace au type FileInputStream et FileOutputStream vont me permettre de lire et d'écrire dans les fichiers passeés en paramètres
        FileInputStream srcFile = new FileInputStream(srcPath);
        FileOutputStream destFile = new FileOutputStream(destPath);

        // Ces deux variables nous permettent l'accès à la fonction getChannel() qui nous permet de créer un lien en le fichier source et le fichier de destination
        FileChannel inCopy = srcFile.getChannel();
        FileChannel outPaste = destFile.getChannel();


        // J'utilise un buffer auquel j'alloue de la mémoire dans le but de stocker des caractères du fichier src
        // la boucle me permet de parcourir et de copier l'intégralité du fichier
        for (ByteBuffer buffer = ByteBuffer.allocate(1024*1024); inCopy.read(buffer) != -1; buffer.clear()){
            buffer.flip();
            while (buffer.hasRemaining())
                outPaste.write(buffer);
        }
        // Je referme les channels ouverts précédement
        inCopy.close();
        outPaste.close();
    }
}
