package board;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HexMapUnitTest {

    Hex hex;
    HexMap hexMap;

    @Test
    public void test(){
        hex = Hex.builder().hashCode(0).xCoordinate(0).yCoordinate(0).zCoordinate(0).pieces(0).player(0).build();
        hexMap = new HexMap(4);
        hexMap.getHex(0);
        System.out.println(hexMap.getHex(1).getXCoordinate());
        System.out.println(hexMap.getHex(1).getYCoordinate());
        Assert.assertEquals(hex, hexMap.getHex(0));
    }
}