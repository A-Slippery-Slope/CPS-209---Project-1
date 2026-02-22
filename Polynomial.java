public class Polynomial extends Function {
    private int[] coefficients;
    
    // Creates a non-zero polynomial with all random degree and coefficients
    public Polynomial() {
        super(); // Call the parent constructor
        
        // Generate a random degree between 1 and 6
        int degree = (int)(Math.random() * 6) + 1;
        coefficients = new int[degree + 1];
        for (int i = 0; i <= degree; i++) {
            coefficients[i] = (int)(Math.random() * 25) + 1; // Coefficients between 1 and 25
        }
    }
    public Polynomial(int[] coefficients) {
        super(); // Call the parent constructor

        int traveller = coefficients.length - 1;
        while (traveller > 0 && coefficients[traveller] == 0) {
            traveller--;
        }
        int[] coeff = new int[traveller + 1];
        System.arraycopy(coefficients, 0, coeff, 0, traveller + 1);
        this.coefficients = coeff;
    }

    public Polynomial add(Polynomial other) {

    }
}
