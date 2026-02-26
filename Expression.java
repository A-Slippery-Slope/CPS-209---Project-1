import java.util.ArrayList;

public class Expression {
    private Polynomial[] terms;
    private Types type;
    private final char variable;
    
    // Creates an expression of the given type and variable. If the type is not DEPENDANT, the terms are randomized.
    public Expression(Types type, char variable) {
        this.type = type;
        this.variable = variable;
        switch (type) {
            case MULTIPLICATION:
                this.terms = new Polynomial[2];
                break;
            case QUOTIENT:
                this.terms = new Polynomial[2];
                break;
            case DEPENDANT:
                this.terms = new Polynomial[1];
                ArrayList<Integer> coeffs = new ArrayList<>();
                coeffs.add(0);
                coeffs.add(1);
                terms[0] = new Polynomial(coeffs, variable);
                break;
            case POLYNOMIAL:
                this.terms = new Polynomial[1];
                break;
            default:
                throw new AssertionError();
        }

        if (type != Types.DEPENDANT) randomizeTerms();
    }

    // Getters and setters
    public Polynomial getTerm(int k) {
        if (k < 0 || k > terms.length - 1) return null;
        return terms[k];
    }

    public void setTerm(int k, Polynomial term) {
        if (k < 0 || k > terms.length - 1) return;
        terms[k] = term;
    }
    public Types getType() {
        return type;
    }
    public char getVariable() {
        return variable;
    }

    // Converts the expression to a polynomial, which is only valid if the expression is currently a multiplication.
    public void multToPoly() {
        if (type != Types.MULTIPLICATION) return;
        
        this.type = Types.POLYNOMIAL;
        this.terms = new Polynomial[] {terms[0]};
    }

    // Randomizes the coefficients of the terms in the expression.
    public void randomizeTerms() {
        for (int i = 0; i < terms.length; i++) {
            int degree = (int)(Math.random() * 3) + 2;
            ArrayList<Integer> coeffs = new ArrayList<>();

            for (int j = 0; j < degree + 1; j++) {
                coeffs.add((int)(Math.random() * 20) - 10);
            }

            terms[i] = new Polynomial(coeffs, variable);
        }
    }

    // Returns a string showing the derivative of this expression.
    public String showDerivative(char variable) {
        String str = "";
        switch (type) {
            case MULTIPLICATION -> str = "(" + terms[0] + ")' * (" + terms[1] + ") + (" + terms[0] + ") * (" + terms[1] + ")'";
            case QUOTIENT -> str = "((" + terms[0] + ")' * (" + terms[1] + ") - (" + terms[0] + ") * (" + terms[1] + ")') / (" + terms[1] + ")^2";
            case DEPENDANT -> str = "dy/d" + variable;
            case POLYNOMIAL -> str = "d/d" + variable + "(" + toString() + ")";
        }
        return str;
    }

    @Override
    public String toString() {
        String str = "";
        
        switch (type) {
            case MULTIPLICATION -> str = "(" + terms[0].toString() + ") * (" + terms[1].toString() + ")";
            case QUOTIENT -> str = "(" + terms[0].toString() + ") / (" + terms[1].toString() + ")";
            case DEPENDANT -> str = terms[0].toString();
            case POLYNOMIAL -> str = terms[0].toString();
            default -> throw new AssertionError();
        }

        return str;
    }
}
