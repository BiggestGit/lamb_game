package board;
import logic.HexCalculator;
import java.util.HashMap;

public class HexMap {
    private HashMap<Integer, Hex> map;

    public HexMap(int size){
        int hashCode;
        int sideLength = size/4;
        for (int x = -sideLength; x < sideLength; x++) {
            for (int y = -sideLength; y < sideLength; y++) {
                hashCode = HexCalculator.calculateHash(x, y);
                this.map.put(hashCode,
                        Hex.builder().xCoordinate(x)
                                     .yCoordinate(y)
                                     .zCoordinate(-x-y)
                                     .pieces(0)
                                     .player(0)
                                     .hashCode(hashCode)
                                     .build());
            }
        }
    }

    public Hex getHex(int hashCode){
        return this.map.get(hashCode);
    }
}
