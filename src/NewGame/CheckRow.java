package NewGame;

/**
 *This class gets checks each row and gets the number of squares in a certain direction.
 */
public class CheckRow {
    private static int yMax;
    private static int xMax;
    static boolean checkBounds(int[] coords) {
        return coords[0] >= 0 && coords[0] < yMax && coords[1] >= 0 && coords[1] < xMax;
    }

    /**
     * This method passes the functional interface and passes coordinates of the map and gets the number of squares in that direction.
     * @param map takes the map
     * @param coords takes the coordinates of the map
     * @param check takes the check
     * @param dir takes the direction of the check
     * @return number of occurrences
     */
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
