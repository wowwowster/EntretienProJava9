package main.java.tests;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

class Base {
    int x = 10;

    void display() {
        System.out.println("Base");
    }
}

class Derived extends Base {
    int x = 20;

    void display() {
        System.out.println("Derived");
    }
}


public class testBidon {


    public static void main(String[] args) {
   /*  String nomFichier = " Un  DEUX    tRIS    QUATRE    .pdf";

       int a1 = 5; double a2 = (float)a1;

       System.out.println("a1=" + a1);
      nomFichier = nomFichier.replaceAll("\\s+", " ");
      System.out.println(nomFichier);
      DoubleStream stream5 = DoubleStream.generate(Math::random);
      System.out.println(stream5.count());
      System.out.println("fin de la lecture du stream");

       List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
       Optional<Integer> firstSquareDivisibleByThree =
               someNumbers.stream()
                       .map(x -> x * x)
                       .filter(x -> x % 3 == 0)
                       .findFirst(); // 9




        Base b = new Base();
        Derived d = new Derived();
        Base bd = new Derived();

        // System.out.println(b.x + " " + d.x + " " + bd.x);

        b.display();
        d.display();
        bd.display();
        System.out.println();  */


        int a[] = {1, 2, 053, 4};
        int b[][] = {{1, 2, 4}, {2, 2, 1}, {0, 43, 2}};
        System.out.print(a[3] == b[0][2]);
        System.out.print(" " + (a[2] == b[2][1]));
    }


}
