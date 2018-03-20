package exception;


/**
 * Cette exception est l'exception de base dont hérite toues les exception créées par l'application
 * CL_Extranet. Cette exception ajoute un champ 'code' qui permet d'identifier plus rapidement le
 * problème.
 *
 * Les codes actuellement existants sont :
 *
 * Code Exception Description
 * ------------------------------------------------------------------------
 * ---------------------------------------
 *
 * 1000 UnavailableJMSManagerException Le gestionnaire JMS n'est pas initialisé 1001
 * ParseDataBlocException La chaîne transcrite n'est pas au format attendue 1002
 * ReceiveNotificationException Le message de notification n'a pas été reçu 1003
 * ReceiveAnswerException Le message de réponse n'a pas été reçu 1004 InvalidNotificationException
 * La structure du message de notification n'est pas valide 1005 InvalidAnswerException La structure
 * du message de réponse n'est pas valide 1006 SendMessageException Le message n'a pas pu être
 * envoyé vers la file d'attente (erreur JMS) 1007 ReceiveMessageException Le message n'a pas pu
 * être récupéré de la file d'attente (erreur JMS) 1008 MyException Fusion PDF impossible
 * 
 * 2999 MyException Erreur inattendue.
 *
 * 
 */

public class MyException extends Exception {
   private static final long serialVersionUID = 1L;
   int code = 1008;

   /** pour un test */
   static String message = "Injection de code au sein d'une requ�te SQL ou DWR";

   /**
    * Constructor for IntrusionException.
    */
   public MyException() {
      super(message);
   }

   /**
    * Constructor for MyException.
    * 
    * @param message
    */
   public MyException(String message) {
      super(message);
   }

   /**
    * Constructor MyException.
    * 
    * @param codeMessage
    * @param message
    */
   public MyException(int codeMessage, String message) {
      super(message);
      this.code = codeMessage;
   }

   /**
    * Returns the code.
    * 
    * @return int
    */
   public int getCode() {
      return code;
   }

}
