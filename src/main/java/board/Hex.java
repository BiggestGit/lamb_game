package board;
import lombok.*;

import java.util.Objects;

/**
 * A hex object contains it's coordinates, the player that controls it and the number of pieces on the hex. Also the
 * has code is stored directly to avoid needing to calculate it multiple times.
 */
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hex hex = (Hex) o;
        return this.hashCode == hex.hashCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.hashCode);
    }
}
