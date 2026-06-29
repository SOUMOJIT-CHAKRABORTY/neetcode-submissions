class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Map<Integer, Integer> numsMap = new HashMap<>();
        int i =0;
        int remainingSum = target;
        dfs(nums, i, target, remainingSum, combination, res);
        return res;
    }
    private void dfs(int[] nums, int i, int target, int remainingSum, 
    List<Integer> combination, List<List<Integer>> res) {
       if(remainingSum == 0){
        res.add(new ArrayList(combination));
        return;
       }
       if(remainingSum < 0 || i>=nums.length) return;
       combination.add(nums[i]);
       dfs(nums, i, target, remainingSum - nums[i], combination, res);

        combination.remove(combination.size() - 1);
       
       dfs(nums, i+1, target, remainingSum, combination, res);
    }  
}
