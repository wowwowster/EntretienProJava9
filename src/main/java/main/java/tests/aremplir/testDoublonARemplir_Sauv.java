package main.java.tests.aremplir;

public class testDoublonARemplir_Sauv {

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
      elts[2] = 8;
      elts[6] = 4;
      elts[8] = 8;
      affiche();
      System.out.println("\n-----------");
      doublon();
   }

   public static void doublon() {
      int l, index = 0;
      l = elts[index];
      for (int indexB = 1; indexB < N - 1; indexB++) {

         if (l == elts[indexB]) {
            System.out.println(l + " est en doublon ");
            l = elts[++index];
            indexB = index + 1;
         }

      }
      /*
       * for (i = 0; i < N - 1; i++) { checkForDoublon(elts[i], i); }
       */

   }

   public static void checkForDoublon(int l, int index) {



   }

}
