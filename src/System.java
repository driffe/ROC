public class System {
    private static final int TOTAL_SPACES = 34;
    int turn;
    static class Score {
        int p1Score;
        int p2Score;
        Score(int p1Score, int p2Score) {
            this.p1Score = p1Score;
            this.p2Score = p2Score;
        }
        public int getP1Score() {
            return p1Score;
        }
        public int getP2Score() {
            return p2Score;
        }
    }

    public Score getScore(Map map) {
        int p1Score = 0;
        int p2Score = 0;
        //iterates through getMap to see how many 1's there are and 2's which represent the scores of
        //p1 and p2
        for (int i = 0; i < map.getMap().length; i++) {
            for (int j = 0; j < map.getMap()[i].length; j++) {
                if (map.getMap()[i][j] == 1) {
                    p1Score++;
                } else if (map.getMap()[i][j] == 2) {
                    p2Score++;
                }
            }
        }
        return new Score(p1Score, p2Score);
    }

    public boolean findIfGameOver(Map map){
        //compares totalNumberOfSpaces to number of spaces used to find if Game is over
        int gameScore = 0;
        Score score = getScore(map);
        gameScore = score.getP1Score() + score.getP2Score();
        if (gameScore >= TOTAL_SPACES) {
            return true;
        } else {
            return false;
        }
    }
    //updates turn for each player
    public void updateTurn(){
        turn++;
    }
}
