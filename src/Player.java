public class Player {
    public void move(Map map, int x1, int y1, int x2, int y2) {
        //For now we are asserting that x1,y1,x2, and y2 are valid moves.
        int[][] m = map.getMap();
        int p = m[x1][y1];
        //If the distance between two coordinates is greater then two we know its a jump move
        if(Math.abs(x1 - x2) >= 2 || Math.abs(y1 - y2) >= 2) {
            m[x1][y1] = 0;
        }
        m[x2][y2] = p;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                int ni = x2 + i;
                int nj = y2 + j;
                if(ni < 0 || ni >= m.length || nj < 0 || nj >= m[0].length || m[ni][nj] == 0 || m[ni][nj] == p)
                    continue;
                m[ni][nj] = p;
            }
        }
    }
}
