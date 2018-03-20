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
       int memory, compt;
       boolean marqueur ;
       for (int j = 1; j < tableau.length; j++) {

            memory = tableau[j] ;
            compt=j-1;

            do {

                marqueur = false;
                if (memory < tableau[compt]) {
                    marqueur = true;
                    tableau[compt+1] = tableau[compt];
                    compt--;
                }
                if (compt<0) {
                    marqueur = false;
                }
            } while (marqueur);
           tableau[compt+1]=memory;

       }


      for (int i = 0; i < tableau.length; i++) {
            System.out.print(tableau[i]);

         System.out.print("\n");
      }
   }

}
