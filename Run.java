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
        fullcode = stringToIntArrayList(args[0]);
        //inizializzo la memoria
        Memory memoria = new Memory(fullcode);
        //prima istruzione
        opcode = Opcode.fromOp(fullcode.get(0));
        while(isHalting == false) {
            //creo la memoria contenente tutti i parametri e istruzioni inseriti dall'utente
            decode
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





    public static void execute(Opcode op, Memory.Location[] params, Registers registers){

        switch (op){
            case ADD:
                break;
            case MULTIPLY:
                break;
            case READ:
                break;
            case WRITE:
                break;
            case JUMP_NOT_ZERO:
                JumpIfNotZero istr = new JumpIfNotZero(params,registers);

                istr.execute();
                break;
            case JUMP_ZERO:
                break;
            case LESS_THAN:
                break;
            case EQUALS:
                break;
            case ADJ_RBP:
                break;
            case HALT:
                break;
        }
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
