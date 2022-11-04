package StringListHash;

/**
 * @ClassName:smallestNumber
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/construct-smallest-number-from-di-string/discuss/2611901/1ms-Java-Easiest-Solution
 * @Date: 04/11/2022 10:11
 * @Version: v1.0
 */
public class smallestNumber {
    public static void main(String[] args) {
        smallestNumber test = new smallestNumber();
        test.smallestNumber("IIIDIDDD");
    }
    public String smallestNumber(String pattern) {
        int[] ch = new int[pattern.length() + 1];
        for (int i = 0; i < ch.length; i++) ch[i] = i + 1;
        boolean err = true;
        while (err) {
            err = false;
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == 'I' && ch[i] > ch[i + 1]) {
                    swap(ch, i, i + 1);
                    err = true;
                } else if (pattern.charAt(i) == 'D' && ch[i] < ch[i + 1]) {
                    swap(ch, i, i + 1);
                    err = true;
                }
            }
        }
        String ans = "";
        for (int num : ch)
            ans += num;
        return ans;
    }

    public static void swap(int[] ch, int i, int j) {
        int c = ch[i];
        ch[i] = ch[j];
        ch[j] = c;
    }
}
