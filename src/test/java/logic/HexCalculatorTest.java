package logic;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HexCalculatorTest {

    @Test
    public void calculateHashX0Y0Test() {
        Assert.assertEquals(0 ,HexCalculator.calculateHash(0, 0));
    }
    @Test
    public void calculateHashX0Y1Test() {
        Assert.assertEquals(0 ,HexCalculator.calculateHash(0, 1));
    }
    @Test
    public void calculateHashX1Y0Test() {
        Assert.assertEquals(0 ,HexCalculator.calculateHash(1, 0));
    }
    @Test
    public void calculateHashX0YMinus1Test() {
        Assert.assertEquals(0 ,HexCalculator.calculateHash(0, -1));
    }
    @Test
    public void calculateHashMinusX0Y0Test() {
        Assert.assertEquals(0 ,HexCalculator.calculateHash(-1, 0));
    }
}