import java.util.ArrayList;
import java.util.List;

/**
 * OVERVIEW: le istanze di queste classe rappresentano la memoria della VM per IntCode
 *           la memoria e' composta da celle.
 *           Le istanze delle classe Location rappresentano l'accesso alle celle di memoria, e' possibile
 *           scrivere e leggere un dato in una locazione di memoria. (cella = locazione di memoria)
 */
public class Memory {

    //CAMPI
    /** Celle che compongono la memoria*/
    private List<Integer> memoryCells;

    //COSTRUTTORI

    /**
     * Post-condizioni: costruisce la memoria e salva tutte le informazioni del programma nella memoria
     * @param program il codice dell'intero programma
     */
    public Memory(List<Integer> program){
        memoryCells = new ArrayList<>(program);
    }

    //METODI
    /**
     * Effetti collaterali: potrebbe modificare this
     * Post-condizioni:     salva il valore value nella cella di memoria all'indirizzo index
     * @param index l'indirizzo della cella di memoria
     * @param value il valore da salvare nella cella di memoria
     */
    private void set(int index, int value){
        memoryCells.set(index,value);
    }

    /**
     * Post-condizioni: restituisce il valore salvato nella cella di memoria all'indirizzo index
     * @param index l'indirizzo della cella di memoria
     * @return valore che si trova nella cella di memoria
     */
    private int get(int index){
        return memoryCells.get(index);

    }
    /**
     * OVERVIEW: Le istanze di questa classe rappresentano l'accesso alla locazione di memoria
     * */
    public class Location{
        //CAMPI
        /** Modalita' di accesso */
        private final Mode mode;
        /** Indirizzo della locazione di memoria */
        private final int memoryIndex;
        /** Offset dalla cella di memoria con indirizzo 0*/
        private final int relativeBasePointer;

        //COSTRUTTORI

        /**
         * Post-condizioni: istanzia un accesso a una cella di memoria specifidando la
         *                  modalita' di accesso ad essa, il suo indirizzo e l'offset
         * @param mode la modalita' di accesso
         * @param memoryIndex l'indirizzo della locazione di memoria
         * @param relativeBasePointer valore offset
         */
        public Location(Mode mode, int memoryIndex, int relativeBasePointer){
            this.mode = mode;
            this.memoryIndex = memoryIndex;
            this.relativeBasePointer = relativeBasePointer;
        }

        //METODI

        /**
         * Effetti collaterali: potrebbe modificare this
         * Post-condizioni:     salva il valore v nella locazione di memoria this in base alla modalita' di accesso:
         *                      se di tipo RELATIVE somma l'indirizzo della cella di memoria con l'offset e poi salva,
         *                      se di tipo POSITION come sopra ma l'offset sara' = 0
         *                      se di tipo IMMEDIATE solleva un'eccezione di tipo IllegalStateException
         * @param v valore da salvare nella cella di memoria
         */
        void write(int v){
            if( mode == Mode.IMMEDIATE) throw new IllegalStateException();
            int address = memoryIndex;
            if(mode == Mode.RELATIVE) address += relativeBasePointer;
            set(address,v);

        }

        /**
         * Post-condizioni: restituisce il valore salvato nella locazione di memoria this in base alla modalita' di accesso:
         *                  se di tipo RELATIVE somma l'indirizzo della cella di memoria con l'offset e prendi il valore dall'indirizzo
         *                  se di tipo POSITION come sopra ma l'offset sara' = 0
         *                  se di tipo IMMEDIATE restituisce il valore che si trova all'indirizzo della lcoazione di memoria this
         * @return  valore salvato all'indirizzo della locazione di memoria this
         */
        int read(){
            int address = memoryIndex;
            if(mode == mode.IMMEDIATE) return get(address);
            if(mode == Mode.RELATIVE) address += relativeBasePointer;
            return get(get(address));
        }
    }

}
