public class Equation {
    private Expression left;
    private Expression right;

    public Equation(Expression left, Expression right) {
        this.left = left;
        this.right = right; 
    }
    public Equation(Types left, Types right, char leftVar, char rightVar) {
        this.left = new Expression(left, leftVar);
        this.right = new Expression(right, rightVar); 
    }

    public Expression getLeft() {
        return left;
    }
    public Expression getRight() {
        return right;
    }

    public String differentiate() {
        return left.showDerivative(right.getVariable()) + " = " + right.showDerivative(right.getVariable());
    }

    @Override
    public String toString() {
        return left.toString() + " = " + right.toString();
    }
}
