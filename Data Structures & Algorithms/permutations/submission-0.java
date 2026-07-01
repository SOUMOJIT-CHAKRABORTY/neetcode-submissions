class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> permute = new ArrayList<>();
        int[] arr = new int[nums.length];
        dfs(nums, arr, permute);
        return res;
    }
    private void dfs(int[] nums, int[] arr, List<Integer> permute){
        if(permute.size() == nums.length){
            res.add(new ArrayList<>(permute));
            return;
        }
        
        for(int i = 0; i<nums.length; i++){
            if(arr[i] == 0){
                permute.add(nums[i]);
                arr[i] = 1;
                dfs(nums, arr, permute);
                permute.remove(permute.size()-1);
                arr[i] = 0;
            }
        }
    }
}
