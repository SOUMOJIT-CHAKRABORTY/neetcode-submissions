class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> strList = new ArrayList();
        backtrack(s, 0 , strList);
        return res;
    }
    private void backtrack(String str, int i, List<String> strList){
        if(i == str.length()){
            res.add(new ArrayList(strList));
            return ;
        }
        for(int j = i; j<str.length(); j++){
            String subStr = str.substring(i, j+1);
            if(!isPalindrome(subStr)){
                continue;
            }
            strList.add(subStr);
            backtrack(str, j+1, strList);
            strList.remove(strList.size()-1);
        }
    }
    private boolean isPalindrome(String str){
        int i = 0; int j = str.length() - 1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

