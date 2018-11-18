package main.java.tests;


public class upperCaseFirstLetterSansSolution {

    public static void main(String[] args) {
        String texte = "dans xsd , on peut rendre un attribut obligatoire avec a";
        // on s'occupe de la premi�re lettre

        System.out.println(upperCaseFirstLetter(texte));


    }

    static String upperCaseFirstLetter(String chaine) {
        int longueur = chaine.length();
        char[] tabChar = chaine.toCharArray();

        tabChar[0] = Character.toUpperCase(chaine.charAt(0));
        for (int index = 1; index < longueur; index += 1) {
            if (tabChar[index - 1] == ' ') {
                tabChar[index] = Character.toUpperCase( tabChar[index]);
            } else {
                tabChar[index] = Character.toLowerCase( tabChar[index]);
            }
        }
        return new String(tabChar);
    }
}
