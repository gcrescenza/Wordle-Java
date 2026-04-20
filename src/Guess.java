
/**
 * <strong>Entity class</strong>. Si occupa di modellare il tentativo effettuato
 * dall'utente per indovinare la parola segreta
 */
public class Guess {

    /**
     * Il tentativo effettuato dall'utente
     */
    private String guess;

    /**
     * Un array di colori che associa ad ogni carattere del tentativo un colore
     * 
     * @see Color
     */
    private Color background[];

    /**
     * Costruttore del tentativo. Dopo aver avvalorato la stringa del tentativo, si
     * occupa di avvalorare l'array di colori confrontando, carattere per carattere,
     * la parola segreta e la parola inserita dall'utente
     * 
     * @param guess      Tentativo inserito dall'utente
     * @param secretWord Parola segreta corrente
     */
    Guess(String guess, String secretWord) {
        this.guess = guess;
        this.background = new Color[5];
        for (int i = 0; i < background.length; i++) {
            if (guess.charAt(i) == secretWord.charAt(i))
                background[i] = Color.GREEN;
            else if (secretWord.indexOf(guess.charAt(i)) != -1)
                background[i] = Color.YELLOW;
            else
                background[i] = Color.GREY;
        }
    }

    /**
     * 
     * @return La parola inserita dall'utente in qualità di tentativo.
     */
    public String getGuess() {
        return this.guess;
    }

    /**
     * 
     * @param index Indice del carattere
     * @return Colore del carattere nella posizione index di background
     */
    public Color getBackgroundAt(int index) {
        return background[index];
    }

    /**
     * Verifica che il tentativo sia corretto, ossia corrispondente alla parola
     * segreta
     * 
     * @return <strong>True</strong> se l'array di colori background contiene solo
     *         il colore VERDE per ogni carattere, <strong>False</strong>
     *         altrimenti.
     */
    public boolean isCorrect() {
        for (int i = 0; i < background.length; i++)
            if (getBackgroundAt(i) != Color.GREEN)
                return false;
        return true;
    }

    /**
     * Modella tutti i colori di interesse per il modello di dominio
     */
    enum Color {
        GREEN("\u001b[42;1m"),
        YELLOW("\u001b[43;1m"),
        GREY("\u001b[47;1m");

        /**
         * ANSI Escape Code corrispondente al colore di background
         */
        private final String backgroundColor;

        /**
         * Avvalora backgroundColor
         * 
         * @param backgroundColor ANSI Escape Code corrispondente al colore desiderato
         */
        Color(String backgroundColor) {
            this.backgroundColor = backgroundColor;
        }

        /**
         * @return ANSI Escape Code del colore utile a stampare il colore di
         *         background
         * @see ScreenManager
         */
        public String toString() {
            return this.backgroundColor;
        }
    }
}
