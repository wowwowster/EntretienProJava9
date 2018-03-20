package exception;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

public class MainGestionDesExceptions {

   public static void main(String[] args) {
      try {



         lanceIntrusionException();

         /*
          * } catch (MyException e) { System.out.println("doLog(e) = " + doLog(e));
          * System.out.println("MyException Exception e.toString()=" + e.toString());
          * System.out.println("MyException  e.getMessage()=" + e.getMessage());
          * System.out.println("MyException  e.getLocalizedMessage()=" + e.getLocalizedMessage());
          */
      } catch (Exception e) {
         System.out.println("doLog(e) = " + doLog(e));
         System.out.println("Exception e.toString()=" + e.toString());
         System.out.println("Exception  e.getMessage()=" + e.getMessage());
         System.out.println("Exception  e.getLocalizedMessage()=" + e.getLocalizedMessage());
      }
   }

   private static void lanceIntrusionException() {
      Long docId = Long.valueOf("94938136676663296");

      // try {
      String ns = null;
      int i = ns.length();
      // } catch (Exception e) {
      // throw new MyException("1002");
      // }

   }

   protected static String doLog(Object message) {


      // Extract the message content
      String message_string = null;
      if (message == null) {
         message_string = "null";
      } else if (message instanceof Throwable) {
         // It(s an exception. convert to string
         CharArrayWriter bytearrayoutputstream = new CharArrayWriter();
         PrintWriter printstream = new PrintWriter(bytearrayoutputstream);
         ((Throwable) message).printStackTrace(printstream);
         message_string = bytearrayoutputstream.toString();

      } else {
         // It's an object. use toString()
         message_string = message.toString();
      }

      return message_string;

   } // doLog
}
