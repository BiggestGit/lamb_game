package ai;

import board.HexMap;
import logic.PlyMaker;
import lombok.AllArgsConstructor;

public class AlphaBetaPlayer implements AIPlayer{
    private final PlyMaker plyMaker;
    private final int greed;

    public AlphaBetaPlayer(HexMap hexMap, int greed){
        this.plyMaker = new PlyMaker(hexMap);
        this.greed = greed;
    }

    public boolean move(){
        return false;
    }

    private int evaluateHex(int target){
        return -1;
    }
}
