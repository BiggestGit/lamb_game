package board;

import org.junit.Assert;
import org.junit.Test;

//TODO check for if need more substantive tests
public class HexMapUnitTest {

    Hex hex;
    HexMap hexMap;

    @Test
    public void test00initialized() {
        hex = Hex.builder().hashCode(0).xCoordinate(0).yCoordinate(0).zCoordinate(0).pieces(0).player(0).build();
        hexMap = new HexMap();
        Assert.assertEquals(hex, hexMap.getHex(0));
    }
}