public class Expression {
    private Polynomial[] terms;
    private Types type;
    private char variable;
    
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
                break;
            case NEITHER:
                this.terms = new Polynomial[1];
                break;
            default:
                throw new AssertionError();
        }

        randomizeTerms();
    }

    public Polynomial getTerm(int k) {
        if (k < 0 || k > terms.length - 1) return null;
        return terms[k];
    }

    public void randomizeTerms() {
        for (int i = 0; i < terms.length; i++) {
            int degree = (int)(Math.random() * 5) + 1;
            int[] coeffs = new int[degree + 1];

            for (int j = 0; j < coeffs.length; j++) {
                coeffs[j] = (int)(Math.random() * 20) - 10;
            }

            terms[i] = new Polynomial(coeffs, variable);
        }
    }
}
