package StringListHash;

import java.util.HashMap;

/**
 * @ClassName:decodeMessage
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/decode-the-message/
 * @Date: 03/11/2022 12:22
 * @Version: v1.0
 */
public class decodeMessage {
    public static void main(String[] args) {
        decodeMessage("the quick brown fox jumps over the lazy dog","vkbs bs t suepuv");
    }
    static public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();
        char index = 'a';
        for(char c : key.toCharArray()){
            if(c >= 'a' && c <= 'z' && !map.containsKey(c))
                map.put(c,index++);
        }

        StringBuilder sb = new StringBuilder();
        for(char c : message.toCharArray()){
            if(c >= 'a' && c <= 'z'){
                sb.append(""+map.get(c));
            }else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
