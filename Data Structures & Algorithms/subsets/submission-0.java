class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int i = 0;

        dfs(nums,i,subset,res);
        return res;
    }
    private void dfs(int[] nums,
     int i,
     List<Integer> subset,
      List<List<Integer>> res) {
        if(i >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        // add - then construct the rest of the tree.
        subset.add(nums[i]);
        dfs(nums, i+1, subset, res);
        // remove and explore the other way.
        subset.remove(subset.size() - 1);
        dfs(nums, i+1, subset, res);
        

    }
}
