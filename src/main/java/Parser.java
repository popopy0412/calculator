public class Parser {
    public String[] parse(String expression) {
        if (expression == null || expression.isEmpty()) return null;
        String[] tokens = expression.replaceAll("[,;]", " + ").trim().split(" ");
        return tokens;
    }
}
