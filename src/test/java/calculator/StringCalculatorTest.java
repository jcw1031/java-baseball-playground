package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @CsvSource(value = {"2 + 3 * 4 / 2:10", "3 * 6 / 5 - 2:1.6"}, delimiter = ':')
    @ParameterizedTest
    void calculate(String formula, double expected) {
        double actual = calculator.calculate(formula);
        assertThat(actual).isEqualTo(expected);
    }
}