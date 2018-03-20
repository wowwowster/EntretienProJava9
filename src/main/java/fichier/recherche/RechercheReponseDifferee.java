package fichier.recherche;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("LossyEncoding")
public class RechercheReponseDifferee {

   public static void main(String[] argv) throws IOException {

      System.out.println("D�but Recherche R�ponse diff�r�e ");
      BufferedReader lecteurAvecBuffer = null;
      String ligne = "";
      String ERROR_MSG = "Erreur SQL lors de l'insert : INSERT INTO TQQEDTP (ID_DOSSIER, LL_PRESENTATEUR, LL_EXPEDITEUR";
      String LIGNE_AVEC_NUM_DOSSIER = "] R�f CL pret:'";
      File fichierAvecListeNumerosDossier = new File("K:\\RechercheReponseDifferee\\ListeNumerosDossier.txt");

      /** lister fichier A copier */
      try {
         // lecteurAvecBuffer = new BufferedReader(new
         // FileReader("K:\\temp\\migrationSuisse\\fichiersACopierSeptembre2015.txt"));
         lecteurAvecBuffer = new BufferedReader(new FileReader("K:\\RechercheReponseDifferee\\catalina.out"));



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
      String numDossier = "";
      FileOutputStream fos = new FileOutputStream(fichierAvecListeNumerosDossier);
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

      while (ligne != null) {
         if (ligne.contains(LIGNE_AVEC_NUM_DOSSIER)) {
            int indiceFinNumDossier = StringUtils.lastIndexOf(ligne, "'");
            int indiceDebNumDossier = StringUtils.indexOf(ligne, "'");
            System.out.println("indiceFinNumDossier=" + indiceFinNumDossier);
            System.out.println("indiceFinNumDossier=" + indiceDebNumDossier);
            numDossier = ligne.subSequence(indiceDebNumDossier + 1, indiceFinNumDossier).toString();
            System.out.println("numDossier =" + numDossier);
         }


         if (ligne.contains(ERROR_MSG)) {
            System.out.println("ligne=" + ligne);
            bw.write(numDossier);
            bw.newLine();
            numDossier = "";
         }

         ligne = lecteurAvecBuffer.readLine();
         if (!StringUtils.isEmpty(ligne)) {
            try {
               ligne = ligne.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
               ligne = ligne.replaceAll("\\+", "%2B");
               ligne = ligne.replaceAll("é", "�");
               ligne = URLDecoder.decode(ligne, "UTF-8");

            } catch (IllegalArgumentException e) {
               System.out.println("ligne=" + ligne);
            }
         }


      }
      lecteurAvecBuffer.close();
      bw.close();



      /** copie de fichiers */
      /*
       * Iterator<String> itB = fichiersACopier.iterator(); while (itB.hasNext()) { String filenameB
       * = itB.next(); String filenameTomcat = filenameB.replaceFirst("Java Source", "JavaSource");
       * 
       * Path srcPath = Paths.get("C:\\CRELOG_Tools\\workspace_crelog\\cl-extranet-war\\" +
       * filenameB); Path targetPath =
       * Paths.get("C:\\CRELOG_Tools\\workspace_crelog\\ga-extranet-war\\" + filenameTomcat); try {
       * Files.copy(srcPath, targetPath, StandardCopyOption.REPLACE_EXISTING); } catch
       * (NoSuchFileException e) {
       * 
       * Path parentDir = targetPath.getParent(); if (!Files.exists(parentDir))
       * Files.createDirectories(parentDir); Files.copy(srcPath, targetPath,
       * StandardCopyOption.REPLACE_EXISTING); } catch (DirectoryNotEmptyException e) {
       * System.out.println("R�pertoire d�j� existant :" + filenameB); } }
       */



      System.out.println("Fin Recherche R�ponse diff�r�e");

   }
}
