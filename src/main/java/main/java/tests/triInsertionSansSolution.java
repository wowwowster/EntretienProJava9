package main.java.tests;

public class triInsertionSansSolution {

   public static void main(String[] args) {
      int tableau[] = {1, 6, 4, 6, 2, 0, 1, 5};

      triInsertion(tableau);

      for (int i = 0; i < tableau.length; i++) {
         System.out.print(tableau[i]);
      }
   }

   static void triInsertion(int[] tableau) {

       for (int index =0; index<tableau.length-1 ; index+=1) {
           int valeurA = tableau[index];
           int valeurB = tableau[index + 1];

           if (valeurA > valeurB) {
               tableau[index] = valeurB ;
               tableau[index + 1] = valeurA;
               index =-1;
           }
       }


   }

}
