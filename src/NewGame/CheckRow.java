package NewGame;

public class CheckRow {
    private static int yMax;
    private static int xMax;
    static boolean checkBounds(int[] coords) {
        return coords[0] >= 0 && coords[0] < yMax && coords[1] >= 0 && coords[1] < xMax;
    }
    public static int getOccurencesInDirection(int[][] map, int[] coords, int check, RowDirection dir) {
        dir.doChange(coords);
        yMax = map.length;
        xMax = map[0].length;
        int ret = 0;
        while (checkBounds(coords) && map[coords[0]][coords[1]] == check) {
            dir.doChange(coords);
            ret++;
        }
        return ret;
    }
}
