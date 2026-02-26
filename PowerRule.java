public class PowerRule implements Rule {
    // Applies the power rule to the given expression, which must be a polynomial, multiplication, or quotient.
    public static boolean apply(Expression expression) {
        if (!isValid(expression)) return false;

        expression.getTerm(0).reduceDegree();
        for (int i = 0; i < expression.getTerm(0).getDegree() + 1; i++) {
            expression.getTerm(0).scaleCoefficient(i, i + 1);
        }
        if (expression.getType() == Types.MULTIPLICATION || expression.getType() == Types.QUOTIENT) {
            expression.getTerm(1).reduceDegree();
            for (int i = 0; i < expression.getTerm(1).getDegree() + 1; i++) {
                expression.getTerm(1).scaleCoefficient(i, i + 1);
            }
        }

        return true;
    }

    public static boolean isValid(Expression expression) {
        return expression.getType() == Types.POLYNOMIAL || expression.getType() == Types.MULTIPLICATION || expression.getType() == Types.QUOTIENT;
    }
}
