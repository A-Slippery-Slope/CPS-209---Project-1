import java.util.ArrayList;

public class Polynomial extends Function {
    private ArrayList<Integer> coeff;
    private final char variable;
    
    public Polynomial(ArrayList<Integer> coefficients, char variable) 
    {
        this.variable = variable;
        coeff = removeZeros(coefficients);

        function = this.toString();
    }

    private ArrayList<Integer> removeZeros(ArrayList<Integer> coefficients) {
        int length = coefficients.size();
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            if (coefficients.get(i) == 0) length--;
            else break;
        }

        return new ArrayList<>(coefficients.subList(0, length));
    }
    
    public int getDegree() 
    {
        return coeff.size() - 1;
    }
    
    public int getCoefficient(int k) 
    {
        if (k < 0 || k > coeff.size() - 1) return 0;
        return coeff.get(k);
    }
    
    public long evaluate(int x)
    {
        long sum = 0;
        for (int i = 0; i < coeff.size(); i++) {
            long temp = 1;
            for (int j = 0; j < i; j++) {
                temp *= x;
            }
            sum += temp * coeff.get(i);
        }

        return sum;
    }

    public Polynomial add(Polynomial other) 
    {
        if (this.variable != other.variable) { 
            super.add(other); 
            return this;
        }
        ArrayList<Integer> added = new ArrayList<>(coeff);

        for (int i = 0; i < other.coeff.size(); i++) {
            if (i < added.size()) added.set(i, added.get(i) + other.coeff.get(i));
            else added.add(other.coeff.get(i));
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
