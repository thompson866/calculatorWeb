package pro.sky.culculatorplus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import pro.sky.culculatorplus.exception.DelByZeroException;

import java.security.DigestException;

public class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    //@Disabled//
    public void plusTest() {
        Number actual = calculatorService.plus(5, 5);
        Number expected = 10;
        Assertions.assertEquals(expected, actual);


        actual = calculatorService.plus(-1, 2);
        expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void minusTest() {
        Number actual = calculatorService.minus(5, 5);
        Number expected = 0;
        Assertions.assertEquals(expected, actual);


        actual = calculatorService.minus(-1, 2);
        expected = -3;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void multiplyTest() {
        Number actual = calculatorService.multiply(5, 5);
        Number expected = 25;
        Assertions.assertEquals(expected, actual);


        actual = calculatorService.multiply(-1, 2);
        expected = -2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void divideTest() {
        Number actual = calculatorService.divide(5, 5);
        Number expected = 1.0;
        Assertions.assertEquals(expected, actual);


        actual = calculatorService.divide(-1, 2);
        expected = -0.5;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void plusNegativeTest() {


        Assertions.assertThrows(DelByZeroException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                calculatorService.divide(1, 0);
            }
        });
        Assertions.assertThrows(DelByZeroException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                calculatorService.divide(-1, 0);
            }
        });
    }


}
