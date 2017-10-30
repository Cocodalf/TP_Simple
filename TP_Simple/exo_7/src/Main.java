import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


public class Main {
    public static void main(String[] args) throws Exception {
        // Je déclare une url d'image ainsi qu'un fichier de type jpg pour acceuillir la copie de l'image
        String imgUrl ="http://cdnf.rctoulon.com/wp-content/uploads/importedmedia/news/2015/06/15/Nouveau_Logo_596x326.jpg";
        String destFile = "img.jpg";

        //J'appelle ma fonction qui permet de sauvegarder une image depuis une Url
        saveImg(imgUrl, destFile);
    }

    public static void saveImg(String imgUrl, String destFile) throws IOException {
        // Je crée des objets qui me permettent de lire, d'écrire et d'ouvrir des fichiers
        URL url = new URL(imgUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destFile);

        //Je crée un tableau d'octets
        byte[] b = new byte[2048];
        int length;

        // Tant que la longueur est égale au nombre d'octets à lire  on écrit dans le ficher destination
        while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
        }

        // Je ferme les différents fichiers encore ouverts
        is.close();
        os.close();
    }
}
