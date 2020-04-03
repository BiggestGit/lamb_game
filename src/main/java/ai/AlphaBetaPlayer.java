package ai;

import board.HexMap;
import groovy.lang.Tuple;
import logic.PlyMaker;

import java.util.AbstractMap;
import java.util.HashMap;

public class AlphaBetaPlayer implements AIPlayer{
    private final PlyMaker plyMaker;
    private final int greed;

    public AlphaBetaPlayer(HexMap hexMap, int greed){
        this.plyMaker = new PlyMaker(hexMap, new HashMap<>(), new HashMap<>());
        this.greed = greed;
    }

    //TODO tee loppuun
    public boolean move(int player){
        int bestOrigin = this.plyMaker.evaluateHexesForOrigin(player);
        AbstractMap.SimpleImmutableEntry<Integer, Integer> bestTarget = this.plyMaker.evaluateFromHexForTarget();
        this.plyMaker.transferPieces(bestOrigin, bestTarget.getKey(), bestTarget.getValue()/2);
        return false;
    }
}
