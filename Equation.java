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

    @Override
    public String toString() {
        return left.toString() + " = " + right.toString();
    }
}
