package main.java.tests;

public class triInsertion {

   public static void main(String[] args) {
      int tableau[] = {1, 6, 4, 6, 2, 0, 1, 5};

      triInsertion(tableau);
   }

   public static void triInsertion(int tablo[]) {

      int longueur = tablo.length;

      for (int indexA = 0; indexA < longueur - 1; indexA++) {
         int valueA = tablo[indexA];
         int valueB = tablo[indexA + 1];
         if (valueA > valueB) {
            tablo[indexA] = valueB;
            tablo[indexA + 1] = valueA;
            indexA = -1;
         }

      }

      for (int i = 0; i < longueur; i++) {
         System.out.print(tablo[i] + ",");
      }


      /*
       * for (int i = 0; i < tablo.length; i++) { System.out.print(tablo[i]);
       * 
       * } System.out.print("\n");
       */

   }
}
