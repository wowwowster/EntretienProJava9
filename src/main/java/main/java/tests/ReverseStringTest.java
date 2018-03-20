package main.java.tests;

public class ReverseStringTest {
   public static void main(String[] args) {
      String str = "What's going on?";
      System.out.println(ReverseString.reverseIt(str));

      String mtVir = "0014886707";
      float floatMtVir = Float.parseFloat(mtVir) / 100f;
      float floatMtVirB = Float.parseFloat(mtVir);
      double doubleMtVir = Double.parseDouble(mtVir) / 100f;

   }
}


class ReverseString {
   public static String reverseIt(String str) {

      StringBuffer sb = new StringBuffer(str);
      sb.reverse();
      return sb.toString();

   }
}
