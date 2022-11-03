package StringListHash;

/**
 * @ClassName:garbageCollection
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/
 * @Date: 03/11/2022 12:33
 * @Version: v1.0
 */
public class garbageCollection {

    public static void main(String[] args) {
        garbageCollection(new String[]{"MMM","PGM","GP"},new int[]{3,10});
    }
  static   public int garbageCollection(String[] garbage, int[] travel) {
        int glassLastIdx = 0, plasticLastIdx = 0, metalLastIdx = 0;
        int totalTime = 0;

        for (int i = 0; i < garbage.length; i++) {
            // if m/g/p seen at current index, its the last index its been seen for now
            for (char c : garbage[i].toCharArray()) {
                if (c == 'P') plasticLastIdx = i;
                if (c == 'M') metalLastIdx = i;
                if (c == 'G') glassLastIdx = i;
                 totalTime++;         // +1 for each pick
            }
        }

        // creating a prefix sum array for travel time
        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }

        // adding LastIndex - 1 because travel time of i-th house is given by travel[i - 1]
        totalTime += (metalLastIdx == 0) ? 0 : travel[metalLastIdx - 1];
        totalTime += (plasticLastIdx == 0) ? 0 : travel[plasticLastIdx - 1];
        totalTime += (glassLastIdx == 0) ? 0 : travel[glassLastIdx - 1];

        return totalTime;
    }
}
