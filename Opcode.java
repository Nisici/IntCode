/**
 * OVERVIEW: questa classe rappresenta tutte le possibili operazioni eseguibili con IntCode:
 *           add, multiply, read, write, ...
 */
public enum Opcode {
    /** lista delle operazioni */

    ADD(1,3),
        /*
        @Override
        Instruction toInstruction(Memory.Location[] parameters,Registers registers){
            return new Add(parameters);
        }
        */
    MULTIPLY(2,3),
    READ(3,1),
    WRITE(4,1),
    JUMP_NOT_ZERO(5,2),
    JUMP_ZERO(6,2),
    LESS_THAN(7,3),
    EQUALS(8,3),
    ADJ_RBP(9,1),
    HALT(99,0);

    /** operation code */
    public final int op;
    /** numero di parametri */
    public final int params;

    /**
     * Post-condizioni: inizializza un opcode
     * @param op operation code
     * @param params numero di parametri
     */
    private Opcode(int op, int params){
        this.op = op;
        this.params = params;
    }

    /**
     * Post-condizioni: restituisce l'operazione corrispondente a code in input
     * @param code op code
     * @return Opcode, oggetto avente un op, il numero di parametri ad esso associato, e il nome dell'operazione
     */
    public static Opcode fromOp(int code) {
        for(Opcode o: values()) if (o.op == code) return o;
        throw new IllegalArgumentException(("Invalid Mode: " + code));
    }
    //abstract Instruction toInstruction(Memory.Location[] parameters,Registers registers);
}
