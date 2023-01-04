package Mock;

import java.util.*;

/**
 * @ClassName:combinationSum
 * @Auther: yyj
 * @Description:
 * @Date: 30/12/2022 14:23
 * @Version: v1.0
 */
public class combinationSum {
    public static void main(String[] args) {
        combinationSum test = new combinationSum();
        test.combinationSum(new int[]{2,3,6,7},7);
    }


    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum_DFS(candidates,target,new ArrayList<>(),0);
        return ans;
    }

    private void combinationSum_DFS(int[] candidates, int target, ArrayList<Integer> arr, int start) {
        if(target == 0){
            ans.add(new ArrayList<>(arr));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = start;i<candidates.length;i++){
            arr.add(candidates[i]);
            combinationSum_DFS(candidates,target - candidates[i],arr,i);
            arr.remove(arr.size()-1);
        }
    }
}
