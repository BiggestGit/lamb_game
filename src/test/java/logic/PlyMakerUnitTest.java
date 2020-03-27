package logic;

import board.Hex;
import board.HexMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

//TODO more tests
@RunWith(MockitoJUnitRunner.class)
public class PlyMakerUnitTest {
    @InjectMocks
    private PlyMaker plyMaker;

    @Mock
    private HexMap hexMapMock;

    @Test
    public void movePiecesGetsCorrectHex(){
        //Arrange
        int fromHexHash = 0;
        int toHexHash = 1;
        int amount = 2;
        Hex fromHexMock = Mockito.mock(Hex.class);
        Hex toHexMock = Mockito.mock(Hex.class);
        Mockito.when(this.hexMapMock.getHex(fromHexHash)).thenReturn(fromHexMock);
        Mockito.when(this.hexMapMock.getHex(toHexHash)).thenReturn(toHexMock);
        Mockito.when(fromHexMock.getPieces()).thenReturn(3);

        //Act
        this.plyMaker.movePieces(fromHexHash, toHexHash, amount);

        //Assert
        InOrder inOrder = Mockito.inOrder(this.hexMapMock, fromHexMock, toHexMock);
        inOrder.verify(this.hexMapMock).getHex(fromHexHash);
        inOrder.verify(fromHexMock).getPieces();
        inOrder.verify(this.hexMapMock).getHex(fromHexHash);
        inOrder.verify(fromHexMock).setPieces(1);
        inOrder.verify(this.hexMapMock).getHex(toHexHash);
        inOrder.verify(toHexMock).setPieces(amount);
    }

}