package ai;

import board.HexMap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AlphaBetaPlayerUnitTest {

    @Mock
    HexMap hexMapMock;

    private AlphaBetaPlayer alphaBetaPlayer;

    @BeforeClass
    public void setUp(){
        this.alphaBetaPlayer = new AlphaBetaPlayer(this.hexMapMock, 1);
    }

    @Test
    public void moveTest() {
        //Arrange
        int result = -1;

        //Act
        this.alphaBetaPlayer.move();

        //Assert
        Assert.assertEquals(1, result);
    }
}