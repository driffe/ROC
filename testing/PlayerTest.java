import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    int[][] arrClone(int[][] c) {
        int[][] a = new int[c.length][c[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                a[i][j] = c[i][j];
            }
        }
        return a;
    }
    @Test
    void move_basicMovementNoJump() {
        Player player = new Player();
        Map map = new Map();
        map.map = new int[][]
                {
                        {1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0}
                };
        var expected = arrClone(map.map);
        expected[0][1] = 1;

        player.move(map, 0,0,0,1);

        assertArrayEquals(expected, map.getMap());
    }

    @Test
    void move_basicMovementJump() {
        Player player = new Player();
        Map map = new Map();
        map.map = new int[][]
                {
                        {1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0}
                };
        var expected = arrClone(map.map);
        expected[0][0] = 0;
        expected[0][2] = 1;

        player.move(map, 0,0,0,2);

        assertArrayEquals(expected, map.getMap());
    }

    @Test
    void move_infectNeighbors() {
        Player player = new Player();
        Map map = new Map();
        map.map = new int[][]
                {
                        {1, 2, 0, 2, 0},
                        {0, 2, 2, 2, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0}
                };
        var expected = new int[][]
                {
                        {0, 1, 1, 1, 0},
                        {0, 1, 1, 1, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0}
                };


        player.move(map, 0,0,0,2);

        assertArrayEquals(expected, map.getMap());
    }
}
