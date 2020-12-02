/**
 * OVERVIEW: questa classe estende la classe ParameterAndRegisterInstruction
 *           rappresenta le istruzioni che possono modificare il flusso del programma
 *           es.: jump_not_zero $t0 $t1
 *                se il valore della locazione memoria $t0 e' diverso da zero allora la prossima istruzione
 *                sara' = al valore della locazione di memoria $t1
 *           questo tipo di istruzioni utilizza solo il registo InstructionPointer (e non RBP)
 */
public abstract class ControlFlowInstructions extends ParameterAndRegisterInstruction{

    /**
     * Post-condizioni:  crea un'istruzione con parametri parameters e che utilizza registri registers
     * @param parameters sono i parametri dell'istruzione
     * @param registers  sono i registri utilizzati per l'istruzione
     */
    public ControlFlowInstructions(Memory.Location[] parameters, Registers registers){
        super(parameters,registers);
    }


}
