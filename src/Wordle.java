
import java.util.ArrayList;
import java.util.List;

/** <strong>Entity class</strong>. Modella la partita avviata dall'utente. */
public class Wordle {

    /** La parola segreta della partita corrente */
    private String secretWord;

    /**
     * Lista dei tentativi effettuati dal Giocatore
     * 
     * @see Guess
     */
    private List<Guess> guesses;

    /**
     * Costruttore. Avvalora la parola segreta e istanza una lista vuota di
     * tentativi
     * 
     * @param secretWord La parola segreta acquisita dal Paroliere
     */
    Wordle(String secretWord) {
        this.secretWord = secretWord;
        this.guesses = new ArrayList<>();
    }

    /**
     * Aggiunge un tentativo alla lista di tentativi
     * 
     * @param lastGuess Tentativo effettuato dal Giocatore
     */
    public void addGuess(Guess lastGuess) {
        guesses.add(lastGuess);
    }

    /**
     * @return Numero di tentativi effettuati
     */
    public int getTentativi() {
        return guesses.size();
    }

    /**
     * @return Parola segreta della partita
     */
    public String getSecretWord() {
        return this.secretWord;
    }

    /**
     * @param index Indice del tentativo
     * @return Tentativo nella posizione specificata
     */
    public Guess getGuessAt(int index) {
        return this.guesses.get(index);
    }

    /**
     * Controlla che la partita non sia conclusa a causa della vittoria del
     * Giocatore
     * 
     * @return <strong>True</strong> se la parola segreta è stata indovinata,
     *         <strong>False</strong> altrimenti
     */
    public boolean hasWon() {
        if (!guesses.isEmpty())
            return guesses.get((guesses.size() - 1)).isCorrect();
        else
            return false;
    }

    /**
     * Controlla che la partita non sia conclusa a causa della sconfita del
     * Giocatore
     * 
     * @return <strong>True</strong> se il Giocatore non ha esaurito i tentativi,
     *         <strong>False</strong> altrimenti
     */
    public boolean hasLost() {
        return (getTentativi() >= 6);
    }
}
