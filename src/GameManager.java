
/**
 * <strong>Control class</strong>. Si occupa di controllare l'esecuzione
 * dell'applicazione e l'interazione fra le varie classi
 */
public class GameManager {

    /** Partita attuale */
    private Wordle actualGame = null;

    /** Flag utile a sapere quando la partita è stata effettivamente avviata */
    private boolean playStatus = false;

    /**
     * Controlla la stringa di input discernendo qualora si tratti di un comando
     * oppure di un tentativo per indovinare la parola segreta
     * 
     * @param inString Input dell'utente da analizzare
     * @throws NotRecognized Nel caso in cui la stringa non corrisponda ad alcun
     *                       comando e non possa al contempo considerarsi un
     *                       tentativo
     */
    public void computeInput(String inString) throws NotRecognized {
        if (inString.charAt(0) == '/')
            computeCommand(inString);
        else {
            // take it as a guess
            if (playStatus)
                if (checkGuess(inString))
                    actualGame.addGuess(new Guess(inString, actualGame.getSecretWord()));
        }
    }

    /**
     * Cerca corrispondenze tra la stringa di input ed i comandi disponibili
     * all'utente
     * 
     * @see Command
     * @param inString Stringa acquisita contenente un comando
     * @throws NotRecognized Nel caso in cui non vi siano corrispondenze tra il
     *                       comando inserito e quelli disponibili
     */
    private void computeCommand(String inString) throws NotRecognized {
        String splitCommand[] = inString.split(" ");
        if (splitCommand.length == 1) {
            if (splitCommand[0].equals(Command.PLAY.toString())) {

                playStatus = true;
                play();

            } else if (splitCommand[0].equals(Command.SHOW.toString())) {

                if (actualGame != null)
                    showSecretWord();
                else
                    System.out.println("Non hai ancora impostato alcuna parola segreta!");

            } else if (splitCommand[0].equals(Command.HELP.toString())) {

                help();

            } else if (splitCommand[0].equals(Command.ABANDON.toString())) {

                quitGame();

            } else if (splitCommand[0].equals(Command.QUIT.toString())) {

                quit();

            } else
                throw new NotRecognized("Command rejected!");

        } else if (splitCommand.length == 2) {

            if (splitCommand[0].equals(Command.NEW.toString())) {
                actualGame = newWord(splitCommand[1]);
            } else
                throw new NotRecognized("Command rejected!");

        } else
            throw new NotRecognized("Command rejected!");
    }

    /**
     * Controlla che il tentativo per indovinare la parola segreta sia composto da
     * un corretto numero di caratteri e non contenga caratteri alfabetici
     * 
     * @param inString Il tentativo acquisito da esaminare
     * @return <strong>True</strong> se il tentativo è della giusta lunghezza e
     *         contiene solo caratteri alfabetici, <strong>False</strong> altrimenti
     */
    public boolean checkGuess(String inString) {
        if (inString.length() > 5)
            // ScreenManager.longGuess()
            return false;
        else if (inString.length() < 5)
            // ScreenManager.shortGuess()
            return false;
        else if (!Keyboard.isValidString(inString))
            return false;
        else
            return true;
    }

    /**
     * Controlla che la parola segreta sia composta da 5 caratteri e che non
     * contenga caratteri non alfabetici
     * 
     * @param inString Parola segreta acquisita da tastiera
     * @return <strong>True</strong> se la parola segreta è composta da 5 caratteri
     *         e non contiene caratteri non-alfabetici, <strong>False</strong>
     *         altrimenti
     */
    private boolean checkSecretWord(String inString) {
        if (inString.length() > 5) {
            System.out.println("Parola segreta troppo lunga");
            return false;
        } else if (inString.length() < 5) {
            System.out.println("Parola segreta troppo corta");
            return false;
        } else if (!Keyboard.isValidString(inString)) {
            System.out.println("Parola segreta invalida");
            return false;
        } else {
            System.out.println("Parola segreta impostata correttamente!");
            return true;
        }
    }

    /**
     * Avvia una nuova partita e si prepara all'acquisizione di un tentativo oppure
     * di un comando
     */
    public void play() {
        ScreenManager.showMatrix(actualGame);
        do {
            String inString = "";
            inString = Keyboard.getString();
            try {
                computeInput(inString);
            } catch (NotRecognized e) {
                System.out.println(e.getMessage());
            }
            ScreenManager.showMatrix(actualGame);
        } while (playStatus && !actualGame.hasWon() && !actualGame.hasLost());
        if (playStatus) {
            if (actualGame.hasWon()) {
                ScreenManager.win();
                actualGame = null;
                playStatus = false;
            } else if (actualGame.hasLost()) {
                ScreenManager.loss();
                actualGame = null;
                playStatus = false;
            }
        }
    }

    /**
     * Crea una nuova partita con la parola segreta specificata
     * 
     * @param secretWord Parola segreta della partita da creare
     * @return Istanza della partita creata con la parola segreta specificata
     * @throws NotRecognized Nel caso in cui la parola segreta non possa essere
     *                       utilizzata dall'applicazione per creare una nuova
     *                       partita
     */
    public Wordle newWord(String secretWord) throws NotRecognized {
        if (checkSecretWord(secretWord))
            return new Wordle(secretWord);
        else
            throw new NotRecognized("La parola segreta inserita non è valida");
    }

    /** Mostra a schermo i comandi disponibili all'utente */
    public void help() {
        ScreenManager.viewCommands();
    }

    /** Mostra a schermo la parola segreta */
    public void showSecretWord() {
        ScreenManager.secretWord(actualGame.getSecretWord());
    }

    /**
     * Consente, dopo aver richiesto conferma, di abbandonare la partita in corso
     * 
     * @see Keyboard
     */
    public void quitGame() {
        if (Keyboard.getConfirmation("Vuoi davvero abbandonare la partita? (y/n)")) {
            if (playStatus) {
                actualGame = null;
                playStatus = false;
            }
            ScreenManager.greetings();
        }
    }

    /**
     * Consente, dopo aver richiesto conferma, di uscire dall'applicazione
     * 
     * @see Keyboard
     */
    public void quit() {
        if (Keyboard.getConfirmation("Vuoi davvero chiudere l'applicazione? (y/n)")) {
            if (playStatus) {
                actualGame = null;
                playStatus = false;
            }
            System.exit(0);
        }
    }

    /** Elenco dei comandi disponibili all'utente */
    enum Command {
        PLAY("/gioca"),
        NEW("/nuova"),
        SHOW("/mostra"),
        HELP("/help"),
        ABANDON("/abbandona"),
        QUIT("/esci");

        /** Il comando in forma testuale */
        final private String txt;

        /**
         * Avvalora il campo txt con il testo del comando corrispondente
         * 
         * @param txt Testo del comando
         */
        Command(String txt) {
            this.txt = txt;
        }

        /**
         * @return Forma testuale del comando
         */
        public String toString() {
            return this.txt;
        }
    }
}
