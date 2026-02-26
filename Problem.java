public class Problem {
    private String problem;
    private Equation equation;
    private Types rightType, leftType;
    private final char leftVar, rightVar;
    
    // Creates a problem with a random type of right expression and a dependant left expression, which is always y. 
    // The variable for the right expression is randomly selected from v, w, and x.
    public Problem() {
        this.problem = "";

        leftType = Types.DEPENDANT;
        leftVar = 'y';

        while (rightType == null || rightType == Types.DEPENDANT) {
            rightType = Types.values()[(int)(Math.random() * Types.values().length)];
        }
        rightVar = (char)((int)(Math.random() * 3) + 118);

        generateProblem();
    }

    // Creates a problem with the given type of right expression and a dependant left expression, which is always y.
    public Problem(Types type) {
        this.problem = "";

        leftType = Types.DEPENDANT;
        leftVar = 'y';

        this.rightType = type;
        rightVar = (char)((int)(Math.random() * 3) + 118);

        generateProblem();
    }
    
    // Generates the problem by creating an equation with the given types and variables for the left and right expressions, and converting it to a string.
    public void generateProblem() {
        equation = new Equation(leftType, rightType, leftVar, rightVar);
        this.problem = equation.toString();
    }

    // Getter
    public Equation getEquation() {
        return equation;
    }

    // Returns a string describing the problem, which includes the problem itself and instructions on how to solve it based on the type of the right expression.
    @Override
    public String toString() {
        String str = "";

        switch (rightType) {
            case MULTIPLICATION -> str = "Find the derivative of " + problem + ", wrt " + rightVar + " using the product rule.";
            case QUOTIENT -> str = "Find the derivative of " + problem + ", wrt " + rightVar + " using the quotient rule.";
            case DEPENDANT -> str = "Find the derivative of " + problem + ", wrt " + rightVar + ".";
            case POLYNOMIAL -> str = "Find the derivative of " + problem + ", wrt " + rightVar + " using the power rule.";
        }

        return str;
    } 
}