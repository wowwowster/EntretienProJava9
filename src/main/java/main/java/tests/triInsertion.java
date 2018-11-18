package main.java.tests;

public class triInsertion {

   public static void main(String[] args) {
      int tableau[] = {1, 6, 4, 6, 2, 0, 1, 5};

      triInsertion(tableau);
   }

      public static void triInsertion(int tableau[])  {
         int longueur=tableau.length;

         for(int i=1;i<longueur;i++)  {
            int memory=tableau[i];
            int compt=i-1;
            boolean marqueur;
            do  {
               marqueur=false;
               if (tableau[compt]>memory)    {
                  tableau[compt+1]=tableau[compt];
                  compt--;
                  marqueur=true;
               }
               if (compt<0) marqueur=false;
            }
            while(marqueur);
            tableau[compt+1]=memory;
         }



      for (int i = 0; i < longueur; i++) {
         System.out.print(tableau[i] + ",");
      }


      /*
       * for (int i = 0; i < tablo.length; i++) { System.out.print(tablo[i]);
       * 
       * } System.out.print("\n");
       */

   }
}
