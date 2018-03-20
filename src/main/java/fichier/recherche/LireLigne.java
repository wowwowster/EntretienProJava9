package fichier.recherche;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LireLigne {

   public static void main(String[] argv) throws IOException {

      System.out.println("D�but Migration CLA");
      BufferedReader lecteurAvecBuffer = null;
      String ligne = "";
      Set<String> fichiersACopier = new HashSet<String>();
      Set<String> fichiersANePasEcraser = new HashSet<String>();
      Set<String> fichiersASupprimer = new HashSet<String>();

      /** lister fichier A copier */
      try {
         // lecteurAvecBuffer = new BufferedReader(new
         // FileReader("K:\\temp\\migrationSuisse\\fichiersACopierSeptembre2015.txt"));
         lecteurAvecBuffer = new BufferedReader(new FileReader("K:\\MAJ_CLA_042016\\log_MEP_avril_2016_Add.txt"));



         /*
          * exemple de contenu : WebContent/WEB-INF/lib/phramer.jar
          * WebContent/WEB-INF/lib/xmlsec-1.5.7.jar .classpath
          * Java%20Source/com/cardiweb/cardibox/components/ConfValue.java
          * Java%20Source/commun/framework/jms/data/BlocAutrePret.java
          */
      } catch (FileNotFoundException exc) {
         System.out.println("Erreur d'ouverture");
      }

      ligne = URLDecoder.decode(lecteurAvecBuffer.readLine(), "UTF-8");
      while (ligne != null) {
         System.out.println("fichiersACopier=" + ligne);
         if (!ligne.substring(ligne.length() - 4).equalsIgnoreCase(".txt")) {
            fichiersACopier.add(ligne);
         }

         ligne = lecteurAvecBuffer.readLine();
         if (ligne != null) {
            ligne = URLDecoder.decode(ligne, "UTF-8");
         }
      }
      lecteurAvecBuffer.close();

      /**
       * lister fichier A ne pas ecraser try { lecteurAvecBuffer = new BufferedReader(new
       * FileReader( "C:\\temp\\migration_CLA\\fichiers_CLA.txt")); } catch (FileNotFoundException
       * exc) { System.out.println("Erreur d'ouverture"); } ligne =
       * URLDecoder.decode(lecteurAvecBuffer.readLine(), "UTF-8"); while (ligne != null) {
       * System.out.println("fichiersANePasEcraser=" + ligne); if (!ligne.substring(ligne.length() -
       * 4).equalsIgnoreCase(".txt")) { fichiersANePasEcraser.add(ligne); } ligne =
       * lecteurAvecBuffer.readLine(); if (ligne != null) { ligne = URLDecoder.decode(ligne,
       * "UTF-8"); } } lecteurAvecBuffer.close();
       */

      /**
       * synthese
       * 
       * Iterator<String> it = fichiersANePasEcraser.iterator(); while (it.hasNext()) { String
       * filename = it.next(); if (fichiersACopier.contains(filename)) {
       * fichiersACopier.remove(filename); System.out.println("fichiersACopier.remove=" + filename);
       * }
       * 
       * }
       */

      /** copie de fichiers */
      Iterator<String> itB = fichiersACopier.iterator();
      while (itB.hasNext()) {
         String filenameB = itB.next();
         String filenameTomcat = filenameB.replaceFirst("Java Source", "JavaSource");

         Path srcPath = Paths.get("C:\\CRELOG_Tools\\workspace201511\\cl-extranet-war\\" + filenameB);
         Path targetPath = Paths.get("C:\\CRELOG_Tools\\workspace_cla\\ga-extranet-war\\" + filenameTomcat);
         try {
            Files.copy(srcPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
         } catch (NoSuchFileException e) {

            Path parentDir = targetPath.getParent();
            if (!Files.exists(parentDir))
               Files.createDirectories(parentDir);
            Files.copy(srcPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
         } catch (DirectoryNotEmptyException e) {
            System.out.println("R�pertoire d�j� existant :" + filenameB);
         }
      }

      /**
       * lister fichier A supprimer try { lecteurAvecBuffer = new BufferedReader(new
       * FileReader("C:\\temp\\migration_CLA\\fichiers_SUISSE_FRASupprimer.txt")); } catch
       * (FileNotFoundException exc) { System.out.println("Erreur d'ouverture"); } ligne =
       * URLDecoder.decode(lecteurAvecBuffer.readLine(), "UTF-8"); while (ligne != null) {
       * System.out.println("fichiersASupprimer=" + ligne); fichiersASupprimer.add(ligne); ligne =
       * lecteurAvecBuffer.readLine(); if (ligne != null) { ligne = URLDecoder.decode(ligne,
       * "UTF-8"); } } lecteurAvecBuffer.close();
       * 
       * 
       * synthese Iterator<String> itANePasEcraser = fichiersANePasEcraser.iterator(); while
       * (itANePasEcraser.hasNext()) { String filename = itANePasEcraser.next(); if
       * (fichiersASupprimer.contains(filename)) { fichiersASupprimer.remove(filename);
       * System.out.println("fichiersASupprimer.remove=" + filename); }
       * 
       * }
       * 
       * 
       * /** suppression de fichiers
       */
      /**
       * Iterator<String> itToDelete = fichiersASupprimer.iterator(); while (itToDelete.hasNext()) {
       * String filenameToDelete = itToDelete.next(); Path pathToDelete = Paths .get(
       * "C:\\workspaces\\workspace_fusion_SAML_Advens\\ga-extranet-war\\" + filenameToDelete); if
       * (Files.isRegularFile(pathToDelete)) { Files.deleteIfExists(pathToDelete); } else if
       * (Files.isDirectory(pathToDelete)) { try { Files.delete(pathToDelete); } catch
       * (DirectoryNotEmptyException e) { System.out
       * .println("R�pertoire qu'on ne peut supprimer car non vide  :" + filenameToDelete); //
       * continuer } }
       * 
       * }
       */


      System.out.println("Fin Migration CLA");

   }
}
