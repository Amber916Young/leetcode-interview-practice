package Mock;

/**
 * @ClassName:removeElement
 * @Auther: yyj
 * @Description:
 * @Date: 30/12/2022 14:16
 * @Version: v1.0
 */
public class removeElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;

    }
}
