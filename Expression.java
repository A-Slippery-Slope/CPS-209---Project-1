import java.util.ArrayList;

public class Expression {
    private Polynomial[] terms;
    private final Types type;
    private final char variable;
    
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

    public Polynomial getTerm(int k) {
        if (k < 0 || k > terms.length - 1) return null;
        return terms[k];
    }

    public Types getType() {
        return type;
    }

    public char getVariable() {
        return variable;
    }

    public void randomizeTerms() {
        for (int i = 0; i < terms.length; i++) {
            int degree = (int)(Math.random() * 4) + 2;
            ArrayList<Integer> coeffs = new ArrayList<>();

            for (int j = 0; j < degree + 1; j++) {
                coeffs.add((int)(Math.random() * 20) - 10);
            }

            terms[i] = new Polynomial(coeffs, variable);
        }
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
