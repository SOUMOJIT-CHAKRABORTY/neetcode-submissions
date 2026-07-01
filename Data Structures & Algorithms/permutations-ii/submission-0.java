class Solution {
        List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> permute = new ArrayList<>();
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        backtrack(nums, arr, permute);
        return res;
    }
    private void backtrack(int[] nums, int[] arr, List<Integer> permute){
        if(permute.size() == nums.length){
            res.add(new ArrayList<>(permute));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(arr[i]==1 || (i >0 && nums[i] == nums[i-1] && arr[i-1]==0)){
                continue;
            }
                permute.add(nums[i]);
                arr[i] = 1;
                backtrack(nums, arr, permute);
                permute.remove(permute.size() - 1);
                arr[i] = 0;
        }
    }
    // public List<List<Integer>> permuteUnique(int[] nums) {
        
    // }
}