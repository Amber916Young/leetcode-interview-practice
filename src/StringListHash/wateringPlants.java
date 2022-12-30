package StringListHash;

import java.util.ArrayList;

/**
 * @ClassName:wateringPlants
 * @Auther: yyj
 * @Description:
 * @Date: 19/12/2022 16:10
 * @Version: v1.0
 */
public class wateringPlants {
    public static void main(String[] args) {
        wateringPlants(new int[]{2,2,3,3},5);
    }


    // plants = [2,2,3,3], capacity = 5
   static public int wateringPlants(int[] plants, int capacity) {
        int steps = 0;
        int tmp = capacity;
        for (int i = 0; i < plants.length; i++) {
            if(plants[i] <= tmp){
                steps += 1;
                tmp -= plants[i];
            }else {
                steps += i;
                steps += i + 1;
                tmp = capacity;
                tmp -= plants[i];

            }
        }

        return steps;

    }
}
