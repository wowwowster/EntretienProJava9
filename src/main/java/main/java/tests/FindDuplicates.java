package main.java.tests;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

    static int[] tabInt= new int[12];
    static Set doublonsSet = new HashSet();
    static Set tamponSet = new HashSet();

    static void  init () {
        for (int index = 0; index<tabInt.length ; index +=1) {
            tabInt[index] = (int) (10*Math.random());
        }
    }

    public static void main(String[] args) {
        init();
        for (int indexB = 0; indexB<tabInt.length ; indexB +=1) {
            System.out.print(tabInt[indexB]+" " );
            if (!tamponSet.add(tabInt[indexB])) {
                doublonsSet.add(tabInt[indexB]);

            }

        }

    String toto="";
    }
}
