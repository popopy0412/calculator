import java.util.Arrays;

public class Calculator {
    int add(int i, int j) {
        return i + j;
    }

    int subtract(int i, int j) {
        return i - j;
    }

    int multiply(int i, int j) {
        return i * j;
    }

    int divide(int i, int j) {
        return i / j;
    }

    public int calculate(String expression) {
        if (expression == null || expression.isEmpty()) return 0;

        Parser parser = new Parser();
        String[] tokens = parser.parse(expression);
        int answer = 0;

        int validExpressionCode = checkValidExpression(tokens);

        if (validExpressionCode == -1) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        } else if (validExpressionCode == 0) {
            return 0;
        } else {
            answer = Integer.parseInt(tokens[0]);
            for (int i = 1; i < tokens.length; i+=2) {
                char operator = tokens[i].charAt(0);
                int operand = Integer.parseInt(tokens[i+1]);

                if (operator == '+') {
                    answer = add(answer, operand);
                } else if (operator == '-') {
                    answer = subtract(answer, operand);
                } else if (operator == '*') {
                    answer = multiply(answer, operand);
                } else if (operator == '/') {
                    try {
                        answer = divide(answer, operand);
                    } catch (ArithmeticException e) {
                        throw new ArithmeticException("You cannot divide by zero: " + Arrays.toString(tokens));
                    }
                } else {
                    throw new IllegalArgumentException("Invalid operator: " + operator);
                }
            }
            return answer;
        }
    }

    private int checkValidExpression(String[] tokens) {
        // -1 : 수식이 잘못 이루어져 있음
        // 0 : 수식이 비어있거나 null임
        // 1 : 올바른 수식
        if (tokens == null || tokens.length == 0) return 0;
        else if (!tokens[0].matches("[0-9]") || tokens.length % 2 == 0) return -1;
        for (int i = 0; i < tokens.length; i+=2) {
            String operand = tokens[i];
            if (!operand.matches("[0-9]")) return -1;

            if (i+1 < tokens.length) {
                String operator = tokens[i+1];
                if (!operator.matches("^[^+\\-/*]*([+\\-/*])[^+\\-/*]*$")) return -1;
            }
        }
        return 1;
    }
}