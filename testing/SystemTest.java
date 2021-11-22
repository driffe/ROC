import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class SystemTest {
    @Test
    public void testGetScore(){
        Player player = new Player();
        Map map = new Map();
        map.map = new int[][]
                {
                        {1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {2, 2, 2, 2, 0}
                };
        assertEquals(p1Score.getScore(), 5);
        assertEquals(p2Score.getScore(), 4);
    }

    @Test
    public void testFindIfGameOver(){
        Player player = new Player();
        Map map = new Map();
        map.map = new int[][]
                {
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1}
                };
        assertEquals(map.findIfGameOver, true);
    }
    @Test
    public void testUpdateTurn(){
        System system = new System();
        Player player1 = new Player();
        int turn = 0;
        player1.updateTurn();
        assertEquals(turn, 1);
    }
}
