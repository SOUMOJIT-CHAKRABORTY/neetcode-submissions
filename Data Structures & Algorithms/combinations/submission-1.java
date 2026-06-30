class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        List<Integer> combi = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }
        dfs(arr, 0, k, combi);
        return res;
    }
    private void dfs(int[] arr, int i, int k, List<Integer> combi){
        if(combi.size() == k){
            res.add(new ArrayList<>(combi));
            return;
        }
        for(int j = i; j<arr.length; j++){
            // if(j > k){
            //     break;
            // }
            combi.add(arr[j]);
            dfs(arr, j+1, k, combi);
            combi.remove(combi.size()-1);
        }
    }
}