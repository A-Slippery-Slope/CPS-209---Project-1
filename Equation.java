public class Equation {
    private Expression left;
    private Expression right;

    // Creates an equation with the given left and right expressions.
    public Equation(Expression left, Expression right) {
        this.left = left;
        this.right = right; 
    }

    // Creates an equation with the given left and right types and variables.
    public Equation(Types left, Types right, char leftVar, char rightVar) {
        this.left = new Expression(left, leftVar);
        this.right = new Expression(right, rightVar); 
    }

    // Getters
    public Expression getLeft() {
        return left;
    }
    public Expression getRight() {
        return right;
    }

    // Returns a string showing the derivative of each expression seperatly and puts an = between them.
    public String differentiate() {
        return left.showDerivative(right.getVariable()) + " = " + right.showDerivative(right.getVariable());
    }

    @Override
    public String toString() {
        return left.toString() + " = " + right.toString();
    }
}
