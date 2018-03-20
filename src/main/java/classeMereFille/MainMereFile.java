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

   }
}
