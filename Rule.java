public interface Rule {
    public static boolean apply(Expression expression) { return false; }

    public static boolean isValid(Expression expression) { return false; }
}