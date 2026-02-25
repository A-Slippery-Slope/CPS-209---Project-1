public class PowerRule implements Rule {
    public static boolean apply(Expression expression, char varRespectTo) {
        if (!isValid(expression)) return false;

        if (expression.getVariable() != varRespectTo) {
            while (expression.getTerm(0).getDegree() > 1) expression.getTerm(0).reduceDegree();
            expression.getTerm(0).scaleCoefficient(0, 0);
            return true;
        }

        expression.getTerm(0).reduceDegree();
        for (int i = 0; i < expression.getTerm(0).getDegree(); i++) {
            expression.getTerm(0).scaleCoefficient(i, i + 1);
        }
        return true;
    }

    public static boolean isValid(Expression expression) {
        return expression.getType() == Types.POLYNOMIAL;
    }
}
