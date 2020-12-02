/**
 * OVERVIEW: questa classe implementa l'interface Instruction
 *           rappresenta tutte le istruzioni che per essere eseguite hanno bisogno
 *           di parametri come argomenti (oltre all'op code) es.: ADD $t0, $t1, $t2
 *                                                                i parametri sono t0,t1,t2
 */
public abstract class ParameterInstructions implements Instruction{
    /** Parametri dell'istruzione */
    protected final Memory.Location[] parameters;

    /**
     * Post-condizioni: crea un'istruzione con parametri parameters
     * @param parameters sono i parametri dell'istruzione
     */
    public ParameterInstructions(Memory.Location[] parameters){
            this.parameters = parameters;
        }

    @Override
    /**
     * Post-condizioni: restituisce true se e' un istruzione di tipo halt
     *                  false altrimenti. Le istruziondi basate su parametri restituiscono sempre true
     * @return false
     */
    public boolean isHalting() {
        return false;
    }
}
