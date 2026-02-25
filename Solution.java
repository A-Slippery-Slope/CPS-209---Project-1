public class Solution {
    Equation solution;

    public Solution(Problem problem) {
        this.solution = problem.getEquation();

        System.out.println("The solution steps are:");

        switch (problem.getType()) {
            
        }
    }
    @Override
    public String toString() {
        return solution.toString();
    }
}
