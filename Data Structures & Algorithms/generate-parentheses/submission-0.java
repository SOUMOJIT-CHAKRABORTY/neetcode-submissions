class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder generate = new StringBuilder("");
        int open = 0;
        int close = 0;
        backtrack(n, generate, open, close);
        return res;
    }
    private void backtrack(int n, StringBuilder generate, int open, int close){
        if(open == n && close == n){
            res.add(new StringBuilder(generate).toString());
            return;
        }
        if(close < open){
            generate.append(")");
            close++;
            backtrack(n, generate, open, close);
            close--;
            generate.deleteCharAt(generate.length() - 1);
        } if(open<n){
            generate.append("(");
            open++;
            backtrack(n, generate, open, close);
            open--;
            generate.deleteCharAt(generate.length() - 1);
        }
    }
}
