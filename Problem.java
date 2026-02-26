public class Problem {
    private String problem;
    private Equation equation;
    private Types rightType, leftType;
    private final char leftVar, rightVar;
    
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
    public Problem(Types type) {
        this.problem = "";

        leftType = Types.DEPENDANT;
        leftVar = 'y';

        this.rightType = type;
        rightVar = (char)((int)(Math.random() * 3) + 118);

        generateProblem();
    }
    
    public void generateProblem() {
        equation = new Equation(leftType, rightType, leftVar, rightVar);
        this.problem = equation.toString();
    }

    public Equation getEquation() {
        return equation;
    }

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