import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * OVERVIEW: fa partire la Virtual Machine di IntCode
 */
public class Run {
    public static void main(String[] args) {
        int num;
        Opcode opcode;
        Memory.Location[] params = new Memory.Location[]{};
        Registers registers = new Registers();
        List<Integer> fullcode = new ArrayList<Integer>();
        //insieme delle operazioni
        fullcode = stringToIntArrayList(args[0]);

        //inizializzo la memoria
        Memory memoria = new Memory(fullcode);
        //prima istruzione
        opcode = Opcode.fromOp(fullcode.get(0));
        Instruction instr = opcode.toInstruction(params,registers);
        while(instr.isHalting() == false) {
            //creo la memoria contenente tutti i parametri e istruzioni inseriti dall'utente

            opcode = Opcode.fromOp(...);
            execute(opcode, params, registers);

        }


    }

    /**
     * Post-condizioni: data una lista di stringhe la converte in una lista di interi
     * @param args array di stringhe
     * @return lista di interi
     */
    public static List<Integer> stringToIntArrayList(String args){
        int j=0;
        List<Integer> program = new ArrayList<Integer>();
        for(int i = 0; i < args.length(); i++){
            int val = 0;
            while(args.charAt(j)!=','){
                val = val*10 + (args.charAt(j)-48) ;
                j++;
                if(j==args.length()) break;
            }
            program.add(i,val);
            j++;
            if(j>=args.length()) break;
        }
        return program;
    }


    /**
     * Post-condizioni: esegue l'operazione di opcode op, di parametri params e di registri registers se ne ha bisogno
     * @param op opcode
     * @param params parametri facoltativi
     * @param registers registri facoltativi
     */
    public static void execute(Opcode op, Memory.Location[] params, Registers registers){
       Instruction instr = op.toInstruction(params,registers);
       instr.execute();
    }

    /**
     * Post-condizioni: restituisce il nuovo valore di InstructionPointer che puntera' alla prossima istruzione
     * @param params i parametri dell'istruzione
     * @param registers i registri dell'istruzione
     * @return InstructionPointer
     */
    private static int NextInstruction(Memory.Location[] params,Registers registers){
        return registers.InstructionPointer = registers.InstructionPointer + params.length + 1;
    }

}
