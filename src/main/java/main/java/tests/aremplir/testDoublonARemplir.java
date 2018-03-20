package main.java.tests.aremplir;

public class testDoublonARemplir {

   static int[] elts;
   static int N = 10;
   static int i, j = 0, longueurTabElmtsControles;
   static int[] tabElmtsControles = new int[10];

   public static void init() {
      elts = new int[10];
      for (int k = 0; k < N; k++)
         elts[k] = (int) (100 * Math.random());
   }

   public static void affiche() {
      for (i = 0; i < N; i++)
         System.out.print(elts[i] + " ");
   }

   public static void main(String[] args) {
      init();
      elts[0] = 4;
      elts[2] = 4;
      elts[6] = 4;
      elts[8] = 4;
      affiche();
      System.out.println("\n-----------");
      doublon();
   }

   public static void doublon() {


   }


}
