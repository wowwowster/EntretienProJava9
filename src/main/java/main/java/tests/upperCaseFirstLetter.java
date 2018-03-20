package main.java.tests;

import org.apache.commons.lang3.StringUtils;

public class upperCaseFirstLetter {

   public static void main(String[] args) {
      String texte = " dans xsd , on peut rendre un attribut obligatoire avec a";
      // on s'occupe de la premi�re lettre
      texte = StringUtils.capitalize(texte);
      char[] tabChar = texte.toCharArray();

      for (int i = 0; i < texte.length() - 1; i++)
         if (tabChar[i] == ' ') {
            tabChar[i + 1] = Character.toUpperCase(tabChar[i + 1]);
         }

      System.out.println(new String(tabChar));
   }



}
