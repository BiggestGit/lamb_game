package logic;

public class HexCalculator {

    /**
     * calculates a very simple hash for a Hex. The prime number chosen is very small to make calculations faster.
     * There is no danger of collision since the creates y is going to be is 8. Technically a smaller prime would do
     * just fine.
     * @param x x coordinate of the hex.
     * @param y y coordinate of the hex.
     * @return new hash.
     */
    public static int calculateHash(int x, int y){
        return x*257+y;
    }
}
