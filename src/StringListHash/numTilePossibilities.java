package StringListHash;

import java.util.*;

/**
 * @ClassName:numTilePossibilities
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/letter-tile-possibilities/
 * @Date: 05/11/2022 21:36
 * @Version: v1.0
 */

public class numTilePossibilities {

    public static void main(String[] args) {
        numTilePossibilities test = new numTilePossibilities();
        test.numTilePossibilities("AAB");
    }

    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] vis = new boolean[tiles.length()];
        numTilePossibilities_DFS(tiles,"",set,vis);
        return set.size()-1;
    }

    private void numTilePossibilities_DFS(String tiles, String curr,Set<String> set,   boolean[] vis) {
        set.add(curr);
        for(int i = 0 ;i<tiles.length();i++){
            if(!vis[i]){
                vis[i]=true;
                numTilePossibilities_DFS(tiles, curr+tiles.charAt(i), set, vis);
                vis[i]=false;
            }
        }
    }
}
