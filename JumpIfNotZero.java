/**
 * OVERVIEW:    questa classe estende la classe ControlFlowInstructions
 *              rappresenta l'istruzione JUMP_NOT_ZERO:
 *                 JUMP_ZERO $t0 $t1
 *                 se il valore della locazione memoria $t0 e' diverso da zero allora la prossima istruzione
 *                 sara' = al valore della locazione di memoria $t1
 */
public class JumpIfNotZero extends ControlFlowInstructions{
    /**
     * Post-condizioni:  crea l'istruzione JUMP_NOT_ZERO con parametri parameters e che utilizza registri registers
     * @param parameters sono i parametri dell'istruzione
     * @param registers  sono i registri utilizzati per l'istruzione
     */
    public JumpIfNotZero(Memory.Location[] parameters, Registers registers) {
        super(parameters, registers);
    }

    @Override
    /**
     * Post-condizioni: esegue l'istruzione JUMP_NOT_ZERO
     *                  se il valore e' != 0 la prossima istruzione da eseguire e' quella salvata nell' InstructionPointer
     */
    public void execute() {
        jump_if_not_zero();
    }

    /**
     * Post-condizioni: se il valore puntato dal primo parametro e' != 0, allora la prossima istruzione
     *                  sara' quella puntata dal secondo parametro e verra' salvata nell' InstructionPointer
     */
    private void jump_if_not_zero(){
        if(parameters[0].read() != 0) registers.InstructionPointer = parameters[1].read();
    }
}
