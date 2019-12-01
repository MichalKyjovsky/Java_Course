public class Map {
    public char[][] mapPreparation(String[] matrix){
        char[][] map = new char[matrix.length + 2][matrix.length + 2];

        for (int i = 0; i < matrix.length ; i++){
            for (int j = 0; j < matrix.length  ;j++){
                map[i + 1][j + 1] = matrix[i].charAt(j);
            }
        }

        for (int i = 0; i < matrix.length; i++){
            map[0][i + 1] = matrix[matrix.length-1].charAt(i);
            map[map.length - 1][i + 1] = matrix[0].charAt(i);
            map[i + 1][0] = matrix[i].charAt(matrix.length-1);
            map[i + 1][map.length - 1] = matrix[i].charAt(0);
        }

        map[0][0] = matrix[matrix.length -1].charAt(matrix.length -1);
        map[0][map.length - 1] = matrix[matrix.length -1].charAt(0);
        map[map.length - 1][0] = matrix[0].charAt(matrix.length -1);
        map[map.length - 1][map.length - 1] = matrix[0].charAt(0);

        return map;
    }

    public char[][] mapUpdate(char[][] newMap){

        for (int i = 0; i < newMap.length -2 ; i++){
            newMap[0][i + 1] = newMap[newMap.length - 2][i + 1];
            newMap[newMap.length - 1][i + 1] = newMap[1][i+1];
            newMap[i + 1][0] = newMap[i+1][newMap.length-2];
            newMap[i + 1][newMap.length - 1] = newMap[i + 1][1];
        }

        newMap[0][0] = newMap[newMap.length -2][newMap.length -2];
        newMap[0][newMap.length - 1] = newMap[newMap.length - 2][0];
        newMap[newMap.length - 1][0] = newMap[0][newMap.length -2];
        newMap[newMap.length - 1][newMap.length - 1] = newMap[1][0];

        return newMap;
    }

    public char[][] copyMap(char[][] toBeCopied){
        char[][] outputMap = new char[toBeCopied.length][toBeCopied.length];
        for (int i = 0; i < toBeCopied.length; i++){
            for (int j = 0; j < toBeCopied.length; j++){
                outputMap[i][j] = toBeCopied[i][j];
            }
        }
        return outputMap;
    }
}
