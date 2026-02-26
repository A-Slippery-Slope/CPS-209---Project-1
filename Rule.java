public interface Rule {
    // Applies the rule to the given expression, modifying the expression to be its derivative. 
    // Returns true if the rule was successfully applied, and false if the rule was not applicable to the expression.
    public static boolean apply(Expression expression) { return false; }

    public static boolean isValid(Expression expression) { return false; }
}