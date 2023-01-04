package Mock;

/**
 * @ClassName:generateMatrix
 * @Auther: yyj
 * @Description:
 * @Date: 04/01/2023 14:57
 * @Version: v1.0
 */
public class generateMatrix {

    public static void main(String[] args) {
        generateMatrix(3);
    }


  static   public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n-1;
        int top = 0;
        int down = n-1;
        int direction = 0;
        if(n==1) {
            return new int[][]{{1}};
        }
        int[][] res = new int[n][n];
        int count = 1;
        while (top<=down && left<=right) {
            if(direction == 0){
                for(int i =left ; i <= right;i++){
                    res[top][i] = count++;
                }
                top++;
            }else if(direction == 1){
                for(int i =top ; i <= down;i++){
                    res[i][right] = count++;
                }
                right--;
            }else if(direction == 2){
                for(int i =right ; i >= left;i--){
                    res[down][i] = count++;
                }
                down--;
            }else if(direction == 3){
                for(int i =down ; i >= top;i--){
                    res[i][left] = count++;
                }
                left++;
            }
            direction = (direction+1) % 4;
        }
        return res;



    }
}
