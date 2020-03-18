package board;

@Getter
public class Hex {
    final private Integer x;
    final private Integer y;
    final private Integer z;
    private Integer player;
    private Integer pieces;

    public Hex(Integer x, Integer y, Integer z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.player = 0;
        this.pieces = 0;
    }
}