public class PowerRule implements Rule {
    public static boolean apply(Expression expression) {
        if (!isValid(expression)) return false;

        
    }

    public static boolean isValid(Expression expression) {
        return expression.getType() == Types.POLYNOMIAL;
    }
}
