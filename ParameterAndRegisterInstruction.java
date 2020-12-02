/**
 * OVERVIEW: Questa classe estende la classe ParameterInstruction
 *           rappresenta le istruzioni basate su parametri e registri (InstructionPointer e RelativeBasePointer)
 */
public abstract class ParameterAndRegisterInstruction extends ParameterInstructions{
    /** registri */
    Registers registers;

    /**
     * Post-condizioni:  crea un'istruzione con parametri parameters e che utilizza registri registers
     * @param parameters sono i parametri dell'istruzione
     * @param registers  sono i registri utilizzati per l'istruzione
     */
    public ParameterAndRegisterInstruction(Memory.Location[] parameters, Registers registers){
        super(parameters);
        this.registers = registers;
    }


}
