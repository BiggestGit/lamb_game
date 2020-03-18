package board;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Hex {
    private int player;
    private int pieces;
    private final int xCoordinate;
    private final int yCoordinate;
    private final int zCoordinate;
    private final int hashCode;

    @Override
    public int hashCode() {
        return this.hashCode;
    }
}
