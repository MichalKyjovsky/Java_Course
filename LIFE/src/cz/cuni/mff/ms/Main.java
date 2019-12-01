public class Main {

    public static void main(String[] args) {
	    InputProcessor inputProcessor = new InputProcessor();
	    char[][] map;

        try {
            Map matrix = new Map();
            map = matrix.mapPreparation(inputProcessor.manageInput());
            char[][] mapPreviousRound = matrix.copyMap(map);
            Conditions conditions = new Conditions();

            for(int round = 0; round < inputProcessor.getRoundsNumber(); round++){

                for (int i = 1; i < map.length - 1; i++){
                    for (int j = 1; j < map.length - 1; j++){
                        map[i][j] = conditions.checkCondition(mapPreviousRound,i,j);
                    }
                }

                mapPreviousRound = matrix.copyMap(map);
                mapPreviousRound = matrix.mapUpdate(mapPreviousRound);
            }

            for (int i = 1; i < map.length - 1; i++){
                for (int j = 1; j < map.length - 1; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
