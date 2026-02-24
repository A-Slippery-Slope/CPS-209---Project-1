public class Function {
    protected static String function;
    
    public Function() {}

    public String getFunction() {
        return function;
    }

    public void add(Function other) {
        function += " + " + other.getFunction();
    }
    public void subtract(Function other) {
        function += " - " + other.getFunction();
    }
    public void multiply(Function other) {
        function += " * " + other.getFunction();
    }
    public void divide(Function other) {
        function += " / " + other.getFunction();
    }

    @Override
    public String toString() {
        return function;
    }
}
