public class Solution {
    private Equation solution;
    private String steps;

    // Creates a solution for the given problem and generates the steps to solve it.
    public Solution(Problem problem) {
        this.solution = problem.getEquation();
        this.steps = "";

        steps += "\nThe solution steps are:\n1. " + solution.differentiate();

        switch (solution.getRight().getType()) {
            case MULTIPLICATION -> {
                steps += "\n2. Use the product rule: (f * g)' = f' * g + f * g'\n";

                ProductRule.apply(solution.getRight());
            }
            case QUOTIENT -> {
                steps += "\n2. Use the quotient rule: (f / g)' = (f' * g - f * g') / g^2\n";

                QuotientRule.apply(solution.getRight());
            }
            case POLYNOMIAL -> {
                steps += "\n2. Use the power rule: (x^n)' = n * x^(n-1)\n";

                PowerRule.apply(solution.getRight());
            }
        }

        steps += "3. dy/d" + solution.getRight().getVariable() + " = " + solution.getRight() + "\n";
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
