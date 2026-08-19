class Solution {

    static void solve(int i ,int total, int target, List<List<Integer>> result , List<Integer> curr , int [] candidates){
        if(total == target){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(total>target){
            return;
        }
        if(i>=candidates.length){
            return;
        }
        int sum = total+candidates[i];
        curr.add(candidates[i]);
        solve(i,sum,target,result,curr,candidates);
        sum = total;
        curr.remove(curr.size()-1);
        solve(i+1,sum,target,result,curr,candidates);
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> curr = new ArrayList<>();

      solve(0,0,target,result,curr,candidates);
    
        return result;
    }
}