package music;

import java.io.File;
import java.io.IOException;

public class GenerateDiscography {

   public static void main(String[] args) {
      File currentDir = new File("C://Users/CarlB/Documents/Vuze Downloads/Duran Duran");

      displayDirectoryContents(currentDir);
   }

   public static void displayDirectoryContents(File dir) {
      try {
         File[] files = dir.listFiles();
         for (File file : files) {
            if (file.isDirectory()) {
               System.out.println("directory:" + file.getCanonicalPath());
               displayDirectoryContents(file);
            } else {
               // System.out.println("     file:" + file.getCanonicalPath());
            }
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
