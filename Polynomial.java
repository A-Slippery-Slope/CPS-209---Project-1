import java.util.ArrayList;
import java.util.Arrays;

public class Polynomial extends Function {
    private ArrayList<Integer> coeff;
    private final char variable;
    
    public Polynomial(ArrayList<Integer> coefficients, char variable) {
        this.variable = variable;
        coeff = removeZeros(coefficients);

        function = this.toString();
    }

    private ArrayList<Integer> removeZeros(ArrayList<Integer> coefficients) {
        int length = coefficients.size();
        if (length == 0) return new ArrayList<>(Arrays.asList(0));
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            if (coefficients.get(i) == 0) length--;
            else break;
        }

        return new ArrayList<>(coefficients.subList(0, length));
    }
    
    public int getDegree() {
        return coeff.size() - 1;
    }
    public int getCoefficient(int k) {
        if (k < 0 || k > coeff.size() - 1) return 0;
        return coeff.get(k);
    }

    public void scaleCoefficient(int k, int scalar) {
        if (k < 0 || k > coeff.size() - 1) return;
        coeff.set(k, coeff.get(k) * scalar);
    }
    
    public long evaluate(int x) {
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

    public void reduceDegree() {
        coeff.remove(0);
    }

    public Polynomial add(Polynomial other) {
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
    public Polynomial subtract(Polynomial other) {
        if (this.variable != other.variable) { 
            super.subtract(other); 
            return this;
        }
        ArrayList<Integer> subtracted = new ArrayList<>(coeff);

        for (int i = 0; i < other.coeff.size(); i++) {
            if (i < subtracted.size()) subtracted.set(i, subtracted.get(i) - other.coeff.get(i));
            else subtracted.add(-other.coeff.get(i));
        }

        return new Polynomial(subtracted, variable);
    }
    public Polynomial foil(Polynomial other) {
        if (this.variable != other.variable) { 
            super.multiply(other); 
            return this;
        }
        ArrayList<Integer> multiplied = new ArrayList<>();

        for (int i = 0; i < coeff.size() + other.coeff.size(); i++) multiplied.add(0);

        for (int i = 0; i < coeff.size(); i++) {
            for (int j = 0; j < other.coeff.size(); j++) {
                multiplied.set(i + j, multiplied.get(i + j) + coeff.get(i) * other.coeff.get(j));
            }
        }

        return new Polynomial(multiplied, variable);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Polynomial) {
            Polynomial o = (Polynomial) other;
            if (this.variable != o.variable || this.getDegree() != o.getDegree()) return false;
            for (int i = 0; i < coeff.size(); i++) {
                if (this.coeff.get(i) != o.coeff.get(i)) return false;
            }
            return true;
        }
        
        return false;
    }

    @Override 
    public String toString() {
        String str = "";

        if (coeff.get(coeff.size() - 1) != 1 || coeff.size() == 1) str += coeff.get(coeff.size() - 1);
        if (coeff.size() - 1 >= 1) str += variable;
        if (coeff.size() - 1 > 1) str += "^" + (coeff.size() - 1);
        for (int i = coeff.size() - 2; i >= 0; i--) {
            if (coeff.get(i) != 0) {
                if (i != 0 && Math.abs(coeff.get(i)) == 1) str += coeff.get(i) < 0 ? " - " : " + ";
                else str += coeff.get(i) < 0 ? " - " + Math.abs(coeff.get(i)) : " + " + coeff.get(i);
                
                if (i >= 1) str += variable;
                if (i > 1) str += "^" + i;
            }
        }

        return str;
    }
}