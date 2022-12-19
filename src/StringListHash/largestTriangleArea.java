package StringListHash;

/**
 * @ClassName:largestTriangleArea
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/largest-triangle-area/
 * @Date: 20/11/2022 20:04
 * @Version: v1.0
 */
public class largestTriangleArea {

    //[0,0],[0,1],[1,0],[0,2],[2,0]
    // **`A(x1, y1), B(x2, y2),`** and **`C(x3, y3)`** is:

    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0.0;


        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++) {
                    double currArea = area(points[i], points[j], points[k]);
                    maxArea = Math.max(maxArea, currArea);
                }

        return maxArea;
    }
    //(ΔABC) = (1/2)|x1(y2 − y3) + x2(y3 − y1) + x3(y1 − y2)
    public double area(int[] p1, int[] p2, int[] p3) {
        return Math.abs(
                        p1[0] * (p2[1] - p3[1]) +
                        p2[0] * (p3[1] - p1[1]) +
                        p3[0] * (p1[1] - p2[1])
                ) / 2.0;
    }
}
