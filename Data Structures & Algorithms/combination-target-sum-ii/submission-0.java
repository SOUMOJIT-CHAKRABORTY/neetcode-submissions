class Solution {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res.clear();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, combination, res, target);
        return res;
    }
    private void dfs(int[] nums, int i, int total, 
    List<Integer> combination, List<List<Integer>> res, int target) {
        if(total == target){
            res.add(new ArrayList<>(combination));
            return;
        }
        for(int j = i; j<nums.length; j++){
            if(j>i && nums[j] == nums[j-1]){
                continue;
            }
            if(total + nums[j] > target){
                break;
            }
            combination.add(nums[j]);
            dfs(nums, j+1, total + nums[j], combination, res, target);
            combination.remove(combination.size()-1);
        }
            
        
    }
}
