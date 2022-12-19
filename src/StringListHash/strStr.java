package StringListHash;

/**
 * @ClassName:strStr
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/discuss/12965/Java-KMP
 * @Date: 21/11/2022 11:53
 * @Version: v1.0
 */
public class strStr {
    public static void main(String[] args) {
        strStr("sadbutsad","sad");
    }
    // KMP 算法
    public static int strStr(String haystack, String needle) {
        int[] prefix = getLPS(needle, needle.length());
        int i = 0, j = 0;
        int n = haystack.length();
        int m = needle.length();
        char[] charArr1 = haystack.toCharArray(),
                charArr2 = needle.toCharArray();
        while (i < n && j < m) {
            if (charArr1[i] == charArr2[j]) {
                i++;
                j++;
                if (j == m)
                    return i - m;
            } else if (j > 0) {
                j = prefix[j - 1];

            } else {
                i++;
            }
        }
        return -1;
    }

    private static int[] KMP(String needle) {
        int[] res = new int[needle.length()];
        char[] charArr = needle.toCharArray();
        int i = 0, j = 1;
        while (j < needle.length()) {
            if (charArr[i] == charArr[j]) {
                res[j] = i + 1;
                i++;
                j++;
            } else {
                if (i != 0) {
                    i = res[i - 1];
                } else {
                    res[j] = 0;
                    j++;
                }
            }
        }
        return res;
    }

    // KMP get the longest prefix and suffix
   static int[] getLPS(String s, int n) {
        int i = 1, len = 0;
        int[] lps = new int[n];

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i++] = ++len;
            } else if (len == 0) {
                lps[i++] = 0;
            } else {
                len = lps[len - 1];
            }
        }

        return lps;
    }
}
