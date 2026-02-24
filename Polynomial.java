public class Polynomial extends Function {
    private final int[] coeff;
    private final char variable;
    
    public Polynomial(int[] coefficients, char variable) 
    {
        this.variable = variable;
        coeff = removeZeros(coefficients);

        function = this.toString();
    }

    private int[] removeZeros(int[] coefficients) {
        int length = coefficients.length;
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] == 0) length--;
            else break;
        }

        if (length < 1) length = 1;
        
        int[] c = new int[length];

        System.arraycopy(coefficients, 0, c, 0, length);

        return c;
    }
    
    public int getDegree() 
    {
        return coeff.length - 1;
    }
    
    public int getCoefficient(int k) 
    {
        if (k < 0 || k > coeff.length - 1) return 0;
        return coeff[k];
    }
    
    public long evaluate(int x)
    {
        long sum = 0;
        for (int i = 0; i < coeff.length; i++) {
            long temp = 1;
            for (int j = 0; j < i; j++) {
                temp *= x;
            }
            sum += temp * coeff[i];
        }

        return sum;
    }

    public Polynomial add(Polynomial other) 
    {
        if (this.variable != other.variable) { 
            super.add(other); 
            return this;
        }
        int[] added = new int[Math.max(getDegree(), other.getDegree()) + 1];

        for (int i = 0; i < added.length; i++) {
            added[i] = getCoefficient(i) + other.getCoefficient(i);
        }

        return new Polynomial(added, variable);
    }

    @Override 
    public String toString()    
    {
        String str = "";

        str += coeff[coeff.length - 1];
        if (coeff.length - 1 >= 1) str += variable;
        if (coeff.length - 1 > 1) str += "^" + (coeff.length - 1);
        for (int i = coeff.length - 2; i >= 0; i--) {
            if (coeff[i] != 0) {
                str += coeff[i] < 0 ? " - " + Math.abs(coeff[i]) : " + " + coeff[i];
                if (i >= 1) str += variable;
                if (i > 1) str += "^" + i;
            }
        }

        return str;
    }
}
