package pro.sky.culculatorplus;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.culculatorplus.exception.DelByZeroException;

import java.util.stream.Stream;

public class CalculatorParameterizedTest {
//assertJ
    private final CalculatorService calculatorService = new CalculatorService();

    public static Stream<Arguments> plusTestParams() {
        return Stream.of(Arguments.of(5, 5, 10),
                Arguments.of(4, 0, 4),
                Arguments.of(-1, -2, -3)
        );
    }

    public static Stream<Arguments> minusTestParams() {
        return Stream.of(Arguments.of(5, 5, 0),
                Arguments.of(4, 0, 4),
                Arguments.of(-1, -2, 1)
        );
    }

    public static Stream<Arguments> multiplyTestParams() {
        return Stream.of(Arguments.of(5, 5, 25),
                Arguments.of(4, 0, 0),
                Arguments.of(-1, -2, 2)
        );
    }

    public static Stream<Arguments> divideTestParams() {
        return Stream.of(Arguments.of(5, 5, 1.0),
                Arguments.of(0, 4, 0.0),
                Arguments.of(-1, -2, 0.5)
        );
    }

    public static Stream<Arguments> divideNegativeTestParams() {
        return Stream.of(Arguments.of(5, 0),
                Arguments.of(4, 0),
                Arguments.of(-1, 0));
    }

    @ParameterizedTest
    @MethodSource("plusTestParams")
    //@Disabled//
    public void plusTest(int num1, int num2, int expected) {
        Assertions.assertThat(calculatorService.plus(num1, num2))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("minusTestParams")

    public void minusTest(int num1, int num2, int expected) {
        Assertions.assertThat(calculatorService.minus(num1, num2))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("multiplyTestParams")
    public void multiplyTest(int num1, int num2, int expected) {
        Assertions.assertThat(calculatorService.multiply(num1, num2))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("divideTestParams")
    public void divideTest(int num1, int num2, Number expected) {
        Assertions.assertThat(calculatorService.divide(num1,num2)).isEqualTo(expected);}

    @ParameterizedTest
    @MethodSource("divideNegativeTestParams")
    public void divideTest(int num1, int num2) {
        Assertions.assertThatExceptionOfType(DelByZeroException.class)
                .isThrownBy(() -> calculatorService.divide(num1, num2));
    }
}
