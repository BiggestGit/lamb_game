package logic;

import org.junit.Assert;
import org.junit.Test;

public class HexCalculatorUnitTest {

    @Test
    public void calculateHashX0Y0Test() {
        Assert.assertEquals(0 ,HexCalculator.calculateHash(0, 0));
    }
    @Test
    public void calculateHashX0Y1Test() {
        Assert.assertEquals(1 ,HexCalculator.calculateHash(0, 1));
    }
    @Test
    public void calculateHashX1Y0Test() {
        Assert.assertEquals(257 ,HexCalculator.calculateHash(1, 0));
    }
    @Test
    public void calculateHashX0YMinus1Test() {
        Assert.assertEquals(-1 ,HexCalculator.calculateHash(0, -1));
    }
    @Test
    public void calculateHashMinusX1Y0Test() {
        Assert.assertEquals(-257 ,HexCalculator.calculateHash(-1, 0));
    }
    @Test
    public void calculateHashMinusX1Y1Test() {
        Assert.assertEquals(-256 ,HexCalculator.calculateHash(-1, 1));
    }
    @Test
    public void calculateHashX1MinusY1Test() {
        Assert.assertEquals(256 ,HexCalculator.calculateHash(1, -1));
    }
}