package NewGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OmokModelTest {

    @Test
    void playerTurn() {
        OmokModel o = new OmokModel(null);

        boolean swap = true;
        for (int i = 0; i < 10; i++) {
            assertEquals(o.playerTurn(), swap ? 1 : 2);
            swap = !swap;
            o.updateTurn();
        }
    }


    @Test
    void getSquare() {
        var m = new int[][]{
                {1,0,0,2,0},
                {0,2,2,0,0},
                {0,0,0,0,0}
        };
        OmokModel o = new OmokModel(m);

        for(int i = 0 ; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                assertEquals(m[i][j], o.getSquare(i,j));
            }
        }
    }

    @Test
    void updateSquare() {
        var m = new int[][]{
                {1,0,0,2,0},
                {0,2,2,0,0},
                {0,0,0,0,0}
        };
        OmokModel o = new OmokModel(m);

        o.updateSquare(0,1);
        assertEquals(1, o.getSquare(0,1));

        o.updateTurn();
        o.updateSquare(2,4);
        assertEquals(2, o.getSquare(2,4));
    }

    @Test
    void checkWinner() {
        var m = new int[][]{
                {1,1,1,1,1},
                {0,2,2,0,0},
                {0,0,0,0,0}
        };
        OmokModel o = new OmokModel(m);

        assertTrue(o.checkWinner(0,0));

        m = new int[][] {
                {1,0,0,2,0},
                {0,2,2,0,0},
                {0,0,0,0,0}
        };
        o = new OmokModel(m);
        assertFalse(o.checkWinner(2,2));

        m = new int[][] {
                {1,0,0,0,0},
                {0,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,0},
                {0,0,0,0,1}
        };
        o = new OmokModel(m);
        assertTrue(o.checkWinner(4,4));

        m = new int[][] {
                {0,0,0,0,1},
                {0,0,0,1,0},
                {0,0,1,0,0},
                {0,1,0,0,0},
                {1,0,0,0,0}
        };
        o = new OmokModel(m);
        assertTrue(o.checkWinner(4,0));

    }
}