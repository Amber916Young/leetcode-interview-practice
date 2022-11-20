package Matrix;

/**
 * @ClassName:rotateTheBox
 * @Auther: yyj
 * @Description:
 * @Date: 18/11/2022 20:45
 * @Version: v1.0
 */
public class rotateTheBox {


    public static void main(String[] args) {


        char[][] mat = new char[][]{{'#','#','*','.','*','.'},
                {'#','#','#','*','.','.'},
                {'#','#','#','.','#','.'}};

        rotateTheBox(mat);
    }
    static public char[][] rotateTheBox(char[][] box) {
        int row = box.length;
        int col = box[0].length;
        char[][] mat = new char[col][row];
        for (int i = 0; i < row; i++) {
            int start = 0;
            int end = start + 1;
            while (start <= end && end < col) {
                if (box[i][start] == '*') {
                    start++;
                    end++;
                    continue;
                }
                if (box[i][start] == '.') {
                    start++;
                    end++;
                    continue;
                }
                if (box[i][end] == '*') {
                    start = end;
                    end++;
                    continue;
                }
                if (box[i][end] == '#') {
                    end++;
                    continue;
                }
                if (box[i][end] == '.') {
                    box[i][start] = '.';
                    box[i][end] = '#';
                    start++;
                    end++;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[j][row-i-1] = box[i][j];
            }
        }
        return mat;
    }
}
