/**
 * Descrive il comportamento di una generica istruzione nel linguaggio IntCode
 */
public interface Instruction {
    /**
     * Post-condizioni: viene eseguita l'istruzione
     */
    public void execute();

    /**
     * Post-condizioni: restituisce true se e' un istruzione di tipo halt
     *                  false altrimenti. (Un'istruzione di tipo halt fa terminare il programma)
     * @return true se e' un'istruzione di tipo Halt
     */
    public boolean isHalting();
}
