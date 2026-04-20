import java.util.Scanner;

/**
 * <strong>Boundary class</strong>. Si occupa di acquisire input di varia natura
 * dall'utente mediante la tastiera.
 */
public class Keyboard {

    /** Stringa contenente i caratteri non validi per l'applicazione */
    private final static String invalidChars = "1234567890!£$%&/()='ì?^|è+òàùé*ç°§[]@#,.-;:_<>\\";

    /**
     * Acquisisce una stringa inserita dall'utente
     * 
     * @return La stringa inserita dall'utente
     */
    public static String getString() {
        String inString = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("-> ");
        inString = sc.nextLine();
        return inString;
    }

    /**
     * Acquisisce una conferma dall'utente in caso di azioni irreversibili (chiusura
     * dell'applicazione o abbandono dellapartita corrente)
     * 
     * @param contextString Il contesto nel quale è richiesta la conferma
     * @return <strong>True</strong> se il carattere è una risposta affermativa,
     *         <strong>False</strong> altrimenti
     */
    public static boolean getConfirmation(String contextString) {
        String confirmation = "";
        Scanner sc = new Scanner(System.in);
        System.out.println(contextString);
        System.out.print("-> ");
        confirmation = sc.nextLine();
        if (confirmation.length() == 1 && confirmation.toLowerCase().charAt(0) == 'y')
            return true;
        else
            return false;
    }

    /**
     * Controlla che la stringa inserita dall'utente non contenga caratteri non
     * validi per l'applicazione
     * 
     * @param inString Stringa acquisita dall'utente da controllare
     * @return <strong>True</strong> se la stringa non contiene un carattere non
     *         valido, <strong>False</strong> altrimenti
     */
    public static boolean isValidString(String inString) {
        for (int i = 0; i < inString.length(); i++) {
            if (invalidChars.indexOf(inString.charAt(i)) != -1)
                return false;
        }
        return true;
    }
}
