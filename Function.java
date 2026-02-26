import java.util.ArrayList;

public class Function {
    protected static String function;
    protected static ArrayList<Function> terms;
    
    // Default constructor, creates an empty function.
    public Function() {
        function = "";
        terms = new ArrayList<>();
    }

    // If project were to be expanded to multiple types of functions, 
    // this ArrayList would be used to store non-combinable functions
    public Function(Function other) {
        terms.add(other);
        function = other.toString();
    }

    // Adds, subtracts, multiplies, or divides this function with another function.
    public void add(Function other) {
        terms.add(other);
        function += " + " + other.toString();
    }
    public void subtract(Function other) {
        terms.add(other);
        function += " - " + other.toString();
    }
    public void multiply(Function other) {
        terms.add(other);
        function += " * " + other.toString();
    }
    public void divide(Function other) {
        terms.add(other);
        function += " / " + other.toString();
    }

    @Override
    public String toString() {
        return function;
    }
}
