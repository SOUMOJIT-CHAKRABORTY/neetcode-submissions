class Solution {
    private List<String> res = new ArrayList<>();
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        backtrack(digits, 0, "");
        return res;
    }
    private void backtrack(String digits, int i, String curStr) {
        if(digits.length() == curStr.length()){
            res.add(curStr);
            return;
        }
        String chars = digitToChar[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            backtrack(digits, i + 1, curStr + c);
        }
    }
}
