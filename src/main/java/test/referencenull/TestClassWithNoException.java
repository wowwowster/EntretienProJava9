package test.referencenull;

/**
 * Created by CARL on 05/03/2018.
 */
public class TestClassWithNoException {

    static int a = 10;

    public static void main(String ar[]){
        TestClassWithNoException t1 = null ;
        System.out.println(t1.a); // At this line

        int j = 20, i = 0;
        System.out.println(j/i);
        System.out.println("coucou toi !");

    }
}




