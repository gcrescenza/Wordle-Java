
/**
 * <strong>NO ECB</strong>. Eccezione utilizzata per modellare il caso in cui un
 * generico input acquisito da tastiera non sia conforme alle possibilità
 * dell'utente o contenga qualche errore
 */
public class NotRecognized extends Exception {
    /** Messaggio di errore */
    private String errorMsg;

    /**
     * Avvalora il messaggio di errore
     * 
     * @param contestualMsg Il contesto specifico nel quale l'eccezione è stata
     *                      sollevata
     */
    NotRecognized(String contestualMsg) {
        this.errorMsg = contestualMsg;
    }

    /**
     * @return Messaggio di errore
     */
    public String getMessage() {
        return errorMsg;
    }

}