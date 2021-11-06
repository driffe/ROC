public class System extends Map {
    private int totalNumberOfSpaces = 34;

    public static int getScore() {
        int p1Score = 0;
        int p2Score = 0;
        //iterates through getMap to see how many 1's there are and 2's which represent the scores of
        //p1 and p2
        for (int i = 0; i < getMap.length; i++) {
            for (int j = 0; j < getMap[i].length; j++) {
                if (getMap[j][i] == 1) {
                    p1Score++;
                } else if (getMap[i] == 2) {
                    p2Score++;
                }
            }
        }

        public boolean findIfGameOver(int totalNumberOfSpaces){
            //compares totalNumberOfSpaces to number of spaces used to find if Game is over
            int gameScore = 0;
            findIfGameOver = false;
            p1.getScore() + p2.getScore = gameScore;
            if (gameScore >= totalNumberOfSpaces) {
                return true;
            } else {
                return false;
            }
        }
        //updates turn for each player
        public static void updateTurn(){
            turn++;
        }
    }
}
