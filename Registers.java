/**
 * OVERVIEW: le istanze di questa classe rappresentano i registri della VM per IntCode
 */
public class Registers {
    /** Registro contenente l'indirizzo dell'istruzione successiva */
    protected int InstructionPointer;
    /** Registro contenente il valore dell'offset */
    protected int RelativeBasePointer;

    /**
     * Post-condizioni: inizializza i registri IP e RBP
     */
    protected Registers(){
        InstructionPointer = 0;
        RelativeBasePointer = 0;
    }
}
