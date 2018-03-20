package main.java.tests;



public class upperCaseFirstLetterSansSolution {

   public static void main(String[] args) {
      String texte = "dans xsd , on peut rendre un attribut obligatoire avec a";
      // on s'occupe de la premi�re lettre

      System.out.println(upperCaseFirstLetter(texte));


   }

   static String upperCaseFirstLetter (String chaine) {

      Character character = chaine.charAt(0);

      StringBuffer sb = new StringBuffer(chaine.length());
      sb.append(Character.toUpperCase(character));
      for (int i = 1 ; i < chaine.length() ; i++) {

        if  (chaine.charAt(i-1) == ' ') {
           sb.append(Character.toUpperCase(chaine.charAt(i)));
        } else  sb.append(chaine.charAt(i));
      }
      return sb.toString() ;
   }
}
