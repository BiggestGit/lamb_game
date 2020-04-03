package board;
import errors.InsufficientPiecesException;
import logic.HexCalculator;
import logic.PlyMaker;
import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

public class HexMap {
    private HashMap<Integer, Hex> map;

    /**
     * Creates a new HexMap that starts from the vertex which is and creates and
     * populates a Hash Map with hexes until the 16th hex is reached.
     */
    //TODO: Create a map generator that populates the map more like in the original game
    public HexMap(){
        map = new HashMap<>();
        int hashCode;
        int sideLength = 2;
        int hexCount = 0;
        for (int x = -sideLength; x <= sideLength; ++x) {
            for (int y = -sideLength; y <= sideLength; ++y) {
                hashCode = HexCalculator.calculateHash(x, y);
                if (hexCount < 16){
                    this.map.put(hashCode,
                            Hex.builder().xCoordinate(x)
                                    .yCoordinate(y)
                                    .zCoordinate(-x-y)
                                    .pieces(0)
                                    .player(0)
                                    .hashCode(hashCode)
                                    .build());
                    hexCount++;
                }
            }
        }
    }

    /**
     * Returns a tile on the map corresponding to the hash.
     * @param hashCode hashCode linked to a hex tile.
     * @return returns a Hex
     */
    public Hex getHex(int hashCode){
        return this.map.get(hashCode);
    }

    public boolean containsHex(int hashCode){
        return this.map.containsKey(hashCode);
    }

    /**
     * Moves pieces from one hex to another.
     * @param fromHexHash The hex that the pieces are moved from
     * @param toHexHash The hex that the pieces are moved to
     * @param amountMoved the amountMoved of hexes to be moved
     */
    public void transferPieces(int fromHexHash, int toHexHash, int amountMoved){
        int numberOfPiecesOnHex = this.map.get(fromHexHash).getPieces();
        if (numberOfPiecesOnHex <= amountMoved){
            throw new InsufficientPiecesException("The move is invalid. There are only " +
                                                  Integer.toString(numberOfPiecesOnHex - 1) +
                                                  " pieces available. Tried to move " +
                                                  Integer.toString(amountMoved));
        }
        this.map.get(fromHexHash).setPieces(numberOfPiecesOnHex - amountMoved);
        this.map.get(fromHexHash).setPieces(amountMoved);
    }

    /**
     * Counts the number of hexes that are controlled by each player and returns who controls the most hexes on the map
     * @return the number of the player that has the most hexes, or -1 in the case of a tie.
     */
    public int determineWinner(){
        int player1Pieces = 0;
        int player2Pieces = 0;
        int currentTileOwner;
        for (Map.Entry<Integer, Hex> entry: this.map.entrySet()) {
            currentTileOwner = entry.getValue().getPlayer();
            if (currentTileOwner == 1){
                player1Pieces++;
            }
            if(currentTileOwner == 2){
                player2Pieces++;
            }
        }
        if (player1Pieces > player2Pieces){
            return 1;
        }
        else if(player2Pieces > player1Pieces){
            return 2;
        }
        else{
            return -1;
        }
    }
}

