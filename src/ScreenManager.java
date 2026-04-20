
/**
 * <strong>Boundary class</strong>. Si occupa di mostrare a schermo le
 * informazioni circa l'applicazione e/o la partita corrente
 */
public class ScreenManager {

    /** ANSI Escape Code utile a ripristinare il colore del terminale */
    private static final String ANSI_COLOR_CLEARANCE = "\u001b[0m";

    /**
     * Mostra a schermo i comandi che l'utente ha a disposizione nell'applicazione
     */
    protected static void viewCommands() {
        System.out.println("Comandi disponibili per l'utente:");
        System.out.println("\t/gioca");
        System.out.println("\t/mostra");
        System.out.println("\t/nuova <parola>");
        System.out.println("\t/help");
        System.out.println("\t/abbandona");
        System.out.println("\t/esci");
    }

    /** Mostra a schermo la parola segreta della partita corrente */
    protected static void secretWord(String secretWord) {
        System.out.println("La parola segreta corrente e': " + secretWord);
    }

    protected static void greetings() {
        System.out.println("Sarebbe carino metterci Wordle scritto in ASCII");
    }

    /** Mostra a schermo la stringa di benvenuto dell'applicazione */
    protected static void greetings(String args[]) {
        System.out.println("Sarebbe carino metterci Wordle scritto in ASCII");
        if (args.length == 1) {
            if (args[0].equals("--h") || args[0].equals("-help"))
                viewCommands();
        }
    }

    /**
     * Mostra a schermo la matrice dei tentativi della partita corrente
     * 
     * @param actualGame Istanza della partita corrente
     */
    protected static void showMatrix(Wordle actualGame) {
        int i = 0;
        for (i = 0; i < actualGame.getTentativi(); i++)
            printGuess(actualGame, i);
        while (i < 5) {
            printEmptyRow(i);
            i++;
        }

    }

    /**
     * Mostra a schermo la riga vuota della matrice
     * 
     * @param rowIndex indice della riga da mostrare
     */
    private static void printEmptyRow(int rowIndex) {
        System.out.println(
                "-------------------------------------------------------------------------------------------------");
        System.out.println("Tentativo " + (rowIndex + 1) + ": ");
        System.out.println(
                "-------------------------------------------------------------------------------------------------");
    }

    /**
     * Mostra a schermo la riga della matrice contenente un tentativo
     * 
     * @param actualGame Istanza della partita corrente
     * @param guessIndex Indice della riga della matrice da mostrare
     */
    private static void printGuess(Wordle actualGame, int guessIndex) {
        Guess actualGuess = actualGame.getGuessAt(guessIndex);
        String guessString = "";
        System.out.println(
                "-------------------------------------------------------------------------------------------------");
        guessString += "Tentativo " + (guessIndex + 1) + ": ";
        for (int i = 0; i < 5; i++) {
            guessString += actualGuess.getBackgroundAt(i).toString() + actualGuess.getGuess().charAt(i)
                    + ANSI_COLOR_CLEARANCE;
        }
        System.out.println(guessString);
        System.out.println(
                "-------------------------------------------------------------------------------------------------");
    }

    /** Mostra a schermo il messaggio di vittoria del Giocatore */
    protected static void win() {
        System.out.println("Congratulazioni, hai vinto!");
    }

    /** Mostra a schermo il messaggio di sconfitta del Giocatore */
    protected static void loss() {
        System.out.println("Oh no, hai perso!");
    }

}
