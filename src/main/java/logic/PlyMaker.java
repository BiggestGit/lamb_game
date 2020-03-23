package logic;

import board.HexMap;
import errors.IncorrectDirectionException;
import errors.InsufficientPiecesException;

public class PlyMaker {
    private final HexMap hexMap;

    public PlyMaker(){
        this.hexMap = HexMap.builder().build();
    }

    /**
     * Moves pieces from one hex to another.
     * @param fromHex The hex that the pieces are moved from
     * @param toHex The hex that the pieces are moved to
     * @param amount the amount of hexes to be moved
     */
    private void movePieces(int fromHex, int toHex, int amount){
        int numberOfPieces = this.hexMap.getHex(fromHex).getPieces();
        if (numberOfPieces <= amount){
            throw new InsufficientPiecesException("The move is invalid. There are only " +
                                                  Integer.toString(numberOfPieces - 1) +
                                                  "pieces available. Tried to move " +
                                                  Integer.toString(amount));
        }
        this.hexMap.getHex(fromHex).setPieces(numberOfPieces - amount);
        this.hexMap.getHex(toHex).setPieces(amount);
    }

    /**
     * Checks if there are valid hexes in a given direction.
     * @param originX x coordinate of origin hex
     * @param originY y coordinate of origin hex
     * @param directionX direction of travel on x axis can be 1, 0 or -1
     * @param directionY direction of travel on y axis can be 1, 0 or -1
     * @return returns hash of closest valid hex
     */
    private int checkDirection(int originX, int originY, int directionX, int directionY){
        if ( directionX > 1 || directionY > 1 || directionX < -1 || directionY < -1){
            throw new IncorrectDirectionException("directional coordinates should be between -1 and 1 for both x and y." +
                                                  "instead directional coordinates were: x=" +
                                                  Integer.toString(directionX) +
                                                  " y= " +
                                                  Integer.toString(directionY));
        }
        int nextX = originX;
        int nextY = originY;
        int hashCode;
        while(true){
            nextX += directionX;
            nextY += directionY;
            hashCode = HexCalculator.calculateHash(nextX, nextY);
            if (this.hexMap.containsHex(hashCode)){
                if(this.hexMap.getHex(hashCode).getPieces() == 0){
                    return hashCode;
                }
            }
            else {
                return hashCode;
            }
        }
    }
}
