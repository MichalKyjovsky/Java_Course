public class Conditions {

    public char checkCondition(char[][]mapPreviousRound , int i, int j){

        if(mapPreviousRound[i][j] == 'X') {

            int counterLiveCells = 0;

            if (mapPreviousRound[i - 1][j - 1] == 'X') {
                counterLiveCells++;
            }
            if (mapPreviousRound[i - 1][j] == 'X') {
                counterLiveCells++;
            }
            if (mapPreviousRound[i][j - 1] == 'X') {
                counterLiveCells++;
            }
            if (mapPreviousRound[i - 1][j + 1] == 'X') {
                counterLiveCells++;
            }
            if (mapPreviousRound[i + 1][j - 1] == 'X') {
                counterLiveCells++;
            }
            if (mapPreviousRound[i + 1][j] == 'X') {
                counterLiveCells++;
            }
            if (mapPreviousRound[i][j + 1] == 'X') {
                counterLiveCells++;
            }
            if (mapPreviousRound[i + 1][j + 1] == 'X') {
                counterLiveCells++;
            }

            if(counterLiveCells < 2){
                return '_';
            }else if(counterLiveCells == 2 || counterLiveCells == 3){
                return 'X';
            }else{
                return '_';
            }
        }else{
            int counterLiveCells = 0;

            if (mapPreviousRound[i - 1][j - 1] == 'X') {
                counterLiveCells++;
            }
            if (mapPreviousRound[i - 1][j] == 'X') {
                counterLiveCells++;
            }
            if (mapPreviousRound[i][j - 1] == 'X') {
                counterLiveCells++;
            }
            if (mapPreviousRound[i - 1][j + 1] == 'X') {
                counterLiveCells++;
            }
            if (mapPreviousRound[i + 1][j - 1] == 'X') {
                counterLiveCells++;
            }
            if (mapPreviousRound[i + 1][j] == 'X') {
                counterLiveCells++;
            }
            if (mapPreviousRound[i][j + 1] == 'X') {
                counterLiveCells++;
            }
            if (mapPreviousRound[i + 1][j + 1] == 'X') {
                counterLiveCells++;
            }

            if (counterLiveCells == 3){
                return 'X';
            }
        }
        return '_';
    }
}
