import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    static Parser parser;

    @BeforeEach
    void setUp() {
        parser = new Parser();
    }

    @AfterEach
    void tearDown() {
        parser = null;
    }

    @Test
    @DisplayName("올바른 수식 파싱 결과")
    void parseWithValidExpression() {
        String expression = "1 + 2;3 * 2 / 3";
        String[] tokens = parser.parse(expression);
        assertArrayEquals(new String[]{"1", "+", "2", "+", "3", "*", "2", "/", "3"}, tokens);
    }

    @Test
    @DisplayName("올바르지 않은 수식 파싱 결과")
    void parseWithInvalidExpression() {
        String expression = ";2,1";
        String[] tokens = parser.parse(expression);
        assertArrayEquals(new String[]{"+", "2", "+", "1"}, tokens);
    }

    @Test
    @DisplayName("비어있는 수식 파싱 결과")
    void parseWithEmptyExpression() {
        String expression = "";
        String[] tokens = parser.parse(expression);
        assertArrayEquals(null, tokens);
        assertNull(tokens);
    }

    @Test
    @DisplayName("null인 수식 파싱 결과")
    void parseWithNullExpression() {
        String expression = null;
        String[] tokens = parser.parse(expression);
        assertArrayEquals(null, tokens);
        assertNull(tokens);
    }
}