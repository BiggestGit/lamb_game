package logic;

import board.Hex;
import board.HexMap;
import errors.IncorrectDirectionException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

@Getter @AllArgsConstructor
public class PlyMaker {
    //TODO figure our how to make final without breaking mock
    private final HexMap hexMap;
    private final HashMap<Integer, Integer> activeNodesPlayer1;
    private final HashMap<Integer, Integer> activeNodesPlayer2;

    /**
     * Checks if there are valid hexes in a given direction.
     * @param originX x coordinate of origin hex
     * @param originY y coordinate of origin hex
     * @param directionX direction of travel on x axis can be 1, 0 or -1
     * @param directionY direction of travel on y axis can be 1, 0 or -1
     * @param originHex hash of the hex that we are checking from
     * @return returns hash of furthest valid hex or originHex if it doesn't exist.
     */
    //TODO make directional check dependent on coordinates rather than a contains function.
    public int checkDirection(int originX, int originY, int directionX, int directionY, int originHex){
        if ( directionX > 1 || directionY > 1 || directionX < -1 || directionY < -1){
            throw new IncorrectDirectionException("directional coordinates should be between -1 and 1 for both x and y." +
                                                  "instead directional coordinates were: x=" +
                                                  Integer.toString(directionX) +
                                                  " y= " +
                                                  Integer.toString(directionY));
        }
        int nextX = originX;
        int nextY = originY;
        int previous = originHex;
        int current;
        while(true){
            nextX += directionX;
            nextY += directionY;
            current = HexCalculator.calculateHash(nextX, nextY);
            if (this.hexMap.containsHex(current)){

                if(this.hexMap.getHex(current).getPieces() == 0){
                    previous = current;
                }
                else{
                    return previous;
                }
            }
            else {
                return previous;
            }
        }
    }

    //TODO toteuta loppuun
    public int evaluateHexesForOrigin(int player) {
        int freedoms;
        int highestComparativeValue = -7000;
        int currentComparativeValue  = -7000;
        if (player == 1){
            for (Map.Entry<Integer, Integer> entry: this.activeNodesPlayer1.entrySet()) {
                freedoms = this.checkFreedoms(entry.getKey());

                if (highestComparativeValue < currentComparativeValue){

                }
            }
        }
        else {
            for (Map.Entry<Integer, Integer> entry: this.activeNodesPlayer2.entrySet()) {

            }
        }

        return 0;
    }


    /**
     * Checks for freedoms of give hex.
     * @param origin the tile of which to calculate the freedoms of
     * @return number of  freedoms of the hex
     */
    private int checkFreedoms(int origin){
        return -1;
    }

    public AbstractMap.SimpleImmutableEntry<Integer, Integer> evaluateFromHexForTarget() {
        return new AbstractMap.SimpleImmutableEntry<>(1, 1);
    }

    public void transferPieces(int fromHex, int toHex, int amount) {
        this.hexMap.transferPieces(fromHex, toHex, amount);
    }
}
