package utils;


import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

public class MyStringUtils extends StringUtils {

   private static final String TRANSLATED_ASCII = "DdOocYCRo";

   /** \u00D0 => Š */
   private static final String UNICODE_TO_TRANSLATE = "\u00D0\u00F0\u00D8\u00F8\u00A2\u00A5\u00A9\u00AE\u00B0";
   private static final String LIGATURE_UNICODE = "\u0152\u0153\u00C6\u00E6\u00DF";
   private static final String[] LIGATURE_ASCII = new String[] {"OE", "oe", "AE", "ae", "ss"};

   /**
    * On ajoute une limitation de taille à la méthode leftPad d'Apache
    * 
    * @param arg0
    * @param arg1
    * @return String
    */
   public static String leftPad(String arg0, int arg1) {
      String result = leftPad(arg0, arg1);
      if (isNotEmpty(result)) {
         if (result.length() > arg1) {
            result = result.substring(0, arg1);
         }
      }
      return result;
   }

   /**
    * On ajoute une limitation de taille Ã  la mÃ©thode rightPad d'Apache
    * 
    * @param arg0
    * @param arg1
    * @return String
    */
   public static String rightPad(String arg0, int arg1) {
      String result = rightPad(arg0, arg1);
      if (isNotEmpty(result)) {
         if (result.length() > arg1) {
            result = result.substring(0, arg1);
         }
      }
      return result;
   }

   /**
    * On ajoute une limitation de taille Ã  la mÃ©thode leftPad d'Apache
    * 
    * @param arg0
    * @param arg1
    * @param arg2
    * @return String
    */
   public static String leftPad(String arg0, int arg1, String arg2) {
      String result = leftPad(arg0, arg1, arg2);
      if (isNotEmpty(result)) {
         if (result.length() > arg1) {
            result = result.substring(0, arg1);
         }
      }
      return result;
   }

   /**
    * On ajoute une limitation de taille Ã  la mÃ©thode rightPad d'Apache
    * 
    * @param arg0
    * @param arg1
    * @param arg2
    * @return String
    */
   public static String rightPad(String arg0, int arg1, String arg2) {
      String result = rightPad(arg0, arg1, arg2);
      if (isNotEmpty(result)) {
         if (result.length() > arg1) {
            result = result.substring(0, arg1);
         }
      }
      return result;
   }

   /**
    * Renvoie true si la String en param est nulle ou vide
    * 
    * @param chaine
    * @return
    */
   public static boolean isEmpty(String chaine) {
      return (chaine == null) ? true : chaine.trim().length() == 0;
   }

   /** L'encodage des serveurs Crelog est l'ASCII */
   public static String translateToASCII(String orig) {

      if (!isEmpty(orig)) {
         StringBuilder s = new StringBuilder(orig);
         for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 127) {
               char c = s.charAt(i);
               if (c == '€') {
                  s.setCharAt(i, 'e');
               }

            }
         }

        // try {
            //return getNormalizationStringFilter().filter(s.toString()).replaceAll("[^\\p{ASCII}]", "");

            return "toto" ;
        /* } catch (ClassNotFoundException e) {
            return "";
         }*/
      } else
         return "";
   }

   /** L'encodage des BDD Crelog est l'ISO8859-1 */

   public static String translateToISO(String orig) {
      if (!isEmpty(orig)) {
         StringBuilder sb = new StringBuilder(orig.length());
         for (int i = 0; i < orig.length(); i++) {

            char c = orig.charAt(i);

            if (c == '€') {

               sb.append('e');
               continue;
            }

            if (c >= 256) {
               int pos = UNICODE_TO_TRANSLATE.indexOf(c);
               if (pos > -1) {
                  sb.append(TRANSLATED_ASCII.charAt(pos));
               } else {
                  pos = LIGATURE_UNICODE.indexOf(c);
                  if (pos > -1) {
                     sb.append(LIGATURE_ASCII[pos]);
                  } else {
                     sb.append(translateToASCII(Character.toString(c)));
                  }
               }
            } else {
               sb.append(c);
            }
         }
         return sb.toString();
      }
      return "";
   }

   public static String translateHTMLToISO(String orig) {

      StringBuilder sb = new StringBuilder(orig.length());
      for (int i = 0; i < orig.length(); i++) {

         char c = orig.charAt(i);

         if (c == '€') {
            sb.append('e');
         } else if (c == 'ĥ') {
            sb.append('h');
         } else if (c == 'Š') {
            sb.append('S');
         } else if (c == 'ŝ') {
            sb.append('s');
         } else if (c == 'ĩ') {
            sb.append('i');
         } else if (c == 'ġ') {
            sb.append('g');
         } else if (c == 'ů') {
            sb.append('u');
         } else {
            sb.append(c);
         }

      }
      return StringEscapeUtils.unescapeHtml4(sb.toString());

   }

   /**
    * Méthode de contrôle nécessaire pour éviter les intrusions applicatives via les requêtes SQL et
    * DWR. A noter que pour ces requetes, les paramètres à tester peuvent être null ou vides.
    */

   public static boolean isNumericOrEmpty(String texte) {
      if (isEmpty(texte)) {
         return true;
      }
      try {
         Integer.parseInt(texte);
      } catch (NumberFormatException e) {
         return false;
      }
      return true;
   }

   public static String getNameWithoutExtension(String fileName) {
      return fileName.substring(0, fileName.lastIndexOf("."));
   }


  /* public static StringFilter getNormalizationStringFilter() throws ClassNotFoundException
   {
      try
      {
         return new Java6Normalizer();
      }
      catch (Exception e)
      {}
      try
      {
         return new Java5Normalizer();
      }
      catch (Exception e)
      {}
      throw new ClassNotFoundException("Cannot instantiate a normalizer");
   }
   */
}
