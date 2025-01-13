import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        Calculator calculator = new Calculator();
        try {
            int answer = calculator.calculate(expression);
            System.out.printf("Answer: %d%n", answer);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
