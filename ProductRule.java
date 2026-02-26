import java.util.ArrayList;

public class ProductRule implements Rule {
    public static boolean apply(Expression expression) {
        if (!isValid(expression)) return false;

        Polynomial f = expression.getTerm(0).add(new Polynomial(new ArrayList<>(), expression.getVariable()));
        Polynomial g = expression.getTerm(1).add(new Polynomial(new ArrayList<>(), expression.getVariable()));;
        
        PowerRule.apply(expression);

        Polynomial fPrime = expression.getTerm(0);
        Polynomial gPrime = expression.getTerm(1);

        expression.setTerm(0, f.foil(gPrime).add(g.foil(fPrime)));
        expression.multToPoly();

        return true;
    }

    public static boolean isValid(Expression expression) {
        return expression.getType() == Types.MULTIPLICATION;
    }
    
}
