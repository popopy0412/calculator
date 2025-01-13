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
}
