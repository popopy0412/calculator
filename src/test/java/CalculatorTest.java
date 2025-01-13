import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    static Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @Test
    @DisplayName("2 + 3 덧셈 연산 결과에 대한 정답 확인 테스트")
    void testAdd() {
        assertThat(calculator.add(2,3)).isEqualTo(5);
    }

    @Test
    @DisplayName("3 - 2 뺄셈 연산 결과에 대한 정답 확인 테스트")
    void testSubtract() {
        assertThat(calculator.subtract(3, 2)).isEqualTo(1);
    }

    @Test
    @DisplayName("2 * 3 곱셈 연산 결과에 대한 정답 확인 테스트")
    void testMultiply() {
        assertThat(calculator.multiply(2,3)).isEqualTo(6);
    }

    @Test
    @DisplayName("6 / 2 나눗셈 연산 결과에 대한 정답 확인 테스트")
    void testDivide() {
        assertThat(calculator.divide(6, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("0으로 나누기에 대한 예외 처리 확인 테스트")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(2, 0));
    }

    @Test
    @DisplayName("종합 계산 테스트 - 올바른 수식")
    void calculateWithValidExpression() {
        String expression = "2 + 3;4 * 5 / 3";
        int result = calculator.calculate(expression);
        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("종합 계산 테스트 - 올바른 수식(하나의 숫자만 포함)")
    void calculateWithValidExpressionOnlyOneNumber() {
        String expression = "2";
        int result = calculator.calculate(expression);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("종합 계산 테스트 - 올바르지 않은 수식 1")
    void calculateWithInValidExpression1() {
        String expression = "- 2 + 3;4 * 5 / 3";
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(expression));
    }

    @Test
    @DisplayName("종합 계산 테스트 - 올바르지 않은 수식 2")
    void calculateWithInValidExpression2() {
        String expression = ";2 + 3;4 * 5 / 3";
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(expression));
    }

    @Test
    @DisplayName("종합 계산 테스트 - 올바르지 않은 수식 3")
    void calculateWithInValidExpression3() {
        String expression = "2 ++ 3;4 * 5 / 3";
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(expression));
    }

    @Test
    @DisplayName("종합 계산 테스트 - 올바르지 않은 수식 4")
    void calculateWithInValidExpression4() {
        String expression = "2 + 3;4 * 5 / 3 /";
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(expression));
    }

    @Test
    @DisplayName("종합 계산 테스트 - 0으로 나누기가 존재하는 수식")
    void calculateWithExpressionIncludesDivideByZero() {
        String expression = "2 + 3;4 * 5 / 0 * 3";
        assertThrows(ArithmeticException.class, () -> calculator.calculate(expression));
    }

    @Test
    @DisplayName("종합 계산 테스트 - 빈 수식")
    void calculateWithEmptyExpression() {
        String expression = "";
        assertEquals(0, calculator.calculate(expression));
    }

    @Test
    @DisplayName("종합 계산 테스트 - null인 수식")
    void calculateWithNullExpression() {
        String expression = null;
        assertEquals(0, calculator.calculate(expression));
    }
}
