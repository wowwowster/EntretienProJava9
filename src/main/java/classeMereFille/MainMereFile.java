package classeMereFille;

public class MainMereFile {


   public static void main(String[] args) {
      Fille girl = new Fille();

      girl.presentation();
      girl.presentationOverrided();

      Mere mother = new Mere();

      mother = (Fille) girl;
      mother.presentation();
      mother.presentationOverrided();

      mother.presentationStatic();

      Bidule b=new Bidule(); Machin m =b;
      System.out.println(m.f()*m.g());

       Machin machin = b;

       Bidule bidule = (Bidule) machin;
       System.out.println(machin.f());
       System.out.println(bidule.g());
       System.out.println(b.g());

   }
}
