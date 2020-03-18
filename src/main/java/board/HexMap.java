package board;

import logic.HexCalculator;


import java.util.HashMap;
public class HexMap {
    private HashMap<Integer, Hex> map;

    public HexMap(int size){
        int sideLength = size/4;
        for (int x = -sideLength; x < sideLength; x++) {
            for (int y = -sideLength; y < sideLength; y++) {
                Hex.builder().xCoordinate(x)
                             .yCoordinate(y)
                             .zCoordinate(-x-y)
                             .pieces(0)
                             .player(0)
                             .hashCode(HexCalculator.calculateHash(x, y))
                             .build();
            }
        }
    }
}
