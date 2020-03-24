package board;
import logic.HexCalculator;
import lombok.Builder;

import java.util.HashMap;

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
}
