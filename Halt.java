public class Halt implements Instruction{
    @Override
    public void execute() {
        return;
    }

    @Override
    public boolean isHalting() {
        return true;
    }
}
