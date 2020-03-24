package logic;

import board.HexMap;
import errors.IncorrectDirectionException;
import errors.InsufficientPiecesException;

public class PlyMaker {
    //TODO figure our how to make final without breaking mock
    private HexMap hexMap;

    public PlyMaker(){
        this.hexMap = new HexMap();
    }

    /**
     * Moves pieces from one hex to another.
     * @param fromHexHash The hex that the pieces are moved from
     * @param toHexHash The hex that the pieces are moved to
     * @param amountMoved the amountMoved of hexes to be moved
     */
    public void movePieces(int fromHexHash, int toHexHash, int amountMoved){
        int numberOfPiecesOnHex = this.hexMap.getHex(fromHexHash).getPieces();
        if (numberOfPiecesOnHex <= amountMoved){
            throw new InsufficientPiecesException("The move is invalid. There are only " +
                                                  Integer.toString(numberOfPiecesOnHex - 1) +
                                                  " pieces available. Tried to move " +
                                                  Integer.toString(amountMoved));
        }
        this.hexMap.getHex(fromHexHash).setPieces(numberOfPiecesOnHex - amountMoved);
        this.hexMap.getHex(toHexHash).setPieces(amountMoved);
    }

    /**
     * Checks if there are valid hexes in a given direction.
     * @param originX x coordinate of origin hex
     * @param originY y coordinate of origin hex
     * @param directionX direction of travel on x axis can be 1, 0 or -1
     * @param directionY direction of travel on y axis can be 1, 0 or -1
     * @return returns hash of closest valid hex
     */
    //TODO make directional check dependent on coordinates rather than a contains function.
    public int checkDirection(int originX, int originY, int directionX, int directionY){
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
