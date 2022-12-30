package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:combinationSum3
 * @Auther: yyj
 * @Description:
 * @Date: 20/12/2022 14:23
 * @Version: v1.0
 */
public class combinationSum3 {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n < 3){
            return ans;
        }
        int[] arr = new int[9];
        for(int i =1 ; i <= 9 ;i++){
            arr[i-1] = i;
        }
        List<Integer> res = new ArrayList<>();
        combinationSum3_DFS(arr,n,res,0,0,k);
        return ans;
    }

    private void combinationSum3_DFS(int[] arr,int target, List<Integer> res,int start,int sum,int size) {
        if (sum > target){
            return;
        }
        if(sum == target && res.size()==size){
            ans.add(new ArrayList<>(res));
            return;
        }


        for(int i = start; i<arr.length;i++){
            res.add(arr[i]);
            combinationSum3_DFS(arr,target,res,i+1,sum+arr[i],size);
            res.remove(res.size() - 1);
        }
    }
}
