import ai.AlphaBetaPlayer;
import board.HexMap;

public class Main {
    public static void main(String[] args) {
        HexMap hexMap = new HexMap();
        AlphaBetaPlayer player1 = new AlphaBetaPlayer(hexMap, 1);
        AlphaBetaPlayer player2 = new AlphaBetaPlayer(hexMap, 1);
        boolean gameOver1;
        boolean gameOver2;
        while (true){
            gameOver1 = player1.move();
            gameOver2 = player2.move();
            if (gameOver1 && gameOver2){
                hexMap.determineWinner();
                break;
            }
        }
    }
}
