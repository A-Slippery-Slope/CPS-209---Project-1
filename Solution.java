public class Solution {
    private Equation solution;
    private String steps;

    // Creates a solution for the given problem and generates the steps to solve it.
    public Solution(Problem problem) {
        this.solution = problem.getEquation();
        this.steps = "";
        String beforeDerivative = solution.differentiate();
        
        steps += "\nThe solution steps are:";

        switch (solution.getRight().getType()) {
            case MULTIPLICATION -> {
                steps += "\n1. Use the product rule: (f * g)' = f' * g + f * g'";

                ProductRule.apply(solution.getRight());
            }
            case QUOTIENT -> {
                steps += "\n1. Use the quotient rule: (f / g)' = (f' * g - f * g') / g^2";

                QuotientRule.apply(solution.getRight());
            }
            case POLYNOMIAL -> {
                steps += "\n1. Use the power rule: (x^n)' = n * x^(n-1)";

                PowerRule.apply(solution.getRight());
            }
        }

        steps += "\n2. " + beforeDerivative;
        steps += "\n3. dy/d" + solution.getRight().getVariable() + " = " + solution.getRight() + "\n";
    }
    
    // Checks if the given answer is correct by comparing it to the solution's right expression, ignoring whitespace and case.
    public boolean isCorrect(String answer) {
        answer = answer.replaceAll("\\s+", "").toLowerCase();
        String correct = solution.getRight().toString().replaceAll("\\s+", "");
        String altCorrect = "dy/d" + solution.getRight().getVariable() + "=" + correct;
        
        return answer.equals(correct) || answer.equals(altCorrect);
    }
    
    // Getter
    public Equation getSolution() {
        return solution;
    }

    @Override
    public String toString() {
        return steps;
    }
}
