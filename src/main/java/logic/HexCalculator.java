package logic;

import errors.IncorrectDirectionException;

public class HexCalculator {

    /**
     * Calculates a very simple hash for a Hex. The prime number chosen is very small to make calculations faster.
     * There is no danger of collision since the greatest y value can be is 8. Technically a smaller prime would do
     * just fine.
     * @param x x coordinate of the hex.
     * @param y y coordinate of the hex.
     * @return new hash.
     */
    public static int calculateHash(int x, int y){
        return x*257+y;
    }

//    /**
//     * Returns the hash of the next Hex in given direction
//     * @param currentX the x coordinate of the hex that is departed from
//     * @param currentY the y coordinate of the hex that is departed from
//     * @param xDirection the x offset from the hex
//     * @param yDirection the y offset from the hex
//     * @return returns the hash of the next hex
//     */
//    public static int nextHexHash(int currentX, int currentY, int xDirection, int yDirection){
//        if ( currentX > 1 || currentY > 1 || currentX < -1 || currentY < -1){
//            throw new IncorrectDirectionException("directional coordinates should be between -1 and 1 for both x and y." +
//                    "instead directional coordinates were: x=" +
//                    Integer.toString(currentX) +
//                    " y= " +
//                    Integer.toString(currentY));
//        }
//        return calculateHash(currentX + xDirection, currentY + yDirection);
//    }
}
